class Solution:
    def findMin(nums):
        low = 0
        high = len(nums) - 1    
        while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]
            mid = (low + high) // 2
            if nums[low] == nums[mid] and nums[low] == nums[high]:
                return nums[low]
            elif nums[mid] <= nums[low] and nums[mid] < nums[high]:
                high = mid
            elif nums[mid] >= nums[low] and nums[mid] < nums[high]:
                high = mid - 1
            else:
                low = mid + 1
if __name__ == "__main__":
    s = Solution
    ans = s.findMin([3,4,5,1,2])
    print(ans)

