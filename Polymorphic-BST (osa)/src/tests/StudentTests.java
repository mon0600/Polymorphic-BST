package tests;

import java.util.Set;

import org.junit.Test;

import junit.framework.TestCase;
import tree.PlaceKeysValuesInArrayLists;
import tree.PolymorphicBST;

public class StudentTests extends TestCase {

	@Test  //in this test i test the size, put, insert and delete methods.
	public void testDelete() {
		PolymorphicBST<Integer,String> ptree = new PolymorphicBST<Integer,String>();

		assertEquals(0, ptree.size());

		ptree.put(2, "Two");
		ptree.put(1, "One");
		ptree.put(3, "Three");
		ptree.put(5, "Five");
		assertEquals(4, ptree.size());

		ptree.remove(1);
		ptree.remove(2);


		assertEquals(null, ptree.get(8));
		assertEquals(null, ptree.get(1));
	}

	@Test//in this test i test the  height, In-order Traversal, and remove methods.
	public void testInTraversal() {
		PolymorphicBST<Integer,String> ptree = new PolymorphicBST<Integer,String>();

		assertEquals(0, ptree.size());

		ptree.put(5, "Five");
		ptree.put(2, "Two");
		ptree.put(3, "Three");
		ptree.put(1, "One");
		ptree.put(4,"Four");

		assertEquals(4, ptree.height());

		ptree.remove(1);
		ptree.remove(2);
		PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists<Integer, String>();
		ptree.inorderTraversal(task);

		assertEquals(task.getKeys().toString(), "[3, 4, 5]");
		assertEquals(task.getValues().toString(), "[Three, Four, Five]");
	}

	@Test
	public void testRiRoLefTraversal() {
		PolymorphicBST<Integer,String> ptree = new PolymorphicBST<Integer,String>();

		assertEquals(0, ptree.size());

		ptree.put(3, "Three");
		ptree.put(5, "Five");
		ptree.put(2, "Two");

		ptree.put(1, "One");
		ptree.put(4,"Four");

		assertEquals(5, ptree.size());


		PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists<Integer, String>();
		ptree.rightRootLeftTraversal(task);

		assertEquals(task.getKeys().toString(), "[4, 5, 3, 1, 2]");
		assertEquals(task.getValues().toString(), "[Four, Five, Three, One, Two]");

	}

	@Test
	public void testMax() {
		PolymorphicBST<Integer,String> ptree = new PolymorphicBST<Integer,String>();

		assertEquals(0, ptree.size());

		ptree.put(3, "Three");
		ptree.put(5, "Five");
		ptree.put(2, "Two");

		ptree.put(1, "One");
		ptree.put(4,"Four");
		ptree.put(23, "Twenty-Three");
		ptree.put(22, "Twenty-Two");


		assertEquals("23", ptree.getMax().toString());


	}

	@Test
	public void testMin() {
		PolymorphicBST<Integer,String> ptree = new PolymorphicBST<Integer,String>();

		assertEquals(0, ptree.size());

		ptree.put(3, "Three");
		ptree.put(5, "Five");
		ptree.put(2, "Two");

		ptree.put(1, "One");
		ptree.put(4,"Four");
		ptree.put(23, "Twenty-Three");


		assertEquals("1", ptree.getMin().toString());


	}

	@Test // in this test I test the keySet method.
	public <K> void testAddKeysToColl() {
		PolymorphicBST<Integer,String> ptree = new PolymorphicBST<Integer,String>();





		ptree.put(3, "Three");
		ptree.put(5, "Five");
		ptree.put(2, "Two");

		ptree.put(1, "One");
		ptree.put(4,"Four");
		ptree.put(23, "Twenty-Three");

		Set<Integer> keySert = ptree.keySet();



		assertEquals(keySert.toString(), "[1, 2, 3, 4, 5, 23]");


	}

	@Test
	public <K> void testSubMap() {
		PolymorphicBST<Integer,String> ptree = new PolymorphicBST<Integer,String>();





		ptree.put(3, "Three");
		ptree.put(5, "Five");
		ptree.put(2, "Two");

		ptree.put(1, "One");
		ptree.put(4,"Four");
		ptree.put(23, "Twenty-Three");

		ptree.put(7, "Seven");
		ptree.put(8,"Eight");
		ptree.put(9, "Nine");
		ptree.put(21, "Twenty-One");
		ptree.put(24,"Twenty-Four");
		ptree.put(28, "Twenty-Eight");

		PolymorphicBST<Integer,String> rndm = ptree.subMap(3, 9);


		assertEquals("[3, 4, 5, 7, 8, 9]",rndm.keySet().toString());
	}


	@Test// in this test I test the clear and get method.
	public <K> void testClear() {
		PolymorphicBST<Integer,String> ptree = new PolymorphicBST<Integer,String>();





		ptree.put(3, "Three");
		ptree.put(5, "Five");
		ptree.put(2, "Two");

		ptree.put(1, "One");
		ptree.put(4,"Four");
		ptree.put(23, "Twenty-Three");

		ptree.put(7, "Seven");
		ptree.put(8,"Eight");
		ptree.put(9, "Nine");
		ptree.put(21, "Twenty-One");
		ptree.put(24,"Twenty-Four");
		ptree.put(28, "Twenty-Eight");

		ptree.clear();



		assertEquals(null,ptree.get(1));

	}


		@Test
		public <K> void testHEIGHT() {
			PolymorphicBST<Integer,String> ptree = new PolymorphicBST<Integer,String>();
	
	
	
	
	
			ptree.put(3, "Three");
		
	
	
			
			
			assertEquals(1,ptree.height());
	
	
	
		}
		


}