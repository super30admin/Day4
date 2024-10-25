"When trying to find the peak always move towards the side of mid, which is greater than mid."
"This is because, if we continue doing this, we are sure to get a peak, probably not a perfect peak where left and right elements are low"
"Peak atleast can be on far right or left "

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        start = 0
        end = len(nums)-1

        while(start < end):
            mid = (start + end) // 2

            if (nums[mid] < nums[mid+1]):
                start = mid + 1
            else:
                end = mid 

        return start
        