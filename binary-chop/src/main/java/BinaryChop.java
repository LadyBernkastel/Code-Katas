public class BinaryChop {
	/*
	 * Try 2 - Iterative
	 */
	public int iterativeChop(int target, int[] dataSet) {
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

	public int recursiveChop(int target, int[] dataSet) {
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
			return iterativeChop(target, choppedArray);

		} else if (middleValue < target) {
			int choppedLength = arrayLength-arrayMiddle;
			int[] choppedArray = copyArray(dataSet, arrayMiddle, choppedLength);

			int relativePosition = dataSet.length - choppedLength;
			int iterativeChop = iterativeChop(target, choppedArray);

			if (iterativeChop != -1)
				return iterativeChop + relativePosition;
			return iterativeChop;
		}

		return arrayMiddle;
	}
	
	
}
