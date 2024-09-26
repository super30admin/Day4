/*
Problem is to find the minimum element is the rotated array

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
*/

class Problem2 {
    public int findMin(int[] nums) {
        if(nums.length == 0){
            return -1;
        }
        
        
        
        int low = 0;
        int high = nums.length-1;
        
        //{4,5,6,7,0,1,2}
        //low = 0,high = 6
        // nums[0] > nums[6]
        
        if(nums[high] > nums[low]){
            //then this means the array has not been rotated
            return nums[low];//return the first element of the array
            
        }
        
        while(low <= high){
            int mid = (high + low)/2; //mid = 3
            
            if(nums[mid] > nums[mid+1]){ //nums[mid] = 7 , 7 > 0 
                //this is the rotated point in the array
                return nums[mid+1]; //return 0
            }
            
            if(nums[mid] < nums[mid-1]){  //5,6,7,0,1,2,3 , here nums[mid] =0 and 0 < 7
                return nums[mid];
            }
            
            if(nums[mid] > nums[0]){ //5,6,7,8,9,2,3 , nums[mid] =8 , this fails above two                                         //conditon hence, 
                // 8 > 5, search in the right side of array
                left = mid+1;
            }else{
                //search on left of the array
                right = mid-1;
            }
        }       
        return -1;
    }
}