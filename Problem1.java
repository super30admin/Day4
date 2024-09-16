class Solution {
    public int[] searchRange(int[] nums, int target) {
        //1. Brute force - sort through each element
        // Time complexity O(n) , space complexity O(1)

        int[] positionArray = new int[] {-1,-1};
        
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == target && positionArray[0] == -1){
                positionArray[0] = i;
                positionArray[1] = i;  
            }

            else if (nums[i] == target){
                positionArray[1] = i;
            }
        }
        return positionArray;
    }
}
