/*
 * This class provide custom made methods for strings
 * @author Rajendra Singh Rathore
 * 
 */

package customstring;

import java.util.ArrayList;

public class CustomString {
	private String userString;

	public CustomString(String userString) {
		this.userString = userString;
	}

	/**
	 * Checks equivalence between the two strings
	 * 
	 * @param checkEqualityString
	 * @return 1 if both strings are equal otherwise 0
	 */
	public int isEquals(String checkEqualityString) {
		if (userString.length() == checkEqualityString.length()) {
			for (int i = 0; i < userString.length(); i++) {
				if (userString.charAt(i) != checkEqualityString.charAt(i)) {
					return 0;
				}
			}
		} else {
			return 0;
		}
		return 1;
	}

	/**
	 * Find Reverse string of the input String
	 * 
	 * @return
	 */
	public String reverseString() {
		String reverseString = "";
		for (int i = userString.length() - 1; i >= 0; i--) {
			reverseString = reverseString + userString.charAt(i);
		}
		return reverseString;
	}

	/**
	 * Convet Lowercase characters to Uppercase and Vice-versa
	 * 
	 * @return modified string
	 */
	public String viceVersa() {
		String viceVersa = "";
		int lowerToUpper = 'a' - 'A';
		for (int i = 0; i < userString.length(); i++) {
			if (userString.charAt(i) >= 'a' && userString.charAt(i) <= 'z') {
				viceVersa = viceVersa + (char) (userString.charAt(i) - lowerToUpper);
			} else if (userString.charAt(i) >= 'A' && userString.charAt(i) <= 'Z') {
						viceVersa = viceVersa + (char) (userString.charAt(i) + lowerToUpper);
					} else if (userString.charAt(i) == ' ') {
								viceVersa = viceVersa + " ";
							} else {
								viceVersa = viceVersa + userString.charAt(i);
							}	
		}
		return viceVersa;
	}

	/**
	 * Find the Longest word in a string 
	 * if two words are of same length then return last word
	 * 
	 * @return longest word
	 */
	public String longestWord() {
		ArrayList<Integer> wordCount = new ArrayList<Integer>();
		ArrayList<String> wordInString = new ArrayList<String>();
		int characterCount = 0;
		String wordTaker = "";
		for (int i = 0; i < userString.length(); i++) {
			if ((char) userString.charAt(i) == ' ' || i == userString.length() - 1) {
				if (i == userString.length() - 1) {
					wordCount.add(characterCount + 1);
					wordTaker = wordTaker + userString.charAt(userString.length() - 1);
					wordInString.add(wordTaker);
				} else {
					wordCount.add(characterCount);
					wordInString.add(wordTaker);
				}
				characterCount = 0;
				wordTaker = "";
			} else {
				characterCount++;
				wordTaker = wordTaker + userString.charAt(i);
			}
		}
		int max = 0;
		int index = -1;
		for (int i = wordCount.size() - 1; i >= 0; i--) {
			if (max < wordCount.get(i)) {
				max = wordCount.get(i);
				index = i;
			}
		}
		return wordInString.get(index);
	}
}
