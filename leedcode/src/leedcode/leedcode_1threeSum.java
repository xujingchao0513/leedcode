package leedcode;

import java.util.HashMap;

public class leedcode_1threeSum {
	/**
	 *Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

		Note:

		Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
		The solution set must not contain duplicate triplets.
 
    	For example, given array S = {-1 0 1 2 -1 -4},

    	A solution set is:
    	(-1, 0, 1)
    	(-1, -1, 2)
		2018.08.24
	 */
	public static void main(String[] args) {
		leedcode_1threeSum leed1=new leedcode_1threeSum();
		int target = 9;
		//设置初始值
//		int[] nums=new int[]{2,7,11,15}; 	//例子数据
//		int[] nums=new int[]{15,11,7,2}; 	//测试数据
//		int[] nums=new int[]{15,11,7,8,2}; 	//测试数据
		//衍生方法测试值
		int[] nums=new int[]{2,7,11,13,17,19,23,29,31,37,41}; 	//例子数据
//		int[] nums=new int[]{0,1,2,3,4,5,6,7,8}; 				//例子数据
		target=38;							//修改target用于测试
/*		//方法一
		int[]result=leed1.threeSum_1(nums,target);
		System.out.println("方法一:"+result[0]+","+result[1]);
		//方法二
		int[]result2=leed1.twoSum_2(nums,target);
		System.out.println("方法二:"+result2[0]+","+result2[1]);
		//衍生方法一
		int[]result3=leed1.twoSum_3(nums,target);
		System.out.println("衍生方法一:"+result3[0]+","+result3[1]);
		//衍生方法二
		int[]result4=leed1.twoSum_4(nums,target);
		System.out.println("衍生方法二:"+result4[0]+","+result4[1]);*/
	}
	/**
	 * 思路:先将int[]数组放到map中去,通过对数组循环相加求和
	 * 属于暴力破解,不能作为算法解,不推荐
	 */  
	public int[] threeSum_1(int[] nums, int target) {
    	 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	 int times = 1;
    	for(int i =0;i<nums.length;i++){
    		map.put(i,nums[i]);
    	}
    	int sum = 0;
    	if(sum==target) sum=1;
    	int[] result=new int[]{}; 			 //初始化为默认值,int型为0
    	for(int j=0;j<nums.length;j++){
    		for(int i=j+1;i<nums.length;i++){
    			sum=nums[j]+nums[i];
    			if(sum==target)
    				result=new int[]{j,i};
    			times++;
    		}
    	}
    	System.out.println("方法一执行:"+times+"次");
    	// map.remove(key);//删除map中的无用数据
		return result; 
    }
	
}
