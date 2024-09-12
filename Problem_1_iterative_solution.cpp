#include <iostream>
#include <vector>
#include <cmath>
class Solution{
    public:
    std::vector<int> searchRange(std::vector<int>& nums,int target){
        if(&nums==nullptr || nums.size()==0){
            return std::vector<int>{-1,-1};
        }
        int first_occurence = helper_1(nums,target);
        int second_occurence = helper_2(nums,target);
        return std::vector<int>{first_occurence,second_occurence};
    }

    int helper_1(std::vector<int>& nums, int target){
        int l=0;
        int r=nums.size()-1;
        while(l<=r){
            int mid=l+std::floor((r-l)/2);
            if(nums[mid]==target){
                if(mid == 0 || nums[mid-1]<nums[mid]){
                    return mid;
                }
                else{
                    r=mid-1;
                }
            } 
            else if(nums[mid]<target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return -1;
    }

    int helper_2(std::vector<int>& nums, int target){
        int l=0;
        int r=nums.size()-1;
        while(l<=r){
            int mid=l+std::floor((r-l)/2);
            if(nums[mid]==target){
                if(mid == nums.size()-1 || nums[mid]<nums[mid+1]){
                    return mid;
                }
                else{
                    l=mid+1;
                }
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return -1;
    }
};