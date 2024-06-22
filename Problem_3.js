// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes couldn't think of solution apart from linear search - waited till it got solved in class


// Your code here along with comments explaining your approach in three sentences only - As taught in class

/**
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement = function(nums) {
    if(nums == null || nums.length == 0)
        return null;
    let low = 0; 
    let high = nums.length - 1;
    while(low<=high){
        let mid = low + Math.floor((high-low)/2);
        console.log(mid)
        if((mid == nums.length -1 || nums[mid] > nums[mid+1])
            && (mid ==0 || nums[mid]> nums[mid-1])){
                return mid;
        }
        else if(mid!=0 && nums[mid] < nums[mid-1] ){
            high = mid - 1;
        }
        else
            low = mid + 1;
    }

};