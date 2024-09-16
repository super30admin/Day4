// Time Complexity : O(log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach



    
    class MinimumInSorted {
        public int findMin(int[] nums) {
             if(nums==null || nums.length==0) return -1;
            int low=0; 
            int high=nums.length-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                if((mid==nums.length-1 ||nums[mid]<nums[mid+1]) && 
                   (mid==0||nums[mid]<nums[mid-1]))
                    return nums[mid];
                else{ 
                    if(nums[mid]<nums[high]){
                        high=mid-1;
                    }else{
                        low=mid+1;
                    }
                }
            }
            return -1;
            
            
        }
    }
