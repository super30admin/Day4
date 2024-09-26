class Solution {
    public int findMin(int[] nums) {
        
        int left=0;
        int right=nums.length-1;
        
        while(left<right)
        {
            int mid= left +(right-left)/2;
            if(nums[mid]>nums[right])
            {
                left=mid+1;
            }
            else
            {
                right=mid;
            }
        }
        return nums[left];
    }
}

//timecomplexity : O(logn)
//space :O(1)
//ran successfully on leetcode
//solved with different comparision method and approach is binary search
//Didnt faced any difficulties
