#include <iostream>
#include <vector>
using namespace std;

bool ascending_check(vector<int>&nums,int ind){
    int n = nums.size();
    if(ind==n-1) return false;
    if(ind==0) return nums[1]>=nums[0];
    return nums[ind-1]<nums[ind]&&nums[ind]<nums[ind+1];
}
bool descending_check(vector<int>&nums,int ind){
    int n = nums.size();
    if(ind==0) return false;
    if(ind==n-1) return nums[n-2]>=nums[n-1];
    return nums[ind-1]>nums[ind]&&nums[ind]>nums[ind+1];
}
bool peak_check(vector<int>&nums,int ind){
    int n = nums.size();
    if(ind==0) return nums[0]>nums[1];
    if(ind==n-1) return nums[n-2]<nums[n-1];
    return nums[ind-1]<nums[ind]&&nums[ind]>nums[ind+1];
}
int findPeakElement(vector<int>& nums) {
    int n = nums.size(), f = 0, l = n-1;
    if(n==1) return 0;
    while(f<l){
        int mid = (f+l)/2;            
        bool ascending = ascending_check(nums,mid), descending = descending_check(nums,mid);
        if(!ascending&&!descending){
            bool peak = peak_check(nums,mid);
            if(peak) return mid;
            l = mid-1;
        }
        if(ascending) f = mid+1;
        else l = mid-1;
    }
    return f;
}

int main(){
    vector<int> nums = {1,2,3,1};
    cout<<findPeakElement(nums);
    return 0;
}