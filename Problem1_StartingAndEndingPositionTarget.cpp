// Time Complexity : O(log n) + O( log n)= O(log n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


#include<vector>
#include<bits/stdc++.h>
#include<stdlib.h>
#include<cmath>
#include<time.h>
#include<iostream>

using namespace std;       



class Solution {
     
public:
    int binarySearchFirst(int,int );
    int binarySearchLast(int,int );
    vector<int> searchRange(vector<int>& nums, int target) {
        if(nums.empty() && nums.size()==0) return  {-1,-1};
        if(target<nums[0]||target>nums[nums.size()-1]) return {-1,-1};
        int first=binarySearchFirst(nums, target);
        int last=binarySearchLast(nums, target);
        vector<int> a={first,last};
        return a;
        
        
    }
        int binarySearchFirst(vector<int> nums, int target){
        int low =0;
        int high=nums.size()-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target) {
                if (mid==0 || nums[mid]>nums[mid-1]) return mid;
                else
                    high=mid-1; //we have to keep moving towards left
            }
            else if(nums[mid]>target)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
        
    }
    
    int binarySearchLast(vector<int> nums, int target){
        int low =0;
        int high=nums.size()-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target) {
                if (mid==nums.size()-1 || nums[mid]<nums[mid+1]) return mid;
                else
                    low=mid+1; //we have to keep moving towards right  
            }
            else if(nums[mid]>target)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
        
    }
};


int main(){
    Solution a;
    vector<int> nums={0,2,2,2,2,2,2,3,5};
    int target=2;
    vector<int> b = a.searchRange(nums,target);
    for (int x : b) 
        cout << x << " "; 
}