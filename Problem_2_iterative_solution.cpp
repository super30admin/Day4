#include <iostream>
#include <vector>
#include <cmath>
#include <climits>

using namespace std;
class Solution {
public:
    int findMin(vector<int>& nums) {
        int min = INT_MAX;
        if(nums.size()>0){
             int l=0; int r=nums.size()-1;
             while(l<=r){
               int mid= l+floor((r-l)/2);
                 if(nums[mid]<=nums[r]){ //right sorted
                     if(min>nums[mid]){
                         min = nums[mid];
                     }
                     r=mid-1;
                 }
                 else if(nums[mid]>=nums[l]){//left sorted
                     if(min>nums[l]){
                         min = nums[l];
                     }
                     l=mid+1;
                 }
             }
        }
        return min;
    }
};


