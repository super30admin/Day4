// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Your code here along with comments explaining your approach
//We use binary search to find the inflection point where we have rotated the array and that would be our minimal element
//We compare the mid element with the right mpst element to keepm moving towards the unsorted part of the array
class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int r=nums.length-1;
        while(l<=r)
        {
            int mid= l+(r-l)/2;
            System.out.println(nums[mid]);
            if((mid==0||nums[mid]<nums[mid-1])&&(mid==nums.length-1||nums[mid]<nums[mid+1]))
                    {
                        return nums[mid];
                    }
            else if(nums[mid]<=nums[r])
                    {
                        r=mid-1;
                    }
            else
                {
                    l=mid+1;
                        }
        }
        return -1;
    }
}

---------------------------------------------------------------------------------

// Time Complexity :O(log n)
// Space Complexity :O(1)
// Your code here along with comments explaining your approach	
//We break down our search into two parts.Finding the initial pos of target and finding the last occourence of target.We use binary search to reduce O.
//If we encounter Target for initial occourence we move left until we find element smaller than target and the next time we move right to find the last occourence.
//We also use the leftmost occourence index to further reduce search space of finding occurence on the right
class Solution {
     private static int SearchFirst(int[] nums,int target)
     {
         int l=0;
         int r=nums.length-1;
         while(l<=r)
         {
             System.out.println("Khatam 1");
             int mid=l+(r-l)/2;
             if(nums[mid]==target)
            {
                if(mid==0||nums[mid-1]<nums[mid])
                {
                    return mid;
                }
                else
                    r=mid-1;
            }
            else if(nums[mid]>target)
                {
                    r=mid-1;
                }
                else
                l=mid+1;
         
         }
         
         return -1;
     }
    
    private int SearchLast(int[] nums,int target,int l,int r)
    {  if(l==-1)
        l=0;
     
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(nums[mid]==target)
            {
                if(mid==nums.length-1||nums[mid+1]>nums[mid])
                return mid;
                else
                    l=mid+1;
                    
            }
            else if (nums[mid]>=target)
            {
                r=mid-1;
            }
            else
                l=mid+1;
        }
     System.out.println("Khatam");
        return -1;
                
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans={-1,-1};
        if(nums==null||nums.length==0)
            return ans;
       if(nums.length==1&&nums[0]!=target)
           return ans;
        int low=SearchFirst(nums,target);
        int high=SearchLast(nums,target,low,nums.length-1);
        ans[0]=low;
        ans[1]=high;
        return ans;
    }
}
---------------------------------------------------------------------------------------------------------------------------------------------------
// Time Complexity :O(log n)
// Space Complexity :O(1)
// Your code here along with comments explaining your approach	
//We use binary search to reduce our search space moving in the direction wherever we find a number greater than our initial index(MID) thereby anticipating that there exists a number on its other side that is also smaller than it
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums==null||nums.length==0)
            return -1;
        if(nums.length==1)
            return 0;
        int l=0;
        int r=nums.length-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if((mid==0&&nums[mid]>nums[mid+1])||(mid==nums.length-1&&nums[mid]>nums[mid-1])||nums[mid]>nums[mid+1]&&nums[mid]>nums[mid-1])
                return mid;
            else if(nums[mid+1]>nums[mid])
                l=mid+1;
            else
                r=mid-1;
        }
        return -1;
    }
}