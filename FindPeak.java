/*
Time complexity: O(log(n)) binary search 
Space complexity: O(1) No auxilary space needed to compute 
*/

public class FindPeak {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;
        // When mid is greater than the element after that then it is peak.
        while(left < right) {
            int mid = left + (right-left)/2;
            if(nums[mid] < nums[mid+1]) left = mid+1;
            else right = mid;
        }
        return left;
    }
}