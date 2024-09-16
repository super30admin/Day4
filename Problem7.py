
class Solution:
    def first_position(nums, target):
            n=len(nums)
            res=-1   #default value
            pos=[]   # result

            left,right =0 ,n-1
    """
    First occurence

    """
            while left <= right:
                mid=left+ (right-left)//2
                if nums[mid]==target:
                    #store the index temporarily
                    res=mid
                    right=mid-1
                elif target>nums[mid]:
                    left=mid+1
                else:
                    right=mid-1

            pos.append(res)  #Appending the first occurence


    """
    Second occurence

    """
            left =0;right=n-1

            while left <= right:
                mid=left+ (right-left)//2
                if nums[mid]==target:
                    res=mid
                    left=mid+1
                elif target>nums[mid]:
                    left=mid+1
                else:
                    right=mid-1
            pos.append(res)    #Appending the second occurence
            return(pos)

"""

Time complexity: O(log n)
Space Complexity: O(1)

"""

# nums = [5,7,8,9,9,10]
# target = 9
# first_position(nums, target)
