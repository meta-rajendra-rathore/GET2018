package datastructure_2.Q7_nestedList;

import java.util.List;

/**
 * @author Rajendra Singh Rathore
 *
 */
public class ListOLists implements IList {
    public List<Object> listOfList;

    /**
     * default non-parameterized constructor used to add values in various
     * innerlists and add them in outerlist
     * @param list 
     */
    public ListOLists(List<Object> list) { 
        listOfList = list;
    }

    @Override
    public String getValue(String string) {
        return (getElement(listOfList, string));
    }

    /**
     * @param list
     * @param string
     * @return element from nested list accessed by using parameter string
     */
    @SuppressWarnings("unchecked")
    public String getElement(List<Object> list, String string) {
        int value = -1;

        if (string.charAt(0) == 'T' && string.length() == 1)
            throw new AssertionError();

        else if (string.charAt(0) == 'H' && string.length() == 1) {

            if ((list.get(0)) instanceof Integer) {
                value = ((Integer) list.get(0));
                return (value + "");
            }
            throw new AssertionError("List instance found at head");
        }

        else if (string.charAt(0) == 'T') {
            list.remove(0);
            return getElement((List<Object>) list,
                    string.substring(1, string.length()));
        }

        else if (string.charAt(0) == 'H')
            return getElement((List<Object>) list.get(0),
                    string.substring(1, string.length()));

        return null;
    }
}
