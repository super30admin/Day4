#Time Complexity = log n + log n = 2log n = O(log n)

class Solution:
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        if nums is None or len(nums) == 0:
            return [-1, -1]
        self.low = 0
        self.high = len(nums) - 1
        self.first = self.binary_search_first(nums, 0, self.high, target)
        if self.first == -1:
            return [-1, -1]
        self.last = self.binary_search_last(nums, self.first, self.high, target)
        return [self.first, self.last]

    def binary_search_first(self, nums: list[int], low: int, high: int, target: int):
        while self.low <= self.high:
            self.mid = int((self.low + self.high) / 2)
            if nums[self.mid] == target:
                if self.mid == 0 or nums[self.mid - 1] < nums[self.mid]:
                    return self.mid
                else:
                    self.high = self.mid - 1
            elif nums[self.mid] > target:
                self.high = self.mid - 1
            else:
                self.low = self.mid + 1

        return -1

    def binary_search_last(self, nums: list[int], low: int, high: int, target: int):
        while self.low <= self.high:
            self.mid = int((self.low + self.high) / 2)
            if nums[self.mid] == target:
                if (self.mid == self.high) or (nums[self.mid + 1] > nums[self.mid]):
                    return self.mid
                else:
                    self.low = self.mid + 1
            elif nums[self.mid] > target:
                self.high = self.mid - 1
            else:
                self.low = self.mid + 1

        return -1