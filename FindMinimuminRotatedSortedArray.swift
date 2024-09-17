
//After class
// Time Complexity : (O)logn
// Space Complexity : (O)1
// Did this code successfully run on Leetcode : Yes

//Use binary search to find pivot element
// use two pointer technique. keep track of low and high pointer
// if mid element is less than mid-1 and mid+1 then return mid element
// otherwise move the high pointer to mid -1 when mid value is less than high pointer value
// Or move the low pointer to mid + 1 when mid value is higher than high pointer value

class Solution {
    func findMin(_ nums: [Int]) -> Int {
       //edge
       guard nums.count > 0 else { return -1 }
       
       var low = 0
       var high = nums.count - 1
       while low <= high {
           if nums[low] <= nums[high] {
               return nums[low]
           }
           let mid = low + (high - low)/2
           if (mid == 0 || nums[mid] < nums[mid - 1]) && 
              (mid == nums.count - 1 || nums[mid] < nums[mid + 1]) {
                  return nums[mid]
           } else if nums[mid] < nums[high] {
                high = mid - 1
           } else {
                low = mid + 1
           }
       } 
       return -1 
    }
}