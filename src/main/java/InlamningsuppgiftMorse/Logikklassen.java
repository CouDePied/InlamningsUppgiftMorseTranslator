package InlamningsuppgiftMorse;

import java.util.HashMap;

public class Logikklassen {

    //En HashMap som innehåller översättning åt båda håll.
    //För varje bokstav ligger två poster i samma Hashmap.
    //Först är bostaven-key och morse-value.
    //Sen tvärtom.
    HashMap<String, String> map = new HashMap<>();

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
        //Loopen går igenom alfabetet. 26 gånger.
        for (int i = 0; i < alfabet.length(); i++) {
            //Hämtar en bokstav
            String letter = Character.toString(alfabet.charAt(i));
            //Fyller hashmapen.
            map.put(letter, morsekod[i]);
            map.put(morsekod[i], letter);

        }
    }
    public String textToMorse(String text) {

      //Omvandlar små bokstäver till stora innan loopen börjar översätta.
text = text.toUpperCase();

        String result = "";
        //En for-loop som går igenom texten tecken för tecken med charAt(i).
        //Sen en HashMap för att hämta morsekoden som motsvarar varje bokstav.
        //Loopen går igenom hela texten
        //Den körs en gång för varje tecken i texten
        for (int i = 0; i < text.length(); i++) {

            //CharHämtar en bokstav i taget.
            String letter = Character.toString(text.charAt(i));

            //Felhantering1
            // Kontrollerar om bokstav finns i HashMap.
if (!map.containsKey(letter)) {
    //Och om tecknet INTE finns så går programmet in i if.

    //Då kastas ett IllegalArgumentexception om tecknet inte finns. Fungerar även på HEJ123
    throw new IllegalArgumentException("Appapp! Ogiltigt tecken!");
    //Meddelandet är det som testet sen kontrollerar.
    //Exceptionet fångas av mainklassen med catch och skriver ut felmeddelande.
}
            //Hämtar morsekoden och lägger den i resultatet.
                result += map.get(letter) + " ";
            }

          //Tar bort mellanslaget i slutet.
        return  result.trim();
    }

        public String morseToText(String morse) {
//Delar upp morse koden i en array så att det inte blir en lång sträng.
String[] letters = morse.split(" ");
String result = "";


//Går igenom arrayen en morsebokstav i taget.
            for (int i = 0; i < letters.length; i++) {

         //Hämtar en morsebokstav.       //Och sparar det i en String.
                String letter = letters[i];
    //Felhantering2
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

//if (i > 0) {
//    result += " ";
//}

