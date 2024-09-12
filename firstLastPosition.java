class Solution {
    //Time complexity: O(logn)
    //Space complexity: O(1)
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[]{-1,-1};
        if(nums.length==0){
            return res;
        }
        ArrayList<Integer> arr=new ArrayList<>();
        int l=0,h=nums.length-1,m=-1;
        while(l<=h){
            m=l+(h-l)/2;
            if(nums[m]==target){
                if(m==0 || nums[m-1]!=target){
                    res[0]=m;
                    break;
                }
                h=m;
            }
            else if(nums[m]<target){
                l=m+1;
            }
            else{
                h=m-1;
            }
        }
        if(res[0]==-1){
            return res;
        }
        l=m;
        h=nums.length-1;
        while(l<=h){
            m=l+(h-l)/2;
            if(nums[m]==target){
                if(m==nums.length-1 || nums[m+1]!=target){
                    res[1]=m;
                    break;
                }
                l=m+1;
            }
            else if(nums[m]>target){
                h=m-1;
            }
            else{
                l=m+1;
            }
        }
        return res;
    }
}