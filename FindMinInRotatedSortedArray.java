class FindMinInRotatedSortedArray{
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length-1;

        while(lo <= hi){
            if(nums[lo] < nums[hi]){
                return nums[lo];
            }
            int mid = lo + (hi - lo) / 2;
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length-1 || nums[mid] < nums[mid+1])){
                return nums[mid];
            }
            else if(nums[mid]>= nums[lo]){
                lo = mid + 1;
            }
            else{
                hi = mid-1;
            }
        }
        return Integer.MAX_VALUE;
    }
}