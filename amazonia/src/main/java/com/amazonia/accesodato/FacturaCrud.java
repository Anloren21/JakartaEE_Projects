package com.amazonia.accesodato;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.amazonia.dtos.Cliente;
import com.amazonia.dtos.Factura;
import com.amazonia.dtos.Usuario;
import com.amazonia.dtos.Factura.Linea;
import com.amazonia.dtos.Producto;

import bibliotecas.accesodatos.BaseDeDatos;

public class FacturaCrud {
	private static final String SQL_INSERT = """
			INSERT INTO facturas (numero, fecha, clientes_id)
			VALUES (
				(SELECT CONCAT(
					YEAR(CURDATE()),
			        '-',
			        LPAD(COALESCE(MAX(CAST(SUBSTRING_INDEX(numero, '-', -1) AS UNSIGNED)), 0) + 1, 4, '0')
				) AS ultima_factura FROM facturas AS f WHERE numero LIKE CONCAT(YEAR(CURRENT_DATE()), '-%')),
			    CURRENT_DATE(),
			    ?
			);
						""";

	private static final String SQL_INSERT_LINEA = """
			INSERT INTO facturas_tiene_productos (facturas_id, productos_id, cantidad) VALUES (?,?,?)
			""";

	private static final String SQL_SELECT_ID = """
			SELECT
				f.id AS f_id, f.numero AS f_numero, f.fecha AS f_fecha,
				c.id AS c_id, c.nombre AS c_nombre, c.apellidos AS c_apellidos, c.nif AS c_nif
			FROM facturas f
			JOIN clientes c ON c.id = f.clientes_id
			WHERE f.id = ?
						""";

	private static final String SQL_SELECT_LINEA = """
			SELECT
				p.id AS p_id, p.nombre AS p_nombre, p.precio AS p_precio, p.descripción as p_descripcion,
				fp.cantidad AS fp_cantidad
			FROM facturas_tiene_productos fp
			JOIN productos p ON p.id = fp.productos_id
			WHERE facturas_id = ?
						""";

	public static Factura obtenerPorId(Long id) {
		try (PreparedStatement pst = BaseDeDatos.crearSentencia(SQL_SELECT_ID)) {
			pst.setLong(1, id);
			ResultSet rs = pst.executeQuery();

			Factura factura = null;

			if (rs.next()) {
				/*
				 * factura = new Factura(rs.getLong("f_id"), rs.getString("f_numero"),
				 * rs.getDate("f_fecha").toLocalDate(), cliente, lineas);
				 */

				String facturaNumero = rs.getString("f_numero");
				LocalDate facturaFecha = rs.getDate("f_fecha").toLocalDate();

				Cliente cliente = new Cliente(rs.getLong("c_id"), rs.getString("c_nombre"), rs.getString("c_apellidos"),
						rs.getString("c_nif"));

				PreparedStatement pstLinea = BaseDeDatos.crearSentencia(SQL_SELECT_LINEA);

				pstLinea.setLong(1, id);

				ArrayList<Linea> lineas = new ArrayList<Linea>();

				ResultSet rsLineas = pstLinea.executeQuery();

				while (rsLineas.next()) {
					Producto producto = new Producto(rsLineas.getLong("p_id"), rsLineas.getString("p_nombre"),
							rsLineas.getString("p_descripcion"), rsLineas.getBigDecimal("p_precio"));
					lineas.add(new Linea(producto, rsLineas.getInt("fp_cantidad")));
				}

				factura = new Factura(id, facturaNumero, facturaFecha, cliente, lineas);
			}
			return factura;
		} catch (SQLException e) {
			throw new RuntimeException("Error al obtener la factura " + id, e);
		}
	}

	public static Factura insertar(Factura facturaProvisional) {
		Long idCliente = facturaProvisional.cliente().id();
		try (PreparedStatement pst = BaseDeDatos.crearSentencia(SQL_INSERT)) {
			pst.setLong(1, idCliente);
			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			rs.next();

			Long idFactura = rs.getLong(1);

			PreparedStatement pstLinea = BaseDeDatos.crearSentencia(SQL_INSERT_LINEA);
			pstLinea.setLong(1, idFactura);

			for (Linea linea : facturaProvisional.lineas()) {
				pstLinea.setLong(2, linea.producto().id());
				pstLinea.setLong(3, linea.cantidad());

				pstLinea.executeUpdate();
			}

			return obtenerPorId(idFactura);

		} catch (SQLException e) {
			throw new RuntimeException("Error al guardar la factura " + facturaProvisional, e);
		}

	}

}
