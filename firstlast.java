/*
time complexity 0(log n)+m where m is the number of repeated elements. when m is lowere time complexity is O(log n)
space complexity
O(1)
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
     int low=0;
     int high=nums.length-1;
        int a[]=new int[2];
        a[0]=-1;
        a[1]=-1;
     while(low<=high){
         int mid=low+(high-low)/2;
         if(nums[mid]==target){
             int h=mid;
             int l=mid;
             while(h<=nums.length-1&&nums[h]==target){
                 h++;
             }
             a[1]=h-1;
             while(l>=0&&nums[l]==target){
                 l--;
             }
             a[0]=l+1;
             break;
         }
         else{
             if(nums[mid]>target){
                 high=mid-1;
             }
             else{
                 low=mid+1;
             }
         }
     }
        return a;
    }
}