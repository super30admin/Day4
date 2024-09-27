//Time Complexity: O(log(n))
//Space Complexity: O(1)
class FindPeak {
    public int findPeakElement(int[] nums) {

        int l=0,r=nums.length-1, mid=0;

        while(l<=r)
        {
            mid=l+(r-l)/2;
            if( (mid==0 || nums[mid]> nums[mid-1])
                    &&(mid==nums.length-1 || nums[mid]> nums[mid+1]))
            {
                return mid;
            }
            else if(mid!=0 && nums[mid]< nums[mid-1])
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