// Time Complexity : O(Log(N)) -> Binary search involved
// Space Complexity : O(1) -> No extra space used
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
//Couldn't solve problem on my own.

// Your code here along with comments explaining your approach


class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums == null || nums.length == 0)
            return new int[] {-1, -1};
        
        int firstElem = findRightMostIndex(nums, target-1);
        int lastElem = findRightMostIndex(nums, target); 
        
        if(firstElem == lastElem)
            return new int[]{-1, -1};
        
        return new int[] {firstElem + 1, lastElem};
        
    }
        
        private int findRightMostIndex(int[] arr, int value){
            
            int low = 0;
            int high = arr.length-1;            
            
            if(value < arr[0])
                return -1;
            
            if(value >= arr[arr.length-1])
                return arr.length-1;
            
            while(low<=high){
                int mid = low + (high-low)/2;
                
                if(arr[mid] <= value && arr[mid+1] > value){
                    return mid;
                }
                if(arr[mid] <= value){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            
            return -1;
        }
}