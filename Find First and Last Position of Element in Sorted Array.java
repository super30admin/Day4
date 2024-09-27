


/*
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1, -1]
        
        def binaryFirst(nums, target):
            low = 0
            high = len(nums) - 1
            
            while low <= high:
                mid = low + (high - low) // 2
                
                if nums[mid] == target:
                    if mid ==low or nums[mid] > nums[mid - 1]:
                        return mid
                    else:
                        high = mid - 1
                    
                elif target > nums[mid]:
                    low = mid + 1
                    
                else:
                    high = mid - 1
            return -1
        
        def binaryLast(nums, target):
            low = 0
            high = len(nums) - 1
            
            while low <= high:
                mid = low + (high - low) // 2
                
                if nums[mid] == target:
                    if mid ==high or nums[mid] < nums[mid + 1]:
                        return mid
                    else:
                        low = mid + 1
                    
                elif target > nums[mid]:
                    low = mid + 1
                    
                else:
                    high = mid - 1
            return -1
        
        first = binaryFirst(nums, target)
        last = binaryLast(nums, target)
        
        return [first, last]


*/


// Time Complexity : O(logn) where n is size of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: We first find the first occurence and then last occurence separately
// by using the same binary search logic

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[] {-1, -1};
        
        int first = binaryFirst(nums, target);
        int last = binaryLast(nums, target);
        
        return new int[] {first, last};
    }
    
    private int binaryFirst(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = low + (high-low) / 2;
            
            if(nums[mid] == target){
                if(mid == low || nums[mid] > nums[mid - 1])
                    return mid;
                else
                    high = mid - 1;
            }
            else if(target > nums[mid])
                low = mid + 1;
            
            else
                high = mid - 1;
        }
        return -1;
    }
    
    
    private int binaryLast(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = low + (high-low) / 2;
            
            if(nums[mid] == target){
                if(mid == high || nums[mid] < nums[mid + 1])
                    return mid;
                else
                    low = mid + 1;
            }
            else if(target > nums[mid])
                low = mid + 1;
            
            else
                high = mid - 1;
        }
        return -1;
    }
}
