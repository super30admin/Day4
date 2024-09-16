// Time Complexity : O(Log(N))
// Space Complexity : O(1).
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : Nope.


// Your code here along with comments explaining your approach

class BinarySearchFirstandLastPosition {
    
    private int first(int[] nums,int target, int low, int high){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == low || nums[mid-1] != target){return mid;}
                high = mid-1;
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
    
    private int last(int[] nums, int target, int low, int high){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == high || nums[mid+1] != target){return mid;}
                low = mid+1;
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
    
    private int search(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int search = search(nums,target);
        if(-1 == search){return new int[]{-1,-1};}
        int first = first(nums,target,0,search);
        int last = last(nums,target,search,nums.length-1);
        return new int[]{first,last};
    }
}