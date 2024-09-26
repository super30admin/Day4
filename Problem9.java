//Time Complexity O(log n)

/*
Approach:
    Find the middle element so as to divide the search space into 2 half
    Check if mid is greater than its neighbours - return mid
    Check if mid is greater than right neighbour - set start = mid + 1;
    Check if mid is greater than left neighbour - set end = mid -1;
*/

class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        
        while(start<=end){
            int mid = start+(end-start)/2;
            //If mid greater than both its neigbour
            if((mid == 0 || nums[mid-1]<nums[mid])&&(mid==(nums.length-1) || nums[mid+1]<nums[mid])) return mid;
            //If mid greater than its right neigbour
            else if(mid<(nums.length-1) && nums[mid+1]>nums[mid]){
                start = mid+1;
            }
            //If mid greater than its left neigbour 
            else{
                end = mid -1;
            }
        }
        
        return -1;
    }
}

class Main{
    public static void main(String[] args){
        Solution obj = new Solution();
        int[] arr = [1,2,3,1];
        System.out.println(obj.findPeakElement(arr));
    }
}
