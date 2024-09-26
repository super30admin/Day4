// time: O(log n)
//space: O(1)

class min_element_rotated_array {
    public int findMin(int[] nums) {
        int minEle = -1;
        
        int start = 0;
        int end = nums.length - 1;
        
        if(nums.length == 1){
            return nums[0];
        }
        
        if(nums[end] > nums[start]){
            return nums[start];
        }
        
        while(start <= end){
            int mid = start + (end -start)/2;
            // mid element is greater than the next element, next is the minEle
            if(nums[mid] > nums[mid +1]){
                return nums[mid + 1];
            } 
            
// mid ele is less than the previous element, mid is the minnEle
            if(nums[mid] < nums[mid-1]){
                return nums[mid];
            }
            
            if(nums[mid] > nums[start]){
                start = mid +1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}