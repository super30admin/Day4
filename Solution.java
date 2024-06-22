// The search range is adjusted by comparing the middle element with its neighbors and narrowing the range accordingly.
public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = left+(right-left)/2;
            if(mid>0 && nums[mid]<nums[mid-1]){
                right = mid -1;
            }
            else if(mid<(nums.length-1) && nums[mid+1]>nums[mid]){
                left=mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
} 
