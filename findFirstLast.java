// Time Complexity: O(log(M*N))
// Space complexity: O(1)

import java.util.Arrays;

class findFirstLast {
    public int[] searchRange(int[] nums, int target) {
        int low =0;
        int high = nums.length -1;
        int[] result = {-1,-1};
        int mid = 0;
        int found=0;
        //Finding first index of target
        while(low<=high){
            mid = low + (high-low)/2;
            if(nums[mid]==target){ //if found 
                found = mid; //store this first found index, we can start for last index from here
                if(mid==0 || nums[mid]!=nums[mid-1]){ //check if it is the starting index
                    result[0] = mid;
                    break;
                } else{  //if not first index move left
                    high = mid-1; 
                }
            } else{ //if not found move left or right in BST
                if(nums[mid]<target){
                    low = mid+1;
                } else{
                    high = mid-1;
                }
            }
        }
        if(result[0] == -1) return result;  // if element is not found
        //Finding last index
        low = result[0];   // we can start search from where it is found the first time
        high = nums.length-1;
        while(low<=high){
            mid = low + (high-low)/2;
            //if found
            if(nums[mid]==target){
                //check if next element is higher/if it is the last
                if(mid==nums.length-1 || nums[mid]!=nums[mid+1]){ 
                    result[1] = mid;
                    break;
                } else{  //move right if it is not the last index
                    low = mid+1;
                }
            } else{ //if not found move left or right in BST
                if(nums[mid]<target){
                    low = mid+1;
                } else{
                    high = mid-1;
                }
            }
        }
        return result;
        }

        public static void main(String args[]){
        findFirstLast obj = new findFirstLast();
        int[] testcase = {1,2,1,3,3,3,3,5,6,4};
        int target = 3;
        int[] result = obj.searchRange(testcase, target);
        System.out.println(Arrays.toString(result));
    }
     

    }
