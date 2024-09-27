/*
Time complexity: O(log(n)) binary search two times on given array
Space complexity: O(1) No auxilary space needed to compute 
*/
class FirstAndLastIndex {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{getFirstIndex(nums, target), getLastIndex(nums, target)};
    }
    private int getFirstIndex(int[] nums, int target){
        int low = 0, high = nums.length-1;
        int ans = -1;
        //if target is greater than mid my desired element will lie in right side of the mid
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target) ans = mid;
            if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    } 
    private int getLastIndex(int[] nums, int target){
        int low = 0, high = nums.length-1;
        int ans = -1;
        //if target is greater than mid my desired element will lie in right side of the mid
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target) ans = mid;
            if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}