// Time Complexity :O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//one approach is to find the index of the element and then run the lopp both the sides to get the first and the lat index.
//but this can rally become O(logn) +O(n) if all the element are same in the array.

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr=new int[2];
        if(nums.length==0){
            arr[0]=-1;
            arr[1]=-1;
            return arr;
        }
        if(nums.length==1 && nums[0]==target){
            return arr;
        }
        
        int start=0;
        int end=nums.length-1;
        int midPoint=0;
        while(start<=end){
            midPoint=start+(end-start)/2;
            if(nums[midPoint]==target){
                break;
            }else if(target<nums[midPoint]){
                end=midPoint-1;
            }else if(target>nums[midPoint]){
                start=midPoint+1;
            }
        }
        //System.out.println(midPoint);
        if(nums[midPoint]!=target){
            arr[0]=-1;
            arr[1]=-1;
            return arr;
        }
        start=midPoint;
        while(start >=0 && nums[start]==target){
            start--;
        }
        end=midPoint;
        while(end <nums.length && nums[end]==target){
            end++;
        }
        arr[0]=start+1;
        arr[1]=end-1;
        return arr;

        
    }
}

//The secoond method is the more efficient one in which we apply binary search twice to find the left and the right elements of the array.
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr=new int[2];
        if(nums.length==0){
            arr[0]=-1;
            arr[1]=-1;
            return arr;
        }
        if(nums.length==1 && nums[0]==target){
            return arr;
        }
        arr[0]=-1;
        arr[1]=-1;
        int start=0;
        int end=nums.length-1;
        int midPoint=0;
        while(start<=end){
            midPoint=start+(end-start)/2;
            if(nums[midPoint]==target){
                arr[0]=midPoint;
                end=midPoint-1;
            }else if(target<nums[midPoint]){
                end=midPoint-1;
            }else if(target>nums[midPoint]){
                start=midPoint+1;
            }
        }
        //System.out.println(midPoint);
        if(arr[0]==-1){
            return arr;
        }
        start=0;
        end=nums.length-1;
        midPoint=0;
        while(start<=end){
            midPoint=start+(end-start)/2;
            if(nums[midPoint]==target){
                arr[1]=midPoint;
                start=midPoint+1;
            }else if(target<nums[midPoint]){
                end=midPoint-1;
            }else if(target>nums[midPoint]){
                start=midPoint+1;
            }
        }
         //System.out.println(midPoint);

        return arr;

        
    }
}


