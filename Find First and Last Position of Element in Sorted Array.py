class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        length = len(nums)

        if nums == None or length == 0:
            return -1, -1

        if (target < nums[0]) or (target > nums[length - 1]):
            return -1, -1

        def binarySearchFirst(self, nums: List[int], target: int):
            low = 0
            high = length - 1

            while (low <= high):
                mid = low + ((high - low) // 2)
                if target == nums[mid]:
                    if (mid == 0 or nums[mid] > nums[mid - 1]):
                        return mid
                    else:
                        high = mid - 1
                elif (nums[mid] > target):
                    high = mid - 1
                else:
                    low = mid + 1
            return -1

        def binarySearchLast(self, nums: List[int], target: int):
            low = 0
            high = length - 1

            while (low <= high):
                mid = low + ((high - low) // 2)
                if target == nums[mid]:
                    if (mid == length - 1 or nums[mid] < nums[mid + 1]):
                        return mid
                    else:
                        low = mid + 1
                elif (nums[mid] > target):
                    high = mid - 1
                else:
                    low = mid + 1
            return -1

        first = binarySearchFirst(self, nums, target)

        if first == -1:
            return -1, -1
        else:
            last = binarySearchLast(self, nums, target)

        return [first, last]



    """
    Time Complexity: O(Log n)
    """