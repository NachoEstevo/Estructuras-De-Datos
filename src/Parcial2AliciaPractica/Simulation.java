package Parcial2AliciaPractica;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Simulation {


    public static void main(String[] args) throws FileNotFoundException {

        String[] provinces = {"Buenos Aires", "Catamarca", "Chaco", "Chubut", "Cordoba", "Corrientes", "Entre Rios", "Formosa", "Jujuy", "La Pampa", "La Rioja", "Mendoza", "Misiones", "Neuquen", "Rio Negro", "Salta", "San Juan", "San Luis", "Santa Cruz", "Santa Fe", "Santiago del Estero", "Tierra del Fuego", "Tucuman"};

        try {
            RainFile file = new RainFile("RainRegister.txt"); //RainRegister.txt
            for (int i = 0; i < provinces.length; i++) { //Add 12 random rain data for each province, as a ProvinceAndRain object

                file.write(new ProvinceAndRain(i, (int) ((Math.random() * 100) + 10), (int) ((Math.random() * 100) + 10), (int) ((Math.random() * 100) + 10), (int) ((Math.random() * 100) + 10), (int) ((Math.random() * 100) + 10), (int) ((Math.random() * 100) + 10), (int) ((Math.random() * 100) + 10), (int) ((Math.random() * 100) + 10), (int) ((Math.random() * 100) + 10), (int) ((Math.random() * 100) + 10), (int) ((Math.random() * 100) + 10), (int) ((Math.random() * 100) + 10)));
            }

            ProvinceAnualRain[] toPrint = getValues(file, provinces);
            for (ProvinceAnualRain province : toPrint) {
                System.out.println("Province: " + province.getName() + "   AnualRain: " + province.getAmount());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ProvinceAnualRain[] getValues(RainFile aFile, String[] provinces) throws IOException {
        ProvinceAnualRain[] anualRain = new ProvinceAnualRain[23]; // Province name and anual sum
        ProvinceAndRain[] provinceRain = new ProvinceAndRain[23]; // Index and 12 months info
        aFile.beginning();
        for (int j = 0; j < aFile.registers(); j++) {
            provinceRain[j] = aFile.read(); //Error reading
        }

        for (int i = 0; i < anualRain.length; i++) {
                int anualRainFromProvince = 0;
                anualRainFromProvince += provinceRain[i].getJanuary();
                anualRainFromProvince += provinceRain[i].getFebraury();
                anualRainFromProvince += provinceRain[i].getMarch();
                anualRainFromProvince += provinceRain[i].getApril();
                anualRainFromProvince += provinceRain[i].getMay();
                anualRainFromProvince += provinceRain[i].getJune();
                anualRainFromProvince += provinceRain[i].getJuly();
                anualRainFromProvince += provinceRain[i].getAugust();
                anualRainFromProvince += provinceRain[i].getSeptember();
                anualRainFromProvince += provinceRain[i].getOctober();
                anualRainFromProvince += provinceRain[i].getNovember();
                anualRainFromProvince += provinceRain[i].getDecember();
                anualRain[i] = new ProvinceAnualRain(provinces[provinceRain[i].getIndex()], anualRainFromProvince);
        }
        return anualRain;
    }
}
