import java.util.Arrays;

class FirstLastPosSortedArray {
    static int lowGlobal;

    // Searching leftmost element
    public static int binarySearchFirst(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // we got the target element then search for left side
            if (arr[mid] == target) {

                // mid == 0 means we reached at leftmost side 
                // if mid is bigger than it's right element then return mid
                if(mid == 0 || arr[mid] > arr[mid -1]){
                    return mid;
                } else {
                    end = mid -1;
                }
              
            } 
            // if mid is bigger than target move end to right side
            else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchLast(int[] arr, int target) {
        int start = lowGlobal;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                if(mid == arr.length - 1 || arr[mid] < arr[mid +1]){
                    return mid;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int[] searchRange(int[] arr, int target) {
        if (arr == null || arr.length <= 0) return new int[] { -1, -1 };
        if(arr[0] > target || arr[arr.length -1] < target) return new int[] { -1, -1 };

        // searching for leftmost element 
        int firstElement = binarySearchFirst(arr, target);

        // Using lowGlobal to start search right side from where left side ended
        lowGlobal = firstElement;

        // If left element is not found means there is no target element
        if(firstElement == -1) return new int[] { -1, -1 };

        // searching rightmost element
        int lastElement = binarySearchLast( arr, target);

        return new int[] { firstElement, lastElement };
    }

    public static void main(String[] args) {
        int[] arr = { 2, 2 };
        int target = 2;
        System.out.println(Arrays.toString(searchRange(arr, target)));
    }
}