// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Look for target and target -1 last position
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length==0) return new int[]{-1,-1};

        if(nums.length == 1 ){
            if(nums[0] == target){
                return new int[]{0,0};
            }
            else{
                return new int[]{-1,-1};
            }

        }
        if(target<nums[0] || target> nums[nums.length-1]){
            return new int[]{-1,-1};
        }

        int start = binarySearch(nums, target-1);
        int end = binarySearch(nums, target);
        if(start == end){
            return new int[]{-1,-1};
        }
        return new int[]{start+1, end};

    }

    public int binarySearch(int[] arr, int target){
        int l = 0;
        int h = arr.length-1;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(target>=arr[arr.length-1]) return arr.length-1;
            if(arr[mid]<=target && arr[mid+1]>target){
                return mid;
            }

            if(arr[mid]<=target){
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        return -1;
    }
}
