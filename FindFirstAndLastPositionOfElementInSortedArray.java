package S30_Codes.Binary_Search_2;

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Binary-Search-2

class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int startPos = binarySearch(nums, target, true);
        int endPos = binarySearch(nums, target, false);

        return new int[] {startPos, endPos};
    }

    private int binarySearch(int arr[], int target, boolean isStart){
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid] == target){
                if(isStart){
                    if(mid == 0 || arr[mid-1] != target){
                        return mid;
                    }
                    end = mid-1;
                }
                else{
                    if(mid == arr.length-1 || arr[mid+1] != target){
                        return mid;
                    }
                    start = mid+1;
                }
            }
            else if(arr[mid] < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
}