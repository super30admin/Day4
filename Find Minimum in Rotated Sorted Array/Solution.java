// Time Complexity: O(logn)
// Space Complexity: O(logn)
class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            if(nums[l]<nums[h]) return nums[l];
            int m= l+(h-l)/2;
            if((m==0 || nums[m]<nums[m-1]) && (m==nums.length-1 || nums[m]<nums[m+1]))             {
            return nums[m];    
            } else if(nums[l]<=nums[m]){
                l=m+1;
            } else {
                h=m-1;
            }
            }
            return 99999;
        }
    
    }
