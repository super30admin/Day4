// 34. Find First and Last Position of Element in Sorted Array
// TC: O(log(n))
// SC: O(1)


class LC34 {

    public void binarySearch(int l, int h, int ans[], int ansLoc, int target, int nums[]){
        while(l<=h){
            int mid = (l+h)/2;
            if(nums[mid]==target){
                ans[ansLoc]=mid;
                if(ansLoc==0) h=mid-1;
                else l=mid+1;
            } else if(nums[mid]>target){
                h=mid-1;
            } else {
                l=mid+1;
            }
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        ans[0]=ans[1]=-1;
        if(nums==null || nums.length==0) return ans;
        int n=nums.length;
        if(target < nums[0] || target > nums[n-1]) return ans;
        binarySearch(0, n-1, ans, 0, target, nums);
        binarySearch(0, n-1, ans, 1, target, nums);
        return ans;
    }
}