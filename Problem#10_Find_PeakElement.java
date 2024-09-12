/*
 * Time Complexity: O(Log(N)) for binary search approach.
 * Space Complexity: O(1) constant space.
 * */
public class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length -1;
        int mid = 0;
        //Binary search approach for O(lon(N))
        while(l<r){
            mid = l + (r-l)/2;
            if(nums[mid]<nums[mid+1]){
                l = mid+1;
            } else{
                r = mid;
            }
        }
        return l;
    }
}