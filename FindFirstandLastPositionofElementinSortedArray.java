package FindFirstAndLastPositionofElementinSortedArray;

public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {binarySearch (nums, target, true),binarySearch (nums, target, false)};

    }

    public int binarySearch (int [] nums, int target, boolean isLeft) {
        int left = 0 ;
        int right = nums.length-1;
        int index = -1;



        while (left<=right) {
            int middle = (left + (right-left)/2);

            if (nums[middle] > target) {
                right = middle-1;
            }

            else if (nums[middle] < target) {
                left = middle+1;
            }

            else {
                index=middle;

                if (isLeft == true) {
                    right = middle-1;
                }
                else {
                    left = middle+1;
                }
            }

        }

        return index;
    }
}
