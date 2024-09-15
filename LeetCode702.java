public class LeetCode702{
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        // this is my first approach but i guess no need to take a varibale n:
        // int n=10000;
        // while(high<=n){
        // int val=reader.get(high);
        // if(val>=target){
        // break;
        // }else{
        // low=high;
        // high=high*2;
        // }
        // }

        // time complexity of this while loop is O(log(n)) as i am moving the high in
        // power 2 multiples
        while (reader.get(high) <= target) {// here i making sure that traget will lie in my range of low and high in
                                            // sort creating a range between which in need to serach
            low = high;
            high = high * 2;
        }

        // tc=O(log(n))--> binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (target > reader.get(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

// TC=O(log(n))
// SC=O(1)
