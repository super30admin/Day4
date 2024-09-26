class Solution {// O(log n)
    int[] out = new int[]{-1,-1};
    public int[] searchRange(int[] nums, int target) {
        if(nums == null ) return out;
        int left = 0;
        int right = nums.length - 1;
        binarySearch(nums, target , left , right , true);
        binarySearch(nums, target , left , right , false);
        return out;
    }
    private void binarySearch(int[] nums, int target, int left, int right, boolean isLeft){
        while(left<= right){
            int mid = left + (right - left)/2;
            if(nums[mid]== target){
                if(isLeft) {
                    out[0] = mid;
                    right = mid -1;
                }
                else{
                    out[1] = mid;
                    left = mid+1 ;
                }
            }
            else if(nums[mid]<target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
    }
}