/*
Time Complexity = 2(logN)
 */

class FindFirstAndLastPositionSortedArray {
    public int[] searchRange(int[] nums, int target) {

        int[] index = {-1,-1};
        if (nums.length < 1)
            return index;

        index[0] = firstOccurrence(nums, target);
        index[1] = lastOccurrence(nums, target);

        return index;
    }

    private int firstOccurrence ( int[] arr , int target)
    {

        int low = 0;
        int high = arr.length-1;
        int mid ;

        while(low <= high)
        {
            mid = low + (high-low)/2;
            //System.out.println(mid);
            if ((mid == 0 && arr[mid] == target) || ( arr[mid]==target && arr[mid-1]<target))
            {
                return mid;
            }
            else if (target > arr[mid])
            {
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }

    private int lastOccurrence(int[] arr , int target)
    {
        int low = 0;
        int high = arr.length - 1;
        int mid ;

        while (low <= high)
        {

            mid = low + (high-low)/2;

            if ((mid == arr.length-1 || target < arr[mid+1]) && arr[mid] == target)
            {
                return mid;
            }

            else if (target >= arr[mid])
            {
                low = mid +1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }

}