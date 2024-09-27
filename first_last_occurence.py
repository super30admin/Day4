#Time Complexity = O(logn)
#Space Complexity = O(1)
#Successfully compiled and run on Leetcode

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        lower = self.Bound(nums, target, True)  # finding first occurence of val
        if (lower == -1):  # val doesnot exist
            return [-1, -1]

        upper = self.Bound(nums, target, False)  # finding last occurence of val

        return [lower, upper]

    def Bound(self, nums: List[int], target: int, isFirst: bool) -> int:

        N = len(nums)
        begin, end = 0, N - 1
        while begin <= end:
            mid = int((begin + end) / 2)

            if nums[mid] == target:

                if isFirst:
                    # we found our lower bound.
                    if mid == begin or nums[mid - 1] < target:
                        return mid

                    # Search on the left side for the bound.
                    end = mid - 1
                else:

                    # we found our upper bound.
                    if mid == end or nums[mid + 1] > target:
                        return mid

                    # Search on the right side for the bound.
                    begin = mid + 1

            elif nums[mid] > target:
                end = mid - 1
            else:
                begin = mid + 1

        return -1