class Solution {
    public int position(int []nums ,int target , String direction,int startPosition){
        int pos=-1;
        int low=startPosition;
        int high=nums.length-1;
        int mid;
        while(low<=high){
            mid=low+(high-low)/2;
            System.out.println("l = " + low +"h= " + high+ " mid = "+mid);
            if(nums[mid]>target){
                high=mid-1;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                pos=mid;
                if(mid!=0 && direction=="left"){
                    System.out.println("inside left");
                    high=mid-1;
                }else if(mid!=nums.length-1 && direction=="right"){
                    System.out.println("inside right");
                    low=mid+1;
                }
                else{
                    return pos;
                }
            }
        }
        return pos;
    }

    public int[] searchRange(int[] nums, int target) {
        int firstPosition=this.position(nums,target,"left",0);
        if(firstPosition!=-1){
            int lastPosition=this.position(nums,target,"right",firstPosition);
            return new int []{firstPosition,lastPosition};
        }
        else{
            return new int []{-1,-1};
        }


    }
}