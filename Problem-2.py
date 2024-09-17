class Solution:
    def findMin(self, nums) :

        length = len(nums)
        if length == 1:
            return nums[0]
        start = 0
        end = length - 1

        if nums[end] > nums[0]:
            return nums[0]

        while end >= start:
            mid = start + (end - start) // 2

            if nums[mid] > nums[mid + 1]:
                return nums[mid + 1]
            elif nums[mid - 1] > nums[mid]:
                return nums[mid]
            elif nums[mid] > nums[0]:
                start = mid + 1
            else:
                end = mid - 1

sol=Solution()
num=[6,7,8,9,10,2,3,4,5]
print(sol.findMin(num))