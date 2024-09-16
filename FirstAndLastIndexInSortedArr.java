// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Was trying pass the already found left index to the second BS
// function to find the right index to decrease the time. But failed when the left index function returned -1.


// Your code here along with comments explaining your approach
//performing binary search twice to get the low index and high index
//of the occurrence of the target.

public class FirstAndLastIndexInSortedArr {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }

        int leftIndexValue = leftIndex(nums,target);
        int rightIndexValue = rightIndex(nums,target);

        return new int[]{leftIndexValue, rightIndexValue};
    }

    public int leftIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == low || nums[mid] > nums[mid-1]){
                    return mid;
                }else{
                    high = mid - 1;
                }
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }//end of while
        return -1;
    }

    public int rightIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                if(mid == high ||nums[mid] < nums[mid+1]){
                    return mid;
                }else{
                    low = mid + 1;
                }
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }//end of while

        return -1;
    }
}





