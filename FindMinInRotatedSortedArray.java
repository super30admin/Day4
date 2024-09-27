//Time Complexity: O(log(n))
//Space Complexity: O(1)
class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l=0,r=nums.length-1,mid=0;

        while(l<=r)
        {
            //Check if left most element is the min element
            if(nums[l]<= nums[mid] && nums[l]<=nums[r])
                return nums[l];
            mid=l+(r-l)/2;// To avoid integer overflow

            // Check if the mid element is the minimum element
            if((mid==nums.length-1 || nums[mid]< nums[mid+1])
                    && (mid==0 || nums[mid] < nums[mid-1]))
            {
                return nums[mid];
            }
            else
            {
                //Left side is sorted
                if(nums[l]<=nums[mid])
                {
                    l=mid+1;
                }
                else
                {
                    r=mid-1;
                }
            }

        }

        return -1;// dummy value
    }
}
