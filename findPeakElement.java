public class findPeakElement {
    public static int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // if mid == 0 means first element
            // if mid == arr.length - 1 means it's last element
            // if mid's left and right then it's peak element
            if ((mid == arr.length - 1 || arr[mid] > arr[mid + 1]) && (mid > 0 || arr[mid] > arr[mid - 1])) {
                return arr[mid];
            
            // if mid is larger than 0 && left side is smaller than move end to mid
            } else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2 };
        System.out.println(findPeakElement(arr));
    }
}
