public class BinaryChop {
	/*
	 * Try 2 - Iterative
	 */
	public int chop(int target, int[] dataSet) {
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
