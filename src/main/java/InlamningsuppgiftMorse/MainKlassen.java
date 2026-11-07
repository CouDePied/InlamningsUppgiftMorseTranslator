package InlamningsuppgiftMorse;

import java.util.Scanner;

public class MainKlassen {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Skapar ett objekt som kan använda de två metoderna.
        Logikklassen logik = new Logikklassen();


        System.out.println("Skriv in text eller morsekod:");

        //Läser in hela raden och sparar den i input.
        String input = scan.nextLine();
        try {
//Avgör om användaren skriver vanlig text eller morsekod.
            if (input.startsWith(".") || input.startsWith("-")) {
                System.out.println(logik.morseToText(input));
            } else {
                System.out.println(logik.textToMorse(input));

            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }   //Mainklassen skickar texten till Logikklassen.
    //Som ser att ! inte finns i alfabetet.
    //En IllegalArgumentException kastas.
    //Catch fångar felet.
    //Användaren får felmeddelandet.
}
