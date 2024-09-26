
public class problem2 {

    // Time Complexity : O(log n)
    // Space Complexity : Constant
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    public int findMin(int[] nums) {
        int l=0;
        int r=nums.length-1;
        
        while(l<=r){
            int mid= (r+l)/2;
            
            if(mid>0&&mid<nums.length-1&& nums[mid-1]>nums[mid]&& nums[mid+1]>nums[mid]){
                return nums[mid];
            }
            
            else if(nums[l]>nums[mid]){ r=mid-1;}
            else if(nums[r]<nums[mid]){ l=mid+1;}
            else{ return nums[l];}
        }
        return -1;
    }
}
