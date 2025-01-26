public class PeakElement {
        public int findPeakElement(int[] nums) {

            int l = 0;
            int n = nums.length;
            int h = n-1;

            while(l <= h){
                int mid = l + (h-l)/2;

                //check if cur mid element is peak by comparing with its neighbors
                if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n - 1 || nums[mid] > nums[mid + 1])) {
                    return mid;
                }
                //if not check the neighbor who is higher than the mid element to check that partition
                else if(mid > 0 && nums[mid] < nums[mid - 1]){
                    h = mid -1;
                }else{
                    l = mid+1;
                }
            }
            return -1;
        }
}


//Time Complexity -> O(log(n))
//Space Complexity -> O(1)