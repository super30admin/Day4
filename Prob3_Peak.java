class Solution {
    public int findPeakElement(int[] nums) {
        int high=nums.length-1;
        int low=0;
        while(high>=low){
        int mid=low+(high-low)/2;
        if((mid==0||nums[mid]>nums[mid-1]) && (mid==nums.length-1 ||nums[mid]>nums[mid+1])){
            return mid;
        }
        else if(mid>0 && nums[mid]<nums[mid-1]){
            high=mid-1;
        }
        else{
            low=mid+1;
        }
        }
        return -1;
    }
}
// class Solution {
//     public int findPeakElement(int[] nums) {
//         //Time Complexity:O(N)
//         //Space Complexity:O(1)
//         for(int i=0;i<nums.length;i++){
//             if(i==0)
//                 if(nums.length==1 ||nums[i]>nums[i+1])
//                     return i;
//             if(i==nums.length-1)
//                 if(nums[i]>nums[i-1])
//                     return i;
//             if((i!=0 &&nums[i]>nums[i-1]) && (i!=nums.length-1 &&nums[i]>nums[i+1]))
//                     return i;    
//         }
//         return -1;
//     }
// }
