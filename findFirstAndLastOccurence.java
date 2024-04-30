class Solution {
    
    private int binarySearch1(int[] nums, int low, int high, int target) {
        
        int mid = low + (high - low)/2;
        
        while(low <= high) {
            mid = low + (high - low)/2;
            if (nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return -1;
        
    }
    
    private int firstOccurence(int[] nums, int low, int high, int target) {
        
        
        int mid = binarySearch1(nums, low, high, target);
        
        if(mid == -1)
            return -1;
        
        
        while(target >= nums[low] && target <= nums[high]) {
            mid = binarySearch1(nums, low, high, target);
            if(mid - 1 < 0)
                break;
            high = mid - 1;
        }
        
        return mid;
        
    }
    
    private int lastOccurence(int[] nums, int low, int high, int target) {
        
        int mid = -1;        
        while(target >= nums[low] && target <= nums[high]) {
            mid = binarySearch1(nums, low, high, target);
            if(mid +1 == nums.length)
                break;
             low = mid+1;
        }
        return mid;
    }
    
    public int[] searchRange(int[] nums, int target) {
        
        int result[] = {-1,-1};

        if(nums == null || nums.length == 0)
            return result;
        
        int high = nums.length-1;
        int low = 0;
        int mid;
        int k = firstOccurence(nums, low, high, target);
        if (k == -1)
            return result;
        
        result[0] = k;
        
        result[1] = lastOccurence(nums, k, high, target);
        return result;
        
    }
}
