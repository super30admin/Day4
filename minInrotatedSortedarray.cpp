//TC:O(log(n))
//SC:O(1)
// Here we will first check if the whole array is sorted or no. If it is, then we will return the first val since it will be the minimum
//else we will find the mid and check if the mid is less than its prev and nxt postion if it is return mid
//But, while doing this we have to consider the edge case as well which includes if the mid is at the inital or last positon
//If both of this cond are not true we will perform the search operation
// we will check which array is sorted and will move the index ie s/e to the unsorted one to get the minimium index

class Solution {
public:
    int findMin(vector<int>& nums) {
        int s =0;
        int n = nums.size();

        int e = nums.size()-1;
         while(s<=e){
            if(nums[s]<=nums[e]) return nums[s]; //whole array is sorted
            int mid = s+(e-s)/2;
            //not on a sorted range
            //check if mid is the minimum element here before proceding
             if((mid==0 || nums[mid-1]>nums[mid]) && (mid==n-1 || nums[mid+1]>nums[mid])) return nums[mid];
            //check which part is sorted
            else if (nums[s]<=nums[mid]){                 // left sorted
                 s = mid+1;
            }
            else {
                e= mid-1;
            }
         }
         return 0;

    }
};