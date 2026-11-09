package InlamningsuppgiftMorse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MorseTest {
    @Test
    public void testTextToMorse() {

        //Arrange
        Logikklassen logik = new Logikklassen();
        String expected = ".-";
        //Act
        String actual = logik.textToMorse("A");
        //Assert
        assertEquals(expected, actual);

    }

    @Test
    public void testTextToMorseB() {
        //Arrange
        Logikklassen logik = new Logikklassen();
        String expected = "-...";
        //Act
        String actual = logik.textToMorse("B");
        //Assert
        assertEquals(expected, actual);

    }

    //Kontrollerar morse till text
    @Test
    public void testMorseToTextB() {
        //Arrange
        Logikklassen logik = new Logikklassen();
        String expected = "B";
        //Act
        String actual = logik.morseToText("-...");
        //Assert
        assertEquals(expected, actual);
    }

    //Kontrollerar att programmet kan översätta flera bokstäver och separera morsekoderna med mellanslag.
    @Test
    public void testMultipleLetters() {
        //Arrange
        Logikklassen logik = new Logikklassen();
        String expected = ".- -...";
        //Act
        String actual = logik.textToMorse("AB");
        //Assert
        assertEquals(expected, actual);
    }

    //Testa hela alfabetet
    @Test
    public void testWholeAlphabet() {
        //Arrange
        Logikklassen logik = new Logikklassen();
        String expected = ".- -... -.-. -.. . ..-. --. .... .. .--- "
                + "-.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- "
                + ".-- -..- -.-- --..";
        //Act
        String actual = logik.textToMorse("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        //Assert
        assertEquals(expected, actual);

    }

    @Test
    public void testMorseToText() {
        //Arrange
        Logikklassen logik = new Logikklassen();
        String expected = "H";
        //Act
        String actual = logik.morseToText("....");
        //Assert
        assertEquals(expected, actual);

    }

    @Test
    public void testMorseToTextWords() {
        Logikklassen logik = new Logikklassen();

        String expected = "HEJ";
        String actual = logik.morseToText(".... . .---");
        assertEquals(expected, actual);

    }

    @Test
    public void testToUpperCase() {
        //Arrange
        Logikklassen logik = new Logikklassen();
        String expected = ".... . .---";

        //Act
        String actual = logik.textToMorse("hej");

        //Assert
        assertEquals(expected, actual);

    }
    @Test
    public void testInvalidCharacter() {

        //Arrange
        Logikklassen logik = new Logikklassen();
        boolean errorFound = false;

        //Act
        try {
            logik.textToMorse("HEJ!");

        } catch (IllegalArgumentException e) {
            errorFound = true;

            //Assert
            assertEquals("Appapp! Ogiltigt tecken!", e.getMessage());
        }

        assertEquals(true, errorFound);
    }
    @Test
    public void testInvalidMorse() {
//Arrange
        Logikklassen logik = new Logikklassen();

        //errorFound börjar som false
        //Försöker översätta ".-.-.-."
        //Om metoden kastar ett IllegalArgumentException fångas det av catch.
        //Kontrollen är att exception verkligen kastades..
        boolean errorFound = false;

        //Act
        try {
            logik.morseToText(".-.-.-");
        } catch (IllegalArgumentException e) {
            errorFound = true;
        }
            //Assert
            assertEquals(true, errorFound);

        }
    }



