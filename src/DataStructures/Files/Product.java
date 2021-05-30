package DataStructures.Files;

public class Product {
    private int codigo;
    private double precio;
    private char tipo;
    private boolean activo;

    public Product() {}

    public Product(int codigo, double precio,  char tipo, boolean activo) {
        this.codigo = codigo;
        this.precio = precio;
        this.tipo = tipo;
        this.activo = activo;
    }


    public int getCodigo() {return codigo;}

    public void setCodigo(int codigo) {this.codigo = codigo;}

    public double getPrecio() {return precio;}

    public void setPrecio(double precio) {this.precio = precio;}


    public char getTipo() {return tipo;}

    public void setTipo(char tipo) {this.tipo = tipo;}

    @Override
    public String toString() {
        return "Producto [codigo=" + codigo + ", precio=" + precio
                +   ", tipo=" + tipo + ", activo="
                + activo + "]";
    }

    public boolean isActivo() {return activo;}

    public void setActivo(boolean activo) {this.activo = activo;}

}