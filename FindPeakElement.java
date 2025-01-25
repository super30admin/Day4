class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n= nums.length;
        int low=0;
        int high=n-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if((mid==n-1 || nums[mid] > nums[mid+1]) && (mid == 0 || nums[mid] > nums[mid-1]))
            return mid;
            else if(mid <= n-1 && nums[mid+1] > nums[mid])
            {
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}


//Time Complexity: O(log n)
//Space Complexity: O(1)