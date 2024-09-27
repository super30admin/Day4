#TimeComplexity: O(logn)
#spaceComplexity: O(1)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        while low < high:
            mid = (low+high)//2
            if nums[mid] < nums[high]:
                high = mid
            else:
                low = mid +1
        return nums[low]