# Time:- O(log(n))
# Space:-O(1)
# Idea:- First try to find if the element is in the array or not, if found(Partition Element) then do Binary Search on the 
# left array trying to look for the leftmost index of element we are searching for and then look into 
# the right array based on the partition element looking for the rightmost occurence of the target
class Solution:
    def searchRange(self, nums, target):
        self.lo,self.hi=-1,-1
        def leftbs(low,hi):
            while(low<=hi):
                mid=(low+hi)>>1
                if nums[mid]==target:
                    self.lo=mid
                    # looking for the leftmost occurence of the target, found the target but still want to check on the left
                    hi=mid-1
                elif nums[mid]>target:
                    hi=mid-1
                else:
                    low=mid+1
                
        def rightbs(low,hi):
            while(low<=hi):
                mid=(low+hi)>>1
                if nums[mid]==target:
                    self.hi=mid
                    # looking for the rightmost occurence of the target, found the target but still want to check on the right
                    low=mid+1
                elif nums[mid]>target:
                    hi=mid-1
                else:
                    low=mid+1
        low=0
        hi=len(nums)-1
        while(low<=hi):
            mid=(low+hi)>>1
            if nums[mid]==target:
                self.lo=self.hi=mid
                leftbs(low,mid-1)
                rightbs(mid+1,hi)
                break
            if target<nums[mid]:
                hi=mid-1
            else:
                low=mid+1
        return [self.lo,self.hi]
            
            
            