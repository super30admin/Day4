// Time Complexity : log(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class PeakElement {
    public static int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] > nums[mid+1]){
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String args[]){
        int[] arr = new int[]{1,2,3,1};
        System.out.println(findPeakElement(arr));
    }
}
