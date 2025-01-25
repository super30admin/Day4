'''
Time Complexity :
log(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : No
'''

def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n=len(nums)
        left,right=0,n-1
        while(left<right):
            mid=(left+right)//2
            if nums[mid]>nums[right]:
                left=mid+1
            else:
                right=mid
        return nums[left]
