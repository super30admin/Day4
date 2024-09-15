class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        output= [-1,-1]
        def b_search(l,r,nums,isleft):
            while l<=r:
                mid = (l+r)//2 #4
                if nums[mid]==target: #4
                    if isleft==True:
                        output[0]=mid #3
                        r = mid-1 #r = 3
                    else:
                        output[1]=mid #5
                        l=mid+1
                else:
                    if nums[mid]>target:
                        r=mid-1
                    else:
                        l=mid+1 #l=3
                        
        
        l=0
        r=len(nums)-1 #5
        b_search(l,r,nums,True)
        b_search(l,r,nums,False)
        return output
        