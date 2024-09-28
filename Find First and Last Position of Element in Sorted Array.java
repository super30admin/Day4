class Solution {

    public int[] searchRange(int[] nums, int target) {

        int[] ans = new int[]{-1,-1};

        if(nums.length == 0) return ans;

        ans[0] = bs(nums,target,false);
        ans[1] = bs(nums,target,true);

        return ans;

    }

    public int bs(int[] nums, int target , boolean x){

        int low = 0;
        int high = nums.length-1;


        while(low<=high){

             int mid = low + (high-low)/2;

            if(nums[mid] == target){

            //first
            if(!x){

                if(mid==0 || nums[mid-1]!=nums[mid]) return mid;
                else high = mid-1;
            }

            //last
            else{
                if(mid == nums.length-1 || nums[mid+1]!=nums[mid]) return mid;
                else low = mid + 1;
            }

            }

            else if(nums[mid] > target){

                high = mid-1;

            }

            else{
                low = mid + 1;
            }

        }

        return -1;

    }

}
