package dto;

public class Equipo {

    private int id;

    private String modelo;

    private int stockDisponible;

    private int categoriaId;

    private String categoriaNombre;


    public Equipo() {
    }


    public Equipo(
            int id,
            String modelo,
            int stockDisponible,
            int categoriaId,
            String categoriaNombre) {

        this.id = id;

        this.modelo = modelo;

        this.stockDisponible = stockDisponible;

        this.categoriaId = categoriaId;

        this.categoriaNombre = categoriaNombre;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public int getStockDisponible() {
        return stockDisponible;
    }


    public void setStockDisponible(
            int stockDisponible) {

        this.stockDisponible =
                stockDisponible;
    }


    public int getCategoriaId() {
        return categoriaId;
    }


    public void setCategoriaId(
            int categoriaId) {

        this.categoriaId =
                categoriaId;
    }


    public String getCategoriaNombre() {
        return categoriaNombre;
    }


    public void setCategoriaNombre(
            String categoriaNombre) {

        this.categoriaNombre =
                categoriaNombre;
    }
}