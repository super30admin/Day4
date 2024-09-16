class Solution {
    public int findMin(int[] nums) {
     int first=0;
     int last=nums.length-1;
       while(first<last){
          int mid=(first+last)/2;
           if(nums[mid]<nums[last]){
               last=mid;
             
           }
           else{
               first=mid+1;
           }
       }
        return nums[first];
                
            }
        
            
        }
        
        
