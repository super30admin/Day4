#Time Complexity = O(log n)

class Solution:
    def findPeakElement(self, nums: list[int]) -> int:
        self.low = 0
        self.high = len(nums) - 1
        while self.low <= self.high:
            self.mid = int((self.low+self.high)/2)
            if (self.mid == 0 or nums[self.mid-1] < nums[self.mid]) and \
                    (self.mid == self.high or nums[self.mid+1] < nums[self.mid]):
                return self.mid
            if nums[self.mid] < nums[self.mid - 1]:  # move left
                self.high = self.mid - 1
            else:
                self.low = self.mid + 1
