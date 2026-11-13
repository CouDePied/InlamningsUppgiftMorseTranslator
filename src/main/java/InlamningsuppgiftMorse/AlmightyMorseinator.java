package InlamningsuppgiftMorse;

import java.util.Scanner;

public class AlmightyMorseinator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Skapar ett objekt som kan använda de två metoderna.
        LogicClass logik = new LogicClass();

        System.out.println("Welcome to the Almighty Morseinator!");

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("1. Text to morse");
            System.out.println("2. Morse to text");
            System.out.println("3. Exit");

            System.out.println("Please choose an option:");

            String choice = scan.nextLine();
            try {

                //Kontrollerar om användaren har valt 1.
                if (choice.equals("1")) {
                    System.out.println("Enter text:");
                    String input = scan.nextLine();
                    //Översätter till morsekod.
                    System.out.println(logik.textToMorse(input));

                } else if (choice.equals("2")) {
                    System.out.println("Enter Morse code:");
                    String input = scan.nextLine();
                    //Översätter till text.
                    System.out.println(logik.morseToText(input));
                } else if (choice.equals("3")) {
                    //Gör att loopen avslutas.
                    isRunning = false;
                    System.out.println("Thank you! Goodbye!");
                }

                //Mainklassen skickar texten till Logikklassen.
                //Som ser att ! inte finns i alfabetet.
                //En IllegalArgumentException kastas.
                //Catch fångar felet.
                //Användaren får felmeddelandet.
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }
        }
    }
}



