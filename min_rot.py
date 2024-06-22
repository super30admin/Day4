# time: O(log n)
# space: O(1)

class Solution:
    def findMin(self, nums: List[int]) -> int:
        l,r = 0, len(nums)-1

        while l<r:
            m = (l+r)//2

            if nums[l]<nums[r]:
                return nums[l]
            elif nums[m]>nums[r]:
                l=m+1
            else:
                r=m
        return nums[l]
        