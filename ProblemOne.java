//Timecomplexity:O(log(N))
//Spacecomplexity:O(1)
//Does it successfully run on leetcode:Yes

public class ProblemOne{
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0 || nums==null){return new int[]{-1,-1};}
        int left=binarySearchLeft(nums,target);
        int right=binarySearchRight(nums, target);
        return new int[]{left,right};
    }
    //getting the left index of the target
    private int binarySearchLeft(int nums[],int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==0||nums[mid-1]<nums[mid]){
                    return mid;
                }
                else{
                    high=mid-1;
                }           
            }
            else if(target<nums[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
 
        }
        return -1;
    }
    //getting the right index of the target
   private int binarySearchRight(int nums[],int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1||nums[mid+1]>nums[mid]){
                    return mid;
                }
                else{
                    low=mid+1;
                }           
            }
            else if(target<nums[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
 
        }
        return -1;
    }
    public static void main(String args[]){
        ProblemOne obj=new ProblemOne();
        int nums[]={5,7,7,8,8,10};
        int target=6;
        int res[]=obj.searchRange(nums, target);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}