package DataStructures.Archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ArchivoVentas {
        private File f;
        private RandomAccessFile raf;
        private int sizeReg = 30;

        public ArchivoVentas(String nombre)throws FileNotFoundException {
            f = new File(nombre);
            raf = new RandomAccessFile(f,"rw");
        }

        public void escribir(Venta p)  throws IOException {
            raf.writeUTF(p.getCodigoDeDestino());
            raf.writeInt(p.getCodigoDeArticulo());
            raf.writeInt(p.getCantidad());
            raf.writeInt(p.getPrecioUnitarioEnDolares());
            raf.writeInt(p.getDia());
            raf.writeInt(p.getMes());
            raf.writeInt(p.getAño());
            //raf.writeBytes("\r\n");
        }

        public void cerrar()  throws IOException {
            raf.close();
        }

        public Venta leer() throws IOException{
            return new Venta(raf.readUTF(),raf.readInt(),raf.readInt(), raf.readInt(), raf.readInt(), raf.readInt(), raf.readInt());
        }

        public long cantReg() throws IOException {
            return raf.length()/sizeReg;
        }

        public long length () throws IOException {
            return raf.length();
        }

        public void inicio() throws IOException{
            raf.seek(0);
        }

        public void fin() throws IOException{
            raf.seek(raf.length());
        }


        public void borrar() throws IOException {
            f.delete();
        }

        public void renombrar(String nombre) throws IOException {
            File file = new File (nombre);
            f.renameTo(file);
        }

}
