
// Time Complexity : O(log n) for reducing search space by half
// Space Complexity :O(1) -> only pointers are used for left, right, mid and boolean first
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class SearchElement {
    public int[] searchRange(int[] nums, int target) {
        int i=-1,j=-1;       // Default values to be returned
        
        int low=0, high=nums.length-1;  // assign low and high to first and last positions
        boolean first=false;             // set default false to check firstoccurence of element
        while(low<=high){              // edge case
            
            int mid=low+(high-low)/2;  // find mid element 
            
            if(nums[mid]==target){    // if mid element  target
                
                if(i==-1 || first==false){  // check if i has not been changed from default value and also if first occurence has not occured
                    
                    if(mid == low || nums[mid-1]!=target){ // check for edge case if mid equals to low and if the previous element is not the same element
                        i=mid;                              // because in that case the first occurenece is at previous element
                        first=true;                     // once the edge case satisfies assign i to mid, make first occurence to true
                        low=mid;                       // assign low to mid of element and high to end of array
                        high=nums.length-1;
                    }
                    else
                        high = mid-1;    // else look at left half by reassigning high to mid-1
                    
                }
                else{           // this executes if first occurence occured and looking for second occurence
                   if(mid == high || nums[mid+1]!=target){   // check edge case if mid didnt reach last element and if element next to  
                       j=mid;
                       break;
                   }
                    else
                        low=mid+1;
                }
                  
            }
            
            else if(nums[mid]>target)
                high=mid-1;
            else
                low=mid+1;
                
                
            }
            
            return new int[]{i,j};
            
        }
    }
