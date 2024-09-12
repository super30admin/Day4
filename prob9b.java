// Time Complexity :O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public int findMin(int[] nums) {
        return Find_minimum(nums,0,nums.length-1);
    }
    public int Find_minimum(int [] nums,int low,int high){
        if(nums[low] <= nums[high] ){
            return nums[low];
        }
        while(low <= high){
            int mid = low + (high - low)/2;
            if(mid < high && nums[mid]>nums[mid + 1]){
                return nums[mid + 1] ;
            }
            if(mid > low && nums[mid] < nums[mid - 1]){
                return nums[mid];
            }
            if(nums[low] <= nums[mid]) { // left array is sorted. So the pivot is on the right side
                low = mid+1;
            } else { //right array is sorted. So the pivot is on the left side
                high = mid-1;
            }
            
        }
        return -1;
    }
}