package datastructure_5.dictionary;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DictionaryTest {
    DictionaryImplementation dictionary;
    
    @Before
    public void initWithValidFile() {
        dictionary = new DictionaryImplementation();
        dictionary.readEntriesFromFile("dictionary.json");
    }

    @Test
    public void test() {
        assertEquals("Emperor, ruler", dictionary.getMeaning("King"));
    }
    
    @Rule
    public ExpectedException ex = ExpectedException.none();

    @Test
    public void addItemTest() {
        // Adding Word and its Meaning to Dictionary
        assertTrue(dictionary.addItem("Dog", "Type of Animal"));
    }

    @Test
    public void deleteItemTest() {
        // Deleting Word Attitude from Dictionary
        dictionary.addItem("Dog", "Type of Animal");
        assertTrue(dictionary.deleteItem("Dog"));
    }

    @Test
    public void getMeaningTest() {
        // Getting Meaning of word Attitude
        assertEquals("A small mammal type animal",
                dictionary.getMeaning("Mouse"));
    }

    @Test
    public void sortedListOfKeyTest() {
        // Sorting Dictionary
        Map<String, String> sortedWords = new HashMap<String, String>();
        sortedWords.put("Chair",
                "Furniture used to sit");
        sortedWords.put("King",
                "Emperor, ruler");
        sortedWords.put("Mouse",
                "A small mammal type animal");
        sortedWords.put("Washing Machine",
                "An electric machines");
        assertEquals(sortedWords,
                dictionary.sortedListOfKey());
    }

    @Test
    public void sortedListOfKeysBetweenTwoKeysTest() {
        // Sorting Dictionary in Range Attitude to Content
        Map<String, String> sortedWords = new HashMap<String, String>();
        sortedWords.put("Chair",
                "Furniture used to sit");
        sortedWords.put("King",
                "Emperor, ruler");
        sortedWords.put("Mouse",
                "A small mammal type animal");
        assertEquals(sortedWords,
                dictionary.sortedListOfKeysBetweenTwoKeys("Chair", "Mouse"));
    }

    @Test
    public void addItemWithNull() throws FileNotFoundException {
        // Adding a null word
        ex.expect(NullPointerException.class);
        ex.expectMessage("Key or Value to be Added can't be Null");
        dictionary.addItem(null, "Input");
    }

    @Test
    public void deleteItemWithNullKey() throws FileNotFoundException {
        // Deleting a Null Word
        ex.expect(NullPointerException.class);
        ex.expectMessage("Key to be Deleted can't be Null");
        dictionary.deleteItem(null);
    }

    @Test
    public void getMeaningWithNullKey() throws FileNotFoundException {
        // Getting a Null Word meaning
        ex.expect(NullPointerException.class);
        ex.expectMessage("Key to get Value can't be Null");
        dictionary.getMeaning(null);
    }
}
