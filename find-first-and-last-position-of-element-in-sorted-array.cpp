/*
The code finds the first and last occurrences of a target element in a sorted array using two binary searches.
The findBound function is used for both searches, with a parameter to determine whether to find the first or last occurrence.
The search space is adjusted accordingly in each binary search until the target element is found.
Time Complexity: O(log n)
Space Complexity: O(1)
*/
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int firstOccurrence = findBound(nums, target, 1);
        vector<int> p;
        if (firstOccurrence == -1) {
            p.push_back(-1);
            p.push_back(-1);
            return p;
        }
        
        int lastOccurrence = findBound(nums, target, 0);
        vector<int> k;
        k.push_back(firstOccurrence);
        k.push_back(lastOccurrence);
        return k;
    }

    int findBound(vector<int>& nums, int target, int isFirst) {
        int N = nums.size();
        int begin = 0, end = N - 1;
        
        while (begin <= end) {
            
            int mid = (begin + end) / 2;
            
            if (nums[mid] == target) {
                
                if (isFirst) {
                    
                    if (mid == begin || nums[mid - 1] != target) {
                        return mid;
                    }
                    
                    end = mid - 1;
                    
                } else {
                    
                    if (mid == end || nums[mid + 1] != target) {
                        return mid;
                    }
                    
                    begin = mid + 1;
                }
                
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        
        return -1;
    }
};