package DataStructures.Archivos;

public class MontoDestino {
    String codigoDeDestino;
    String descripcion;
    int montoDestino;

    public MontoDestino(String codigoDeDestino, String descripcion) {
        this.codigoDeDestino = codigoDeDestino;
        this.descripcion = descripcion;
        montoDestino = 0;
    }

    public String getCodigoDeDestino() {
        return codigoDeDestino;
    }

    public void setCodigoDeDestino(String codigoDeDestino) {
        this.codigoDeDestino = codigoDeDestino;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMontoDestino() {
        return montoDestino;
    }

    public void setMontoDestino(int montoDestino) {
        this.montoDestino += montoDestino;
    }

    public String toString(){
        return "\nDestino: " + descripcion + "\n" +
                "Monto total: " + montoDestino;
    }
}
