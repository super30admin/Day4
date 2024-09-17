// Time Complexity : O(logn + logn) => O(logn)
// Space Complexity : O(logn)  due to the recursive implementation , although by iterative while loop it can be O(1) but i wanted to explore the recursive way also.
// Did this code successfully run on Leetcode : Yes Its working
// Any problem you faced while coding this : Figuring out a way to avoid same value to be overwritten in output.

class FirstLastIndex {
    int[] output ={-1,-1};
    int[] nums;
    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        int l = 0, h = nums.length-1;
        BinarySearch(l,h,0,target);
        BinarySearch(l,h,1,target);
        return this.output;
    }
    private  void BinarySearch(int l, int h,int i, int target)
    {
        if(l>h)
            return;
        int m = l+(h-l)/2;
        if(nums[m]==target )
        {
            output[i] = m;
            if(i==0)
                h=m-1;
            else
                l=m+1;
            
        }
        else if(nums[m]<target)
            l=m+1;
        else
            h=m-1;
        BinarySearch(l,h,i,target);
            
    }
    public static void main(String[] args)
    {
        for(int x:new FirstLastIndex().searchRange(new int[]{5,7,7,8,8,10}, 8))
        {
            System.out.println(x);
        }
        for(int x:new FirstLastIndex().searchRange(new int[]{5,7,7,8,8,10}, 6))
        {
            System.out.println(x);
        }
        
    }

}