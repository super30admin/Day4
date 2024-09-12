#   ques: 162. Find Peak Element

#   Time Complexity :
#   O(log n)

#  Space Complexity :
#  O(1)

#  Did this code successfully run on Leetcode :
#  Yes

#  Any problem you faced while coding this :
#  No

#  Your code here along with comments explaining your approach

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        low, high = 0, len(nums)-1
        
        # Applying Binary Search
        while(low<=high):
            mid = (low + high)//2
            
            # If mid lement is peak we will return mid index
            if (mid == 0 or nums[mid]>nums[mid-1]) and (mid == len(nums)-1 or nums[mid]>nums[mid+1]):
                return mid
            # If mid is not peak we will move towards bigger number
            # Checking if left element of mid element is bigger, if it is bigger, peak can be found on left side of mid element
            elif(mid!=0 and nums[mid]<nums[mid-1]):
                high = mid - 1
            # If left element of mid element is smaller then mid element then right element 
            # of mid element must be bigger then mid element and peak can be found in rigt side of mid element
            else:
                low = mid + 1