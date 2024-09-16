//Time Complexity : O(logn)
//Space Complexity : O(1)
//Passed in leetcode : Yes
//Faced any problem : No
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int>v;
        int s=0,e=nums.size()-1,f=0,m;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(mid==0&&nums[mid]==target)
            {
                f=1;
                m=mid;
                break;
            }
            if(nums[mid]==target&&nums[mid-1]!=target){
                f=1;
                m=mid;
                break;
            }
            if(nums[mid]==target&&nums[mid-1]==target){
                e=mid-1;
            }
            else if(nums[mid]>target){
                e=mid-1;
            }
            else if(nums[mid]<target){
                s=mid+1;
            }
        }
        if(f==0){
            v.push_back(-1);
            v.push_back(-1);
            return v;
        }
        v.push_back(m);
        s=m;e=nums.size()-1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(mid==nums.size()-1&&nums[mid]==target)
            {
                m=mid;
                break;
            }
            if(nums[mid]==target&&nums[mid+1]!=target){
                m=mid;
                break;
            }
            if(nums[mid]==target&&nums[mid+1]==target){
                s=mid+1;
            }
            else if(nums[mid]>target){
                e=mid-1;
            }
            else if(nums[mid]<target){
                s=mid+1;
            }
        }
        v.push_back(m);
        return v;
    }
};