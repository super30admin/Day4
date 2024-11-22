//tc- O(2logn)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null && nums.length-1 == 0) return new int[]{-1, -1};
        
        int high = nums.length-1;

        int first = findFirstIndex(nums, 0, high, target);
       if(first == -1){
        return new int[]{-1,-1};
       }
        int second = findLastIndex(nums, first, high, target);

        return new int[]{first, second};
    }
    
    public int findFirstIndex(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid]== target){
               if(mid == 0 || nums[mid - 1] < nums[mid]){ 
                 return mid;
               }else{
                high = mid - 1;
               }
            }else if(nums[mid] > target){
                high = mid -1;
            }else{
                low = mid + 1;
            }
         
        }
           return -1;
    }
    
     public int findLastIndex(int[] nums, int low, int high, int target){
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == high || nums[mid + 1] > nums[mid]){
                    return mid;
                }else{
                    low = mid + 1;
                }
             }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
            
        }
            return -1;
    }
    
 
}

// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int[] result = new int[2];
//         result[0] = findFirstIndex(nums, target);
//         result[1] = findLastIndex(nums, target);
//         return result;
//     }
    
//     public int findFirstIndex(int[] nums, int target){
//         int index = -1;
//         int start = 0;
//         int end = nums.length - 1;
        
//         while(start <= end){
//             int midpoint = start + (end - start)/2;
//             if(nums[midpoint] >= target){
//                 end = midpoint - 1;
//             }
//             else{
//                 start = midpoint + 1;
//             }
//             if(nums[midpoint] == target) index = midpoint;
//         }
//            return index;
//     }
    
//      public int findLastIndex(int[] nums, int target){
//         int index = -1;
//         int start = 0;
//         int end = nums.length - 1;
        
//         while(start <= end){
//             int midpoint = start + (end - start)/2;
//             if(nums[midpoint] <= target){
//                 start = midpoint + 1;
//          }
//             else{
//                 end = midpoint - 1;
//             }
//             if(nums[midpoint] == target) index = midpoint;
//         }
//             return index;
//     }
    
 
// }