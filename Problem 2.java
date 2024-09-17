Time Complexity:O(logn)
Space COmplexity:O(1)

class Solution {
   
    public static int findMin(int[] nums) {

        int left = 0, right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;



            if(nums[mid] < nums[right]) {

                right = mid;

            } else {

                left = mid+1;

            }

        }

        return nums[left];

    }
}
