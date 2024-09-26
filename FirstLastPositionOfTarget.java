//Time complexity: O(log n)
//Space complexity: O(1)
//solved on leetcode: yes
//any doubts: no

import java.util.*;
class FirstLastPositionOfTarget {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        if(n==0|| nums==null)  return new int [] {-1,-1};
        if(nums[0]>target || nums[n-1]<target) return new int [] {-1,-1};
        int first=firstIndex(nums,target);
        if(first==-1) return  new int []{-1,-1};
        int last=LastIndex(nums,first,target);
        return new int[] {first,last};
    }
    int LastIndex(int nums[],int l,int target){
        int low=l;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1||nums[mid]<nums[mid+1]){
                    return mid;
                }
                else{
                    low=mid+1;
                }
            }
            else{
                if(nums[mid]>target){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
        } return -1;
    }
    int firstIndex(int nums[],int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==0|| nums[mid]>nums[mid-1]){
                    return mid;
                }
                else{
                    high=mid-1;
                }
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
        return -1;
    }
    
    public static void main(String args[]) {
    	int ar[]= {5,7,7,8,8,10};
    	FirstLastPositionOfTarget ob=new FirstLastPositionOfTarget();
    	int arr[]=ob.searchRange(ar, 8);
    	
    	for(int i=0;i<arr.length;i++) {
    		System.out.println(arr[i]);
    	}
}
}