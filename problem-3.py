# Time Complexity
# O(log n)
# Space Complexity
# O(1)

# Approach :

# since arr[i] != arr[i+1], on dividing the array into 2 parts,
# search the side where arr[mid] < arr[mid+1], so that we can reach the peak element
# criterion to find pick element is arr[mid+1] > arr[mid] as well as arr[mid] > arr[mid-1]


class Solution:
    def findPeakElement(self, arr: List[int]) -> int:
        if (not arr):
            return -1

        low = 0
        high = len(arr)-1

        while (low <= high):
            mid = (low+high)//2
            if ((mid == low or arr[mid] > arr[mid-1]) and (mid == high or arr[mid] > arr[mid+1])):
                return mid

            if (arr[mid+1] > arr[mid]):
                low = mid+1
            else:
                high = mid-1

        return -1
