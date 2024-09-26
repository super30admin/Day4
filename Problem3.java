/*
Problem is to find the peak element the given array

// Time Complexity : O(n) in method 1. 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, could not implement using recursive binary search
*/

class Problem3 {
    public int findPeakElement(int[] nums) {
        
        if(nums.length == 0){
            return -1;
        }
        
        if(nums.length == 1){
            return 0;
        }
        
        //method -1
        
        //will start searching from postion 1 and check its negihbor
        //this will be a linear search
        
        if(nums[0] > nums[1]){
            return 0;
        }
        
        if(nums[nums.length-1] > nums[nums.length-2]){
            return nums.length-1;
        }
        
        for(int i = 1; i < nums.length-1;i++){
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                return i;
            }
            
        }
        
        return -1;
    }
    
    /*
    method 2 - would be to do binary search recursively until we find the peak element instead of linear search,
    Did not understand to write recurisive function 
    */
    
//         int low = 0;
//         int high = nums.length-1;
        
//         return binarySearch(nums,low,high);
        
    
//     }
//     private int binarySearch(int[]nums,int low,int high)
//     {
//             while(low <= high)
//             {
//              int mid = (low+high)/2;
//              if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
//                 return mid;
//                 binarySearch(nums,low,mid-1);
//                  binarySearch(nums,mid+1,high); 
//             }
             
//             return -1;
//         }
//     }
}