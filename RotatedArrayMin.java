// Time Complexity :log(n)
// Space Complexity :O(1) constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class RotatedArrayMin {
    /*
    Atleast one half is sorted and the minis always on the unsorted side.
    If both halves are sorted that means initially itself low<=high so return low
    If mid is the min in that case if mid is low or high or is less than both previous and next value the return it
    If not proceed with regular binary search to ensure base case is reached.
     */
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0){
            return -1;
        }
        int low=0;
        int high = nums.length-1;
        int max = Integer.MAX_VALUE;
        while(low<=high){
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            int mid = low+(high-low)/2;
            if(((mid==0)|| (nums[mid]<nums[mid-1]))&&((mid==high)|| (nums[mid]<nums[mid+1]))){
                return nums[mid];
            }
            else if(nums[low]<=nums[mid]){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        RotatedArrayMin min = new RotatedArrayMin();
        int [] nums={4,5,6,7,0,1,2};
        System.out.println(min.findMin(nums));
        int [] nums1={1};
        System.out.println(min.findMin(nums1));
        int [] nums2={3,1,2,};
        System.out.println(min.findMin(nums2));
    }
}