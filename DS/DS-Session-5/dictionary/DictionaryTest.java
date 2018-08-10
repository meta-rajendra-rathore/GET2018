package datastructure_5.dictionary;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class DictionaryTest {
    DictionaryImplementation dictionary;
    
    @Before
    public void init_WhenFileIsValid() {
        dictionary = new DictionaryImplementation();
        dictionary.readEntriesFromFile("dictionary.json");
    }
    
    @Test
    public void addItem_whenKeyValuesAreValid() {
        // Adding Word and its Meaning to Dictionary
        assertTrue(dictionary.addItem("Dog", "Type of Animal"));
    }
    
    @Test
    public void getMeaning_whenWordDoesNotExist() {
        assertNotEquals("A small mammal type animal", dictionary.getMeaning("Rabbit"));
    }

    @Test 
    public void getMeaning_whenWordExists_thenGetMeaning() {
        assertEquals("Emperor, ruler", dictionary.getMeaning("King"));
    }
    
    @Test
    public void deleteItem_whenWordExists() {
        // Deleting Word Attitude from Dictionary
        dictionary.addItem("Dog", "Type of Animal");
        assertTrue(dictionary.deleteItem("Dog"));
    }
    
    @Test
    public void deleteItem_whenWordDoesNotExist() {
        assertFalse(dictionary.deleteItem("Attitude"));
    }
    
    @Test
    public void addItemWithNull() throws FileNotFoundException {
        assertFalse(dictionary.addItem(null, "A furniture"));
    }

    @Test
    public void deleteItemWithNullKey() throws FileNotFoundException {
        assertFalse(dictionary.deleteItem(null));
    }

    @Test
    public void getMeaningWithNullKey() throws FileNotFoundException {
        assertFalse(dictionary.getMeaning(null));
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
}
