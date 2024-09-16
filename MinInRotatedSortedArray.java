class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        //if array has only one element or sorted
        if(nums.length==1||
          nums[left]<nums[right])
        {
            return nums[left];
        }
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(mid>0 && nums[mid]<nums[mid-1])
            {
                return nums[mid];
            }
            else if(nums[left]<=nums[mid] && nums[mid]>nums[right])
            {
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return nums[left];
    }
}
//Time Complexity=O(logn)
//Space Complexity=O(1)