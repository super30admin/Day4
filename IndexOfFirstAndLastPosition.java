// Approach 1 : Searcing linerly for first and last occurance of a target element. But in the worst case it'll take O(n) time.

// Approach 2 : Since the elements are in sorted order, we can somehow use binary search. But binary search just searches for an element in the 
// array. But we need to make some modification for the binary search algorithm to solve this problem. 
// To find the first occurance of an element, we beed to push the search space towards the left, we can do this by moving the search space 
// towards left when the mid element is greater than or equal to the target. And as we find the mid index where the element in mid index is
// equal to the target, we keep in updating the index.

// To find the last occurance of the target element also, we follow the same idea, just that here we need to push the search space towards right. 

// Time Complexity : O(logn), we perform binary search twice on the given array. 
// Space Complexity : O(1)

public class IndexOfFirstAndLastPosition {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findStartingIndex(nums, target);
        res[1] = findEndingIndex(nums, target);
        return res;
    }

    private static int findStartingIndex(int[] nums, int target) {
        int index = -1;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;

            if (nums[mid] == target)
                index = mid;
        }

        return index;
    }

    private static int findEndingIndex(int[] nums, int target) {
        int index = -1;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target)
                left = mid + 1;
            else
                right = mid - 1;

            if (nums[mid] == target)
                index = mid;
        }

        return index;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;

        int[] res = searchRange(nums, target);
        System.out.println(res[0] + " " + res[1]);

        target = 6;
        res = searchRange(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }
}