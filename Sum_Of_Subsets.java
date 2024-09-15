package Solution;
import java.util.*;
public class Sum_Of_Subsets {
	static List<List<Integer>> result;
	static int remains;
	private static List<List<Integer>> subsetSum(int[] input,int target){
		for(int i : input)
			remains+=i;
		
		result = new ArrayList<>();
		helper(0, target, 0, input, new ArrayList<Integer>(),remains);
		return result;
	}
	
	private static void helper(int current_sum, int target, int index, int[] nums, ArrayList<Integer>temp, int remains){
		if(target == current_sum){
			result.add(new ArrayList<>(temp));
			return;
		}
		
		if(current_sum > target){
			return;
		}
		if(current_sum + remains < target)
			return;
		
		else{
		temp.add(nums[index]);
		helper(current_sum + nums[index], target, index+1, nums, temp,remains - nums[index]);
		temp.remove(temp.size()-1);
		helper(current_sum, target, index+1, nums,temp,remains - nums[index]);
		}
	}
	public static void main(String args[]){
		int[] input = new int[]{1,4,2,13,11,24,2,10};
		int target = 24;
		subsetSum(input, target);
		System.out.println(result);
		
	}
}
