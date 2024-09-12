// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


var findMin = function(nums) {
    var low = 0, high = nums.length-1;
    if(nums.length == 1){
        return nums[0]
    }
    
    if(nums.length == 0){
        return -1
    }

    if(nums[low] < nums[high]){
        return nums[low]
    }
    
    while(low <= high){
        const mid = Math.floor((low + high) /2);
        

        const lowVal = nums[low]
        const midVal = nums[mid]
        const leftOfMid = nums[mid - 1]
        const rightOfMid = nums[mid + 1]


        //check if smallest elemnet is it inflection point
        if(midVal > rightOfMid){
            return rightOfMid
        } else if(leftOfMid > midVal){
            return midVal
        }
        
        //oterhwise shift the low and high accordingly

        if(midVal > lowVal){
            low = mid + 1
        }else {
            high = mid - 1
        }
        
    }
    
};


var minfind = findMin([4]) ;
console.log(minfind);