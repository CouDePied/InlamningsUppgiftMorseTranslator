package InlamningsuppgiftMorse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MorseTest {
    //Testar LogicClass

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

    //Testar hela alfabetet.
    @Test
    public void testWholeAlphabet() {

        //Arrange
        LogicClass logik = new LogicClass();
        //Expected är en enda lång String med mellanslag mellan morsebokstäverna.
        String expected = ".- -... -.-. -.. . ..-. --. .... .. .--- "
                + "-.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- "
                + ".-- -..- -.-- --..";
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

    //Kontrollerar hela ord.
    @Test
    public void testMorseToTextWords() {

        //Arrange
        LogicClass logik = new LogicClass();
        String expected = "HEJ";
        //Act
        String actual = logik.morseToText(".... . .---");
        //Assert
        assertEquals(expected, actual);
    }

    //kontrollerar omvandlaren fungerar.
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
        String expected = "Invalid character! Try again!";
        //Assert
        assertEquals(expected, actual);
    }

    //Kontrollerar ogiltig morsekod:
    @Test
    public void testInvalidMorse() {

        //Arrange
        LogicClass logik = new LogicClass();
        String input = ".-.-.-";
        String expected = "Invalid morse! Try again!";
        //Act
        String actual = logik.morseToText(input);
        //Assert
        assertEquals(expected, actual);
    }

    //Kontrollerar tom rad.
    @Test
    public void testEmptyInput() {

        //Arrange
        LogicClass logik = new LogicClass();
        String input = "";
        String expected = "No input.";
        //Act
        String actual = logik.textToMorse(input);
        //Assert
        assertEquals(expected, actual);
    }
}





