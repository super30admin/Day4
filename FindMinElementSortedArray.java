//Time complexity O(log n)
//Space complexity O(1)
//Leetcode : yes
//Problem:
public class FindMinElementSortedArray {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int mid;
        //we know its given the array will not be zero but good habit to always put boundary checks
        if (nums.length == 0) {
            return -1;
        }

        //this condition takes care if the entire array is sorted and case of one element only
        //we can also use greater than equalto then we don't need the right == 0 check but since the user said no duplicate in the array added the extra check
        if (nums[right] > nums[0] || right == 0) {
            return nums[0];
        }
        while (left <= right) {
            mid = left + (right - left)/2;
            if (nums[mid] > nums[mid +1]) {
                return nums[mid +1];
            }
            if (nums[mid] < nums[mid -1]) {
                return nums[mid];
            }
            if (nums[left] < nums[mid]) {
                //we know the left side of the array is sorted.so rotated index will on the right side array
                left = mid + 1;
            } else {
                //we know right side is sorted so rotated index will be on left side
                right = mid - 1;
            }
        }
        return -1;
    }
}
