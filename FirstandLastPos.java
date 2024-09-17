public class FirstandLastPos {

    int firstTarget;

    public int binarySearchFirst(int[] nums, int target){
        int r=nums.length-1;
        int l=0;
        if(nums[l]==target) return l;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                if(mid==0 || nums[mid]!=nums[mid-1]){
                    return mid;
                }else{
                    r=mid-1;
                }
            }else if(target>nums[mid]){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return -1;
    }

    public int binarySearchLast(int[] nums, int target){
        if(firstTarget==-1){
            return -1;
        }
        int r=nums.length-1;
        int l=firstTarget;
        if(nums[r]==target) return r;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid]!=nums[mid+1]){
                    return mid;
                }else{
                    l=mid+1;
                }
            }else if(target>nums[mid]){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return -1;
    }


    public int[] searchRange(int[] nums, int target) {

        int l=0,r=nums.length-1;

        if(nums.length==0) return new int[]  {-1,-1};

        int first=binarySearchFirst(nums,target);
        firstTarget=first;
        int last=binarySearchLast(nums,target);

        return new int[] {first,last};
    }
}
