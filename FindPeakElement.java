class Solution {
    public int findPeakElement(int[] nums) {
       //approach 1 linear 
//         if(nums.length == 1)
//             return 0;
        
//         for(int i = 1; i<nums.length-1; i++){
//             if(nums[i] > nums[i-1] && nums[i] > nums[i+1])
//                 return i;
//         }
        
//         if(nums[0] > nums[1])
//             return 0;
//         else
//             return nums.length-1;
        
        
        // approach 2 binary search on array length
//as peak element will have 1 element on its each side so we try to find that middle element. Now if nums[mid] < nums[mid+1], then either nums[mid+2] be lesser than nums[mid+1] in that cat will always be an option [1,2,1,3,5,6,7]
        
        int low = 0, high = nums.length-1;
        
        
        while(low < high){
            int mid = (low + high)/2;
            
            if(nums[mid] < nums[mid+1])
                low = mid + 1;
            else
                high = mid;
            
        }
        return low;
        
    }
}