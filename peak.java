//tc O(logn)
//sc o(1)

class Solution {
    //     public int findPeakElement(int[] nums) {
              
    //         int l = 0;
    //         int r = nums.length - 1;
    //         // int mid = -1;
    //         // if(nums.length==0) 
    //         //     return -1;
            
    //         while(l<r){
    //              int mid = l + (r-l)/2;
    //             if(nums[mid]>nums[mid+1])
    //                 r = mid;
    //             else
    //                 l = mid + 1;
                    
    //         }
            
    //         return l;
           
                
    //     }
        
        // recursive soln
        
        public int findPeakElement(int[] nums) {
            return search(nums, 0, nums.length - 1);
        }
        public int search(int[] nums, int l, int r) {
            if (l == r)
                return l;
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                return search(nums, l, mid);
            return search(nums, mid + 1, r);
        }
    }