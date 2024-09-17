// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
    class problem2 {
        public int findMin(int[] nums) {
            int size = nums.length;
            //if array contains only one element, return first element
            if(size == 1) return nums[0];
            
            //if array is not rotated, return first element
            if(nums[0] < nums[size-1]) return nums[0];
            
            int low = 0, high = size-1;
            
            
            while(low <= high){
               int mid = low + (high-low)/2;
                
                if(nums[mid] > nums[mid+1])
                    return nums[mid+1];
                
                if(nums[mid-1] > nums[mid])
                    return nums[mid];
                
                if(nums[0] < nums[mid])
                    low = mid+1;
                else
                    high = mid-1;
            }
            
            return -1;    
        }
    }
    

