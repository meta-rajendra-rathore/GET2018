package datastructure_5.dictionary;

import java.util.Map;

public interface Dictionary {
    public boolean addItem(String word, String meaning); 
    public boolean deleteItem(String word); 
    public String getMeaning(String word); 
    public Map<String, String> sortedListOfKey(); 
    public Map<String, String> sortedListOfKeysBetweenTwoKeys(String key1, String key2);
}
