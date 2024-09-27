/*

Did it run on leet code: yes
Time Complexity: 0(logN)
Difficulties: At what condition and how you reduce your search size, to find the element.
Took help from geeks for geeks for the condition to half the search size

Algorithm:
-> Just do binary search twice for last and first index
-> At every part, we check which part is sorted if nums[l]<nums[mid], the left half is sorted or else
right is sorted.

*/


class Solution {
    public int search(int[] nums, int target) {
        int l =0;
        int r = nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(target==nums[mid]){
                return mid;
            }
            else if(nums[l]<=nums[mid]){
                if(target>=nums[l] && target<nums[mid]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                if(target<=nums[r] && target>nums[mid]){
                    l=mid+1;
                }else{
                 r=mid-1;
                }
            }
        }
        return -1;
    }
}