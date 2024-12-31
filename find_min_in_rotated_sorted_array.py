# Time Complexity :- O(logn)
# Space Complexity :- O(1) 
# Leetcode :- Yes
# Approach :- used binary to divide array into half while maintaining minimum result
# if the sub array  nums[l] to nums[r] is sorted comparing nums[l] with res 
# also added condition to check on non-sorted part 
class Solution:
    def findMin(self, nums: List[int]) -> int:
        l , r = 0, len(nums)-1
        res = nums[0]

        while l <= r:
            mid = (l+r)//2

            if nums[l] < nums[r]:
                res =  min(res, nums[l])
                return res
                break
            # check if left part is sorted if yes out min will lie in other half 
            if nums[l] <= nums[mid]:
                l = mid +1 
            else:
                r = mid -1
        return res

