/**
 * This class counts number of unique characters in passed string using custom function and cache for optimization 
 */
package datastructure_4.uniquecharacters;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Rajendra Singh Rathore
 *
 */
public class CountUniqueChar {
    CacheOfProcessedStrings cache;
    Set<Character> uniqueChars;
    Set<Character> repeatedChars;

    public CountUniqueChar() {
        cache = new CacheOfProcessedStrings();
        uniqueChars = new HashSet<Character>();
        repeatedChars = new HashSet<Character>();
    }

    /**
     * The function counts number of unique elements in the string, it checks if the
     * string was encountered before, if it did, result is retrieved from cache 
     * and counted otherwise
     * 
     * @param charSeq
     * @return number of unique characters
     */
    public int getNoOfUniqueChar(String charSeq) {
        if (charSeq == null) {
            throw new AssertionError("Passed parameter is null!");
        }
        
        /**
         * Check and retrieve results from cache if string was encountered before too
         */
        if (cache.getCollectionOfProcessedStrings().containsKey(charSeq)) {
            return cache.getUniqueCharInString(charSeq);
        }

        uniqueChars.clear();
        repeatedChars.clear();

        /**
         * If the character is unique then add it to the set of unique characters and 
         * to repeated characters otherwise
         */
        for (int i = 0; i < charSeq.length(); i++) {
            char currentChar = charSeq.charAt(i);
            if (uniqueChars.contains(currentChar)) {    // character was unique but encountered second time
                uniqueChars.remove(currentChar);        // hence remove it 
                repeatedChars.add(currentChar);         // and add to repeated char set
            } else if (!repeatedChars.contains(currentChar)) {  // check if a missing char from unique set exists in repeated set
                uniqueChars.add(charSeq.charAt(i));
            }
        }
        cache.getCollectionOfProcessedStrings().put(charSeq, uniqueChars.size());
        return uniqueChars.size();
    }
}
