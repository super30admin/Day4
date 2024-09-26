// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Yes , getting runtime error


// Your code here along with comments explaining your approach
//This is like a linear search just from two ends. First we start from left and see the first occurence of the targer.
//When we see the target we stop iterating and break the code
//Same thing done from right of the array when we see the element , we break the code
//And then we return the position we found in the first iteration and the position from the second iteration


class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        
        
        int result[] = new int[]{-1,-1};
        int mid = (nums.length)/2;
        
        for (int i=0;i<=mid;i++)
        {
            if(nums[i]==target)
            {
                result[0]=i;
                break;
            }
        }
        
        for(int i = nums.length-1;i>mid;i--)
        {
            if(nums[i]==target)
            {
                result[1] = i;
                break;
            }
        }
        return result;
    }
}







//Time Complexity : O(log n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//here we are using two binary searches.
//We use one for searching towards the left the first occurence of target
//WE use the other for searching towards right the last occurence of target


class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums == null || nums.length == 0 || target<nums[0] || target > nums[nums.length-1])
        {
          return new int[]{-1,-1};
        }
        
        int start = leftBinarySearch(nums,target);
        int end = rightBinarySerach(nums,target);
        
        return new int[]{start,end};
       
    }
    //searching to the left first occurence
    private int leftBinarySearch(int[] nums, int target)
    {
    	//regular binary search with just a condition to stop when no more elements to the left are same as target
        int l = 0;
        int r = nums.length - 1;
        
        while(l <= r)
        {
            int mid = l + (r-l)/2;
            
            if(target == nums[mid])
            {
            	//if we find there are no more same elements as target to the left
                if(mid == 0 || nums[mid]>nums[mid-1])
                {
                    return mid;
                }
                else
                {
                    r = mid -1;
                }
            }
            
            else if(target<nums[mid])
            {
                r = mid -1;
            }
            else
            {
                l = mid + 1;
            }
        }
        return -1;
    }
    
    private int rightBinarySerach(int[] nums, int target)
    {
        int l = 0;
        int r = nums.length -1 ;
    	//regular binary search with just a condition to stop when no more elements to the right are same as target

        while(l <= r)
        {
            int mid = l + (r-l)/2;
            
            if(target == nums[mid])
            {
            	//if we find there are no more same elements as target to the right

            if( mid == nums.length-1 || nums[mid]<nums[mid+1])
            {
                return mid;
            }
            else
            {
                l = mid + 1;        
            }
            }
            else if (target > nums[mid])
            {
                l = mid + 1;
            }
            else
            {
                r = mid -1 ;
            }
            
        }
        return -1;
    }
}