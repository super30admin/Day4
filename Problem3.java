// 162. Find Peak Element

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
          }  
            int low = 0, high = nums.length -1;
            
            while ( low <= high )
            {
                int mid = low + (high - low)/2;
                
                if((mid == 0 || nums[mid] > nums[mid -1]) && 
                    (mid == nums.length -1 || nums[mid] > nums[mid + 1]))
                    return mid;
                else if(mid > 0 && nums[mid] < nums[mid -1]){
                    high = mid -1;
                } else {
                    low = mid +1;
                }
                
            }
        
        return -1;
    }
}

/*

Time complexity : 
O
(
l
o
g
2
(
n
)
)
O(log n). We reduce the search space in half at every step. 
Thus, the total search space will be consumed in log 2(n) steps. Here, n refers to the size of nums array.
Space complexity : O(1).  
*/


