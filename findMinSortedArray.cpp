// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes



class Solution {
public:
    int findMin(vector<int>& nums) {
        if(nums.size() == 1) return nums[0];
        int low = 0;
        int high = nums.size()-1;

        while(low<=high){
            //if the array is sorted, the smallest has to be at 0
            if(nums[low] <= nums[high]) 
                return nums[low];
            
            //otherwise compute mid
            int mid = low + (high-low)/2; //prevent int overflow

            //if the mid is the smallest, then return it 
            //check with previous and next element and return it if its the smallest
            if((mid==0 || nums[mid] < nums[mid-1]) && (mid == nums.size()-1 || nums[mid]<nums[mid+1])){
                return nums[mid];
            }
            
            //idea is the element is in the unsorted half of the array (since that is the pivot element)
            //if the left half is sorted
                //right is not sorted: elemnt has to lie in the right  
                //right is sorted: element still has to lie in the right half (because the array is rotated around the pivot which is the smallest element)
                
            if(nums[low] <= nums[mid]){
                low = mid+1;
            }
            //right is sorted, array has to be in the left
            else 
                high = mid-1;
        }

        return -1;
    }
};