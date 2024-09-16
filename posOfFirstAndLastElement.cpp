class Solution {
public:
    int firstPos(int low,int right,int target,vector<int> nums){
        while (low<=right) {
            int mid=low+(right-low)/2;
            if (nums[mid]==target && (mid==0 || nums[mid-1]<target)) { // if the arr[mid] is equal to the target and (either mid is 0 or nums[mid-1] is lesser than the target)
                return mid;
            } else if (nums[mid]<target) {
              low=mid+1;
            } else {
              right=mid-1;
            }
        }
        return -1;
    }
    
    int lastPos(int low,int right,int target,vector<int> nums) {
        while (low<=right) {
            int mid=low+(right-low)/2;
            if (nums[mid]==target && (mid+1==nums.size() || nums[mid+1]>target)) { // if the arr[mid] is equal to the target and (either mid is the last index or nums[mid+1] is greater than the target)
                return mid;
            } else if (nums[mid]<=target) {
              low=mid+1;
            } else {
              right=mid-1;
            }
        }
        return -1;
    }
    
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> answer;
        int right=nums.size()-1;
        int x=firstPos(0,right,target,nums);//to find the first position
        int y=lastPos(0,right,target,nums);//to find the last position
         
        answer.push_back(x);
        answer.push_back(y);
        return answer;
    }
};