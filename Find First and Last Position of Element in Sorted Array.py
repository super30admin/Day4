class Solution:
    # Time: O(log(n))
    # Space: O(1)
    def searchRange(self, nums, target):

        leftMost = self.findLeftMost(nums, target)
        # print(leftMost)
        rightMost = self.findRightMost(nums, target)
        return [leftMost, rightMost]

    def findLeftMost(self, nums, target):
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == low or nums[mid-1] < target:
                    return mid
                else:
                    high = mid - 1
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def findRightMost(self, nums, target):
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == high or nums[mid+1] > target:
                    return mid
                else:
                    low = mid + 1
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return -1

if __name__ == "__main__":
    nums = [1,2,3,4,4,4,5,6]
    target = 4
    print(Solution().searchRange(nums, target)) #[3,5]
    print(Solution().searchRange([1,2,3,5,6,7,7], 7)) #[5,6]
    print(Solution().searchRange([2,3,4,5,5,6,7,], 1)) #[-1,-1]