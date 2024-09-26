class Solution {
    //TC -  O(logn)
    //SC-O(N)


    public int[] searchRange(int[] arr, int target) {
        
        int arrindex[] = new int[2];
        arrindex[0] = leftindex(arr, target);
        arrindex[1] = rightindex(arr, target);
        return arrindex;
    }
     public int leftindex(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            if (arr[mid] == target) {
                index = mid;
            }

        }
        return index;

    }

    public int rightindex(int arr[], int target)

    {
        int index = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] <= target) {
                left = mid + 1;

            } else {
                right = mid - 1;
            }
            if (arr[mid] == target) {
                index = mid;
            }
        }
        return index;


    }
}
