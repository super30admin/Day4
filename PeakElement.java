// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : figuring out the code for edge cases

class PeakElement {
    public int findPeakElement(int[] nums) {
        
        //If array contains a single element, return 0
        if(nums.length == 1) {
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        
        while(low<=high) {
            int mid = (low + high) / 2;
            //If mid is at index 0 and zeroth element is greater than its right element, index 0 is the peak
            if(mid == 0) {
                if(nums[0] > nums[1]) {
                    return 0;
                } else {
                    low = mid + 1;
                }
                
            } 
            //If mid is at last index of array and element at last index of array is greater than its left element, last index is the peak
            else if(mid == nums.length - 1) {
                if(nums[nums.length - 1] > nums[nums.length - 2]) {
                    return nums.length - 1;
                }
                
            } 
            
            //If element at mid index is a peak, return mid
            else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return mid;
            }
            
            else{
                // If element at mid is greater than element to its right, search in left side of the array
                if(nums[mid] > nums[mid+1]) {
                    high = mid - 1;
                    
                }
                // If element at mid is lesser than element to its right, search in right side of the array
                else {
                    low = mid + 1;
                }
            }
            
                
            }
        
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        PeakElement s = new PeakElement();
        System.out.println(s.findPeakElement(new int[]{1,2,4,5,3,22,3,4,5,64,5,3,121,3,4,5,3,5,3,24,4,35,44,2,42,5,435,432}));
    }
}