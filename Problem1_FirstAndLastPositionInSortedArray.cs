// Time Complexity : O(log n + log n) = O(log n) where n is the size of nums array
// Space Complexity : O(1)
public class Solution {
    public int[] SearchRange(int[] nums, int target) {
        
        int s = 0, e = nums.Length-1;
        int l = -1, r = -1;
        
        // first binary search to find the initial position of the target
        while (s<=e)
        {
            int m = s + (e-s)/2 ;
            if(nums[m] == target && (m==0 || nums[m] != nums[m-1])){
                l = m;
                break;
            } else if(target <= nums[m]) {
                e =  m-1;
            } else{
                s = m+1;
            }
        }
        
        //second binary search to find the last position of the target
        s = 0; e = nums.Length-1; 
        while(s<=e){
            int m = s + (e-s)/2;
            if(nums[m]==target && (m==nums.Length-1 || nums[m] != nums[m+1]))
            {
                r = m;
                break;
            } else if(nums[m] <= target){
                s = m+1;
            } else{
                e = m-1;
            }
        }
        
        return new int[] {l, r};
    }
}