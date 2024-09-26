// Time Complexity : log(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes

public class FindMinInSortedRotatedArray {
    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        // Finding the boundary of the min element
        
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] > nums[high]){
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }

    public static void main(String args[]){
        int[] arr = new int[]{4,5,6,7,8,1,2};
        System.out.println(findMin(arr));
    }
}
