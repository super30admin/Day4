class Solution {
    public int[] searchRange(int[] nums, int target) {
        int x=-1;
        int y=-1;
        int a=-1;
        int b=-1;
        if (nums.length == 0){
            return new int []{-1,-1};
        }
        int s = 0;
        int e = nums.length-1;
        while (s<=e){
            int m = s+(e-s)/2;
            if (nums[m] == target){
                x=m;
                y=m;
                a=x;
                b=y;
                while (nums[x]==target && x > 0){
                    --x;
                }
                while (nums[y]==target && y < nums.length-1){
                    ++y;
                }
                if (nums[x]!=target){
                x++;}
                if (nums[y]!=target){
                y--;}
                return new int[]{x,y};
            }
            if(target<nums[m]){
                e=m-1;}
            else{s=m+1;}
            }
        
        
    
        return new int []{-1,-1};
}}
