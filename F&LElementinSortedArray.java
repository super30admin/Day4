// Time Complexity :
// searchRange = O(log m)
// findtheBinarySearchFirst = O(log m)
// findtheBinarySearchLast = O(log m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        int lowerindex = 0;
        int higherindex = high;
        int mid = 0;
        
        while(low <= high) {
             mid = low + (high - low)/2;
            if(nums[mid] == target) {
                System.out.println(low + " " + mid);
                int firstIndex =  findtheBinarySearchFirst(nums,low,mid, target);
               int LastIndex = findtheBinarySearchLast(nums,mid,high, target);
                return new int []{firstIndex,LastIndex};
                
            }
            
            else if(nums[mid] < target) {
                low = mid + 1;
                
            }
                 
            else if(nums[mid] > target) 
                high = mid - 1;       
        }  
      
        return new int []{-1, -1};
        
    }
    
    private int findtheBinarySearchFirst(int[] nums, int first, int last, int target) {
        while(first <= last) {
            int mid = first + (last - first)/2;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid - 1] != nums[mid])
                    return mid;
                else {
                    last = mid - 1;
            }
            } else {
                first = mid + 1;
        }
            
        }
        return -1;
        
    }
   
    private int findtheBinarySearchLast(int[] nums, int first, int last, int target) {
         while(first <= last) {
           int mid = first + (last - first)/2;
            if(nums[mid] == target) {
                if(mid == last || nums[mid + 1] != nums[mid])
                    return mid;
                else {
                    first = mid + 1;
                }
            } else {
                 last = mid - 1;
                
            }
        
        }
        return -1;
    }
}