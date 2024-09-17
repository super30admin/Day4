// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class firstLast {
    // method to find the first index of occurrence
    public int leftSearch(int[] nums, int target){
        // initialize low and high pointers
        int low = 0;
        int high = nums.length - 1;

        //binary search
        while(low <= high){
            // intialize mid
            int mid = low + (high - low) / 2;

            // if mid element is our target
            if (nums[mid] == target){
                // if element at mid is greater than its previous element
                // also check if it is the first element of the array
                if(mid == 0 || nums[mid] > nums[mid -1]){
                    return mid;
                } else {
                    // keep moving left
                    high = mid - 1;
                }
            } else if (nums[mid] > target) {
                // the element lies on the left side of mid
                high = mid - 1;
            } else {
                // the element lies on the right side of mid
                low = mid + 1;
            }
        }
        return -1;
    }

    public int rightSearch(int[] nums, int target) {
        // intialize low and high pointers
        int low = 0;
        int high = nums.length - 1;

        // binary search
        while (low <= high){
            // intialize mid
            int mid = low + (high - low) / 2;

            if (nums[mid] == target){
                // if mid is the element we are looking for
                if (mid == nums.length -1 || nums[mid] < nums[mid + 1]){
                    // if element at mid is less than its next element
                    // also check if it is the last element of the array
                    return mid;
                } else {
                    // keep moving right
                    low = mid + 1;
                }
            } else if(nums[mid] > target){
                // the element lies on the left side of mid
                high = mid - 1;
            } else {
                // the element lies on the right side of mid
                low = mid + 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        // check if array is null or empty
        if(nums == null || nums.length == 0) return new int[] {-1, -1};
        // if target element is outside the range of sorted array
        if(target < nums[0] || target > nums[nums.length - 1]) return new int[] {-1, -1};
        // search for the first occurrence of the target element
        int first = leftSearch(nums, target);
        // if target element is not present in the array, then return -1
        if(first == -1) return new int[] {-1, -1};
        // search for the last occurrence of the target element
        int last = rightSearch(nums, target);
        return new int[] {first, last};
    }
}