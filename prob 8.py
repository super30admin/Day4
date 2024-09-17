class Solution:
    def findPeakElement(self, nums,t): # t is target
        l, r = 0, len(nums)-1
        #print(l,r)
        while l <= r:
            #print(l,r,'11')
            mid = (l + r)//2
            if nums[mid]== t:
                #print(l, r, '22')
                return mid
            elif nums[mid] >= nums[l]: #sorted part of the array
                if t <= nums[mid-1] and t>=l:
                    r=mid-1
                    #print(l, r, '33')

                else:
                    l=mid+1
                    #print(l, r, '444')
            else:  # sorted part of right array
                if t >= nums[mid+1] and t<=nums[r]:
                    l = mid + 1
                    #print(l, r, '44555')
                else:
                    r = mid-1
                    #print(l, r, '6666')
        return -1
d= Solution()
print(d.findPeakElement([7,8,9,3,4,5,6],4))
