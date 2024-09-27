def findPeakElement(self, nums: List[int]) -> int:
    """
    #Keywords: Peak
    We are searching for curves.
    is it sorted ?? if sorted good, else heapsort nlog(n)

    #Constraints: 
    not returning multiple peaks 
    unknown size and infinite
    
    #Brute force: O(n)
    Sliding window in linear search (i, i+2, i+3) add condition and store i+2 index and return.
    
    #working towards log(n)
    Binary Search:
    Divide problem in two, search for condition of peak, if not found move window mid+1 or mid-1
    """
    left, right = 1, len(nums)
    nums = [float('-inf')] + nums + [float('-inf')] #given

    #base case
    if(len(nums)==1): return 0

    while(left<=right):
        mid = left + (right-left) //2
        current, winLeft, winRight = nums[mid], nums[mid-1], nums[mid+1]

        if(current>winLeft and current>winRight):
            return mid-1
        elif(current>winLeft and current<winRight):
            left = mid+1
        elif(current<winLeft and current>winRight):
            right = mid - 1
        else:
            left = mid+1
    return 0