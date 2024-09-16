class Solution {
    public int findMin(int[] nums) {
       int low = 0;
       int high = nums.length - 1;
       while(low<=high){
          //Edge case : if not present then sorting if done first on left side will not give result
           //if Perfectly sorted
           if(nums[low]<nums[high]) return nums[low];
           
        //find middle 
       int mid = low+ (high-low)/2;
       //if minimum is found at middle   
       if((mid == 0 ||nums[mid] < nums[mid -1] )&& (mid == nums.length -1 ||nums[mid] <nums[mid+1] )) return nums[mid];//minimum    
       // check if right side of middle is sorted     
       else if(nums[mid] < nums[high]){
            high = mid -1; //go find minium in the unsorted side which is left side of middle
       }
        else low = mid +1; // right is the unsorted side hence find minimum in the right side of middle
       }
    return -1;
    }
}

//Time complexity: O(logn)     Space :O(1);