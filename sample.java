//Problem-1
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int[] searchRange(int[] nums, int target) {
       
        if(nums.length==0 || nums == null) // if array is empty return {-1,-1}
        {
            return new int[] {-1,-1};
        }
        
        int front = leftBinarySearch(nums, target); // finding the first occurrence of the target by running binary search on whole array
        int last = rightBinarySearch(nums, target); // finding the last occurence of the target by running binary search on whole array
        return new int[] {front,last}; // returning the found indexes
    }
    
    private int leftBinarySearch(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length-1;
        while(low<=high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid]==target) // binary search conditions
            {
                if( mid==0 || nums[mid]>nums[mid-1]) // to find leftmost i.e if the value at mid should be greater than its left value
                {
                    return mid; // return found left index
                }
                else
                    high = mid-1; // else update the high to reduce the range
            }
            else if(nums[mid] > target)  // binary search conditions
            {
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return -1;
    }
    
     private int rightBinarySearch(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length-1;
        while(low<=high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid]==target) // binary search conditions
            {
                if(mid == nums.length-1 || nums[mid]<nums[mid+1]) // to find rightmost i.e if the value at mid should be lesser than its right value
                {
                    return mid; // return found right index
                }
                else
                    low = mid+1; // else update the low to reduce the range
            }
            else if(nums[mid] > target)  // binary search
            {
                high = mid-1;
            }
            else
                low = mid+1;
        }
         return -1;
    }
    
}

//Problem-2
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


class Solution {
    public int findMin(int[] nums) {
        
        if(nums.length ==1) // if length is 1
            return nums[0]; // return the value as min
        
     int low = 0;
     int high = nums.length-1;
        
        if(nums[high] > nums[0]) // if value at last index > value at first i.e array is sorted
            return nums[0]; // return the first index value
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
             
            if(nums[mid] > nums [mid +1]) // if value at mid is greater than its right value
                return nums[mid+1]; // i.e we found min at mid + 1
            
            if(nums[mid] < nums[mid-1]) // if value at mid is less than its left value
                return nums[mid]; // i.e we found min at mid 
            
            if(nums[mid] > nums[0]) // updating the bounds by checking the sorted array part
                low = mid+1; // if left is sorted, min value will be at right
            else
                high = mid-1; // if right is sorted, min value will be at left
            
           
        }
     return -1;
    }
}


//Problem-3
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int findPeakElement(int[] nums) {
        
   int low = 0 , high = nums.length-1;

        while(low < high) {

          int mid = low + (high - low)/2;

            if (nums[mid] < nums[mid+1]) { // if value at mid is lesser than its right value
                low = mid + 1; // go towards the upper bound and update low
            } else {
                high = mid; // else update high
            }
        }
       return low; // at the end low will give the peak
    }
}