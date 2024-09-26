# Time complexity: O(log n)
# Space complexity: O(1)
# Did it run successfully on leetcode: Yes
# Any problem solving this question: Identifying the trick for comparison was difficult. Also to identify what pointer value to return was tricky.
# After the class concepts were clear and easy to understand
class Solution:
    def findMin(self, nums):

        low, high = 0, len(nums)-1

        while low <= high:
            mid = (low+high)//2

            if (mid == 0 or nums[mid] < nums[mid-1]) and (mid == len(nums)-1 or nums[mid] < nums[mid+1]):
                return nums[mid]

            elif nums[mid] > nums[high]:
                low = mid+1
            else:
                high = mid-1
        return -1

        # while low < high:
        #     mid = (low+high)//2
        #     if nums[mid] < nums[high]:
        #         high = mid
        #     else:
        #         low = mid+1
        # return nums[low]


solution = Solution()
print(solution.findMin([3, 4, 5, 1, 2]))
print(solution.findMin([5, 1, 2, 3, 4]))
print(solution.findMin([1, 2, 3, 4, 5]))
print(solution.findMin([4, 5, 1, 2, 3]))
