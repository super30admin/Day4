class MinimumRotatedSortedArray{
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int mid;

        while(left<right)
        {
        mid=left+(right-left)/2;
        if(nums[mid]>nums[right])
            left=mid+1;
        else
            right=mid;
        }
        return nums[left];
        
    }
}