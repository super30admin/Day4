//After class
// Time Complexity : (O)logn
// Space Complexity : (O)1
// Did this code successfully run on Leetcode : yes

import Foundation

class Solution {
    func findPeakElement(_ nums: [Int]) -> Int {
  //edge
       if nums.count == 0 {
           return -1
       }
       
       var low = 0
       var high = nums.count - 1
       while low <= high {
           let mid = low + (high - low)/2
           if (mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.count - 1 || nums[mid] > nums[mid+1]) {
                  return mid
           } else if mid > 0 && nums[mid - 1] > nums[mid] {
               high = mid - 1
           } else {
               low = mid + 1
           }
       }
       return -1
    }
}
