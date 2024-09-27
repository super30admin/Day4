class Solution {
    //tc= O(logn),sc=O(1)
    public int findMin(int[] nums) {
    int first = 0;
    int last = nums.length -1;
    while(first < last){
        int mid = first+(last-first)/2;
        if(nums[mid] > nums[last]) first = mid +1;
        else last = mid;
    }
    return nums[first];
}
}
