// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, while searching for rightmost index of the element

public class SearchRangeForTargetInSortedArray {
public static int[] searchRange(int[] nums, int target) {
        int left = leftBS(nums, target);
        int right = rightBS(nums, target);

        return new int[]{left, right};
    }

    private static int rightBS(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                if((mid == high) || nums[mid+1] != target){
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if(nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private static int leftBS(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                if((mid == low) || nums[mid-1] != target){
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if(nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }


    public static void main(String args[]){
        int[] arr = new int[]{5,7,7,8,8,10};
        int[] answer = searchRange(arr, 8);
        for(int i : answer){
            System.out.print(" " +i);
        }
    }
}
