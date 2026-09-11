package dto;

import java.time.LocalDateTime;

public class Alquiler {

    private int id;
    private int equipoId;
    private int cantidad;
    private LocalDateTime fechaAlquiler;
    private LocalDateTime fechaFinPrevista;
    private LocalDateTime fechaDevolucion;
    private String estado;


    public Alquiler() {
    }


    public Alquiler(
            int equipoId,
            int cantidad,
            LocalDateTime fechaFinPrevista) {

        this.equipoId = equipoId;
        this.cantidad = cantidad;
        this.fechaFinPrevista = fechaFinPrevista;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getEquipoId() {
        return equipoId;
    }


    public void setEquipoId(int equipoId) {
        this.equipoId = equipoId;
    }


    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }


    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }


    public LocalDateTime getFechaFinPrevista() {
        return fechaFinPrevista;
    }


    public void setFechaFinPrevista(
            LocalDateTime fechaFinPrevista) {

        this.fechaFinPrevista = fechaFinPrevista;
    }


    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }


    public void setFechaDevolucion(
            LocalDateTime fechaDevolucion) {

        this.fechaDevolucion = fechaDevolucion;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }
}
