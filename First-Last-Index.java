// TC: O(log(n))
// SC: O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[] {-1, -1};
        int first = firstOccurance(nums, target);
        System.out.println(first);
        if(first == -1) return new int[] {-1, -1};
        int second = lastOccurance(nums, target);
        return new int[] {first, second};
    }
    
    public int firstOccurance(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid-1] < target) {
                    
                     return mid;
                } else {
                     high = mid - 1;
                }
            } else if(target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    
    public int lastOccurance(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target) {
                if( mid == nums.length-1 || nums[mid+1] > nums[mid]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if(target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
