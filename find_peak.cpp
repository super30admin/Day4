//Time = O(log n)
//Space O(1)
//Leetcode run: yes
//Issues: handlinging the boundary conditions
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int n = nums.size();
        if(n<=1){
            return 0;
        }
        int start = 0;
        int end = nums.size()-1;
        //these edge cases are important
        if(nums[0] > nums[1]) {
            return 0;
        }
        if(nums[n-1] > nums[n-2]) {
            return n-1;
        }

        int mid = 0;
        while(start <= end){
            mid = start + (end-start)/2;
            if((mid != 0) && (mid != nums.size()-1) &&
               (nums[mid] > nums[mid+1]) &&
               (nums[mid] > nums[mid-1])) {
                return mid;
            } else if(mid == 0 || nums[mid] > nums[mid -1]){
                start = mid +1;
            } else{
                end = mid -1;
            }
           
        }
        return -1;
    }
};
