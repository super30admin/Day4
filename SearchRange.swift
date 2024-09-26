

// Time Complexity : O(Log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

    func searchRange(_ nums: [Int], _ target: Int) -> [Int] {
        var firstIndex = -1
        var lastIndex = -1
        var low = 0
        var high = nums.count - 1
        while low <= high {
            var mid = low + (high-low) / 2
            if nums[mid] == target {
                firstIndex = mid
                high = mid - 1
            } else if target > nums[mid] {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
        low = 0
        high = nums.count - 1
        while low <= high {
            var mid = low + (high-low) / 2
            if nums[mid] == target {
                lastIndex = mid
                low = mid + 1
            } else if target > nums[mid] {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
        return [firstIndex,lastIndex]
    }


