#Time Complexity : O(log n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no



class Solution:
    def findPeakElement(self, nums) -> int:
        
        l, r = 0, len(nums) - 1
        
        while l + 1 < r:
            mid = (l + r) // 2
            if nums[mid - 1] < nums[mid] and nums[mid] > nums[mid + 1]:    #check if mid is the peak element by comparing the previous and the end element
                return mid
            elif nums[mid - 1] < nums[mid] < nums[mid + 1]:  #if right value of mid is greater than mid, then there is a peak in the right side, then check the right side
                l = mid
            else:   #if left value of mid is greater than mid, then there is a peak in the left side, then check the left side
                r = mid   
                
        return r if nums[l] < nums[r] else l    #now check whether the left element is lesser than the right element, if yes, print the left one as it's the peak or else print the right one