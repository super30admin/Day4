// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
class PeakInArray {
    /* Peak is always found after an increasing slope or if the mid is in a decreasing slope, then peak is found before
    @param array
    @return peak
     */
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length==0){
            return -1;
        }
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if((mid==low || nums[mid-1]<nums[mid]) && (mid==high || nums[mid]>nums[mid+1])) {
                return mid;
            }
            else if(nums[mid]>nums[mid+1]){
                high = mid-1;
            } else {
                low=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        PeakInArray obj = new PeakInArray();
        int [] nums = {1,2,1,3,5,6,4};
        System.out.println(obj.findPeakElement(nums));
    }
}
