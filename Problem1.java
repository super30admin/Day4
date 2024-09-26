class Solution {
    int first;
    int last;
    public int binarySearchFirst(int []nums,int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            // if mid is equal to target
            if(nums[mid]==target){
                // if mid is first element check with side neighbor 
                //condition if mid==0 i.e., if mid reaches first 0th index of array then                         automatically it is first element
                if(mid==0 || nums[mid-1]<nums[mid]){
                    return mid;
                }
                //if neighbour is not less than mid then bring high
                else{
                    high=mid-1;
                }
            } 
            //if mid is greater than target then the target is in left part
            else if(nums[mid]>target){
                high=mid-1;
            }
            //target in right part
            else{
                low=mid+1;
            }
        }
        //if ntng found return -1;
        return -1;
    }
    
    public int binarySearchLast(int []nums,int target){
        //as we already found first element we can do search for last from first instead of whole array
        int low=first;
        int high=nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            // if mid is equal to target
            if(nums[mid]==target){
                // if mid is last element check with side neighbor 
                //condition if mid==numslength i.e., if mid reaches last nth index of array then                         automatically it is last element
                if(mid==nums.length-1 || nums[mid+1]>nums[mid]){
                    return mid;
                }
                //if neighbour is not greater than mid then bring low
                else{
                    low=mid+1;
                }
            } 
            //if mid is greater than target then the target is in left part
            else if(nums[mid]>target){
                high=mid-1;
            }
            //target in right part
            else{
                low=mid+1;
            }
        }
        //if ntng found return -1;
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        //if empty array return -1,-1
        if(nums == null || (nums.length)==0) return new int[]{-1,-1};
        //if target is not in range with first and last elements of array return -1,-1; 
        if(nums[0]>target || nums[nums.length-1]< target) return new int[]{-1,-1};
        //as we need to perform 2 binary searches one for finding first element and other for   last element worst case that left would be in left part and right would be in right part so 2           funcs
        first = binarySearchFirst(nums,target);
        //after searching through left part and not find return -1,-1
        if(first==-1)return new int[]{-1,-1};
        last = binarySearchLast(nums,target);
        //after searching through right part and not find return -1,-1
        if(last == -1) return new int[]{-1,-1};
        //if found return first and last
        return new int[]{first,last};
    }
}