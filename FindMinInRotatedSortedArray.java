// Approach 1 : Search linearly, and keep updating the index of the min element. And return the index in the end. O(n) time. 

// Approach 2 : Do a finary search, we need to make some minor modification to the binary search algorithm to find the min index. 
// When you find the mid index, compare whether the element in mid index is greater than element in mid+1 index, if so, then mid is the point of rotation, so return mid+1
// Or check whether element in mid-1 is greater than mid, then mid-1 is the point of rotation, so return mid.

// If elemen in the left index is less than element in the mid, then the point of rotation is towards right, so seaech towards right. 
// Or, search towards left side. 

// Time Complexity : O(logn)
// Space Complexity : O(1)

public class FindMinInRotatedSortedArray {
    public static int findMin(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1])
                return mid + 1;
            if (nums[mid - 1] > nums[mid])
                return mid;
            if (nums[mid] > nums[left])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2 };
        System.out.println("Index of min Element : " + findMin(nums));
    }
}