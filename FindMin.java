// Time Complexity :  O(logn)
// Space Complexity : O(1) since it is iterative binary search.
// Did this code successfully run on Leetcode : Yes Its working
// Any problem you faced while coding this : Figuring out thg edge cases
class FindMin {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        if (l==r) 
        {
            return nums[0];
        }
        if(nums[l]<nums[r])
        {
            //array is sorted
            return nums[0];
        }
        while(l<=r)
        {
            
            int m = l+(r-l)/2;
            //base condition
            if(nums[m]>nums[m+1])
            {
                //reach the inflection point
                return nums[m+1];
            }
            if(m!=0 && nums[m-1]>nums[m])
            {
                //reach the inflection point
                return nums[m];
            }
            if(nums[m]>nums[l])
                //it means min is in right part
                l=m+1;
            else
                // it means min is in left part 
                r=m-1;
        }
        return -1;
    }
    public static void main(String[] args)
    {

        System.out.println(new FindMin().findMin(new int[]{3,4,5,1,2}));
        System.out.println(new FindMin().findMin(new int[]{4,5,6,7,0,1,2}));
    
        
    }
}