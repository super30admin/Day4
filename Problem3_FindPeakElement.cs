// Approach : Beacause the neighborhood/boundaries of the array are always less than the elements in the array, we always have a peak in the array. 
// Apply binary search, at each mid -
// if mid is the peak we found the answer
// else move towards the higher side of the mid as there would atleast one peak on the higher side
// Moving to the lower side of the mid doesn't guarentee a peak

// Time Complexity: O(log n)
// Space Complexity : O(1)

public class Solution {
    public int FindPeakElement(int[] nums) {
        int s =0, e = nums.Length -1;
        
        while(s <= e){
            int m = s + (e-s)/2;
            
            bool gtThanLeft = m==0 || nums[m] > nums[m-1] ;
            bool gtThanRight = m==nums.Length-1 || nums[m] > nums[m+1];
            
            if(gtThanLeft && gtThanRight)
                return m;
            else if(gtThanLeft)
                s = m + 1;
            else
                e = m-1;
        }
        
        return -1;
    }
}