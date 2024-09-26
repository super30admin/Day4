
// Time Complexity : O(log n) for reducing search space by half
// Space Complexity :O(1) -> only pointers are used for left, right, mid
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinRotatedArray {
    public int findMin(int[] nums) {
        
        int low=0;
        int high=nums.length-1;
        
        int num= Integer.MAX_VALUE;
        
        while(low<=high){
            
            int mid= low+(high-low)/2;   // compute  mid element
            
           if((mid==0 || nums[mid]<nums[mid-1]) && (mid==nums.length-1 || nums[mid] < nums[mid+1]))
               return nums[mid]; // mid is smaller than both its before and after element- so u found a smallest element at mid
            if(nums[mid]<nums[high]){ // right half is sorted so check on left side
            
                    high=mid-1;      // check left side by moving high to mid-1
                }
                else{
                    low=mid+1; // else check right side by moving low to mid+1
                }
                   
        }
        
        return num; // return default value if no minimum found.
    }
}