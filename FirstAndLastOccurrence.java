/**
 * Approach: Binary Search
 *
 * Working:
 *      FindFirstOccurrence
 *          - calculate mid, and if the target is found in mid,
 *              - check if the PREVIOUS VALUE i.e (arr[mid-1] != target) in the array is not the same as the target
 *              i.e this is to ensure that the current index is the FIRST LEFT MOST OCCURRENCE of the element
 *                  return mid as the first occurrence
 *
 *              - assume that the current index IS NOT THE FIRST INDEX in the array
 *                  then move the high pointer the left part of the array and perform Binary Search
 *          - remaining condition similar to a regular binary search
 *
 *
 *     FindSecondOccurrence
 *          - calculate mid, and if the target is found in mid,
 *              - check if the NEXT VALUE i.e (arr[mid +1] != target) in the array is not the same as the target
 *              i.e this is to ensure that the current index is the LAST RIGHT MOST OCCURRENCE of the element
 *                  return mid as the LAST OCCURRENCE
 *
 *              - assume that the current index is NOT THE LAST INDEX in the array
 *                  then move the LOW POINTER the RIGHT PART of the array and perform Binary Search
 *          - remaining condition similar to a regular binary search
 *
 *
 *     return {firstIndex, lastIndex};
 *
 * Time Complexity: O(long n)
 * Space Complexity: O(1)
 *
 */


class FirstAndLastOccurrence {
    public int[] searchRange(int[] nums, int target) {

        if(nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        int low = 0;
        int high = nums.length-1;

        int firstIndex = findFirstOccurance(nums, low, high, target);
        if(firstIndex == -1) {
            return new int[]{-1,-1};
        }
        int secondIndex = findSecondOccurance(nums, low, high, target);

        return new int[]{firstIndex, secondIndex};


    }

    private int findFirstOccurance(int[] a, int low, int high,int target){

        while(low<=high) {

            int mid = low+(high-low)/2;
            int midVal = a[mid];

            if(midVal == target) {

                if(mid == low || a[mid-1] != target) {
                    return mid;
                }
                high = mid-1;
            }
            else if(target > midVal) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }

        }
        return -1;
    }

    private int findSecondOccurance(int[] a, int low, int high,int target){

        while(low<=high) {

            int mid = low+(high-low)/2;
            int midVal = a[mid];

            if(midVal == target) {

                if(mid == high || a[mid+1] != target) {
                    return mid;
                }
                low = mid+1;
            }
            else if(target > midVal) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }


}

