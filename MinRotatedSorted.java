public class MinRotatedSorted {

    public int findMin(int[] nums) {

        if(nums == null || nums.length == 0) return -1; 
        if (nums.length == 1) return nums[0]; 

        int l = 0, h = nums.length - 1;
        if(nums[l]>nums[h]){
            while(l<=h) { 
                int mid = l + (h-l)/2; 

                if(nums[mid] > nums[mid+1]) return nums[mid+1]; 
                if(nums[mid-1] > nums[mid]) return nums[mid]; 

                if(nums[mid] > nums[l]){ 
                    l = mid + 1;
                } else { 
                    h = mid - 1;
                }
            }
        } else {
            return nums[0];
        }
        return -1;
    }

    
}
