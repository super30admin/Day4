

// Time Complexity : O(Log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


    func findPeakElement(_ nums: [Int]) -> Int {
        var start = 0
        var end = nums.count - 1
         
        while start <= end {
            var mid = start +  (end-start) / 2
            print("start = \(start), end = \(end), mid = \(mid)")
            if (mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.count - 1 || nums[mid] > nums[mid+1])  {
                return mid
            } else if nums[mid] < nums[mid+1] {
                start = mid + 1
                
            } else {
                end = mid - 1
            }
        }
        return -1
    }
