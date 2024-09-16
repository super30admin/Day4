package BinarySearch;

/*
  Time complexity : o(log n)
  Space complexity : o(n)
  Did this code run succesfully in leetcode : yes
  problems faces : no
  Apply binary search to find the first occurence of the element. 
   for ever search ,if the mid matches to target , check if the left adjacent element also matches to target , then move mid to mid-1
  Apply binary search to find the last occurence of the element
   for ever search ,if the mid matches to target , check if the right adjacent element also matches to target , then move mid to mid+1
*/ 


public class SearchRepeatingElementPositionsSortedArray {

    static int firstOccurence;
    static int lastOccurence;

    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0)
            return new int[] { -1, -1 };

        firstOccurence = binarySearchLeft(nums, target);
        if (firstOccurence == -1)
            return new int[] { -1, -1 };
        lastOccurence = binarySearchRight(nums, target);
        return new int[] { firstOccurence, lastOccurence };
    }

    public int binarySearchLeft(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        int mid = -1;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (a[mid] == target) {
                if (mid == 0 || a[mid] > a[mid - 1]) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (a[mid] > target) {
                right = mid - 1;

            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public int binarySearchRight(int[] a, int target) {
        int left = firstOccurence;
        int right = a.length - 1;
        int mid = -1;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (a[mid] == target) {
                if (mid == a.length - 1 || a[mid] < a[mid + 1]) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (a[mid] > target) {
                right = mid - 1;

            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

}
