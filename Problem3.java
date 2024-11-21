public class Problem3 {
    public int[] searchRange(int[] nums, int target) {
        
        int half = nums.length/2;
        int firstIndex = -1;
        int temp;
        int secondIndex = -1;
        
        //finds middle point
        while(half < nums.length || half >= 0)
        {
            if(nums[half] == target)
            {
                firstIndex = half;
                break;
            }
            else if(nums[half] < target)
                half += half/2;
            else
                half -= half/2;
        }
        
        //finds endpoint
        while(nums[half] == target)
        {
            secondIndex = half;
            half++;
        }
        
        //find firstIndex
        if(firstIndex != -1)
        {
            while(nums[firstIndex] == target)
            {
                firstIndex--;
            }
            firstIndex++;
        }
        
        int[] indicies = new int[2];
        
        if(firstIndex == -1)
        {
            if(secondIndex == -1)
            {
                indicies = new int[]{-1,-1};
                return indicies;
            }
            else
            {
                indicies = new int[]{secondIndex, secondIndex};
                return indicies;
            }

        }
        
        else if(secondIndex == -1)
        {
            indicies = new int[]{firstIndex, firstIndex};
            return indicies;
        }
            
        else
        {
            indicies = new int[]{firstIndex, secondIndex};
            return indicies;
        }
    }
}
