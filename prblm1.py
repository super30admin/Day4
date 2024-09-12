class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        #base case
        if not nums:
            return [-1,-1]
       #find 1st element through 1st BS
        def firstBS(nums,target):
            l=0
            r=len(nums)-1
            while l<=r:
                #mid formula
                m=l+((r-l)//2)
                #instaed of returning mid just after finding target in normal BS
                #Here just check if that element is greater than previous element or is this the very first element in array. If yes>>return mid
                #if not>> run BS again in 1st left half to get actual 1st target
                
                if nums[m]==target:
                    if l==m or nums[m]>nums[m-1]  :
                        return m
                    else:
                        r=m-1
                #same as normal BS
                elif nums[m]<target:
                    l=m+1
                #same as normal BS
                else:
                    r=m-1
            #didnt find anything
            return -1
        
        
        def secondBS(nums,target):
            l=0
            r=len(nums)-1
            while l<=r:
                m=l+((r-l)//2)
                 #instead of returning mid just after finding target in normal BS
                #Here just check if that element is less than immediate next right element or is this the very last element in array. If yes>>return mid
                #if not>> run BS again in 2nd right half to get actual last target
                if nums[m]==target:
                    if m==r or nums[m]<nums[m+1] :
                        return m
                    else:
                        l=m+1

                elif nums[m]<target:
                    l=m+1
                else:
                    r=m-1
            return -1

            
        first=firstBS(nums,target)
        second=secondBS(nums,target)
        return [first,second]
#O(log N)
#O(1)





# Method2:
# O(N)
# O(1)
# class Solution:
#     def searchRange(self, nums, target):
#         # find the index of the leftmost appearance of `target`. if it does not
#         # appear, return [-1, -1] early.
#         for i in range(len(nums)):
#             if nums[i] == target:
#                 left_idx = i
#                 break
#         else:
#             return [-1, -1]

#         # find the index of the rightmost appearance of `target` (by reverse
#         # iteration). it is guaranteed to appear.
#         for j in range(len(nums)-1, -1, -1):
#             if nums[j] == target:
#                 right_idx = j
#                 break

#         return [left_idx, right_idx]
            