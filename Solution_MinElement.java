//TC: O(logn)
//SC: O(1)
//Did it run on leetcode: Yes

public class Solution_MinElement {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            if(nums[low] <= nums[high])
                return nums[low];
            int mid = low + (high-low)/2;
            if((mid == 0 || nums[mid-1] > nums[mid]) && (nums[mid+1] > nums[mid]))
                return nums[mid];
            else if(nums[low] <= nums[mid])
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
}
