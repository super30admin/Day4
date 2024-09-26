//In this program, two different functions are used to return the left most occurence which will be the first occurence of the target and thr right most occurence which will return the last occurence of the target. These two functions use binary search to find the occurence. The time complexity is : O(logN) and the space complexity is: O(1).


class Solution{
    public int [] SearchRange (int[] nums, int target){
        int[] res=new int[2];
        res[0]=binaryleft(nums,target);
        res[1]=binaryright(nums,target);
        return res;
    }
    private int binaryleft(int[] nums,int target){
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int mid=(l+(h-l))/2;
            if(mid==0||nums[mid-1]<target&&nums[mid]==target){
                return mid;
            }
            else{
                if(nums[mid]<target){
                    l=mid+1;
                }
                else{
                    h=mid-1;
                }
            }
        }
        return -1;
    }
    private int binaryright(int[] nums,int target){
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int mid=(l+(h-l))/2;
            if(mid==nums.length-1||nums[mid+1]>target&&nums[mid]==target){
                return mid;
            }
            else{
                if(nums[mid]>target){
                    h=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
        }
        return -1;
    }
    
}