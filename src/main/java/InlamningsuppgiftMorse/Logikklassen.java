package InlamningsuppgiftMorse;

import java.util.HashMap;

public class Logikklassen {


    //private HashMap<String, String> map;
    private HashMap<String, String> morse;
    private HashMap<String, String> text;

    String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    String[] morsekod = {
            ".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."
    };

    public Logikklassen() {
        morse = new HashMap<>();
        text = new HashMap<>();
        //Loopen går igenom alfabetet. 26 gånger.
        for (int i = 0; i < alfabet.length(); i++) {
            //Hämtar en bokstav från alfabetet och gör den till en String
            String letter = Character.toString(alfabet.charAt(i));

            //Fyller hashmapen med två poster för varje bokstav.
           // map.put(letter, morsekod[i]);
           // map.put(morsekod[i], letter);
            morse.put(letter, morsekod[i]);
            text.put(morsekod[i], letter);

        }
    }

    public String textToMorse(String text) {

        //Omvandlar små bokstäver till stora innan loopen börjar översätta.
        //Anpassning.
        text = text.toUpperCase();

        //Felhantering. Kontroll om användaren skrivit något.
        if (text.isEmpty()) {
            return "No input";
        }

        String result = "";

        //For loopen går igenom texten tecken för tecken med charAt(i).
        //Den körs en gång för varje tecken i texten
        for (int i = 0; i < text.length(); i++) {

            //Hämtar en bokstav i taget och omvandlar den till en string.
            String letter = Character.toString(text.charAt(i));


               // String morsekod = morse.get(letter);
//Hämtar morsekoden för bokstaven från HashMap.
            String morseCode = morse.get(letter);

//Felhantering 1: Kontrollerar om bokstaven finns.
            if (morseCode == null) {
                return "Appapp! Invalid character!";
            } else {
                //Lägger till morsekoden i resultatet.
                result += morseCode + " ";
            }



            //Hämtar morsekoden och lägger den i resultatet.
           // result += morse.get(letter) + " ";
        }

        //Tar bort mellanslaget i slutet.
        return result.trim();
    }

    public String morseToText(String morse) {
//Delar upp morsekoden vid mellanslagen och sparar delarna i en array.
        String[] letters = morse.split(" ");
        String result = "";


//Går igenom arrayen en morsebokstav i taget.
        for (int i = 0; i < letters.length; i++) {

            //Hämtar en morsebokstav.       //Och sparar det i en String.
            String letter = letters[i];
            String bokstav = text.get(letter);

//Felhantering 2:
// Kontrollerar om morsekoden finns i HashMap.
            if (bokstav == null) {
                return "Appapp! Invalid morse!";
            } else {
                result += bokstav;
            }
            }
            //Översätter och lägger till bokstaven i resultatet.
            //result += map.get(letter);
           // result += text.get(letter);


        //Metoden skickar tillbaka hela den översatta texten.
        return result;
    }
}

//+= betyder att vi lägger till något till det som redan finns i variabeln

