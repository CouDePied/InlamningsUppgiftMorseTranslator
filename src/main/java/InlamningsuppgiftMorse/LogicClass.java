package InlamningsuppgiftMorse;

import java.util.HashMap;

public class LogicClass {

    //Både key och value är strängar.
    private HashMap<String, String> morse;
    private HashMap<String, String> text;

    String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    //Array innehåller 26 morsekoder.
    String[] morsekod = {
            ".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."
    };

    //Konstruktorn skapar och fyller två hashmaps.
    public LogicClass() {
        //Skapar två hashmap objekt.
        morse = new HashMap<>();
        text = new HashMap<>();
        //Loopen går igenom alfabetet. 26 gånger.
        for (int i = 0; i < alfabet.length(); i++) {
            //Hämtar en bokstav från alfabetet (index i) och gör den till en String.
            String letter = Character.toString(alfabet.charAt(i));

            //Fyller en post i varje hashmap för varje bokstav.
            morse.put(letter, morsekod[i]);
            text.put(morsekod[i], letter);

        }
    }

    //Metoderna.
    public String textToMorse(String text) {
        //Anpassning om användaren skriver med små.
        //Omvandlar små bokstäver till stora innan loopen börjar översätta.
        text = text.toUpperCase();

        //Felhantering 1. Kontroll om användaren gjort en tom sträng. Return avslutar.
        if (text.isEmpty()) {
            return "No input.";
        }

        String result = "";

        //For loopen går igenom texten ett tecken i taget.
        for (int i = 0; i < text.length(); i++) {

            //Hämtar en bokstav i taget och omvandlar den till en string.
            String letter = Character.toString(text.charAt(i));

            //Hämtar översatta morsekoden för bokstaven från HashMap.
            String morseCode = morse.get(letter);

            //Felhantering 2:
            // Kontrollerar om bokstaven saknas för att get() returnerar null.
            if (morseCode == null) {
                return "Appapp! Invalid character!";
            } else {
                //Lägger till morsekoden i resultatet.
                result += morseCode + " ";
            }
        }

        //Tar bort mellanslaget i slutet.
        return result.trim();
    }

    public String morseToText(String morse) {
        //Delar upp morsekoden vid mellanslagen och sparar delarna i en array.
        String[] letters = morse.split(" ");
        String result = "";

        //Går igenom arrayen en morsebokstav i taget. Letters är en array.
        for (int i = 0; i < letters.length; i++) {

            //Hämtar en morsebokstav från arrayen och sparar det i en String.
            String letter = letters[i];
            String bokstav = text.get(letter);

            //Felhantering 3:
            // Kontrollerar om morsekoden finns i HashMap.
            if (bokstav == null) {
                return "Appapp! Invalid morse!";
            } else {
                result += bokstav; //+= lägger till något till det som redan finns i variabeln
            }
        }
        //Metoden skickar tillbaka hela den översatta texten.
        return result;
    }
}


