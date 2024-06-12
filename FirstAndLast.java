
// Time Complexity : 2*O(log(n)) = O(log(N))
// Space Complexity : O(log(n))?
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, edge cases were difficult to understand at first. Also thought of recursive calls so at first instead of chaning high and low pointers, I returned a binarySearch call, with the updated low and high. 


class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            int[] res = new int[2];
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        //binary search for lowest number first
        // then run a binary search on the highest number first
        //To see if its lowest or highest, it has to be lower or higher than the previous value 
        int lowerIndex = binarySearchStart(nums,0,nums.length-1,target);
        int higherIndex = binarySearchEnd(nums,0,nums.length-1,target);
        int[] result = new int[2];
        result[0] = lowerIndex;
        result[1] = higherIndex;
        return result;
    }
    
    public int binarySearchStart(int nums[], int low, int high, int target){
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] < target){
                    return mid;
                }else{
                    high = mid-1;
                }
            }else if(nums[mid] > target){
                high = mid - 1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }
        }
        return -1;
    }
    
    public int binarySearchEnd(int nums[], int low, int high, int target){
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                if(mid == nums.length -1 || nums[mid+1] > target){
                    return mid;
                }else{
                    low = mid + 1;
                }
            }else if(nums[mid] > target){
                high = mid - 1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }
        }
        return -1;
    }
    
}