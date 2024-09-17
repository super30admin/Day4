/*
* Time Complexity: O(logN)
* Space Complexity: O(1)
* */
public class FirstAndLastPositionElementSortedArray {
    public int[] searchRange(int[] nums, int target) {
        //Base Cases
        if (nums == null || nums.length == 0) return new int[]{-1, -1};

        if (target < nums[0] || target > nums[nums.length - 1]) return new int[]{-1, -1};
        //Searching for first Occurrence
        int firstOccurence = searchFirstOccurrence(nums, target);
        //Searching for last Occurrence
        if (firstOccurence == -1) {
            return new int[]{-1, -1};
        }
        int lastOccurrence = searchLastOccurrence(nums, target);
        return new int[]{firstOccurence, lastOccurrence};
    }

    /* Method for Find first occurrence in the Array*/
    private int searchFirstOccurrence(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            // Calculating middle index
            int middle = low + (high - low) / 2; //(high - low) -> To prevent Integer overflow condition

            if (nums[middle] == target) {
                // Checking first occurrence
                if (middle == 0 || nums[middle - 1] < nums[middle]) {
                    return middle;
                } else {
                    high = middle - 1; // First occurrence would get in left side
                }
            } // if Target is less than middle element
            else if (target < nums[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    /* Method for Find Last occurrence in the Array*/
    private int searchLastOccurrence(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            // Calculating middle index
            int middle = low + (high - low) / 2; //(high - low) -> To prevent Integer overflow condition

            if (nums[middle] == target) {
                // Checking Last occurrence
                if (middle == nums.length - 1 || nums[middle + 1] > nums[middle]) {
                    return middle;
                } else {
                    low = middle + 1; // Last occurrence would get in right side
                }
            } // if Target is less than middle element
            else if (target < nums[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }
}
