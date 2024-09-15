# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchRange(self, nums, target):
        #Finding first position of the target element
        start = self.searchBinary(nums, target, True)

        #Finding last position of the target element
        end = self.searchBinary(nums, target, False)
        return [start, end]
    
    def searchBinary(self, nums, target, isStart):
        low = 0
        high = len(nums) - 1
        i = -1
        while low <= high:
            mid = low + (high - low) // 2
            
            if nums[mid] == target:
                i = mid
                # Searching for first position of the element
                if isStart:
                    high = mid - 1

                # Searching for last position of the element
                else:
                    low = mid + 1

            # Target belongs to left sub-array
            elif nums[mid] > target:
                high = mid - 1
            
            # Target belongs to right sub-array
            else:
                low = mid + 1
        return i

solution = Solution()
print(f"OUTPUT >> {solution.searchRange([5,7,7,8,8,10], 8)}")