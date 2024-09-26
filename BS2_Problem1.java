// Time Complexity : O(Log N base 2)
// Space Complexity : O(1)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
We look for first occurence of Target element in Input Array
-- IF DON'T GET VALID INDEX OF First OCUURENCE THEN WE WILL IDENTIFY THAT TARGET IS NOT IN THE INPUT ARRAY

-- If IT IS, THEN WE WILL SEARCH FOR LAST OCCURENCE

// So, We use Binary search 2 times.

*/

class IndicesSearch {
    
    public int SearchLeft(int[] nums, int l, int h, int target){
        while(l <= h){
            int mid = l + (h - l) / 2;
            
            if(nums[mid] == target){
                if(mid == 0 || nums[mid] > nums[mid - 1]){
                    return mid;
                } 
                else{
                    h = mid - 1;
                }
            }
            else if(nums[mid] < target){
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
        
        return -1;
    }
    public int SearchRight(int[] nums, int l, int h, int target){
        while(l <= h){
            int mid = l + (h - l) / 2;
            
            if(nums[mid] == target){
                if(mid == nums.length - 1 || nums[mid] < nums[mid + 1]){
                    return mid;
                } 
                else{
                    l = mid + 1;
                }
            }
            else if(nums[mid] < target){
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
        
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return new int[] {-1,-1};
        
        if(target < nums[0] && target > nums[nums.length - 1])  return new int[] {-1,-1};
        int first = SearchLeft(nums, 0, nums.length - 1, target);
        
        if(first == -1) return new int[] {-1, -1};
        int last =  SearchRight(nums, first, nums.length - 1, target);
        
        return new int[] {first, last};


    }
}

public class BS2_Problem1{
    public static void main(String[] args){
        int[] arr = {5,7,7,8,8,10};
        int target = 8;

        IndicesSearch s1 = new IndicesSearch();
        int[] result = s1.searchRange(arr, target);

        System.out.println("Start index : End index for given target is :  " + result[0] + "  " + result[1] );
    }
}