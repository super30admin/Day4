# time: o(log n)
# space: O(log n)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        lower = self.binSearch(nums, 0, len(nums)-1, target, True)
        if lower == -1:
            return [-1,-1]
        upper = self.binSearch(nums, 0, len(nums)-1, target, False)
        return [lower, upper]

    def binSearch(self, nums, l,r, target, isFirst):
        while l<=r:
            m = (l+r)//2
            if target == nums[m]:
                if isFirst:
                    if m==l or nums[m]>nums[m-1]:
                        return m
                    else:
                        r=r-1
                else:
                    if m==r or nums[m]<nums[m+1]:
                        return m
                    else:
                        l=l+1
            elif target > nums[m] :
                l = m+1
            else:
                r = m-1

        return -1
                 


        