class Solution {
    public int findPeakElement(int[] nums) {
        int first =0;
        int last=nums.length-1;
   
        while(first<=last){
            int mid=first+(last-first)/2;
            boolean greaterthanleftside = mid==0 || nums[mid] > nums[mid-1];
            boolean greaterthanrightside = mid==nums.length-1 || nums[mid] > nums[mid+1];
           if(greaterthanleftside && greaterthanrightside){
               return mid;
           }
            if(greaterthanleftside){
                first=mid+1;
            }
            else{
                last=mid-1;
            }
            
        }
        return -1;
    }
}
