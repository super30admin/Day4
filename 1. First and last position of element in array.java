// Time Complexity : O(2log(N)) --> O(log(N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : When writing the logic for finding right most element I didn't think about the logic change in loop completely. After seeing test cases I was able to correct myself. 

// Your code here along with comments explaining your approach in three sentences only
// Use binary search on the array twice, once to find the first occurance and then to find the last occurance.
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int first = -1, last = -1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if (nums[mid] == target && (mid==0 || nums[mid-1]!= target)){
                    // we found first occurance
                    first = mid;
                    break;
            }
            else if (nums[mid] >= target){//go left
                high = mid-1;
            }
            else{
                low = mid + 1;
            }
            
        }
        if (first == -1){ //element not found in array, no need to search for 2nd occurance
            return new int[] { first, last };
        }
        low = first; high = nums.length-1; //low can be first here since we only need to search from the first occurance
        while(low<=high){
            int mid = low + (high-low)/2;
            System.out.println(low);
            if (nums[mid] == target && (mid==nums.length-1 || nums[mid+1]!= target)){
                    // we found last occurance
                    last = mid;
                    break;
            }
            else if (nums[mid] > target){//go left, since we are trying to find the right end we only compare with > and not >=
                high = mid-1;
            }
            else{
                low = mid + 1;
            }
            
        }
    return new int[] { first, last };
    }
}
