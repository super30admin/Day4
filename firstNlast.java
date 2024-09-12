class Solution {
    public int first(int[] nums, int target, int low, int high){
        // binary search for 1st index
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid == low || nums[mid-1] < nums[mid]){
                    return mid;
                } else {
                    high = mid -1;
                }
                
            } else if(nums[mid]> target){
                high = mid -1;
            } else  if(nums[mid]<target){
                low = mid +1;
            }
        }
        return -1;
    }
    public int second(int[] nums, int target, int low, int high){
        // binary search for 1st index
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid == high || nums[mid] < nums[mid+1]){
                    return mid;
                } else {
                    low = mid+1;
                }
                
            } else if(nums[mid]> target){
                high = mid -1;
            } else  if(nums[mid]<target){
                low = mid +1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        // null case
        if(nums.length == 0){
            return new int[] {-1,-1};
        } 
        int n1 = first(nums, target, 0, nums.length-1);
        if(n1 == -1) return new int[] {-1,-1};
        int n2 = second(nums, target, 0, nums.length-1);
        return new int[] {n1,n2};
        
    }
}

// Time Complexity: O(logN)
// Space Complexity: O(1)
