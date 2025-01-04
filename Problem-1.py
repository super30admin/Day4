#We can set the boolean variable to find lower and upper and binarily search lower and upper bounds if the mid is equal to target
#Time is O(logn)
#Space is O(1)
#Yes this worked in leetcode

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        lower = self.find(nums,target, True)
        if lower == -1:
            return [-1,-1]
        
        upper = self.find(nums,target, False)

        return [lower,upper]

    def find(self, nums:List[int],target:int, isFirst: bool) -> int:
        n = len(nums)
        first, last = 0, n-1
        while first <= last:
            mid = first + (last-first)//2
            if nums[mid] ==target:
                if isFirst:
                    if mid == first or nums[mid-1] < target:
                        return mid

                    last = mid-1
                else:

                    if mid == last or nums[mid+1]>target:
                        return mid
                    first = mid+1
            elif nums[mid]>target:
                last = mid-1
            else:
                first = mid+1

        return -1
