// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/** In a rotated sorted array, we know that when we divide it, we have one part atleast that is sorted always and the other can be sorted or not. 
 * To find the minimum, we need explore the possibility of the min item being in the  unsorted array or in a completely sorted array. 
 * If the mid value is greater than the last index element then we see that the minium is in the right side since we know it is an 
 * unsorted portion of the array and we keep dividing the unsorted part of the array till we get a mid < last index ele. 
 * When we find that the mid is less than the last element, then we traverse down the left side of the array since we know the minimum will be on the left 
 * of the mid. We keep dividing and comparing the mid till we run out of array elemenets to compare mid with. 
 * 
*/
/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    let low = 0;
    let high = nums.length - 1;

    while(low<high){
        let mid = low + Math.floor((high-low)/2);

        if(nums[mid]> nums[high]){
            low = mid + 1;
        }
        else
            high = mid;
    }
    return nums[low];
};