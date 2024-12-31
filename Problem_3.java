// Time Complexity :O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No.

//here the approach is to find the mid and check its neighbour that if mid is > than both its neighbour if yes then return it else if on neighbor is greater, we're moving to that side of the array as its high probability that peak exist there.
public class Problem_3 {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int n =  nums.length;
        int high = n-1;
        if(n == 1){
            return 0;
        }
        while(low<=high){
            int mid = low + (high-low)/2;

            if(((mid == 0) || (nums[mid] > nums[mid-1]))&&((mid == n-1) || (nums[mid] > nums[mid+1]))){
                return mid;
            }
            else if(nums[mid] < nums[mid+1]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return 1515;
    }
}
