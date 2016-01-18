package Parser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Pair.Pair;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class PairFileParserTest {

    PairFileParser pairFileParser;

    @Before
    public void setUp() throws Exception {
        String DESKTOP_PATH = System.getProperty("user.home");
        String FILE_NAME = DESKTOP_PATH + "\\desktop\\simple.txt";

        File file = new File(FILE_NAME);
        pairFileParser = new PairFileParser(file);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testReadPair() throws Exception {
        try {
            Pair pair = pairFileParser.readPair('=');
            assertEquals(pair.getKey(), "NAME");
            assertEquals(pair.getValue().toString(), "[JOHN DOE]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRead() throws Exception {
        try {
            char c = (char) pairFileParser.read();
            assertEquals(c, 'N');
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testReadLine() throws Exception {
        try {
            String line = pairFileParser.readLine();
            assertEquals(line, "NAME = JOHN DOE");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testEndOfBlock() throws Exception {
        pairFileParser.endOfBlock('-', '-');
        assertFalse(pairFileParser.isEndOfBlock());
    }

    @Test
    public void testIsEndOfBlock() throws Exception {
        testEndOfBlock();
        try {
            while (pairFileParser.readPair('=') != null){
                if (pairFileParser.isEndOfBlock()){
                    assertTrue(true);
                   break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}