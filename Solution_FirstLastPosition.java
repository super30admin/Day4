//TC: O(logn)
//SC: O(1)
//Did it run on leetcode: Yes
public class Solution_FirstLastPosition {
    int bsFirst(int[] nums, int l, int h, int target){
        int low = l;
        int high = h;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target && (mid == 0 || (nums[mid-1] != nums[mid]))){
                return mid;
            } else if(nums[mid] < target)
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }

    int bsLast(int[] nums, int l, int h, int target){
        int low = l;
        int high = h;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target && (mid == nums.length-1 || (nums[mid+1] != nums[mid]))){
                return mid;
            } else if(nums[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(nums.length == 0)
            return new int[]{-1, -1};
        if(nums[0] > target || nums[n-1] < target)
            return new int[]{-1, -1};
        int first = bsFirst(nums, 0, n-1, target);
        if(first == -1)
            return new int[]{-1, -1};
        int last = bsLast(nums, first, n-1, target);
        return new int[]{first, last};
    }
}
