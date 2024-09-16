/* Time complexity: O(logn)
Space complexity: O(n)

1. The target element is first found by binary search
2. Using searchLeft and searchRight, check if that element is the leftmost/rightmost.
3. If so, return that index else keep interating till it is found. */

class Solution{
    public int[] searchRange(int[] nums, int target){
        int x = nums.length-1;
        int left = searchLeft(nums, target, 0, x);
        int right = searchRight(nums, target, 0, x);
        return new int[] {left,right};
    }

    public int searchLeft(int[] nums, int target, int low, int high){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid != low && nums[mid-1] == target){
                    high = mid-1;
                }
                else{
                    return  mid;
                }
            }
            else if(nums[mid] < target){
                low = mid+1;                
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }

    public int searchRight(int[] nums, int target, int low, int high){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid != high && nums[mid+1] == target){
                    low = mid+1;
                }
                else{
                    return  mid;
                }
            }
            else if(nums[mid] < target){
                low = mid+1;                
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}