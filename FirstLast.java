/*
This solution finds the low and high indexes of target element using binary search. 
We first do a binary search to find the low index of the target, and then a binary
search to find the high index of the target.

Problems with this code: None

Did this code run on leetcode: Yes


*/




class Solution {
    
    /*We pass a flag to the binary search function so that we can check if we are searching for low index or high index.
    We also pass the low variable to the function so that we can optimize it for the search for high index, by passing the
    low index we found from the first search to reduce search space*/
    private int binarySearchIndex(int[] nums, int target, int low, int flag)
    {
        int high = nums.length - 1;
        int mid = 0;
        //For finding low index
        if(flag == 1)
        {
            while(low <= high)
            {
                mid = low + (high-low)/2;
            
                if(nums[mid] == target)
                {   /*We check edge case when the mid is either the first element or if it greater than is previous element.
                    We check mid == 0 first to prevent an index out of bounds error*/
                    if(mid == 0 || nums[mid] > nums[mid-1])
                        return mid;
                
                    else
                        high = mid - 1;
                }
            
                else if(nums[mid] > target)
                    high = mid - 1;
            
                else
                    low = mid + 1;
            }
        }
        
        //For finding high index
        else
        {
            while(low <= high)
            {
                mid = low + (high-low)/2;
            
                if(nums[mid] == target)
                {   /*We check edge case when the mid is either the last element or if it lesser than its next element.
                    We check mid == nums.length-1 first to prevent an index out of bounds error*/
                    if(mid == nums.length-1 || nums[mid] < nums[mid+1])
                        return mid;
                
                    else
                        low = mid + 1;
                }
            
                else if(nums[mid] > target)
                    high = mid - 1;
            
                else
                    low = mid + 1;
            }
        }
        
        return -1;
              
    }

    //Time Complexity: O(log(n))
    //Space Complexity: O(1)
    public int[] searchRange(int[] nums, int target) 
    {
        //Base case when no/null input
        if(nums == null || nums.length == 0)
            return new int[] {-1,-1};
        
        //When target is out of bounds of the range of the array
        if(target < nums[0] || target > nums[nums.length-1])
            return new int[] {-1,-1}; 
        
        int lowIndex = binarySearchIndex(nums, target, 0, 1);
        
        if(lowIndex == -1)
            return new int[] {-1,-1};
        
        int highIndex = binarySearchIndex(nums, target, lowIndex, 2);
            
        return new int[] {lowIndex,highIndex};
        
        
    }
}