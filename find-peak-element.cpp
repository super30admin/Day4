/*The code performs a binary search to find a peak element in the given array.
It compares the middle element with its right neighbor to determine whether the peak lies to the left or right.
The search space is narrowed based on the comparison until a peak element is found.
Time Complexity: O(log n)
Space Complexity: O(1)*/
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int l=0;
        int r=nums.size()-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]>nums[mid+1]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
};