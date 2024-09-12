//Find peak element
//Time Complexity: O(logn)
//Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, Implemented using the approach provided during the class

class Solution{

    public int findPeakElement(int[] nums){
        if(nums == null || nums.length == 0) return -1;

        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid + 1])){
                return mid;

            }else if(mid != 0 && nums[mid] < nums[mid -1]){
                 high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return 99;
    }
}

//-----------------------------------------------------//
//First and last position of an element in a sorted array
//Time Complexity: O(logn)
//Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, Implemented using the approach provided during the class


class Solution {

    public int binarySearchFirst(int[] nums, int low, int high, int target)

    {

        while (low <= high){

            int mid = low + (high - low)/2;

            if(nums[mid] == target){

                if( mid == low ||  nums[mid - 1] < nums[mid]) return mid;

                // still go left

                else high = mid - 1;

            } else if(nums[mid] > target){

                high = mid - 1;

            } else low = mid + 1; 

        }

        return -1; 

    }


    public int binarySearchSecond(int[] nums, int low, int high, int target)

    {

        while (low <= high){

            int mid = low + (high - low)/2;

            if(nums[mid] == target){

                if(mid == high || nums[mid + 1] > target) return mid;

                // still go right

                else low = mid + 1;

            } else if(nums[mid] > target){

                high = mid - 1;

            } else low = mid + 1; 

        }

        return -1; 

    }

    public int[] searchRange(int[] nums, int target) {

        int left = binarySearchFirst(nums, 0, nums.length - 1, target);

        int right = binarySearchSecond(nums, 0, nums.length - 1, target);

        return new int[] {left,right};

    }

}

//---------------------------------------------------------------//

//First minimum in a rotated sorted array
//Time Complexity: O(logn)
//Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, Implemented using the approach provided during the class
class Solution {

    public int findMin(int[] nums) {
  
        int low = 0;
  
        int high = nums.length - 1;
  
        int n = nums.length - 1;
  
        while(low < high)
  
        {
  
            if (nums[low] < nums[high]) return nums[low];
  
            int mid = low + (high-low)/2;
  
            if((mid == 0 || nums[mid] < nums[mid - 1]) &&  nums[mid] < nums[mid + 1])
  
            {
  
                return nums[mid];
  
            } else if(nums[mid] < nums[high])
  
            {
  
               high = mid - 1;
  
            } else{
  
                low = mid + 1;
  
            }
  
        }
  
        return nums[low];
  
    }
  
  }