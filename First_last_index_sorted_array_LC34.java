// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] res = new int[2];
       //create separate methods to perform binary serach to find the first and last index
       res[0] =   firstPosition(nums,target);
       res[1]= lastPosition(nums,target);
        return res;
        }
    
    public int firstPosition(int [] nums,int target){
        int left =0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
        
        //if mid==target then check if its the first posotion by comparing with its left index is lesser than target
            
          if(nums[mid]==target){
              
              //if mid is first element or if mid is > than its left index then return mid
              if(mid==0  ||nums[mid]>nums[mid-1])
              {
                  return mid;
              }
              
             // else reducde the right boundry/high
              else{
                  right=mid-1;
              }
          }
            //normal Binary search cases
            else if(nums[mid]<target){
               left=mid+1; 
            }
            
            else{
                right = mid-1;
            }
            
            
        }
        return -1;
    }
    
    public int lastPosition(int [] nums,int target){
        int left =0;
        int right = nums.length-1;
        while(left<=right){
         int mid = (left+right)/2;
          if(nums[mid]==target){
              if(mid== nums.length-1 || nums[mid]<nums[mid+1])
              {
                  return mid;
              }
              
              else{
                  left=mid+1;
              }
          }
            
            else if(nums[mid]<target){
               left=mid+1; 
            }
            
            else{
                right = mid-1;
            }
            
        }
        return -1;
    }
    }
    