from json.tool import main


class Solution:
    def searchRange(nums, target):
        if not nums or len(nums) == 0:
            return [-1, -1]
        if target < nums[0] or target > nums[-1]:
            return [-1, -1]
        def binarySearchFirst(nums, target):
            low = 0
            high = len(nums) - 1
            while low <= high:
                mid = (low + high) // 2
                if target == nums[mid]:
                    if mid == 0 or nums[mid - 1] < target:
                        return mid
                    else:
                        high = mid - 1
                elif target < nums[mid]:
                    high = mid - 1
                else: 
                    low = mid + 1
            return -1
        
        def binarySearchLast(nums, target):
            low = 0
            high = len(nums) - 1
            while low <= high:
                mid = (low + high) // 2
                if target == nums[mid]:
                    if mid == len(nums) - 1 or nums[mid + 1] > target:
                        return mid
                    else:
                        low = mid + 1
                elif target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1
        
        first = binarySearchFirst(nums, target)
        last = binarySearchLast(nums, target)
        return [first, last]

if __name__ == "__main__":
    s = Solution
    ans = s.searchRange([5,7,7,8,8,10], 8)
    print(ans)