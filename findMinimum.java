// Time Complexity: O(logN)
// Space complexity: O(1)

class findMinimum {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            //check if whole range is sorted and return lowest
            if(nums[low]<=nums[high]) return nums[low];
            //if not BST
            int mid = low + (high-low)/2;
            //Only at lowest element, it's previous is greater than itself
            if(mid!=0 && nums[mid]<nums[mid-1]){
                return nums[mid];
            } 
            //lowest index always lies in unsorted side
            else if(nums[mid]>=nums[low]){  //left sorted, so move to right array
                low = mid+1;
            } else{ //else move to left
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        findMinimum obj = new findMinimum();
        int[] testcase = {3,4,5,1,2};
        int result = obj.findMin(testcase);
        System.out.println(result);
    }
}