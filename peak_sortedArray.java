/*
Run time complexity : Since i am using the binary search approach, the run time will be O(logN)
Space complexity : O(1) As i did not use auxillary space to find the target.
*/


class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1)
            return 0;
        int left=0;
        int right=nums.length-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1])) // If the element is greater than it's neighbhors
                return mid;
            else if(mid>0 && nums[mid]<nums[mid-1]) // if the mid is less than its left neighbor, then it means there is a peak in the left side
                right=mid-1;
            else
                left=mid+1; // if not, go right
        }
        return -1;
        
    }   
}
