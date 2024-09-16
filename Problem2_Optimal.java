
/*
Leet code submitted = Yes
Time complexity = O(logN)
Space complexity = O(1)
Approach = At any point of time one part of the array will be sorted (either left or right) so minimum will be wither first element of that part of that array or checking minimum from the rest of the array*/

class Solution {    
    public int binary_search(int[] nums,int l,int r){
        //calculate middle
        int mid = (l + (r-l)/2);   
        //Base case
        if(l > r){
            return Integer.MAX_VALUE;
        }
        return(Math.min(Math.min(nums[l],binary_search(nums,mid + 1, r)),Math.min(binary_search(nums,l,mid-1),nums[mid])));
    }
    public int findMin(int[] nums) {
        if(nums == null || nums.length < 1)
            return -1;
        if(nums.length == 1)
            return 1;
        else{
            return binary_search(nums,0,nums.length - 1);
        }
        
    }
}

