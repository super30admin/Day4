#Time Complexity = O(log n)

class Solution:
    def findMin(self, nums: list[int]) -> int:
        if nums is None or len(nums) == 0:
            return -1
        self.low = 0
        self.high = len(nums) - 1

        while self.low <= self.high:
            if nums[self.low] <= nums[self.high]:
                return nums[self.low]
            self.mid = int((self.low + self.high)/2)
            if (self.mid == 0 or nums[self.mid] < nums[self.mid-1]) and \
                    (self.mid == len(nums)-1 or nums[self.mid] < nums[self.mid + 1]):
                return nums[self.mid]
            elif nums[self.low] <= nums[self.mid]:  # left sorted
                self.low = self.mid + 1
            else:
                self.high = self.mid - 1

        return -1
