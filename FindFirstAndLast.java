// Time Complexity :searchRange: 2 log n which is log n , we are doing binary search twice here
// Space Complexity :0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

public class FindFirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1};
        int first = binarySearchFirst(nums,target,0,nums.length-1);
        if(first == -1){
            return new int[]{-1,-1};
        }
        int second = binarySearchSecond(nums,target,first,nums.length-1);
        return new int[]{first, second};
    }

    private int binarySearchFirst(int[] nums,int target, int low, int high){
        while(low<=high){
            int mid= low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==0 || nums[mid]!=nums[mid-1]){
                    return mid;
                }else {
                    high = mid-1;
                }
            }else if(nums[mid]>target){
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return  -1;
    }

    private int binarySearchSecond(int[] nums,int target, int low, int high){
        while(low<=high){
            int mid= low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==high || nums[mid]!=nums[mid+1]){
                    return mid;
                }else {
                    low = mid+1;
                }
            }else if(nums[mid]>target){
                high = mid-1;
            }else{
                low=mid+1;
            }

        }
        return  -1;
    }


    public static void main(String args[]) {
        FindFirstAndLast array = new FindFirstAndLast();
        int[] nums = new int[8];
        nums[0]=1;
        nums[1]=1;
        nums[2]=2;
        nums[3]=2;
        nums[4]=2;
        nums[5]=3;
        nums[6]=3;
        nums[7]=3;


        System.out.println("first and last indices of the target " +array.searchRange(nums, 2));

    }

}
