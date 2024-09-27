# Time: O(log(n))
# Space: O(1)
class Solution:
    def findMin(self, nums):
        low, high = 0, len(nums) - 1
        while low < high:
            mid = low + (high - low) // 2
            if nums[mid] < nums[high]:
                high = mid
            else:
                low = mid + 1
        return nums[low]


if __name__ == "__main__":
    nums = [4, 5, 6, 7, 1, 2, 3]
    print(Solution().findMin(nums)) #4
    print(Solution().findMin(([1,2,3,4]))) #0
    print(Solution().findMin(([1,2,3,4,5,0]))) #0
    print(Solution().findMin([30,0])) #1
    print(Solution().findMin([3,4,5,1,2])) #3
