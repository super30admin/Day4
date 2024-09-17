// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        
        vector<int> res;
      
        int start =0; 
        int end = nums.size()-1;
        int s=-1, e=-1;
        
        //find the start index
        while(start<=end){
            int mid = (start+end)/2;
            
            if(nums[mid]==target){
                if(mid>0){
                    if(nums[mid-1]<target){
                        s=mid;
                        break;
                    }
                    else{
                        end = mid-1;
                    }
                }
                else{
                    s=mid;
                    break;
                }
            }
            
            
            else if(nums[mid]<target){
                start = mid+1;
            }
            
            else if(nums[mid]>target){
                end = mid-1;
            }
        }
        
        //find the end index
        
        start =0;
        end = nums.size()-1;
        while(start<=end){
            int mid = (start+end)/2;
            
            if(nums[mid]==target){
                if(mid<nums.size()-1){
                    if(nums[mid+1]>target){
                        e=mid;
                        break;
                    }
                    else{
                        start = mid+1;
                    }
                }
                else{
                    e = mid;
                    break;
                }
            }
            
            else if(nums[mid]<target){
                start = mid+1;
            }
            
            else if(nums[mid]>target){
                end = mid-1;
            }
        }
    
        res.push_back(s);
        res.push_back(e);
        
        return res;
    }
};
