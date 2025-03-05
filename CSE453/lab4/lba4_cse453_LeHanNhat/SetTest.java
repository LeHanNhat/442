package Lab4;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//
//class SetTest {
//	static Set set = new Set();
//	static Set set1 = new Set();
//	static Set set2 = new Set();
//	@Test
//    void testSetInsert() {
//        Set set = new Set();
//        
//        set.insert(5);
//        
//
//      
//        set.insert(3);
//        
//       
//        set.insert(3);
//       
//
//  
//        set.insert(7);
//        int[] expected = new int[]{3, 5, 7};
//        assertArrayEquals(expected, set.toArray());
//    }
//
//    @Test
//    void testMember() {
//        Set set = new Set();
//
// 
//        assertFalse(set.member(5));
//
//      
//        set.insert(3);
//        set.insert(5);
//        set.insert(7);
//
//        
//        assertTrue(set.member(5));
//
//       
//        assertFalse(set.member(4));
//
//        
//        assertFalse(set.member(1));
//
//       
//        assertFalse(set.member(9));
//    }
//
//    @Test
//    void testSection() {
//        
//
//        
//        set1.section(set2);
//        
//        int[] expected = new int[]{};
//        assertArrayEquals(expected, set1.toArray());
//
//       
//        set1.insert(3);
//        set1.insert(5);
//        set1.insert(7);
//
//        set2.insert(5);
//        set2.insert(8);
//
//   
//        set1.section(set2);
//        expected = new int[]{3, 7};
//        assertArrayEquals(expected, set1.toArray());
//
//      
//        set2.insert(10);
//        set1.section(set2);
//        
//        assertArrayEquals(expected, set1.toArray());
//    }
//
//    @Test
//    void testContainsArithTriple() {
//    	set = new Set();
//
//        
//        assertFalse(set.containsArithTriple());
//
//     
//        set.insert(3);
//        set.insert(5);
//        assertFalse(set.containsArithTriple());
//
//       
//        set.insert(10);
//        assertFalse(set.containsArithTriple());
//
//        set.insert(7);
//        assertTrue(set.containsArithTriple());
//    }
//
//    @Test
//    void testToArray() {
//       
//
//        int[] expected = new int[]{};
//        assertArrayEquals(expected, set.toArray());
//
//    
//        set.insert(3);
//        set.insert(5);
//        set.insert(7);
//        expected = new int[]{3, 5, 7};
//        assertArrayEquals(expected, set.toArray());
//    }
//}
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetTest {
    private Set set1;

    @BeforeEach
    public void setUp() {
        set1 = new Set();
    }

    @Test
    void testInsertAndMember() {
        set1.insert(5);
        set1.insert(3);
        set1.insert(8);
        set1.insert(3); 
        assertTrue(set1.member(3)); 
        assertTrue(set1.member(5)); 
        assertTrue(set1.member(8)); 
        assertFalse(set1.member(7)); 
      
        int[] expectedArray = {3,5,8};
        assertArrayEquals(expectedArray,set1.toArray());

    }

    @Test
    void testSection() {
        set1.insert(3);
        set1.insert(5);
        set1.insert(8);

        Set set2 = new Set();
        set2.insert(5);
        set2.insert(7);

        set1.section(set2); 

        int[] expectedArray = {3, 8};
        System.out.println(set1.toArray());
        assertArrayEquals(expectedArray, set1.toArray());
    }

    @Test
    void testContainsArithTriple() {
        set1.insert(1);
        set1.insert(4);
        set1.insert(7);

        assertTrue(set1.containsArithTriple()); 

        set1.insert(10);
        assertTrue(set1.containsArithTriple()); 

        Set set2 = new Set();
        set2.insert(2);
        set2.insert(5);
        set2.insert(9);

        assertFalse(set2.containsArithTriple()); 
    }

    @Test
    void testEdgeCases() {
        Set emptySet = new Set();

        assertEquals(0, emptySet.toArray().length); 
        assertFalse(emptySet.containsArithTriple()); 
        assertFalse(emptySet.member(1)); 
    }
}
