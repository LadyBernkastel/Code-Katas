import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class Main {
	@Test
	public void testChop() {
		int[] emptyData = {};
	    assertEquals(-1, chop(3, emptyData));
	    int[] singleData = {1};
	    assertEquals(-1, chop(3, singleData));
	    assertEquals(0, chop(1, singleData));
	    int[] threeData = {1, 3, 5};
	    assertEquals(0, chop(1, threeData));
	    assertEquals(1, chop(3, threeData));
	    assertEquals(2, chop(5, threeData));
		assertEquals(-1, chop(0, threeData));
		assertEquals(-1, chop(2, threeData));
		assertEquals(-1, chop(4, threeData));
		assertEquals(-1, chop(6, threeData));
		int[] fourData = {1, 3, 5, 7};
		assertEquals(0, chop(1, fourData));
		assertEquals(1, chop(3, fourData));
		assertEquals(2, chop(5, fourData));
		assertEquals(3, chop(7, fourData));
		assertEquals(-1, chop(0, fourData));
		assertEquals(-1, chop(2, fourData));
		assertEquals(-1, chop(4, fourData));
		assertEquals(-1, chop(6, fourData));
		assertEquals(-1, chop(8, fourData));
	}
	
	/*
	 * Try 2 - Iterative
	 */
	private int chop(int target, int[] dataSet) {
		boolean notFound = true;
		int result = -1;		
		int relativePosition = 0;

		if(dataSet.length == 0) {
			return result;
		}
		
		while(notFound) {
			int arrayLength = dataSet.length;
			int arrayMiddle = arrayLength/2;
			int middleValue = dataSet[arrayMiddle];
			
			if(arrayLength == 1 && middleValue != target) {
				return result;
			}
			
			if (middleValue > target) {
				int choppedLength = arrayMiddle;
				dataSet = copyArray(dataSet, 0, choppedLength);
				
			} else if (middleValue < target) {
				int choppedLength = arrayLength-arrayMiddle;
				relativePosition += arrayLength - choppedLength;
				dataSet = copyArray(dataSet, arrayMiddle, choppedLength);
			}
			
			if (middleValue == target) {
				notFound = false;
				result = arrayMiddle + relativePosition;
			}
		}
		
		return result;
	} 


	private int[] copyArray(int[] dataSet, int arrayMiddle, int choppedLength) {
		int[] choppedArray = new int[choppedLength];
		System.arraycopy(dataSet, arrayMiddle, choppedArray, 0, choppedLength);
		return choppedArray;
	}
	
	/*
	 * Try 1 - Recursive
	 *
	private int chop(int target, int[] dataSet) {
		int arrayLength = dataSet.length;
		
		if(dataSet.length == 0) {
			return -1;
		}
		
		int arrayMiddle = arrayLength/2;
		int middleValue = dataSet[arrayMiddle];
		
		if (arrayLength == 1 && middleValue != target) {
			return -1;
		}
		
		if (middleValue > target) {
			int choppedLength = arrayMiddle;
			int[] choppedArray = copyArray(dataSet, 0, choppedLength);
			return chop(target, choppedArray);
			
		} else if (middleValue < target) {
			int choppedLength = arrayLength-arrayMiddle;
			int[] choppedArray = copyArray(dataSet, arrayMiddle, choppedLength);
			
			int relativePosition = dataSet.length - choppedLength;			
			int chop = chop(target, choppedArray);
			
			if (chop != -1)
				return chop + relativePosition;		
			return chop;
		}
		
		return arrayMiddle;
	} */
	
	
}
