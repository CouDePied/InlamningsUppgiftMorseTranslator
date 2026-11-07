package InlamningsuppgiftMorse;

import java.util.HashMap;

public class Logikklassen {

        //Översätter bokstäver till morsekod.
        HashMap<String, String> morse = new HashMap<>();
        //Översätter morsekod till bokstäver.   //Båda metoderna kan använda samma HashMaps.
        HashMap<String, String> text = new HashMap<>();


    String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   //Array med 26 morsekoder.
    String[] morsekoder = {
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
            //Fyller båda hashmaps.
            morse.put(letter, morsekoder[i]);
            text.put(morsekoder[i], letter);

        }
    }
    public String textToMorse(String text) {

      //Felhantering1  //Omvandlar små bokstäver till stora innan loopen börjar översätta
text = text.toUpperCase();

        String result = "";
        //En for-loop som går igenom texten tecken för tecken med charAt(i).
        //Sen en HashMap för att hämta morsekoden som motsvarar varje bokstav.
        //Loopen går igenom hela texten
        //Den körs en gång för varje tecken i texten
        for (int i = 0; i < text.length(); i++) {

            //CharHämtar en bokstav i taget.
           // char letter = text.charAt(i);
            String letter = Character.toString(text.charAt(i));

            //Felhantering2
            //Kontroll om bokstav finns i HashMap.
if (!morse.containsKey(letter)) {

    //Kastar ett IllegalArgumentexception om tecknet inte finns. Fungerar även på HEJ123
    throw new IllegalArgumentException("Appapp! Ogiltigt tecken!");
    //Meddelandet är det som testet sen kontrollerar.
}
            //Hämtar morsekoden och lägger den i resultatet.
                result += morse.get(letter) + " ";
            }

          //Tar bort mellanslaget i slutet.
        return  result.trim();
    }

        public String morseToText(String morse) {
//Delar upp morse koden i en array så att det inte blir en lång sträng.
String[] letters = morse.split(" ");
String result = "";


//Går igenom arrayen en morsebok i taget.
            for (int i = 0; i < letters.length; i++) {

         //Hämtar en morsebokstav.       //Och sparar det i en String.
                String letter = letters[i];

                if (!text.containsKey(letter)) {
                    throw new IllegalArgumentException("Ogiltig morsekod");
                }
               //Översätter och lägger till bokstaven i resultatet.
            result += text.get(letter);

            }
            //Metoden skickar tillbaka hela den översatta texten.
            return result;
        }
    }

//+= betyder att vi lägger till något till det som redan finns i variabeln

//if (i > 0) {
//    result += " ";
//}

