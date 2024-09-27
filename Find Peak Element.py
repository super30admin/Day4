# Time: O(log(n))
# Space: O(1)
class Solution:
    def findPeakElement(self, nums):
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if (mid == low or nums[mid-1] < nums[mid]) and (mid == high or nums[mid] > nums[mid+1]):
                return mid
            elif nums[mid] < nums[mid+1]:
                low = mid + 1
            else:
                high = mid - 1




if __name__ == "__main__":
    nums = [1,2,1,3,4,5,4]
    print(Solution().findPeakElement(nums)) #1 or #5
    print(Solution().findPeakElement([1,2,3,4,5])) #4
    print(Solution().findPeakElement([4,3,2]))  # 0
    print(Solution().findPeakElement([1,2,3,1])) #2
