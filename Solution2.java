//time complexity: O(logn)
//space complxity: O(logn)
//#34. Find First and Last Position of Element in Sorted Array
class Solution2 {
    public int findPeakElement(int[] nums) {
        int L = 0, R = nums.length -1;
        while(L < R) {
            int mid = L + (R-L)/2;
            if(nums[mid] < nums[mid + 1]){
                L = mid + 1;
            } else {
                R = mid;
                
            }
        }
        return L;
    }
}