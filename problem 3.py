# // Time Complexity :O(logn)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :YES

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if(len(nums)==0):
            return -1
        left=0
        right=len(nums)-1
        # using two pointer appriach
        while(left<=right):
            pivot=left+(right-left)//2
            # check if element is greater than left and greater than right
            if((pivot==0 or nums[pivot]>nums[pivot-1])and(pivot==len(nums)-1 or nums[pivot]>nums[pivot+1])):
                return pivot
                # if element is gretaer on right move right because we are looking for gretest eleent than left and right
            elif(nums[pivot+1]>nums[pivot]):
                left=pivot+1
                # else move right
            else:
                right=pivot-1
               
        return 1234