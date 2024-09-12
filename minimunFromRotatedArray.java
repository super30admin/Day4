class Solution {
    public int findMin(int[] nums) {
        int left=0;                             //setting left to first index of array
        int right= nums.length-1;               //to last index of array
        int currentMin = nums[left];            //taking variable just to hold current minimum element

        while(left<=right){                     
            int mid = left+ (right-left)/2;         //calculating mid
            
            if(nums[left]<=nums[right]){                //if the array is not rotated and it is sorted array returning first index
                return Integer.min(currentMin , nums[left]);
            }
            
            
            currentMin = Integer.min(nums[mid],currentMin);         //cheking minimum value between current minimum and calculated mid
            
            if(nums[left]<=nums[mid]){              //if the left side is sorted then minimum should be on right side
            
                left= mid+1;
            }else{
                right = mid-1;                      // else on left side.
            }
        }
        return -1;
    }
}
