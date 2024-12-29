/*
Time Complexity - O(Logn)
Space complexity - Logn
*/
/**
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement = function(nums) {
    var st=0,end = nums.length-1;
   while(st<end){
       var mid = Math.floor((st+end)/2);
       (nums[mid]<nums[mid+1])?st = mid+1:end = mid;
     }
    return st; 
};