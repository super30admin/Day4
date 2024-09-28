//Time complexity: 2 O(log n) we are doing a binary search two times
//Space complexity: O(1)
//Leetcode: Yes
//Problem: Ran few times on Leetcode to get all test case passing.
public class FirstLastIndexSortedArray {
    public int[] searchRange(int[] nums, int target) {

        int[] result = {-1, -1};

        if (nums.length == 0)
        {
            return result;
        }
        //pass true if we are looking for the first index otherwise how the helper function know if we need to check on the left or the right side (whether we are looking for first index or the last index for the element)
        result[0] = searchIndex(nums, target, true);
        if (result[0] == -1) {
            //we know the element does not exist no need to search again.
            return result;
        }
        //look for the last occurence
        result[1] = searchIndex(nums, target, false);

        return result;
    }

    public int searchIndex(int[] nums, int target, boolean isfirst) {

        int left = 0;
        int right = nums.length -1;
        int mid = 0;

        while (left <= right) {
            mid = left + (right-left)/2;
            if (nums[mid] == target) {
                //first check are we lookign for first occurence or last occurence
                if (isfirst) {
                    //check we are not getting out of bounds
                    if (mid == 0) {
                        return mid;
                    }
                    //looking for first occurence
                    //this index can be first or there can be something on the left side
                    if (nums[mid-1] != target) {
                        //we know this is the first occurence
                        return mid;
                    } else {
                        //if equal that means the same target is present on the left part of the array
                        right = mid -1;
                    }
                } else {
                    //check we are not getting out of bounds
                    if (mid == right) {
                        return mid;
                    }
                    //looking for the last occurence
                    if (nums[mid +1] != target) {
                        return mid;
                    } else {
                        //go to the right side of the array as same target exists there
                        left = mid + 1;
                    }
                }
            } else if (nums[mid] < target) {
                //element not at mid and less than target so it must be on the right
                left = mid +1;
            } else {
                //element not at mid and greater than target so it must be on the left
                right = mid -1;
            }
        }//end of while
        return -1;
    } //end of helper search function

    public static void main(String args[]) {
        FirstLastIndexSortedArray ob = new FirstLastIndexSortedArray();
        int[] nums = {10, 20, 40, 40, 40, 40, 50, 50, 70, 80, 90};
        int [] result = ob.searchRange(nums,40);
        System.out.println("first index: "+ result[0] + " Last Index:  "+ result[1]);
    }
}
