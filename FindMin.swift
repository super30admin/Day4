

// Time Complexity : O(Log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :



    func findMin(_ nums: [Int]) -> Int {
        var start = 0
        var end = nums.count - 1
        var minimum = Int.max
        if nums.count < 2 {
            return nums[0]
        }
        while start < end {
            var mid = start + (end - start) / 2
         minimum = min(nums[mid], nums[start],nums[end],minimum)
            if nums[mid]  >= nums[start] {
                start = mid + 1
                
            } else {
                end = mid - 1
            }
           
        }
       return minimum
    }
