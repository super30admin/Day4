// Time Complexity :O(log n) where n in the number elements in the vector
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        // Approach 1 - Brute force 
        /*if(nums.size() == 1)
            return 0;
        if(nums.size() == 2){
            return nums[0]>nums[1] ? 0 : 1;
        }
        int first;
        int second;
        int third;
        first = nums[0];
        for(int i=1;i<nums.size()-1;i++){
            second = nums[i];
            third = nums[i+1];
            cout<<first<<" "<<second<<" "<<third<<endl;
            if(first<second && second>third)
                return i;
            first = second 
        }
        
        return nums[0]>nums[nums.size()-1] ? 0 :nums.size()-1;*/
        
        //Approach -2 Binary Search for logarithmic Complexity
        int low = 0;
        int high = nums.size() -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if((mid == 0 || nums[mid-1]<nums[mid]) && (mid == nums.size()-1 || nums[mid] > nums[mid+1])) //peak condition i.e neighbours are less than the mid positon element 
                return mid;
            else if(nums[mid] < nums[mid+1]) //search right
                low = mid+1;
            else
                high = mid-1;           // search left
        }
        return 2343;
    }
};