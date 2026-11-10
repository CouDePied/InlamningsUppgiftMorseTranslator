package InlamningsuppgiftMorse;

import java.util.HashMap;

public class Logikklassen {

    //En HashMap som innehåller översättning åt båda håll.
    //För varje bokstav sparas två poster i samma Hashmap.
    //Först är bokstaven-key och morse-value.
    //Sen tvärtom.
    //HashMap<String, String> map = new HashMap<>();
    private HashMap<String, String> map;

    String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //Array med 26 morsekoder.
    String[] morsekod = {
            ".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."
    };

    public Logikklassen() {
        map = new HashMap<>();
        //Loopen går igenom alfabetet. 26 gånger.
        for (int i = 0; i < alfabet.length(); i++) {
            //Hämtar en bokstav från alfabetet och gör den till en String
            String letter = Character.toString(alfabet.charAt(i));
            //Fyller hashmapen med två poster för varje bokstav.
            map.put(letter, morsekod[i]);
            map.put(morsekod[i], letter);

        }
    }

    public String textToMorse(String text) {

        //Omvandlar små bokstäver till stora innan loopen börjar översätta.
        text = text.toUpperCase();

        String result = "";

        //For loopen går igenom texten tecken för tecken med charAt(i).
        //Den körs en gång för varje tecken i texten
        for (int i = 0; i < text.length(); i++) {

            //Hämtar en bokstav i taget och omvandlar den till en string.
            String letter = Character.toString(text.charAt(i));

            //Felhantering 1:
            //Kontrollerar om ogiltigt tecken finns i texten..
            if (!map.containsKey(letter)) {
                //Och om tecknet INTE finns så går programmet in i if.

                //Då kastas ett IllegalArgumentexception om tecknet inte finns. Fungerar även på HEJ123.
                //Meddelandet är det som testet sen kontrollerar.
                //Exceptionet fångas av mainklassen med catch och skriver ut felmeddelande.
                throw new IllegalArgumentException("Appapp! Ogiltigt tecken!");

            }
            //Hämtar morsekoden och lägger den i resultatet.
            result += map.get(letter) + " ";
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

            //Felhantering 2: Ogiltig morsekod.
            if (!map.containsKey(letter)) {
                throw new IllegalArgumentException("Ogiltig morsekod!");
            }
            //Översätter och lägger till bokstaven i resultatet.
            result += map.get(letter);

        }
        //Metoden skickar tillbaka hela den översatta texten.
        return result;
    }
}

//+= betyder att vi lägger till något till det som redan finns i variabeln

