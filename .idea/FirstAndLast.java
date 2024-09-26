public class FirstAndLast {
    private int binaryL(int[] nums, int target)
    {
        int l = 0;
        int h = nums.length - 1;
        while(l<=h)
        {
            int m = l + (h - l)/2;
            if(nums[m]==target)
                if(m==l || nums[m]> nums[m-1])
                    return m;
                else
                {
                    h=m-1;
                }
            else if(nums[m]>target)
            {
                h = m- 1;
            }
            else
            {
                l = m +1;
            }
        }
        return -1;
    }
    private int binaryR(int[] nums, int target)
    {
        int l = 0;
        int h = nums.length - 1;
        while(l<=h)
        {
            int m = l + (h - l)/2;
            if(nums[m]==target)
                if(m==h || target < nums[m+1])
                    return m;
                else
                {
                    l= m + 1;
                }
            else if(nums[m]>target)
            {
                h = m- 1;
            }
            else
                l = m +1;
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {

        if(nums == null || nums.length==0)
            return new int[] {-1,-1};
        if(nums[0]>target || nums[nums.length - 1] < target)
            return new int[] {-1,-1};
        int left = binaryL(nums, target);
        if(left==-1)
        {
            return new int[] {-1,-1};
        }
        int right = binaryR(nums, target);
        return new int[] {left,right};
    }
}