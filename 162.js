// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
Algorithm : Binary Search
Iterative Binary search where left id peek element.
**/

/**
 * @param {number[]} nums
 * @return {number}
 */

var findPeakElement = function(nums) {
    
    let left = 0, right = nums.length -1;
    
    while(left <= right) {
        
        if(left === right ) {
            return left
        }
        
        let mid = Math.floor((left + right) /2)  
        
        //comparing mid and mid+1 element who are neighbours to define the boundary of search
        if(nums[mid] > nums[mid+1]) { 
            right = mid
        } else {
            left = mid + 1
        }
    }
    
};