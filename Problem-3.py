class Solution:
    def findPeakElement(self, nums) :

        length = len(nums)

        return self.search(nums, 0, length - 1)

    def search(self, nums, low, high) :

        if low == high:
            return low

        mid = low + (high - low) // 2

        if nums[mid] > nums[mid + 1]:
            return self.search(nums, low, mid)

        return self.search(nums, mid + 1, high)

sol=Solution()
num=[1,2,3,4,1]
print (sol.findPeakElement(num))