package InlamningsuppgiftMorse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MorseTest {

    //Kontrollerar text till morse.
    @Test
    public void testTextToMorseA() {

        //Arrange
        LogicClass logik = new LogicClass();
        String expected = ".-";
        //Act
        String actual = logik.textToMorse("A");
        //Assert
        assertEquals(expected, actual);

    }
//Kontrollerar text till morse.
    @Test
    public void testTextToMorseB() {
        //Arrange
        LogicClass logik = new LogicClass();
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
        LogicClass logik = new LogicClass();
        String expected = "B";
        //Act
        String actual = logik.morseToText("-...");
        //Assert
        assertEquals(expected, actual);
    }

    //Kontrollerar att programmet kan översätta flera bokstäver
    // och separera morsekoderna med mellanslag.
    @Test
    public void testMultipleLetters() {
        //Arrange
        LogicClass logik = new LogicClass();
        String expected = ".- -...";
        //Act
        String actual = logik.textToMorse("AB");
        //Assert
        assertEquals(expected, actual);
    }

    //Testa hela alfabetet.
    @Test
    public void testWholeAlphabet() {
        //Arrange
        LogicClass logik = new LogicClass();
        String expected = ".- -... -.-. -.. . ..-. --. .... .. .---" +
                ", -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...-," +
                " .-- -..- -.-- --..";
        //Act
        String actual = logik.textToMorse("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        //Assert
        assertEquals(expected, actual);

    }
//Kontrollerar en bokstav mitt i.
    @Test
    public void testMorseToText() {
        //Arrange
        LogicClass logik = new LogicClass();
        String expected = "H";
        //Act
        String actual = logik.morseToText("....");
        //Assert
        assertEquals(expected, actual);

    }

    @Test
    //Kontrollerar hela ord.
    public void testMorseToTextWords() {
        LogicClass logik = new LogicClass();

        String expected = "HEJ";
        String actual = logik.morseToText(".... . .---");
        assertEquals(expected, actual);

    }
//kontrollerar
    @Test
    public void testToUpperCase() {
        //Arrange
        LogicClass logik = new LogicClass();
        String expected = ".... . .---";

        //Act
        String actual = logik.textToMorse("hej");

        //Assert
        assertEquals(expected, actual);

    }
    //Kontrollerar om användaren skrivit in ogiltigt texttecken.
    @Test
    public void testInvalidCharacter() {
        //Arrange
        LogicClass logik = new LogicClass();
        String input = "HEJ!";

        //Act
        String actual = logik.textToMorse(input);
        String expected ="Appapp! Invalid character!";

        //Assert
        assertEquals(expected, actual);

    }
    @Test
    public void testInvalidMorse() {
        //Arrange
        LogicClass logik = new LogicClass();
        String input = ".-.-.-";
        String expected = "Appapp! Invalid morse!";

        //Act
        String actual = logik.morseToText(input);

        //Assert
        assertEquals(expected, actual);
    }
    @Test
    public void testEmptyInput() {
        //Arrange
        LogicClass logik = new LogicClass();
        String input = "";
        String expected = "No input";

        //Act
        String actual = logik.textToMorse(input);

        //Assert
        assertEquals(expected, actual);
    }
        }




