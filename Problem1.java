class Solution {
    public int[] searchRange(int[] A, int target) {
        int low = 0;
        int high = A.length-1;
        int mid;

        while(low<high){
            mid = low + (high - low)/2;

            if(A[mid] == target)
                high = mid;
            else if (A[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        if(A.length ==0 || low > A.length || A[low] != target)
            return new int[]{-1,-1};
        int left = low;

        low = 0;
        high = A.length - 1;
        while(low<high){
            mid = high - (high - low)/2;

            if(A[mid] == target)
                low = mid;
            else if (A[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return new int[]{left, low};
    }
}