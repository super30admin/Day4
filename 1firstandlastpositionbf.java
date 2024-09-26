
//This  is a brute force linear search algorithm with worst case time complexity of O(N^2).


class Solution {
    public int[] searchRange(int[] nums, int target) {
        //brute force
        int res[] = {-1,-1};
       for(int i=0;i<nums.length;i++){
           if(nums[i]==target){
               res[0] = i;
               int j = i;
               while(j<nums.length && nums[j] == target)
                   j++;
               res[1] = j-1;
               return res;
           }
       }
        return res;
    }
}