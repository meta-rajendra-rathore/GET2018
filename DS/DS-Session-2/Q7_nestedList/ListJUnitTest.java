package datastructure_2.Q7_nestedList;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Rajendra Singh Rathore
 *
 */
public class ListJUnitTest {
    ListOLists list;
    
    public ListJUnitTest() {
        
        List<Object> inputList = new ArrayList<>();
        
        List<Object> listOuter1 = new ArrayList<>();
        List<Object> listOuter2 = new ArrayList<>();
        List<Object> listOuter3 = new ArrayList<>();
        
        ArrayList<Integer> innerList11 = new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2, 3, 4}));
        ArrayList<Integer> innerList12 = new ArrayList<Integer>(Arrays.asList(new Integer[] {5, 6, 7, 8}));
        ArrayList<Integer> innerList21 = new ArrayList<Integer>(Arrays.asList(new Integer[] {9, 10, 11, 12}));
        ArrayList<Integer> innerList22 = new ArrayList<Integer>(Arrays.asList(new Integer[] {13, 14, 15, 16}));
        ArrayList<Integer> innerList31 = new ArrayList<Integer>(Arrays.asList(new Integer[] {17, 18, 19, 20}));
        ArrayList<Integer> innerList32 = new ArrayList<Integer>(Arrays.asList(new Integer[] {21, 22, 23, 24}));
        
        listOuter1.add(innerList11);
        listOuter1.add(innerList12);
        listOuter2.add(innerList21);
        listOuter2.add(innerList22);
        listOuter3.add(innerList31);
        listOuter3.add(innerList32);
        
        inputList.add(listOuter1);
        inputList.add(listOuter2);
        inputList.add(listOuter3);
        
        list  = new ListOLists(inputList);
        
        //list.addCustomList(inputList);
    }
    
    @Test(expected = AssertionError.class)
    public void test_LargestValue_SingleH_ReturnInvalidOutput() { 
        assertEquals(null, list.getValue("H"));
    }

    @Test(expected = AssertionError.class)
    public void test_LargestValue_SingleT_ReturnInvalidOutput() { 
        assertEquals(null, list.getValue("T"));
    }

    @Test(expected = AssertionError.class)
    public void test_LargestValue_EndsWithT_ReturnInvalidOutput() { 
        assertEquals(null, list.getValue("HHT"));
    }

    @Test
    public void test_LargestValue__ReturnValidOutput() { 
        assertEquals(1, Integer.parseInt(list.getValue("HHH")));
    }

    @Test
    public void test_LargestValue_HHTH_ReturnValidOutput() { 
        assertEquals(2, Integer.parseInt(list.getValue("HHTH")));
    }

    @Test
    public void test_LargestValue_HHTTH_ReturnValidOutput() { 
        assertEquals(3, Integer.parseInt(list.getValue("HHTTH")));
    }

    @Test
    public void test_LargestValue_HHTTTH_ReturnValidOutput() { 
        assertEquals(4, Integer.parseInt(list.getValue("HHTTTH")));
    }

    @Test
    public void test_LargestValue_HHTH_ReturnInvalidOutput() { 
        assertEquals(5, Integer.parseInt(list.getValue("HTHH")));
    }

    @Test(expected = AssertionError.class)
    public void test_LargestValue_IfInputIsAccessingArrayList_ReturnInvalidOutput() { 
        assertEquals(null, list.getValue("HTH"));
    }

   
}
