//time complexity: O(logn)
//space complexity:O(1)

class FirstLastPositionInArray {
    public int[] searchRange(int[] arr, int target) {
       if (arr.length == 0 || arr == null) {
            return new int[]{-1, -1};
        }
        int left = binarySearchLeft(arr, target);
        int right = binarySearchRight(arr, target);

        return new int[]{left, right};
    }

    private int binarySearchLeft(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                // target equals to mid
                // move to left until target>mid or mid - 1 is smaller

                if (low == mid || arr[mid - 1] < arr[mid]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    private int binarySearchRight(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                // target equals to middle
                // move to right until target>mid or mid +1 is larger
                if (high == mid || arr[mid + 1] > arr[mid]) {
                    return mid;
                } else
                {
                    low = mid + 1; // update low
                }
            }
        }
        return -1;
    } 
    
}
