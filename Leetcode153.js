/*
Time Complexity - O(logn)
Space Complexity - logn
*/

/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
   var left=0,right=nums.length-1,mid=0;
    while(left<=right){
        mid = Math.floor((left+right)/2);
        nums[mid]<nums[right] ? right = mid : left=mid+1;
    }
    return nums[mid];
};