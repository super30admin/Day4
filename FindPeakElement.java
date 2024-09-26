//TC = O(log n) where n is number of elements in array.
//SC = O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if((mid == nums.length -1 || nums[mid] > nums[mid + 1]) && (mid == 0 || nums[mid] > nums[mid - 1])){
                return mid;
            }
            else if(mid > 0 && nums[mid] < nums[mid - 1])
            {
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return -1;
    }
}
