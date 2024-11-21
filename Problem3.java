//time - O(log n)
//space - O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = start + ((end - start)/2);
           // int midPlusOne = mid+1 > nums.length-1 ? 0 : mid+1;
            //int midMinusOne = mid-1 < 0 ? nums.length-1 : mid-1;
            int midPlusOne = (mid + 1 + nums.length) % nums.length;
            int midMinusOne = (mid -1 + nums.length) % nums.length;
            if(nums[midMinusOne] < nums[mid] && nums[mid] > nums[midPlusOne])
                return mid;
            if(nums[midPlusOne] > nums[mid] && nums[midPlusOne] >= nums[midMinusOne])
                 start = mid + 1;
            else 
                end = mid -1;
            
        }
        return start;
        
    }
}