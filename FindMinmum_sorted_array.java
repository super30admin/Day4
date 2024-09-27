// Time Complexity : O(log(N)) N is size of input
// Space Complexity : O(1) No Auxilary Array
//                    O(log(N)) recursive stack space
// Did this code successfully run on Leetcode : YES


// Your code here along with comments explaining your approach

class FindMinmum_sorted_array {
    public int findMin(int[] nums) {
        int left  = 0;
        int right = nums.length - 1;
        return find_minimum(nums,left,right);
    }
    
    public int find_minimum(int [] nums, int left, int right){
        
        if(right < left) return nums[0];
        if (left == right){
            return nums[left];
        }
        
        int mid = left +(right - left )/2;
   

        if( mid < right && nums[mid+1] < nums[mid]){
            return nums[mid+1];
        }
        
        if(mid > left &&  nums[mid-1] > nums[mid]){
            return nums[mid];           
        }
        
        if(nums[mid] < nums[right]){
            return find_minimum(nums,left,mid-1);
        }else{
            return find_minimum(nums,mid+1,right);
        }
    }
}
