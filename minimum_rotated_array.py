"""
Time complexity: O(logN) - N is the number of elements - Binary serach
Space complexity: O(1)- No extra space is used
 No doubts

 Explaination:
 1. usually in a sorted array, mid is less than high, else that part is not sorted so take the low to mid+1 else take the high to mid
 2. when the low and high are pointing to the same element, exit



"""


class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 0 or nums == None:
            return 0  # [4,5,6,7,0,1,2]
        low = 0
        high = len(nums) - 1
        while (low < high):
            mid = (low + high) // 2
            if nums[mid] > nums[high]:
                low = mid + 1
            else:
                high = mid
        return nums[low]
