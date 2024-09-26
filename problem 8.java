// Time Complexity :o(nlogn)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : at edges cases needed to change a lot.


// Your code here along with comments explaining your approach:- as usual in binary search if mid element is target for left most index and right most index decreementing l and incrementing h until it is equal to element.
int n = nums.length;
        int low = 0, high = n - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(nums[mid] < target) {
                low = mid + 1;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else { // nums[mid] == target
                low = high = mid;
                
                // expand to the left & find the first occurance of target
                while(low > 0 && nums[low - 1] == target) {
                    low--;
                }
                
                // expand to the right & find the last occurance of target
                while(high < n - 1 && nums[high + 1] == target) {
                    high++;
                }
                
                return new int[] {low, high};
            }
        }
        
        return new int[] {-1, -1}; 
    }
}

