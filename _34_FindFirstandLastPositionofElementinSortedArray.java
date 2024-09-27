// space complexity - O(1)
//time - O(3log(n))
//Ran on leeetcode successfully : Yes
// Problem faced  : No
//Approach : Binary Search,
      //1. Find any occurence of target,
      //2. Find first occurence of target in first half (0 ,mid)
      //3. Find last occurence of target in last half(mid, end)
      //4. If mid = target then move (end or start) to mid not (mid -1 or mid+1) becasue it may be first or last occurence , we dont wanna loose thee current element
      //5. Watch out for the condition when (start == mid) that mean start and end are 1 distance apart and
      //   return index based on start or end index value

class Solution {
    public int[] searchRange(int[] nums, int target) {

      int[] res = {-1,-1};

      if(nums == null || nums.length == 0) return res;

      int targetIndex = findElement(nums, target);

      if(targetIndex == -1) return res;

      int start = findFirstOccurence(nums, target, 0, targetIndex);
      int end = findLastOccurencee(nums, target, targetIndex, nums.length -1);
      res[0] = start;
      res[1] = end;

      return res;
    }

    public int findElement(int[] nums, int target){

      int start = 0;
      int end = nums.length -1;
      int mid = start + (end - start)/2;

      while(start <= end){
        mid = start + (end - start)/2;
        if(nums[mid] == target) return mid;
        else if(nums[mid] < target)  start = mid + 1;
        else end = mid -1;
      }
      return -1;
    }

    public int findFirstOccurence(int[] nums, int target, int start, int end){
      int mid = start + (end - start)/2;
      whille(start <= end){
        mid = start + (end - start)/2;

        if(start == mid) return (nums[start] == target) ? start : end;
        if(nums[mid] == target){
          end = mid;
        }
        else if(nums[mid] < target){
          start = mid + 1;
        }
      }
      return end;
    }

    public int findLastOccurence(int[] nums, int target, int start, int end){
      int mid = start + (end - start)/2;
      whille(start <= end){
        mid = start + (end - start)/2;

        if(start == mid) return (nums[end] == target) ? end : start;
        if(nums[mid] == target){
          start = mid;
        }
        else if(nums[mid] > target){
          end = mid - 1;
        }
      }
      return start;
    }
}
