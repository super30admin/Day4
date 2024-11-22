//logic id to go to higher value from mid higher will always lead to peak, lower might be migh not be
//tc- O(logn)
class Solution {
    public int findPeakElement(int[] nums) {
        int low =0, high = nums.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            // check id left of mid and right of mid both are smaller
            if((mid == 0 || nums[mid-1] < nums[mid]) && (mid == high || nums[mid + 1] < nums[mid] )){
                return mid;
            }else if(mid > 0 && nums[mid - 1] > nums[mid]){//if left of mid bigger go to that peak
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return -1;      
    }
}