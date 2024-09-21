PROBLEM 1:34. Find First and Last Position of Element in Sorted Array

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l = 0
        h = len(nums)-1

        def binarySearchFirst(nums, l, h, target):
            while l<=h:
                m = (l+h) // 2

                if nums[m] == target:
                    if (m == 0 or nums[m-1] < nums[m]):
                        return m
                
                    else:
                        h = m - 1

                elif nums[m] > target:
                    h = m - 1
                
                else:
                    l = m + 1
            return -1
        
        def binarySearchLast(nums, l, h, target):
            while l<=h:
                m = (l+h) // 2

                if nums[m] == target:
                    if ((m == len(nums)-1) or (nums[m+1] > nums[m])):
                        return m
                
                    else:
                        l = m + 1
                elif nums[m] > target:
                    h = m - 1
                
                else:
                    l = m + 1

                

        if len(nums) == 0 or nums == None: return [-1,-1]

        start = binarySearchFirst(nums, 0, len(nums)-1, target)

        if start == -1:
            return [-1,-1]
            
        last = binarySearchLast(nums, start, len(nums)-1, target)

        return [start, last]

PROBLEM 2: 153. Find Minimum in Rotated Sorted Array

class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        h = len(nums)-1

        if len(nums) == 0 or nums == None: return -1

        while(l<=h):
            if nums[l] <= nums[h]:
                return nums[l]

            m = (l+h) // 2

            if (m == 0 or (nums[m] < nums[m-1])) and (m == len(nums)-1 or (nums[m] < nums[m+1])):
                return nums[m]

            elif nums[l] <= nums[m]:
                l = m + 1

            else:
                h = m - 1
            
        return 9808

PROBLEM 3: 162. Find Peak Element

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0
        h = len(nums) - 1

        while(l <= h):
            m = (l + h) // 2

            if (m == 0 or nums[m] > nums[m-1]) and (m == len(nums)-1 or nums[m] > nums[m+1]):
                return m
            
            elif m > 0 and nums[m-1] > nums[m]:
                h = m - 1

            else:
                l = m + 1
        return -1
        

            
        


            


                
 
        

