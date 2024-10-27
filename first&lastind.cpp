//TC:O(logn)
//SC:O(1)
//Approach: We wil create two B.S functions to get the first and last element of the array
//For the firs element we will compare it with its one lesser than index and check if it is the first occ index.
//If it is we will return it.
//For the second one we will do the same but we will check for the one greater than index to get our last occ target
// Also we have to handle edge cases where the prev and nxt ele will be <0 or >nums.size()-1
class Solution {
private:
    int searchFirstInd(vector<int>& nums, int target,int s,int e){
         while(s<=e){
         int mid = s+(e-s)/2;
            if(nums[mid]==target){
                if(mid==0||nums[mid-1]!=nums[mid]) return mid;
                else e = mid-1;
            }
            else if(nums[mid]<target) s=mid+1;
            else e = mid-1;
         }
         return -1;
    } 
    int searchSecondInd(vector<int>& nums, int target,int s,int e){
         while(s<=e){
         int mid = s+(e-s)/2;
            if(nums[mid]==target){
                if(mid==e || nums[mid+1]!=nums[mid]) return mid;
                else s = mid+1;
            }
            else if(nums[mid]<target) s=mid+1;
            else e = mid-1;
         }
         return -1;
    } 
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if(nums.size()==0) return {-1,-1};
        int firstInd = searchFirstInd(nums,target,0,nums.size()-1);
        if(firstInd==-1) return {-1,-1};
        int secondInd = searchSecondInd(nums,target,0,nums.size()-1);
        return {firstInd,secondInd};
    }
};