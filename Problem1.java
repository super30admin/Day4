/*
Big O Analysis: Time O(log N), where N is # of elements in Array and Space O(1)

Passed All Test Cases 

Using two helper functions that perform binary search, we find 1st and last occurences of the element. 
The conditions for binary search are manipulated accordingly once we find element's any occurence. 

*/



class Solution {
    public int[] searchRange(int[] nums, int target) {
    
    //edge case
        if (nums.length == 0 || nums == null) return new int [] {-1, -1} ; 

    //for first and last occurences
     int first = bsFirst(nums, target); 
     int last = bsLast(nums, target) ; 
        return new int[] {first, last} ; 
    }
    
    private int bsFirst(int [] nums, int target) {
        int l = 0 ; 
        int h = nums.length - 1 ; 
        while (l <= h) {
            int m = l + (h - l) / 2 ;
            //we find the element 
            if (nums[m] == target) {
                //we check if it is the first occurence
                if (m == 0 || nums[m] >  nums[m - 1])
                    return m ; 
                //if not, then we move to the left
                else
                    h = m - 1 ; 

                //if we don't find the element at mid 
            } else if (nums[m] > target) h = m - 1 ; 
            else if (nums[m] < target) l = m + 1 ; 
        }
        //element not found 
        return - 1 ; 
    }
    
       private int bsLast(int [] nums, int target) {
        int l = 0 ; 
        int h = nums.length - 1 ; 
        while (l <= h) {
            //calculating middle 
            int m = l + (h - l) / 2 ;

            //once we find the element  
            if (nums[m] == target) {
                //we check if it is the last occurence
                if (m == nums.length - 1 || nums[m] < nums[m + 1])
                    return m ; 

                //if not, we move right 
                else
                    l = m + 1 ;  
            } else if (nums[m] > target) h = m - 1 ; 
            else if (nums[m] < target) l = m + 1 ; 
        }
        return - 1 ; 
    }
}