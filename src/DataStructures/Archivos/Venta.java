package DataStructures.Archivos;

public class Venta {
    private String codigoDeDestino;
    private int codigoDeArticulo;
    private int cantidad;
    private int precioUnitarioEnDolares;
    private int dia,mes,año;

    public Venta(String codigoDeDestino, int codigoDeArticulo, int cantidad, int precioEnDolares, int dia, int mes, int año) {
        this.codigoDeDestino = codigoDeDestino;
        this.codigoDeArticulo = codigoDeArticulo;
        this.cantidad = cantidad;
        this.precioUnitarioEnDolares = precioEnDolares;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public String getCodigoDeDestino() {
        return codigoDeDestino;
    }

    public void setCodigoDeDestino(String codigoDeDestino) {
        this.codigoDeDestino = codigoDeDestino;
    }

    public int getCodigoDeArticulo() {
        return codigoDeArticulo;
    }

    public void setCodigoDeArticulo(int codigoDeArticulo) {
        this.codigoDeArticulo = codigoDeArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioUnitarioEnDolares() {
        return precioUnitarioEnDolares;
    }

    public void setPrecioUnitarioEnDolares(int precioEnDolares) {
        this.precioUnitarioEnDolares = precioEnDolares;
    }

    public int getDia() {
        return dia;
    }

    public int getAño() {
        return año;
    }

    public int getMes() {
        return mes;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "codigoDeDestino='" + codigoDeDestino + '\'' +
                ", codigoDeArticulo=" + codigoDeArticulo +
                ", cantidad=" + cantidad +
                ", precioUnitarioEnDolares=" + precioUnitarioEnDolares +
                ", dia=" + dia +
                ", mes=" + mes +
                ", año=" + año +
                '}';
    }
}
