Time complexity: O(logn)
Space complexity: O(1)

class Solution {
    public int findMin(int[] nums) {
        int i=0,j=nums.length-1; //initialising i to 0, j to last element 
        while(i<j) //while i<j
        {
            int mid=i+(j-i)/2; //initialising mid
            if(nums[mid]<nums[j]) //if current mid is less than last element
                j=mid; //move j to mid
            else
                i=mid+1; //else move i to mid+1
        }
        return nums[i]; //return the min element
    }
}