class FindMinRotated:
    def FindMinVal(self, arr):
        low = 0
        high = len(arr) - 1
        while(low < high):
            if arr[low] == arr[high]:
                return arr[low]
                
            mid = low + (high - low)//2
            if (mid == 0 or arr[mid] < arr[mid - 1]) and arr[mid] < arr[mid + 1]:
                return arr[mid]
            else:
                if arr[mid] > arr[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return arr[low]

if __name__ == "__main__":
	mini = FindMinRotated()
	print(mini.FindMinVal([4,5,6,7,0,1,2]))

