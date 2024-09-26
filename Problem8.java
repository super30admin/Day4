// Time Complexity: O(log n)

/*
Approach:
    Check if length of arr is greater than 1
    Check if array is already sorted by comaparing nums[0] with nums[nums.length-1]
    Find mid element to divide the search space in half.
    Check if mid is greater than nums[mid+1] - return nums[mid]
    Similarly, check if nums[mid-1] is greater than nums[mid] - return nums[mid]
    Check if array is left sorted, if yes the start = mid +1
    Check if array is right sorted, if yes end = mid -1
*/

class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        
        //Only single elemnt in the array
        if(nums.length == 1) return nums[0];
        
        //If array is already sorted
        if(nums[0]<nums[nums.length-1]){
            return nums[0];
        }
        
        while(start<=end){
            //Middle Element
            int mid = start + (end-start)/2;
            
            //Check if middle element is greater than next element
            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            } 
            
            //Check if middle element is smaller than preceeding element
            if(nums[mid-1]>nums[mid]){
                return nums[mid];
            }
            
            if(nums[mid]>nums[0]){
                start = mid+1;
            } else if(nums[mid]<nums[0]){
                end = mid-1;
            }
        }
        return -1;
    }
}

class Main{
    public static void main(String[] args){
        Solution obj = new Solution();
        int[] arr = new int[]{3,4,5,1,2};
        System.out.println("Minimum Element in the array: " + obj.findMin());
    }
}