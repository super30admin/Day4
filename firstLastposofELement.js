/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    if(nums == null || nums.length == 0)
    {
        return [-1,-1];
    }
    var l = 0;
    var h = nums.length -1;


    while(l<=h){
        var mid = Math.floor(l + Math.floor((h-l)/2));
        if(target == nums[mid]){
            if(nums[mid-1]<nums[mid] && nums[mid] < nums[mid+1] ){


                return [mid,mid];
            }
            else {
                let temp = mid;
                while(nums[mid]==nums[temp]){
                    temp = temp+1;
                }
                let temp1 = mid;
                while(nums[mid]==nums[temp1]){
                    temp1 = temp1-1;
                }

                return [temp1+1,temp-1];

            }


        } else if(target < nums[mid]){
            h = mid-1;
        } else if(target > nums[mid]){
            l = mid+1;
        }
    }


    return [-1,-1];


};