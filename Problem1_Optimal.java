
/*
Leet code submitted = Yes
Time complexity = O(logN/2) + O(logN/2)
Space complexity = O(1)
The idea is to find first found element and then recursively check left part of the BST to find  starting index of this target variable and right part of BST to find final index of this target variable. This status is maintained by  current_index array
*/

class Solution {

    public int binary_search(int[] nums,int l,int r,int target,int[] current_index){
        //calculate middle 
        int mid = (l + (r-l)/2);
        
        //Base case
        if(l > r){
            //current_index = -1;
            return -1;
        }
        //truth condition
        if(nums[mid] == target){
            //check leftmost starting position of the target
            if(current_index[0] == -1 || current_index[0] > mid){
                current_index[0] = mid;
            }
            binary_search(nums,l,mid-1,target,current_index);
            
            //check rightmost ending position of the target
            if(current_index[1] == -1 || current_index[1] < mid){
                current_index[1] = mid;
            }
            binary_search(nums,mid+1,r,target,current_index);
            return 0;
        }
       //check if left part is sorted    
        else if(nums[mid] >= target){
              r = mid -1;      
        }else{
              l = mid + 1;
        }
        return binary_search(nums,l,r,target,current_index);
        
    }
    
    public int[] searchRange(int[] nums, int target) {
        int[] output = new int[2];
        output[0] = -1;
        output[1] = -1;
            
        //boundary conditions
        if(nums == null || nums.length < 1){
            return output;
        }
        else if(nums.length == 1){
            if(nums[0] == target){
                output[0] = 0;
                output[1] = 0;
                return output;
            }
            return output;
        }
        else{
            int flag = binary_search(nums,0,nums.length - 1,target,output);
            return(output);    
        }
            
             
    }
}

