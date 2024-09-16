//Time: O(logn), Space O(1)
//Ran Successfully on leetCode - solution accepted
 var searchRange = function(nums, target) {
    if(nums.length == 0 ) return [-1,-1];
    if(target < nums[0] || target > nums[nums.length-1]) return [-1,-1];
    
    let first = binary_search_left(nums,target);
    if(first == -1) return [-1,-1];
    let second = binary_search_right(nums,target);
    return [first,second];
};

function binary_search_left(nums,target){
    let low = 0,high = nums.length-1;
    while(low <= high){
        let mid = low + Math.floor((high-low)/2);
        if(nums[mid] == target){
            if(mid ==0 || nums[mid-1] < nums[ mid] ) return mid;
            high = mid - 1
        }else if(nums[mid] < target){
            low = mid + 1;
        }else{
            high = mid - 1;
        }
    }
    return -1;
}
function binary_search_right(nums,target){
    let low = 0,high = nums.length-1;
    while(low <= high){
        let mid = low + Math.floor((high-low)/2);
        if(nums[mid] == target){
            if(mid == nums.length-1 || nums[mid+1] > nums[ mid] ) return mid;
            low = mid + 1
        }else if(nums[mid] < target){
            low = mid + 1;
        }else{
            high = mid - 1;
        }
    }
    return -1;
}