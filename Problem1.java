//time complexity - O(log n)
//space - O(1)

//approach - look for start using binary search and then end
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] res = {-1, -1};
        /*if(nums[mid] == target) {
        update res[0] to mid
        end = mid-1 }*/
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end) {
            int mid = start + ((end-start)/2);
            if(nums[mid] == target) {
                res[0] = mid;
                end = mid -1;
            }
            else if(nums[mid] < target) {
                start = mid+1;
            }
            else {
                end = mid - 1;
            }
        }
        
        start = res[0] != -1 ? res[0] : 0;
        end = nums.length-1;
        
        while(start <= end) {
            int mid = start + ((end-start)/2);
            if(nums[mid] == target) {
                res[1] = mid;
                start = mid + 1;
            }
            else if(nums[mid] < target) {
                start = mid+1;
            }
            else {
                end = mid - 1;
            }
        }
            
        return res;
        
        
    }
}