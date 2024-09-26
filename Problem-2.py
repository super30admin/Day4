class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #TIMECOMPLEXITY-O(LOG(n))
        #Space-O(n)
        low = 0
        high = len(nums)-1
        
        while(low<=high):
            if(nums[high]>nums[low]):
                return nums[low]
            mid=low+(high-low)//2
            print(low,mid,high)
            if((mid==0 or nums[mid]<nums[mid-1]) and (mid==len(nums)-1 or nums[mid]<nums[mid+1])):
                return nums[mid]
            elif(nums[low] <= nums[mid]):
                low=mid+1 
            else:
                high=mid-1
        return -1
                
                
                