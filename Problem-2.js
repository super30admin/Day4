//Time: O(logn), Space: O(1)
//Ran Successfully on leetCode - solution accepted
 var findMin = function(nums) {
    let low = 0, high=nums.length-1;
    while(low<=high){
        if(nums[low] <= nums[high]) return nums[low]
        var mid = low + Math.floor((high - low)/2);
        if(((mid == 0 || nums[mid - 1]) > nums[mid]) && ((mid == nums.length-1 || nums[mid + 1]) > nums[mid])){
            return nums[mid]
        }
        if(nums[low] <= nums[mid]){
            low = mid + 1;
        }else{
            high = mid - 1;
        }
    }
};