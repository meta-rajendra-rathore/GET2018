/**
 * This class implements the Dictionary interface and provide functionality for dictionary of words
 */
package datastructure_5.dictionary;

/**
 * @author Rajendra Singh Rathore
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DictionaryImplementation implements Dictionary {
    Map<String, String> dictionary;

    public DictionaryImplementation() {
        dictionary = new TreeMap<String, String>();
    }

    /**
     * Read words from json file and enter them into dictionary 
     * @param fileName
     */
    public void readEntriesFromFile(String fileName) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj = (JSONObject) new JSONParser().parse((new FileReader(fileName)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONObject wordsList = (JSONObject) jsonObj.get("DictionaryData");
        dictionary.putAll((Map<? extends String, ? extends String>) wordsList);

    }

    /**
     * Add new word and its meaning to the dictionary
     */
    @Override
    public boolean addItem(String word, String meaning) {
        if (word == null || meaning == null || dictionary.containsKey(word)) {
            throw new NullPointerException("Key or Value to be Added can't be Null");
        } else {
            dictionary.put(word, meaning);
            return true;
        }
    }

    /**
     * Delete entry from the dictionary using the passed word
     */
    @Override
    public boolean deleteItem(String word) {
        if (word == null || !dictionary.containsKey(word)) {
            throw new NullPointerException("Key to be Deleted can't be Null");
        } else {
            dictionary.remove(word);
            return true;
        }
    }

    /**
     * get the meaning of the given word
     */
    @Override
    public String getMeaning(String word) {
        if (word == null) {
            throw new NullPointerException("Key to get Value can't be Null");
        }
        return dictionary.get(word);
    }

    /**
     * return the sorted list
     */
    @Override
    public Map<String, String> sortedListOfKey() {
        return dictionary;
    }

    /**
     * return the sorted list between the two given keys
     */
    @Override
    public Map<String, String> sortedListOfKeysBetweenTwoKeys(String key1, String key2) {
        Map<String, String> sortedListInRange = new HashMap<String, String>();
        Set<String> listOfRequiredKeys = dictionary.keySet();
        Iterator<String> iterator = listOfRequiredKeys.iterator();
        Boolean keyIsElligible = false;
        while (iterator.hasNext()) {
            String currentKey = iterator.next();
            if (key1.equals(currentKey)) {
                keyIsElligible = true;
            } 
            if (keyIsElligible) {
                sortedListInRange.put(currentKey, dictionary.get(currentKey));
            }
            if (key2.equals(currentKey)) {
                keyIsElligible = false;
            }
        }
        return sortedListInRange;
    }

}
