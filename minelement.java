//In this program binary search is used to find out the smallest element in a rotated array. Here conditions such as, if the middle element is greater than its immediate right element, the that immediate right element will be the smallest number. If the middle element is smaller than it immediate left element, then the middle element itself will be the smallest number. Else, if the left most element is smaller than middle, the element which is in the immediate right to the middle is reassigned as the left most element. Else, if the left most element is greater than the middle element, then the right most element is reassigned to the element which is in the immediate left to the middle element. The Time complexity of this algorithm is : O(logN) and the space complexity is : O(1).

class solution{
    public int findmin(int[] nums){
        return findpivot(nums,0,nums.length-1);
    }
    public int findpivot(int[]nums,int left,int right){
        if(nums[left]<=nums[right]){
            return nums[0];
           
        }
        while(left<=right){
            int mid=(left+(right-left))/2;
            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid-1]>nums[mid]){
                return mid;
            }
            if(nums[left]<=nums[mid]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return -1;
    }
}