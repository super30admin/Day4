// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class FirstLastSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int low =0;
        int high = nums.length;
        int mid = 0;
        int a[] = new int[2];
        while(low<high){
            mid = low + (high-low)/2;
            if(nums[mid] < target) low = mid+1;
            else high =mid;
        }
        a[0] = low;
        if(low == nums.length || nums[low] != target)
        {
            a[0] = a[1] = -1;
            return a;
        }
        int targ1 = target +1;// Trying to find next greatest element, helpful in deciding upper bound
        high = nums.length;
        while(low<high){
            mid = low + (high-low)/2;
            if(nums[mid] < targ1) low = mid+1;
            else high = mid;
            }
        a[1] = low-1;
        return a;
    }
}
