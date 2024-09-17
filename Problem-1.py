class Solution:
    def searchRange(self, nums, target) :

        low = self.find(nums, target, True)
        if (low == -1):
            return [-1, -1]

        high = self.find(nums, target, False)

        return [low, high]

    def find(self, nums, target, isFirst) :

        length = len(nums)
        start = 0
        end = length - 1
        while start <= end:
            mid = (start + end) // 2

            if nums[mid] == target:

                if isFirst:
                    if mid == start or nums[mid - 1] < target:
                        return mid

                    end = mid - 1
                else:

                    if mid == end or nums[mid + 1] > target:
                        return mid

                    start = mid + 1

            elif nums[mid] > target:
                end = mid - 1
            else:
                start = mid + 1

        return -1
sol= Solution()
num=[3,4,6,8,10,10,10,10,12,12]
print(sol.searchRange(num,10))