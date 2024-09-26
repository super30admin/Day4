
public class problem3 {

    // Time Complexity : O(log n)
    // Space Complexity : Constant
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    public int findPeakElement(int[] nums) {
        int l =0;
        int r= nums.length-1;
        
        while(l<r){
            int mid = l+(r-l)/2;
            
            if(nums[mid]<nums[mid+1]){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }
}
