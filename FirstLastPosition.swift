//After class
// Time Complexity : (O)logn
// Space Complexity : (O)1
// Did this code successfully run on Leetcode : Yes

class Solution {
  func searchRange(_ nums: [Int], _ target: Int) -> [Int] {

      //edge case
      if nums.count == 0 {
          return [-1,-1]
      }
      
      let first: Int = binarySearchLeft(nums, target)
      let last: Int = binarySearchRight(nums, target)
       
      return [first,last]
  }
    func binarySearchRight(_ nums: [Int], _ target: Int) -> Int {
        var low = 0
        var high = nums.count - 1
        while(low <= high) {
            var mid = low + (high - low)/2
            if nums[mid] == target { 
               if mid == nums.count - 1 || nums[mid] < nums[mid+1] {
                 return mid
               } else {
                   low = mid + 1
               }
            }else if nums[mid] > target {
                   high = mid - 1
               } else {
                   low = mid + 1
             }
        }
        return -1
    }
    
    func binarySearchLeft(_ nums: [Int], _ target: Int) -> Int {
        var low = 0
        var high = nums.count - 1
        while(low <= high) {
            var mid = low + (high - low)/2
            if nums[mid] == target { 
               if mid == 0 || nums[mid] > nums[mid-1] {
                 return mid
               } else {
                  high = mid - 1 
               }
            }else if nums[mid] > target {
                   high = mid - 1
             } else {
                   low = mid + 1
            }
        }
        return -1
    }
    
}


//Not working for all test cases. Will try to fix and commit later.


/*class Solution {
  func searchRange(_ nums: [Int], _ target: Int) -> [Int] {

      
      if nums.count == 1 && nums[0] == target{
          return [0,0]
      }
      
      //find element index
      var numbers = nums
      var index = numbers.count/2
      var targetIndex = -1 
      while index >= 0 && numbers.count>1 {
          if numbers[index] == target {
              targetIndex = index
              break
          } else if numbers[index] > target {
              numbers = Array(0..<(numbers.count/2))
          } else {
              numbers = Array((numbers.count/2)..<numbers.count)
          }
          print(numbers)
          index = numbers.count/2
      }
      
      if targetIndex == -1 {
          return [-1,-1]
      }
      
      //find left position
       var startingPosition = targetIndex
       while startingPosition > 0 {
          if nums[startingPosition] != target {
              startingPosition = startingPosition + 1  
              break
          }
          startingPosition = startingPosition - 1  
       }
      
      //find right position
      var endingPosition = targetIndex
      while endingPosition < nums.count {
          if nums[endingPosition] != target {
              endingPosition = endingPosition - 1
              break
          }
          endingPosition = endingPosition + 1
      }
      return [startingPosition,endingPosition]
  }

    
}
*/