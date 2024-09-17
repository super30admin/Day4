// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class FirstAndLast{
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if(nums == null || nums.length == 0) return res;

        if(target < nums[0] || target > nums[nums.length-1]) return res;
        
        int first = binarySearchFirst(nums, target);
        if(first == -1){
            return res;
        }

        int second = binarySearchSecond(nums, target);
        return new int[] {first, second};
    }
    
    public int binarySearchFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] < nums[mid]){
                    return mid;
                }
                else{
                    high = mid-1;
                }
            }
            else if(target < nums[mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
    
    public int binarySearchSecond(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid+1] > nums[mid]){
                    return mid;
                }
                else{
                    low = mid+1;
                }
            }
            else if(target < nums[mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}