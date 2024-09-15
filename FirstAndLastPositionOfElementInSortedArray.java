package DataStructure.BinarySearch;

// Time Complexity : Add : O(log (n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class FirstAndLastPositionOfElementInSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        // To find the first occurance
        ans[0] = firstOccurenceIndex(nums, target);
        // To find the last occurance
        ans[1] = lastOccurenceIndex(nums, target);
        return ans;
    }

    public static int firstOccurenceIndex(int[] nums, int target){
        int index = -1;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int midpoint = start + (end -start)/2;
            // push the end value to midpoint - 1
            if(nums[midpoint]>=target)
                end = midpoint -1;
            else
                start = midpoint + 1;

            // if midpoint value is equal to target, keep the index as point.
            if(nums[midpoint] == target) index=midpoint;
        }
        return index;
    }

    public static int lastOccurenceIndex(int[] nums, int target){
        int index = -1;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int midpoint = start + (end -start)/2;
            if(nums[midpoint]<=target)
                start = midpoint + 1;
            else
                end = midpoint - 1;

            if(nums[midpoint] == target) index=midpoint;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        searchRange(nums, target);
    }
}
