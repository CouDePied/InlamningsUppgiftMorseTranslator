package InlamningsuppgiftMorse;

import java.util.HashMap;

public class Logikklassen {
    public String textToMorse(String text) {

        HashMap<String, String> morse = new HashMap<>();

        morse.put("A", ".-");
        morse.put("B", "-...");
        morse.put("C", "-.-.");
        morse.put("D", "-..");
        morse.put("E", ".");
        morse.put("F", "..-.");
        morse.put("G", "--.");
        morse.put("H", "....");
        morse.put("I", "..");
        morse.put("J", ".---");
        morse.put("K", "-.-");
        morse.put("L", ".-..");
        morse.put("M", "--");
        morse.put("N", "-.");
        morse.put("O", "---");
        morse.put("P", ".--.");
        morse.put("Q", "--.-");
        morse.put("R", ".-.");
        morse.put("S", "...");
        morse.put("T", "-");
        morse.put("U", "..-");
        morse.put("V", "...-");
        morse.put("W", ".--");
        morse.put("X", "-..-");
        morse.put("Y", "-.--");
        morse.put("Z", "--..");
        // return morse.get(text);

        String result = "";
        //En for-loop som går igenom texten tecken för tecken med charAt(i).
        //Sen en HashMap för att hämta morsekoden som motsvarar varje bokstav.
        //Loopen går igenom hela texten
        //Den körs en gång för varje tecken i texten
        for (int i = 0; i < text.length(); i++) {
            //morse.get(String.valueOf(letter));
            //CharHämtar en bokstav i taget.
           // char letter = text.charAt(i);
            String letter = Character.toString(text.charAt(i));

            //Gör mellanslag
                result += morse.get(letter) + " ";
            }
            //Översätter bokstaven
            //Den hämtar motsvarande morsekod från HashMap och lägger till den i resultatet.
            //result += morse.get(String.valueOf(letter));


        return  result.trim();
    }
    //public String morseToText(String morse) {
       // return "A";
        public String morseToText(String morse) {

            HashMap<String, String> text = new HashMap<>();

            text.put(".-", "A");
            text.put("-...", "B");

            return text.get(morse);
        }
    }

//+= betyder att vi lägger till något till det som redan finns i variabeln
//result += morse.get(String.valueOf(letter)) + " ";
//if (i > 0) {
//    result += " ";
//}
//
//result += morse.get(String.valueOf(letter));
