// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class FirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        
        if(target < nums[0] || nums[nums.length - 1] < target) {
            return new int[] {-1, -1};
        }
        
        int firstIndex = modifiedBinarySearch(nums, target, 0);
        
        if(firstIndex == -1) {
            return new int[] {-1, -1};
        }
        int secondIndex = modifiedBinarySearch(nums, target, nums.length-1);
        
        return new int[] {firstIndex, secondIndex};
    }
    
    public int modifiedBinarySearch(int[] nums, int target, int boundary) {
        
        int low = 0, high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(nums[mid] == target) {
                if(boundary == 0) {
                    if(mid == boundary || nums[mid-1] != nums[mid]) {
                        return mid;
                    } else if(mid != boundary && nums[mid-1] == nums[mid]) {
                        high = mid - 1;
                    }
                } else if(boundary == nums.length - 1) {
                    if(mid == boundary || nums[mid+1] != nums[mid]) {
                        return mid;
                    } else if(mid != boundary && nums[mid+1] == nums[mid]) {
                        low = mid + 1;
                    }
                }
            } else if(target < nums[mid]) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        
        return -1;
    }
}