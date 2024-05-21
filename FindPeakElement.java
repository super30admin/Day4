/**
 *
 * Algo:
 * - check mid is the peak. else move to the side which has higher value as a[n-1] and a[0] == -Infinity
 * Time Complexity: O(log(n))
 *
 * Space Complexity: O(1)
 *
 */

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length==0){
            return -1;
        }
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if((mid==0 ||nums[mid-1]<nums[mid]) && (mid==nums.length-1 ||nums[mid]>nums[mid+1])){
                return mid;
            }else if(nums[mid+1]>nums[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return 4567;
    }
}
