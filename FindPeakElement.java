// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
/* 
1. Peak is identified by having middle-1 and middle+1 elements samller than itself.
2. Peak can be first element also if element next to it is smaller to itself.
3. Peak can be last element if element before it is smaller than itself.
4. To Navigate, if element before the element is greater we always go left.(both sides can be greater in this case)
5. else if only the element after the middle is greater we go right
*/

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high=nums.length-1;
        if(nums.length==1)
            return 0;
        
        while(low<=high)
        {
            int middle=low+(high-low)/2;
            if((middle==0 && nums[middle]>nums[middle+1])
               || (middle==nums.length-1 && nums[middle]>nums[middle-1])
               || (nums[middle]>nums[middle+1] && nums[middle]>nums[middle-1]))
                return middle;
            else if(middle>0 && nums[middle-1]>nums[middle])
                high=middle-1;
            else low=middle+1;
        }
        return -1;
    }
    public static void main(String[] args)
    {
        int[] nums={1,2,3,1};
        FindPeakElement obj=new FindPeakElement();
        System.out.println(obj.findPeakElement(nums));
    }
}
