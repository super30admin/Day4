
public class FirstLastIndex { 

	public int firstIndex(int array[], int target) {
		if (array == null || array.length == 0)
			return -1;
		int low = 0, high = array.length - 1;
		while (low <= high) {
			int middle = low + ((high - low) >> 1);
			if (array[middle] == target) {
				if (middle == 0 || array[middle] > array[middle - 1]) {
					return middle;
				} else {
					high = middle - 1;
				}
			} else if (array[middle] < target)
				low = middle + 1;
			else
				high = middle - 1;
		}
		return -1;
	}

	public int lastIndex(int array[], int target) {
		if (array == null || array.length == 0)
			return -1;
		int low = 0, high = array.length - 1;
		while (low <= high) {
			int middle = low + ((high - low) >> 1);
			if (array[middle] == target) {
				if (middle == array.length - 1 || array[middle] < array[middle + 1]) {
					return middle;
				} else {
					low = middle + 1;
				}
			} else if (array[middle] < target)
				low = middle + 1;
			else
				high = middle - 1;
		}
		return -1;
	}

	public int firstIndexRecursive(int array[], int low, int high, int target) {
		if (low <= high) {
			int middle = low + ((high - low) >> 1);
			if ((middle == 0 || array[middle - 1] < target) && array[middle] == target)
				return middle;
			else if (target > array[middle])
				return firstIndexRecursive(array, middle + 1, high, target);
			else
				return firstIndexRecursive(array, low, middle - 1, target);
		}
		return -1;
	}

	public int lastIndexRecursive(int array[], int low, int high, int target) {
		if (low <= high) {
			int middle = low + ((high - low) >> 1);
			if ((middle == array.length - 1 || target < array[middle + 1]) && array[middle] == target)
				return middle;
			else if (target < array[middle])
				return lastIndexRecursive(array, low, middle - 1, target);
			else
				return lastIndexRecursive(array, middle + 1, high, target);
		}
		return -1;
	}

	public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return new int[] { -1, -1 };
		// return new int[] { firstIndexRecursive(nums, 0, nums.length - 1, target),
		// lastIndexRecursive(nums, 0, nums.length - 1, target) };
		return new int[] { firstIndex(nums, target), lastIndex(nums, target) };

	}
}