Time Complexity: O(logn)
Space Complexity: O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
    int l=0; //initialising l to 0
    int r=nums.length-1; // r to last element
 
    while(l<r){ //while l<r
        int m=l+(r-l)/2; //initialising mid m
        if(nums[m]<target){ //if current mid element is less than target, then move l to m+1
            l=m+1;
        }else{
            r=m; //else move r to m
        }
    }
 
    int first=l; //first as l
    if(l<nums.length&&nums[l]==target){//if l is in boundary and is the target
        l=0; //l to 0
        r=nums.length-1; //r to last element
        while(l<r){ //while l<r
            int m=l+(r-l+1)/2; //initialising mid m
            if(nums[m]>target){ //if current mid element is greater than target, then move r to m-1
                r=m-1;
            }else{
                l=m; //else move l to m
            }
        }
 
        return new int[]{first, r}; //return the found indices
    }
 
    return new int[]{-1,-1}; //else return [-1,-1]
    }
}