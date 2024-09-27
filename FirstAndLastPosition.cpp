//Time Complexity - O(log(n))
//Space Complexity - O(1)
//Problem ran on leet code successfully
//No problems faced

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int noEle=nums.size();
        
        int low=0;
        int high=noEle-1;
        
        int leftMostIndex=-1;
        int rightMostIndex=-1;
        while(low<=high)
        {
            int middleElement=low+ (high-low)/2;
            
            if(target<=nums[middleElement])
            {
                if(nums[middleElement]==target)
                {
                    leftMostIndex=middleElement;
                    if(middleElement==0 || nums[middleElement-1]!=target)
                    {
                        break;
                    }
                    
                }
               high=middleElement-1; 
            }
            else
            {
                low=middleElement+1;
            }
        }
        
        
        
        low=0;
        high=noEle-1;
        while(low<=high)
        {
            int middleElement=low+ (high-low)/2;
            
            if(target>=nums[middleElement])
            {
                if(nums[middleElement]==target)
                {
                    rightMostIndex=middleElement;
                    if(middleElement==noEle-1 || nums[middleElement+1]!=target)
                    {
                        break;
                    }
                }
               low=middleElement+1; 
            }
            else
            {
                high=middleElement-1;
            }
        }
        vector<int> returnVector;
        returnVector.push_back(leftMostIndex);
        returnVector.push_back(rightMostIndex);
        
        return returnVector;
    }
};