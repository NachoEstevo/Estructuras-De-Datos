package Parcial2AliciaPractica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RainFile {
        private File f;
        private RandomAccessFile raf;
        private int sizeReg = 52; //Int = 4.  12 meses mas 1 index. 13X4 = 52;

        public RainFile(String nombre)throws FileNotFoundException {
            f = new File(nombre);
            raf = new RandomAccessFile(f,"rw");
        }

        public void write(ProvinceAndRain p)  throws IOException {
            raf.writeInt(p.getIndex());
            raf.writeInt(p.getJanuary());
            raf.writeInt(p.getFebraury());
            raf.writeInt(p.getMarch());
            raf.writeInt(p.getApril());
            raf.writeInt(p.getMay());
            raf.writeInt(p.getJune());
            raf.writeInt(p.getJuly());
            raf.writeInt(p.getAugust());
            raf.writeInt(p.getSeptember());
            raf.writeInt(p.getOctober());
            raf.writeInt(p.getNovember());
            raf.writeInt(p.getDecember());
        }

        public void close()  throws IOException {raf.close();}

        //Implemented as seen in class. Reads 12 values. Not the index.
        public ProvinceAndRain read() throws IOException{return new ProvinceAndRain(raf.readInt(),raf.readInt(),raf.readInt(),raf.readInt(),raf.readInt(),raf.readInt(),raf.readInt(),raf.readInt(),raf.readInt(),raf.readInt(),raf.readInt(),raf.readInt(),raf.readInt());}

        public long registers() throws IOException {return raf.length()/sizeReg;}

        public long length () throws IOException {return raf.length();}

        public void beginning() throws IOException{raf.seek(0);}

        public void end() throws IOException{raf.seek(raf.length());}

        public void delete() throws IOException {f.delete();}

        public void rename(String nombre) throws IOException {
            File file = new File (nombre);
            f.renameTo(file);
        }

    }

