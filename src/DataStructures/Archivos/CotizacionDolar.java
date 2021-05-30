package DataStructures.Archivos;

public class CotizacionDolar {
    int mes;
    int cotizacion;

    public CotizacionDolar(int mes, int cotizacion) {
        this.mes = mes;
        this.cotizacion = cotizacion;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(int cotizacion) {
        this.cotizacion = cotizacion;
    }
}
