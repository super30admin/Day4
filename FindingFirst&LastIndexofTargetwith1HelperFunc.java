class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[] {-1, -1};
        int first = helperBS(nums, target-1);
        int last = helperBS(nums, target);
        if (first == last)
            return new int[] {-1, -1};
        return new int[] {first+1, last};
        
    }
    private int helperBS(int[] arr, int target)
    {
        int low = 0, high = arr.length-1, mid;
        if (target < arr[low])
            return -1;
        if(target >= arr[high])
            return high;
        while (low <= high)
        {
            mid = low+(high-low)/2;
            if (target < arr[mid+1] && arr[mid] <= target)
                return mid;
            if (arr[mid] <= target)
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
}