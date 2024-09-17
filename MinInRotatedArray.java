//Exercise_9 : Find minimum in rotated Sorted Array
// Time Complexity : O(log(N))
// Space Complexity : O(1) constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No

/**  Similar to the method for finding the minimum element index implemented in "Search element in Sorted Rotated Array" */

class Solution9 {
    
    public int findMin(int[] nums) {

        int start = 0;
        int N     = nums.length;   
        int end   = N-1;
           
        while(start<=end){
            
              if(nums[start]<nums[end]){//array is sorted
                return nums[start];
              }
             
            int mid = start+(end-start)/2;
            
            int nextIdx = (mid+1)%N; //will work like circular array
            int prevIdx = (mid+N-1)%N;  //will work like circular array
                
            if(nums[mid]<=nums[prevIdx] && nums[mid]<=nums[nextIdx]){ //if single item is there i.e equal to is used
                return nums[mid];
            }else if(nums[start]<=nums[mid]){//find which part is sorted-if this condition matches it means other part is unsorted and min elemnet will be there. Equal to is used if two elem are there eg :[2,1] 
                start = mid+1;
            }else if(nums[mid]<=nums[end]){
                end = mid-1;
            }     
          }          
               
           return -1;
       }
    }


}
