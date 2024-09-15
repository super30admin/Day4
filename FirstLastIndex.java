// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * We solve this problem by dividing it into two parts. 
 * 1. Perform binary search to find the starting index of given target.
 *     a. Each and every time we encounter target value, we try to verify if the current value is starting element.
 *     b. Since it is sorted array, we can check if the curr element is > than prev element or if the curr element is the starting element of the array.
 *     c. If the above condition satisfies, then we can say that we have found the starting index of the target.
 *     d. If not we return -1 which indicated that element is not present in the array.
 * 2. Perform binary search to find the ending index of given target.
 *     a. Each and every time we encounter target value, we try to verify if the current value is ending element.
 *     b. Since it is sorted array, we can check if the curr element is < than next element or if the curr element is the ending element of the array.
 *     c. If the above condition satisfies, then we can say that we have found the ending index of the target.
 *     d. If not we return -1 which indicated that element is not present in the array.
*/
class FirstLastIndex {
    public static int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        if (target < nums[0] || target > nums[nums.length - 1]) return new int[]{-1, -1};

        int start = searchStart(nums, target, 0, nums.length - 1);
        int end = searchEnd(nums, target, 0, nums.length - 1);

        return new int[]{start, end};

    }

    private static int searchStart(int[] nums, int target, int low, int high) {

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    // keep moving left
                    high = mid - 1;
                }
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int searchEnd(int[] nums, int target, int low, int high) {

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
                    return mid;
                } else { 
                    // keep moving right
                    low = mid + 1;
                }
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void print(int[] input){
        for(int i: input){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print(searchRange(new int[]{5,7,7,8,8,10}, 8));
        print(searchRange(new int[]{5,7,7,8,8,10}, 6));
        print(searchRange(new int[]{}, 0));
        print(searchRange(new int[]{1,2,3}, 3));
        print(searchRange(new int[]{3,3,3,3,3,3,}, 3));
        print(searchRange(new int[]{3,3,3,3,3,3,}, 1));
    }
}
