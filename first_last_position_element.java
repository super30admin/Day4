/*
Run time complexity : Since i am using the binary search approach, the run time will be O(logN)
Space complexity : O(1) As i did not use auxillary space to find the target.
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int leftindex=getleft(nums,target); // Get the leftmost index of the value
        int rightindex=-1;
        if(leftindex>=0 && leftindex<nums.length && nums[leftindex]==target)
            rightindex=getright(nums,target); // Call the right function only when the left index is valid /
        else
            return new int[]{-1,-1}; // Otherwise there is no such element, return default values
        return new int[]{leftindex,rightindex}; // If both left and right index are obtained, return the values
    }
    
    public int getleft(int[] nums,int target)
    {
        int left=0;
        int right=nums.length-1;
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(nums[mid] == target && (mid==0||nums[mid]>nums[mid-1])) // If this is the first occurrence of the target
                return mid; // return mid value
            else if(nums[mid]>=target)
                right=mid-1; // Go left
            else
                left=mid+1; // Go right
        }
        return left;
    }
    
    public int getright(int[] nums,int target)
    {
        int left=0;
        int right=nums.length-1;
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(nums[mid] == target && (mid==nums.length-1 || nums[mid]<nums[mid+1])) // Last occurrence of the target, send mid.
                return mid;                
            else if(nums[mid]>target)
                right=mid-1; // Go left
            else
                left=mid+1; // Go right
        }
        return right;
    }
    
}
