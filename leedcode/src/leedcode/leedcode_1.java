package leedcode;

import java.util.HashMap;

public class leedcode_1 {
	/**
	 *题目:leedcode_1-Two Sum
		Given an array of integers, return indices of the two numbers such that they add up to a specific target.
		
		You may assume that each input would have exactly one solution, and you may not use the same element twice.
		
		Example:
		
		Given nums = [2, 7, 11, 15], target = 9,
		
		Because nums[0] + nums[1] = 2 + 7 = 9,
		return [0, 1].
		2018.08.22-12:47
	 */
	public static void main(String[] args) {
		leedcode_1 leed1=new leedcode_1();
		int target = 9;
		//设置初始值
//		int[] nums=new int[]{2,7,11,15}; 	//例子数据
//		int[] nums=new int[]{15,11,7,2}; 	//测试数据
//		int[] nums=new int[]{15,11,7,8,2}; 	//测试数据
		//衍生方法测试值
		int[] nums=new int[]{2,7,11,13,17,19,23,29,31,37,41}; 	//例子数据
//		int[] nums=new int[]{0,1,2,3,4,5,6,7,8}; 				//例子数据
		target=38;							//修改target用于测试
		//方法一
		int[]result=leed1.twoSum_1(nums,target);
		System.out.println("方法一:"+result[0]+","+result[1]);
		//方法二
		int[]result2=leed1.twoSum_2(nums,target);
		System.out.println("方法二:"+result2[0]+","+result2[1]);
		//衍生方法一
		int[]result3=leed1.twoSum_3(nums,target);
		System.out.println("衍生方法一:"+result3[0]+","+result3[1]);
		//衍生方法二
		int[]result4=leed1.twoSum_4(nums,target);
		System.out.println("衍生方法二:"+result4[0]+","+result4[1]);
	}
	/**
	 * 思路:先将int[]数组放到map中去,通过对数组循环相加求和
	 * 属于暴力破解,不能作为算法解,不推荐
	 */  
	public int[] twoSum_1(int[] nums, int target) {
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
	/**
	 * 优化方法
	 * 在for循环的同时给map赋值并相加
	 * 将map中key和value反序放入
	 * 
	 */
	public int[] twoSum_2(int[] nums, int target) {
   	 	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
   	 	int[] result=new int[2]; 			 //初始化为默认值,int型为0
   	 	int times = 1;
	   	for(int i =0;i<nums.length;i++){
	   	  if (map.containsKey(target - nums[i])) {
	   		result[0]=i;
	   		result[1]=map.get(target - nums[i]);
	   		times++;
	   	  }
	   	  map.put(nums[i],i);	
	   	}
	   	System.out.println("方法二执行:"+times+"次");
	   	return result; 
   }
	/**	衍生题:数组有序
	 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
		The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
		You may assume that each input would have exactly one solution.
		Input: numbers={2, 7, 11, 15}, target=9
		Output: index1=1, index2=2
	 */
	/**
	 * 思路:有序数组使用二分法
	 * 给定一定有会符合的结果
	 * 20180823
	 */
	public int[] twoSum_3(int[] nums, int target) {
		int[] result=new int[2]; 			//初始化
		int[] result_why=new int[]{}; 		//初始化
		int i = 0;							//初始化数组最小长度
		int len = nums.length-1;			//初始化数组 最大长度
		int times=1;
		while(i<len){
			if(nums[i]+nums[len]==target){			
				result[0]=i;
		   		result[1]=len;
		   		break;
			}else if(nums[i]+nums[len]<target){
				i +=1;
			}else if(nums[i]+nums[len]>target){
				len -=1;
			}else{
				System.out.println("***");
			}
			times++;
		}
		System.out.println("衍生方法一执行:"+times+"次");
		return result;
	}
	/**
	 * 对于衍生问题的优化
	 * 如果数组长度足够长,可以使用分治的方式
	 * 20180823
	 * 优化失败,暂时没有特别好的想法--20180824
	 */
	public int[] twoSum_4(int[] nums, int target) {
		int[] result=new int[2]; 				//初始化
		int[] result_why=new int[]{}; 			//初始化//求大神告知为什么这样会报错数值越界,而上面的方法不会
		int i = 0;								//初始化数组最小长度
		int len = nums.length-1;				//初始化数组 最大长度
		int num = 1;
		while(i<len){
			if(nums[i]+nums[len]==target){			
				result[0]=i;
		   		result[1]=len;
		   		break;
			}else if(nums[i]+nums[len]<target){
				i=GetMedian(0,nums,i,len, target - nums[i]);		
			}else if(nums[i]+nums[len]>target){
				len = GetMedian(1,nums,i,len,target - nums[len]);
			}else{
				result=bad(nums,i,len,target);
				break;
			}
			num++;
		}
		System.out.println("衍生方法二:程序1执行:"+num+"次");
		return result;
	}
	//优化方法
	public int GetMedian(int i,int[] nums,int start,int end,int target){
		int left = start;
        int right = end;
        int times =1;
        //左边小于右边
        while (left < right) {
            //左右中间点
            int mid = left + (right - left) / 2;
            if(i==1){
            	if (nums[mid] > target) {
                    //右边的等于mid-1
                    right = mid - 1<0?0:mid-1;
                } else {
                    //左边等于目标+1；
                    left = mid + 1;
                }
            }else{
            	if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            times++;
        }
        System.out.println("衍生方法二,程序2执行:"+times+"次");
           if(i==1) return right;
           else return left;
	}
	public int[] bad(int[] nums, int start,int end,int target){
		int[] result=new int[2]; 			//初始化
		int times=1;
		int check_start=start;
		int check_end=end;
		for(;start>=0;start--){
			if(nums[start]+nums[end]==target){			 
				result[0]=start;
		   		result[1]=end;
		   		break;
			}else if(nums[start]+nums[end]<target){
				end =end+1>=check_end?check_end:end+1;
			}else if(nums[start]+nums[end]>target){
				end =end-1<=check_start?check_end:end-1;
			}else{
				System.out.println("***");
			}
			times++;
		}
		System.out.println("衍生方法二,程序3执行:"+times+"次");
		return result;
	}
	
	
	
	
	 /**
     * 补充内容:关于Java Applet 和Java Application的区别
     * 
     * Java Applet和Java Application在结构方面的主要区别表现在：
	（1）运行方式不同。Java Applet程序不能单独运行，它必须依附于一个用HTML语言编写的网页并嵌入其中，
	通过与Java兼容的浏览器来控制执行。 Java Application是完整的程序，可以独立运行，只要有支持Java的虚拟机，
	它就可以独立运行而不需要其他文件的支持。
	（2）运行工具不同。运行Java Applet程序的解释器不是独立的软件，而是嵌在浏览器中作为浏览器软件的一部分。
	Java Application程序被编译以后，用普通的Java 解释器就可以使其边解释边执行，
	而Java Applet必须通过网络浏览器或者Applet观察器才能执行。
	（3）程序结构不同。每个Java Application程序必定含有一个并且只有一个main方法，程序执行时，首先寻找main方法，
	并以此为入口 点开始运行。含有main方法的那个类，常被称为主类，也就是说，Java Application程序都含有一个主类。
	而Applet程序则没有含 main方法的主类，这也正是Applet程序不能独立运行的原因。尽管Applet没有含main方法的主类，
	但Applet一定有一个 从 java.applet.Applet派生的类，它是由Java系统提供的。
	（4）Java Applet程序可以直接利用浏览器或AppletViewer提供的图形用户界面，
	而Java Application程序则必须另外书写专用代码来营建自己的图形界面。
	（5）受到的限制不同Java Application程序可以设计成能进行各种操作的程序，包括读／写文件的操作，
	但是 Java Applet 对站 点的磁盘文件既不能进行读操作，也不能进行写 操作。然而，由于 Applet的引入，
	使Web页面具有动态多媒体效果和可交互性能，这使由名为超文本、实为纯文本的HTML语言编写成的Web页面真正具有了超文本功 能，
	不但可以显示文本信息，而且还可以有各种图片效果和动态图形效果，从而使页面显得生动美丽；
	另外，Applet使Web页面增加了按钮等功能，从而增 加了交互性。
     */
	/**
	 * 补充内容:eclipse修改快捷键
	 * 1.右上方选择Windows
	 * 2.在选项中选择preferences
	 * 3.打开属性配置窗口，选择Genaral----keys
	 */
}
