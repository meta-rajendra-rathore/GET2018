/**
 * The class implements a cache for CountUniqueChar class and store results
 */

package datastructure_4.uniquecharacters;

/**
 * @author Rajendra Singh Rathore
 */

import java.util.HashMap;
import java.util.Map;

public class CacheOfProcessedStrings {
    Map<String, Integer> collectionOfProcessedStrings;  // String as key and no of unique characters in it as value

    public CacheOfProcessedStrings() {
        collectionOfProcessedStrings = new HashMap<String, Integer>();
    }
    
    /**
     * @return the cacheOfProcessedStrings
     */
    public Map<String, Integer> getCollectionOfProcessedStrings() {
        return collectionOfProcessedStrings;
    }
    
    /**
     * Retrieve the number of unique characters in the given string 
     * @param charSeq
     * @return noOfUniqueChars
     */
    public int getUniqueCharInString(String charSeq) {
        if (collectionOfProcessedStrings.containsKey(charSeq)) {
            int noOfUniqueChars = collectionOfProcessedStrings.get(charSeq);
            return noOfUniqueChars;
        } 
        
        return 0;
    }
}
