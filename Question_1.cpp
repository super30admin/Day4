#include <vector>
using namespace std;
#include <iostream>
vector<int> searchRange(vector<int>& nums, int target) {
        int n = nums.size(), f = 0, l =n-1;
        if(!n) return {-1,-1};
        while(f<l){
            int mid = (f+l)/2;
            if(nums[mid]==target){
                f=mid;
                l=mid;
                break;
            }
            else if(nums[mid]>target) l = mid-1;
            else f = mid+1;
        }
        if(nums[f]!=target) return {-1,-1};
        int partition = f, left_bound, right_bound;
        f = 0;
        l = partition;
        while(f<l){
            int mid = (f+l)/2;
            if(nums[mid]<target) f=mid+1;
            else l = mid;
        }
        left_bound = f;
        f = partition;
        l = n-1;
        while(l-f>1){
            int mid = (f+l)/2;
            if(nums[mid]>target) l = mid-1;
            else f = mid;
        }
        if(l!=f){
            if(nums[f]==nums[l]) f=l;
            else l=f;
        }
        right_bound = f;
        return {left_bound,right_bound};
    }

int main(){
    vector<int> nums = {5,7,7,8,8,10};
    int target = 8;
    vector<int> ans = searchRange(nums,target);
    cout<<ans[0]<<" "<<ans[1];
    return 0;
}