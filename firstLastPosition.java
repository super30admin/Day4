// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
class firstLastPosition{
    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1,-1}; 
        int start = searchNumber(nums, target, true); // check First accurence
        int end = searchNumber(nums, target, false); // check Last accurrence
        range[0] = start;
        range[1] = end;
        return range;
    }
    int searchNumber(int[] nums, int target, boolean findStartIndex){
        int low = 0;
        int high = nums.length-1;
        int range = -1;
        if(nums == null || nums.length == 0){
            return range;
        }
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                range = mid;
                if (findStartIndex) {
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
                // if(mid + 1 == target){
                    
                // }
                // else if (mid - 1 == target){

                // }               
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return range;
    } 
}