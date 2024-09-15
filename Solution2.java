class Solution2 {
    

    // finding minimum element in rotated subarray
    // Time complexity  : O(logn) and space complexity : O(1)
    
    public int findMin(int[] nums) {
        
        
        
         if(nums.length == 0 || nums == null){
             return 0;
         }
        if(nums.length ==1){
            return nums[0];
        }
        if(nums[nums.length-1] > nums[0]){
            return nums[0];
        }
        
        int start = 0;
        int end = nums.length-1;
        // as its rotated sorted array we are finding position where left of it will be sorted and right of it will also be sorted so it means there will be a pivot element where left of it will be all larger elements and right of it will be also be lagrger elements. 
        //so here we assume if mid element is pivot then element to left of it must be greater then reutrn that mid or right of it will also be greater then return that element. Or if left < mid then left part is sorted array or right part is sorted repeat the process.
        while(start < end){
           int mid = start + (end- start)/2;
            
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            
            if(nums[mid-1] > nums[mid]){
                return nums[mid];
            }
            
            if(nums[mid] > nums[start]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
    
    return -1;
    }
    
}