public class FindFirstAndLastPositionOfElementInSortedArray {

        /* 
    Thought Process:
    
    We have to do 2 binary search, first to find first element and next to find second element.

    How to find the first element?
        - Base Case? -> mid == target and mid-1 < target
        Go left when mid>= target else right

    if no elemnt was find, return -1,-1
    else find second element

    How to find the second element?
        - Base Case? -> mid == target and mid+1 > target
        Go right when mid <= target else left
    
    TC - O(logN)
    SC - O(1)
    */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0]=-1;
        res[1]=-1;
        if(nums.length==0 || nums == null){
            return res;
        }
        int l = 0, h = nums.length-1;
        
        //Finding First Element by Binary Search
        while(l<=h){
            int mid = l + (h-l)/2;
            if(nums[mid]==target && (mid==l || nums[mid-1]<target)) {
                res[0]=mid;
                break;
            }
            else if(nums[mid] >= target) h = mid-1;
            else l = mid+1;
        }
        if(res[0]==-1)return res;
        l = res[0];
        h = nums.length-1;
        //Finding Second Element by Binary Search
        while(l<=h){
            int mid = l + (h-l)/2;
            if(nums[mid]==target && (mid==h || nums[mid+1]>target)) {
                res[1]=mid;
                break;
            }
            else if(nums[mid] <= target) l = mid+1;
            else h = mid-1;
        }
        return res;
    }
}
