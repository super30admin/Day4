public class MinimumInRotatedArr {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low <high)
        {
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid] < nums[mid-1]) &&
                    (mid == nums.length - 1 || nums[mid] < nums[mid + 1]))
            {
                return nums[mid];
            }
            else if(nums[mid]<=nums[high])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return nums[low];
    }
    public static void main(String args)
    {
        int[] nums = {3,4,5,1,2};
        MinimumInRotatedArr ob= new MinimumInRotatedArr();
        System.out.println(ob.findMin(nums));
    }
}
