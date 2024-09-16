//Time Complexity- O(logn)
//Space Complexity- O(1)

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        
        if(nums.size()==1){
            return 0;
        }
        
        int left=0;
        int right=nums.size()-1;
        
        while(left<=right){
            int mid=left+(right-left)/2;
            
            if(mid>0 && mid<nums.size()-1){                                 //If mid is between left and right
                if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]){         //If the mid element is greater than it's neighbours, return mid
                    return mid;
                }
                else if(nums[mid-1]>nums[mid]){                             //If the mid-1 element is greater, it could be the peak, update right
                    right=mid-1;
                }
                else{                                                       //Otherwise update left
                    left=mid+1;
                }
            }
            else if(mid==0){                                                //If mid element is at 0th index
                if(nums[mid]>nums[mid+1]){
                    return mid;
                }
                else{
                    return 1;
                }
            }
            else if(mid==nums.size()-1){                                    //If the mid element is at last index
                if(nums[mid]>nums[mid-1]){
                    return mid;
                }
                else{
                    return mid-1;
                }
            }
        }
        return -1;
    }
};