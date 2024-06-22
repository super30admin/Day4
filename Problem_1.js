// Time Complexity : O(logn) + O(log n) +  (log n) i.e O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/* Reused the binary search logic to first find the mid. If found, then searched the lowest and highest range of the target value
* by traversing half of the array to find lowest range first and then the other half to find higher range
*/

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    let range = [-1, -1];
    let low = 0;
    let high = nums.length-1;
    let targetIdx = -1;
    while(low <= high){
        let mid = low + Math.floor(high-low/2); //To avoid int overflow; 
        if(nums[mid] === target){
            targetIdx = mid;
            break;
        }
        else if(target < nums[mid]){
            high = mid -1;
        }
        else {
            low = mid + 1;
        }
    }
    if(targetIdx > -1 ){
        let lRange = targetIdx;
        let rRange = targetIdx;

        while(nums[lRange] === target && lRange >=0){
            lRange--;
        }
        while(nums[rRange] === target && rRange <=nums.length-1){
            rRange++;
        }
        return[lRange+1, rRange-1];

    }
    return [-1, -1];
};