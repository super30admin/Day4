/**
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement = function(nums) {
    var low = 0;
    var high = nums.length -1;
    var mid;
    while(low<=high){
        mid = Math.floor((low + high)/2);
        if(nums[mid] < nums[mid+1]) low = mid+1;
        else if(nums[mid] < nums[mid-1]) high = mid-1;
        else  return mid;


    }
    return -1;

}

// TimeComplexity : o(logN)