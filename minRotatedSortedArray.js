/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    var low = 0;
    var high = nums.length - 1;
    /*  if(nums== null || nums.length == 0) return -1;   */
    while(low<=high){
        //Perfectly sorted array
        const mid = Math.floor((low + high)/2);
        if(nums[low] < nums[high]) return nums[low];

        // if the min is reached, checking that min is less than its neighbor element
        else if((nums[mid] == 0 || nums[mid] < nums[mid-1])&&(nums[mid] ==nums.length-1||nums[mid] < nums[mid+1])) return nums[mid];


        //check if right is sorted, then go to left unsorted side
        else if(nums[mid] < nums[high]) high = mid-1;

        //check if left is sorted, then go to right unsorted side
        else if(nums[low] < nums[mid]) low = mid+1;


    }

    return nums[low];



};

//Time Complexity : o(logN)