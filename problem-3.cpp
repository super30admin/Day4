//Time Complexity : O(logn)
//Space Complexity : O(1)
//Passed in leetcode : Yes
//Faced any problem : No

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int l=0;
        int r= nums.size()-1;
        
        
        while(l<=r){
            
            int mid=(l+r)/2;
           
            if((mid-1<0 || nums[mid-1]<nums[mid] ) && ((mid+1>nums.size()-1) ||nums[mid]>nums[mid+1])){
                return mid;
            }
            else if((mid+1>nums.size()-1) || nums[mid+1]>nums[mid]){
                l=mid+1;
            }else{
                
                r=mid-1;
            }
           
        }
        
    return -1;
    }
};