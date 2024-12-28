Time complexity - O(logn)
Space complexity - logn.

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    if(!nums.includes(target)){
        return [-1,-1];
    }
    var left = leftside(nums,target);
    var rgt  = rightside(nums,target);
    return [rgt,left];
 }
var leftside = function(nums,target){
    var left = -1,right=nums.length;
    while(right-left>1){
        var mid = Math.floor((right+left)/2);
        if(nums[mid]<=target){
            left = mid;
        }else{
            right = mid;
        }
    }
    return right-1;
}
var rightside = function(nums,target){
    var left=-1,right=nums.length;
    while(right-left>1){
        var mid = Math.floor((left+right)/2);
        if(nums[mid]<target){
         left = mid;
        }
        else{
         right = mid;
        }
    }
    return left+1;
}
