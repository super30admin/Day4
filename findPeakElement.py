# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Not able to think the logic

class Solution(object):
    def findPeakElement(self, nums):
        left ,right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            print(left, mid, right)
            # base condition 1. if we reach the end indexes
            if left == right:
                # print('Here')
                return mid

            # base condition 2. if our mid is at peak
            
            elif  nums[mid] > nums[mid - 1] and nums[mid] > nums[mid + 1] : 
                return mid

            elif nums[mid+1] > nums[mid]:
                left = mid + 1

            else:
                right = mid - 1


nums1 = [1,2,1,3,5,6,4]
ans1 = [1,5]
nums2 = [1,2,3,4]
ans2= [3]
nums3 = [4,3,2,1]
ans3 = [0]
nums4 = [0,1]
ans4 = [1]
nums5 = [1,3,2,1,0]
ans5 = [1]
obj = Solution()

print('1. ' +  str(obj.findPeakElement(nums1) in ans1))
print('2. ' +  str(obj.findPeakElement(nums2) in ans2))
print('3. ' +  str(obj.findPeakElement(nums3) in ans3))
print('4. ' +  str(obj.findPeakElement(nums4) in ans4))
print('5. ' +  str(obj.findPeakElement(nums5) in ans5))

