def searchRange(self, nums: List[int], target: int) -> List[int]:
        """
        keywords: sorted and log(n)
        Follow Binary search and start search from mid.
        Base case: 2 elements in array
        """
        left, right = 0, len(nums)-1
        res = []
        
        while(left<=right):
            mid = left + (right-left)//2
            if(target == nums[mid]):
                i = mid
                while(i>=0 and nums[i]==target):
                    i-=1
                res.append(i+1)
                
                i = mid
                while(i<len(nums) and nums[i] == target):
                    i+=1
                res.append(i-1)

                return res
            elif(target>nums[mid]):
                left = mid+1
            else:
                right = mid-1
        return [-1,-1]