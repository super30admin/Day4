# Time Complexity : o(logn)
# Space Complexity : o(1)
# Did this code successfully run on Leetcode : Yes

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        f=[-1,-1]
        def fp(f):
            l=0
            h=len(nums)-1
            while l<=h:
                m=(l+h)//2
                if nums[m] == target:
                    if m == 0:
                        f[0] = m
                        break
                    elif nums[m-1] == target:       # if target found on left, then it's not the first position.
                        h=m-1
                    else:
                        f[0] = m                    # edge case
                        break
                elif nums[m] < target:
                    l = m+1
                else:
                    h = m-1
        def lp(f): 
            l=0
            h=len(nums)-1
            while l<=h:
                m=(l+h)//2
                if nums[m] == target:
                    if m == len(nums)-1:                        
                        f[1] = m        
                        break   

                    elif nums[m+1] == target:       # if target found on right, then it's not the last position.
                        l = m+1
                        
                    else:
                        f[1] = m                    #edge case
                        break
                elif nums[m] < target:
                    l = m+1
                else:
                    h = m-1
                    
        fp(f)
        lp(f)

        return f         