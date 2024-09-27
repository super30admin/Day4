def findMin(self, nums: List[int]) -> int:
        """
        # Brute force in O(n)
        Search until left is small and right is high and return left
        # Binary Search in O(log(n))
        follow Binary search , check for pivot condition , return left one
        """
        left, right = 0, len(nums)  - 1
        while nums[left] > nums[right]:
            mid =  left + (right-left)//2
            if nums[mid] >= nums[left]:
                left = mid + 1
            else:
                right = mid
        return nums[left]