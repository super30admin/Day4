
class Solution {
	    public int[] searchRange(int[] nums, int target) {
		            if (nums == null || nums.length ==0){
				                return new int[]{-1, -1};
						        }
			            int left = binarySearchLeft(nums, target);
				            if (left == -1){
						                return new int[] {-1,-1};
								        }
					            int right = binarySearchRight(nums,target);
						            return new int[] {left,right};
							        }

	        private int binarySearchLeft(int[] nums, int target){
			        int low = 0;
				        int high = nums.length -1; 
					        while (low<=high){
							            int mid = low +(high-low)/2;
								                if (nums[mid]==target){
											                if (mid==0 || mid==nums.length-1 || nums[mid-1]<target){
														                    return mid;
																                    }
													                else if (nums[mid-1]== target) {
																                    high = mid-1;
																		                    }
															            }
										            else if (target>nums[mid]){
												                    low = mid+1;
														                }
											                else{
														                high = mid-1;
																            }
													        }
						        return -1;
							    }
		    private int binarySearchRight(int[] nums, int target){
			            int low =0;
				            int high = nums.length -1;
					            while (low<=high){
							                int mid = low + (high-low)/2;
									            if (nums[mid]==target){
											                    if (mid == nums.length-1 ||nums[mid+1]>target){
														                        return mid;
																	                }
													                    else if (nums[mid+1]==target){
																                        low = mid+1;
																			                }
															                }
										                else if (target<nums[mid]){
													                high= mid-1;
															            }
												            else {
														                    low = mid+1;
																                }

													            }
						            return -1;
							        }
}
