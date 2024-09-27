# Both run on Leetcode
# Runtimecomplexity- O(logn)
# memory- O(1)

# Brute force with binary search
'''
Implemented the first solution by searching for the target using binary search. 
Iterating through array seraching for least index and max index where number is equal to target.
Returning values if found, or returning [-1,-1]
'''

class Solution:
     def searchRange(self, nums ,target):
        low = 0
        high = len(nums)-1
        result = []
        while(low <= high):
            # checking mid index
            mid = low + (high-low)//2
            # if target is equal to mid number
            if(target == nums[mid]):
                i = mid
                while(i >= 0 and nums[i] == target):
                    i -= 1
                result.append(i+1)
                i = mid
                while(i < len(nums) and nums[i] == target):
                    i += 1
                result.append(i-1)
                return result
            elif(target < nums[mid]):
                high = mid - 1
            else:
                low = mid + 1
        return [-1,-1]


'''
This solution tries to search for first occurence of target element in an array where mid-1 is less than target. 
Searches for second occurence by binary searching for first number where mid+1 is greater than target.
'''

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1, -1]
        a = b = -1
        start, end = 0, len(nums)-1  
        # finding first occurence of number by checking where mid-1 is less than target
        while start <= end:
            mid = (end-start)//2 + start
            if nums[mid] == target and (mid == 0 or nums[mid-1] < target):
                a = mid
                break
            elif nums[mid] < target:
                start = mid+1
            else:
                end = mid - 1

        end = len(nums)-1
        # finding second occurence of number by checking where mid+1 is greater than target
        while start <= end:
            mid = (end-start)//2 + start
            if nums[mid] == target and (mid == len(nums)-1 or nums[mid+1] > target):
                b = mid
                break
            elif nums[mid] <= target:
                start = mid + 1
            else:
                end = mid - 1
        return [a, b]
