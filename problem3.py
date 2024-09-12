# Time Complexity: O(log(n))
# Approach: using binary search aproach, we check if mid is the peak
# if not then we compare the left or right, 
# if mid-1 is greater then definitely a peak is on left of mid
# if mid+1 is greater then definitely a peak is on right of mid
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
#         Inserting -inf to front and back to handle case where len(nums) = 1
        nums.append(-1*sys.maxsize)
        nums.insert(0,-1*sys.maxsize)
        start = 0
        end = len(nums)-1
        answer = -1
        while start <= end:
            mid = (start + end) // 2
            if nums[mid] > nums[mid-1] and nums[mid+1] < nums[mid]:
                answer = mid
                break
            elif nums[mid-1] > nums[mid]:
                end = mid
            elif nums[mid+1] > nums[mid]:
                start = mid
        return answer-1
        