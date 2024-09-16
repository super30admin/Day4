//Time complexity: O(logn)
//Space complexity: O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int f = this.findBoundary(nums, target, true);
        
        if (f == -1) {
            return new int[]{-1, -1};
        }
        
        int l = this.findBoundary(nums, target, false);
        
        return new int[]{f, l};
    }
    
    private int findBoundary(int[] nums, int target, boolean isFirst) {
        int N = nums.length;
        int start = 0, end = N - 1;
        
        while (start <= end) {
            
            int mid = (start + end) / 2;
            
            if (nums[mid] == target) {
                
                if (isFirst) {
                    
                    
                    if (mid == start || nums[mid - 1] != target) {
                        return mid;
                    }
                    
                   
                    end = mid - 1;
                    
                } else {
                    
                    
                    if (mid == end || nums[mid + 1] != target) {
                        return mid;
                    }
                    
                   
                    start = mid + 1;
                }
                
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return -1;
    }
}