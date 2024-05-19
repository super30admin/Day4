//Time Complexity: O(log n)
//Space Complexity: O(1)
//initialize low as 0 and high as 1. SInce we dont know the value of the length of the array
//we use a trial and error method by updating low as high and high as twice the value. 
//Check the value present at high with the target everytime and once the value at high is greater than target
// we stop. We have found a range with low and high within which the target is to be found in between. 
class SearchInSortedArrayOfUnknownSize {
    public int search(ArrayReader reader, int target) {

        int low = 0;
        int high = 1;

        while(target > reader.get(high)) {
            low = high;
            high = high * 2;
        }

        while(low<=high) {

            int mid = low+(high-low)/2;
            int midVal = reader.get(mid);

            if(midVal == target) {
                return mid;
            }
            else if(target < midVal) {
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}