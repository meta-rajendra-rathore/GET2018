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
        
        /**
         * This below two code fetch items one by one from JSON file 
         * and add them to dictionary
         */
        
        /*Set<Entry<String, String>> set = wordsList.entrySet();
        Iterator<Entry<String, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> currentKey = iterator.next(); 
            addItem(currentKey.getKey(), currentKey.getValue());
        }*/
        
        /*Set<String> set = wordsList.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String currentKey = iterator.next();
            addItem(currentKey, wordsList.get(currentKey)+"");
        }*/
    }

    /**
     * Add new word and its meaning to the dictionary
     * @param word
     * @param meaning
     * @return true if item added successfully and false otherwise
     */
    @Override
    public boolean addItem(String word, String meaning) {
        if (word == null || meaning == null )) {
            System.out.println("Key or Value to be Added can't be Null");
            return false;
        } else if (dictionary.containsKey(word)) {
            System.out.println("The word already exists in the dictionary");
            return false;
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
        if (word == null )) {
            System.out.println("Key to be deleted can't be Null");
            return false;
        } else if (!dictionary.containsKey(word)) {
            System.out.println("The word doesn't exist in the dictionary");
            return false;
        } else {
            dictionary.remove(word);
            return true;
        }
    }

    /**
     * get the meaning of the given word
     * @param word whose meaning is required
     * @return meaning of the word
     */
    @Override
    public String getMeaning(String word) {
        if (word == null) {
            System.out.println("Key to get Value can't be Null");
            return "";
        } else if (!dictionary.containsKey(word)) {
            System.out.println("The word doesn't exist in the dictionary");
            return "";
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
     * @param key1
     * @param key2
     * @return sorted list in range
     */
    @Override
    public Map<String, String> sortedListOfKeysBetweenTwoKeys(String key1, String key2) {
        Map<String, String> sortedListInRange = new HashMap<String, String>();
        Set<String> listOfRequiredKeys = dictionary.keySet(); // extract keys from the dictionary and save in set
        Iterator<String> iterator = listOfRequiredKeys.iterator();
        while (iterator.hasNext()) {
            String currentKey = iterator.next();
            if (key1.compareTo(currentKey) <= 0 && key2.compareTo(currentKey) >= 0) {
                sortedListInRange.put(currentKey, dictionary.get(currentKey)); // add elligible key value pair to sortedList
            }
        }
        return sortedListInRange;
    }

}
