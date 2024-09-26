/**
 * Time Complexity : O(logn) where n = size of sorted array nums
 * Space Complexity : O(1)
 */

class SortedMin {
    public int findMin(int[] nums) {
        int low = 0;
        int first = nums[0];
        int high = nums.length-1;
        
        if(nums.length==1) return first;
        
        if(nums[high]>first) return first;
        
        while(low<high){
            int mid = low + (high-low)/2;
            if(nums[mid]>nums[mid+1])
                return nums[mid+1];
            if(nums[mid-1]>nums[mid])
                return nums[mid];
            if(nums[mid]>first)
                low = mid + 1;
            else high = mid - 1;
                
        }
        return -1;
    }

        public static void main(String args[]) {
            int[] myArr = {8,9,10,1,2,4,5,6};
            SortedMin obj = new SortedMin();
            int min = obj.findMin(myArr);
            System.out.println(min);

        }
    }