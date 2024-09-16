/**
 * time complexity : O(logN)
 * space complexity: O(1)
 * LeetCode Execution: successful
 * Steps: 1) verified pre-conditions for null and legth 
 *          2) applied binary search to find mid element
 *          3) to find peak element verified if mid-1 < mid <mid+1 (also verified if mid+1 element exists)
 * 
 */
class FindPeakElement{

    public int findPeakElement(int[] nums) {
        
        if(nums==null || nums.length==0){return -1;}
        
        int low=0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = low +(high-low)/2;
            
            if(nums[mid]>nums[mid-1] && mid+1 <=nums.length-1 && nums[mid]>nums[mid+1]){return mid;}
        
            if(nums[low]<nums[mid]){
                low = mid +1;
            }
            else {
                high = mid -1;
            }
        }
        
        return -1;
        
        
    }
    public static void main(String[] args) {
        FindPeakElement fpe = new FindPeakElement();
        int arr[]={1,2,3,1};
        System.out.println(fpe.findPeakElement(arr));
    }
}