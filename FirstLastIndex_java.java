class Solution {
    /**
     * Idea is to use the getRightmostIndex function as blackbox to get start and end index.
     */
    public int[] searchRange(int[] nums, int target) {
        // base case checks
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        
        int start, end;
        
        // get end index is easy, just call the function with value as target
        // right most index = end index = 6 for value 2.
        end = getRightmostIndex(nums, target);

        // here's the trick, getting right most index for value one less than target
        // the actual start index would be just one next to what we get
        start = getRightmostIndex(nums, target-1);

        // case: target is not present in array
        // Example: target = 4
        // start = getRightmostIndex(4-1) = 8
        // end = getRightmostIndex(4) = 8
        if(start == end) {
            return new int[]{-1, -1};
        }
        
        // return the range
        return new int[]{start+1, end};
    }
    
    /**
     * Compute the right most index after which the 'value' can be inserted in array.
     *
     * Example: 
     * arr: 1 1 1 2 2 2 2 3 3 5 5  5
     * ind: 0 1 2 3 4 5 6 7 8 9 10 11
     *
     * 1. input: -5, output: -1
     * 2. input: 0, output: -1
     * 3. input: 1, output: 2
     * 4. input: 2, output: 6
     * 5. input: 3, output: 8
     * 6. input: 4, output: 8
     * 7. input: 5, output: 11
     * 8. input: 10, output: 11
     * 
     * @param arr sorted array of integers
     * @param 'value' to be inserted
     * @return rightmost index i after which that value can be inserted, keeping array in sorted order
     */
    private int getRightmostIndex(int[] arr, int value) {
        
        int low = 0, high = arr.length - 1;
        
        if(value < arr[0]) { // smaller than smallest, refer example 1 and 2.
            return -1;
        }
        
        if(value >= arr[arr.length-1]) { // >= largest, refer example 7 and 8.
            return arr.length - 1;
        }
        
        while (low <= high) { 
            int mid = low + (high - low) / 2;

            // found the rightmost index
            // element at and before mid <= value and those after mid are greater than value.
            if (arr[mid] <= value && arr[mid + 1] > value) { 
                return mid;
            }
    
			// Case where the index we are interested is on the right side
			// value: 2
            //             mid  desired index
            //              |   | 
     		// arr: 1 1 1 2 2 2 2 3 3 5 5  5
            // ind: 0 1 2 3 4 5 6 7 8 9 10 11
            if (arr[mid] <= value) { 
                low = mid + 1;
            } else { // otherwise
                high = mid - 1;
            }
        }
        return -1;
    }
}