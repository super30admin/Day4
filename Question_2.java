// Find Minimum in Rotated Sorted Array
int findMin(int[] nums) {
    int n = nums.length;
    if(nums[n-1]>nums[0]) return nums[0];
    int f = 0, l = n-1;
    while(l-f>1){
        int mid = (f+l)/2;
        if(nums[mid]>nums[f]){
            f = mid;
        }
        else if(nums[mid]<nums[l]){
            l = mid;
        }
    }
    return nums[l];
}