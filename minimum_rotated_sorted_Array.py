#Time Complexity : O(log n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no

class Solution:
    def findMin(self, nums) -> int:
        
        
        l,r = 0, len(nums)-1  #initiate the first and last pointers
        
        while l < r:          #initiate binary search
            m = (l+r)//2      #find the mid
            if nums[m] >= nums[r]:  #now compare the mid element with the right element, if it is greater than or equal to last element, then our minimum is surelyy on the right side
                l = m + 1    #to search in the right side, shift the left pointer to mid+1
            else:  
                r = m         #or else, then our minimum is surelyy on the left side, so shift right to middle 

        return nums[l]       #now the left most element is our minimum