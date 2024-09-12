// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

var findPeakElement = function(nums) {
    // if(nums.length == 0 || nums == null ){
    //     return -1
    // }

    let low = 0, high = nums.length - 1
    while(low < high){
        let mid = Math.floor((low + high)/2);
        if( nums[mid] > nums[mid+1]) {
            high = mid
        }
        else {
            low = mid + 1
        }
    }
    return low
};