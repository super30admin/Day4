//Time complexity: O(logn)
//Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem7 {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = leftMost(nums,target);
        int rightIndex = rightMost(nums, target);
        return new int[]{leftIndex, rightIndex};
    }

    public int leftMost(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                if(nums[0]==target)
                    return 0;
                else if(nums[mid-1]== target)
                    right = mid-1;
                else
                    return mid;
            }else{
                if(nums[mid]>=target)
                    right = mid-1;
                else
                    left = mid+1;
            }
        }
        return -1;
    }

    public int rightMost(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                if(nums[nums.length-1]==target)
                    return nums.length-1;
                else if(nums[mid+1]== target)
                    left = mid+1;
                else
                    return mid;
            }else{
                if(nums[mid]>=target)
                    right = mid-1;
                else
                    left = mid+1;
            }
        }
        return -1;
    }
}
