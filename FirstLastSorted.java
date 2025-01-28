// Time Complexity : O(log(n)) n is the no of elements
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class FirstLastSorted {
    public int[] searchRange(int[] nums, int target) {
        int n =nums.length;
        if(n==0||nums == null) return new int[]{-1,-1};
        if(target < nums[0]||target > nums[n-1]) return new int[]{-1,-1};
        int first = binarySearchFirst(nums,target,0,n-1);
        if(first == -1) return new int[]{-1,-1};
        int last = binarySearchLast(nums,target,first,n-1);

return new int[]{first,last};

        
}


private int binarySearchFirst(int[] nums, int target,int low,int high){

       
        while(low<=high){
           int mid = low+(high-low)/2;

           if(nums[mid]==target){

             if(mid==0|| nums[mid]!=nums[mid-1]){

                return mid;
             }else{

                high = mid-1;
             }

           } else if (nums[mid] > target){

            high = mid-1;
            
           }else{

            low = mid+1;
           }

        }
      return -1;  
    }



private int binarySearchLast(int[] nums, int target,int low,int high){
     int n = nums.length;
       
        while(low<=high){
           int mid = low+(high-low)/2;

           if(nums[mid]==target){

             if(mid == n-1|| nums[mid]!=nums[mid+1]){

                return mid;
             }else{

                low = mid+1;
             }

           } else if (nums[mid] > target){

            high = mid-1;
            
           }else{

            low = mid+1;
           }

        }
      return -1;  
    }


}
