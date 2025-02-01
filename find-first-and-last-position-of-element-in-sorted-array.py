# The algorithm uses binary search twice—once to find the leftmost occurrence and once to find the rightmost occurrence
#  of the target in a sorted array. It adjusts the search space accordingly to locate both boundaries efficiently.

# Time: O(log N) | Space: O(1).

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        def binary_search(nums, target, search_left):
            begin = 0
            end = len(nums) - 1
            idx = -1
            while begin <= end:
                mid = (begin + end) // 2
                if target < nums[mid]:
                    end = mid - 1
                elif target > nums[mid]:
                    begin = mid + 1
                else:
                    idx = mid
                    if search_left:
                        end = mid - 1
                    else:
                        begin = mid + 1
            return idx

        begin = binary_search(nums, target, True)
        end = binary_search(nums, target, False)
        return [begin, end]