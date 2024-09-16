class MinElem {
    public int findMin(int[] nums) {
        if( nums == null || nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            if(nums[left] < nums [right]){
                return nums[left];
             }
            int mid = left + ( right - left)/2;
            if((mid == 0 || nums[mid] < nums[mid-1])
               &&(mid == nums.length-1 || nums[mid] < nums[mid + 1])){
                return nums[mid];    
            }else if(nums[left] > nums[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,1,2,3};
        MinElem min = new MinElem();
        System.out.println("The min element is " + min.findMin(nums));
    }
}