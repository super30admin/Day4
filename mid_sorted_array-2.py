#Explanation

"Here the only change I have made is that we keep a base case, when ever we calculate mid, 
"we try to compare it with its neighbours, if it is less than both left and right values it is the minimum"

class Solution:
    def findMin(self, nums: List[int]) -> int:
        start = 0
        end = len(nums)-1
        n = len(nums)-1

        while(start <= end):
            mid = (start + end) // 2

            if (mid == n or nums[mid] < nums[mid + 1]) and (mid == 0 or nums[mid] < nums[mid-1]):
                return nums[mid]
            
            elif (nums[mid] < nums[end]):
                end = mid
            else:
                start = mid + 1
        
        return -1