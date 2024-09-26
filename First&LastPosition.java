// Time Complexity : O(LogN) -> for final code, wrote both approaches, in O(N) and O(logN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : For writing the second approach


// Your code here along with comments explaining your approach
/*

for O(N) -> approach
1) scan through the array
2) whenever we find, just assign the index and break
3) same scan from backward side
4) thus we find 2 sides


for O(LogN) approach
1) apply binary search on both sides.
2) once we find the element, we still need to find it as it can be the increased position, and thus we need to again check whether the element exists to the left or not.
3) same for the right side

*/




/*
class Solution {
    public int[] searchRange(int[] nums, int target) {
    
     int first = -1;
     int second = -1;   
        
       for(int i=0;i<nums.length;i++)
       {
           if(nums[i]==target)
           {
               first = i;
               break;
           }
       }
        
       for(int j=nums.length-1;j>=0;j--)
       {
           if(nums[j]==target)
           {
               second =j;
               break;
           }
       }
        
        
        
        
        
     return new int[]{first,second}; 
        
        
    }
}
*/

// Optimized approach O(logN)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        
        
        int result[] = new int[2];
        
        // returns the positions through applying binary search.
        result[0]= findLeftPosition(nums,target);
        result[1] = findRightPosition(nums,target);
        
        return result;
    }
    
    public int findLeftPosition(int [] nums, int target)
    {
        int pos=-1;
        
        int start=0;
        int end = nums.length-1;
        
        while(start<=end)
        {
            int mid = start+(end -start)/2;
            
            if(nums[mid]>= target)
            {
                end = mid -1;
            }
            else
            {
                start= mid +1;
            }
            
            if(nums[mid]==target)
            {
                pos=mid;
                // to again check if there exists any more positions to its left, as we need to return the first arrival of the element
                end =mid-1;
            }
            
        }
        
        return pos;
        
    }
    
    public int findRightPosition(int [] nums, int target)
    {
        int pos=-1;
        
        int start=0;
        int end = nums.length-1;
        
        while(start<=end)
        {
            int mid = start+(end -start)/2;
            
            if(nums[mid]<= target)
            {
                start=mid+1;
            }
            else
            {
                end= mid-1;
            }
            
            if(nums[mid]==target)
            {
                pos=mid;
                // to again check if there exists any more positions to its right, as we need to return the last arrival of the element
                start=mid+1;
            }
            
        }
        
        return pos;
        
    }
}