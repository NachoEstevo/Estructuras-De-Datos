package TraductorRomano;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanTranslator {

    public int romanToInt(String romanNumero){
        Map<Character, Integer> values = new LinkedHashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        int number = 0;
        for (int i = 0; i < romanNumero.length(); i++) {
            if (i+1 == romanNumero.length() || values.get(romanNumero.charAt(i)) >= values.get(romanNumero.charAt(i + 1))) {
                number += values.get(romanNumero.charAt(i));
            } else {
                number -= values.get(romanNumero.charAt(i));
            }
        }
        return number;
    }


    public static void main(String[] args) {
        RomanTranslator aTranslator = new RomanTranslator();
        Scanner input = new Scanner(System.in);
        System.out.print("Inserte un String: ");
        String toConvert = input.nextLine();

        System.out.println("El numero romano se traduce a : " + aTranslator.romanToInt(toConvert.toUpperCase()));

    }
}
