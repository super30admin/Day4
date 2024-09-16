class PeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if((mid == 0  || nums[mid] > nums[mid-1]) 
               && (mid == nums.length -1 || nums[mid] > nums[mid + 1])){
                return mid;
            }else if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,4,5,8,7};
        PeakElement p1 = new PeakElement();
        System.out.println("Index of peak element is: " + p1.findPeakElement(nums));
    }
}