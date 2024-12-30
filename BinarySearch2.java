class Solution {
    public int[] searchRange(int[] nums, int target) {
       if(nums == null || nums.length ==0) 
       {
        return new int[] {-1,-1};
       }
       if (target < nums[0] || target > nums[nums.length-1]) {
        return new int[] {-1,-1};
       }
       
       int first = binarySearchFirst(nums, target);
       if(first == -1) {
        return new int[] {-1,-1};
       }
       int second = binarySearchLast(nums, target);
       return new int[] {first, second};
    }

    private int binarySearchFirst(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length -1;
        while (low <= high) {
            int mid = low + (high - low) /2;
            if(nums[mid] == target)
            {
                if (nums[mid -1] != nums[mid]) {
                    return mid;
                }
                high = mid -1;  
            }
            else if (nums[mid] < target) {
                low = mid +1;
            }
            else {
                high = mid -1;
            }
        }
        return -1;
    }

    private int binarySearchLast(int[]nums, int target)
    {
        int low = 0;
        int high = nums.length -1;
        while (low <= high) {
            int mid = low + (high - low) /2;
            if(nums[mid] == target)
            {
                if ((mid == nums.length -1) || (nums[mid+1] != nums[mid])) {
                    return mid;
                }
                low = mid +1;  
            }
            else if (nums[mid] < target) {
                low = mid +1;
            }
            else {
                high = mid -1;
            }
        }
        return -1;
    }
}



////////////////////Find Minimum in rotated sorted Array
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        int low = 0;
        int high = n-1;
        while (low <= high) {
            if(nums[low] <= nums[high]) {
                return nums[low];
            }
            int mid = low + (high-low)/2;
            if(((mid == 0) || (nums[mid-1] > nums[mid])) && ((mid == n-1) || (nums[mid+1] > nums[mid]))){
                return nums[mid];
            }
            if(nums[low] <= nums[mid]) {
               low = mid +1;
            }
            else {
                high = mid -1;
            }
        }
        return 768758;
    }
}