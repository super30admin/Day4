//Timecomplexity:O(log(N))
//Spacecomplexity:O(1)
//Does it successfully run on leetcode:Yes


public class ProblemTwo {
    public int findMin(int[] nums) {
        if(nums.length==0||nums==null){
            return -1;
        }
        int low=0;int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            if((mid==0||nums[mid]<nums[mid-1])&& (mid==nums.length-1||nums[mid]<nums[mid+1])){
                return nums[mid];
            }
            else if(nums[low]<=nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        ProblemTwo obj=new ProblemTwo();
        int nums[]={3,4,5,1,2};
        System.out.println(obj.findMin(nums));
    }
    
}
