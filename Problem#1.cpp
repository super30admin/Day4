class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int arr[] = {-1, -1};
        int start = 0; 
        int end = nums.length -1;
        
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        return new int[]{left, right};
        
    }
    
    public int searchLeft(int[] nums,  int target) {
        int start = 0; 
        int end = nums.length -1;
        
        while (start <= end) {
            int mid = start + (end - start)/2;
            
            if (nums[mid] == target) {
                if (start == mid || nums[mid -1] < nums[mid]) {
                    return mid;
                } else {
                    end = mid -1;
                }
            }  else if (nums[mid] < target) {
                    start = mid + 1;
            } else {
                    end = mid -1;
            }
        }
        return -1;
    }
    
     public int searchRight(int[] nums,  int target) {
        int start = 0; 
        int end = nums.length -1;
        
        while (start <= end) {
            int mid = start + (end - start)/2;
            
            if (nums[mid] == target) {
                if (end == mid || nums[mid +1] > nums[mid]) {
                    return mid;
                } else {
                     start = start +1;
                }
            }  else if (nums[mid] > target) {
                   end = mid -1;
            } else {
                    start = start +1;
            }
        }
        return -1;
    }
}

/* Complexity Ananlysis  

Time complexity : 
O(logN)
Space complexity : 
O(1)

All work is done in place, so the overall memory usage is constant.

*/