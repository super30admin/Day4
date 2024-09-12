#Reference Video: https://youtu.be/L7gNay1c4ak (Check from 6 min)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1
        
        #Binary Search
        while (left < right): #Not equal to because it will go into an infinite loop with '='
            mid = left + (right - left) // 2
            #which means that the peak exists on the left hand size
            #logic: If there is an increase any side, left or right, it has to decrease, this will create a peak
            if nums[mid] > nums[mid + 1]:
                #change right to mid to traverse left side
                #why not mid - 1? Because mid can also be a peak
                right = mid
            #which means that the peak exists on the right hand size
            #traverse the right side from mid + 1
            else:
                left = mid + 1
        return left