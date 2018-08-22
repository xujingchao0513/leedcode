package leedcode;

import java.util.HashMap;

public class leedcode_1 {
	/**
	 *��Ŀ:leedcode_1-Two Sum
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
	
		//���ó�ʼֵ
		int[] nums=new int[]{2,7,11,15}; 	//��������
//		int[] nums=new int[]{15,11,7,2}; 	//��������
//		int[] nums=new int[]{15,11,7,8,2}; 	//��������
		int target = 9;
		//����һ
		int[]result=leed1.twoSum_1(nums,target);
		System.out.println("����һ:"+result[0]+","+result[1]);
		//������
		int[]result2=leed1.twoSum_1(nums,target);
		System.out.println("������:"+result2[0]+","+result2[1]);
	}
	/**
	 * ˼·:�Ƚ�int[]����ŵ�map��ȥ,ͨ��������ѭ��������
	 * ���ڱ����ƽ�,������Ϊ�㷨��,���Ƽ�
	 */  
	public int[] twoSum_1(int[] nums, int target) {
    	 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i =0;i<nums.length;i++){
    		map.put(i,nums[i]);
    	}
    	int sum = 0;
    	if(sum==target) sum=1;
    	int[] result=new int[]{}; 			 //��ʼ��ΪĬ��ֵ,int��Ϊ0
    	for(int j=0;j<nums.length;j++){
    		for(int i=j+1;i<nums.length;i++){
    			sum=nums[j]+nums[i];
    			if(sum==target)
    				result=new int[]{j,i};
    		}
    	}
    	// map.remove(key);//ɾ��map�е���������
		return result; 
    }
	/**
	 * �Ż�����
	 * ��forѭ����ͬʱ��map��ֵ�����
	 * ��map��key��value�������
	 * 
	 */
	public int[] twoSum_2(int[] nums, int target) {
   	 	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
   	 	int[] result=new int[]{}; 			 //��ʼ��ΪĬ��ֵ,int��Ϊ0
	   	for(int i =0;i<nums.length;i++){
	   	  if (map.containsKey(target - nums[i])) {
	   		result[0]=i;
	   		result[1]=map.get(target - nums[i]);
	   	  }
	   	  map.put(nums[i],i);	
	   	}
	   	return result; 
   }
	
	
	
	
	
	
	
	
	
	
	 /**
     * ��������:����Java Applet ��Java Application������
     * 
     * Java Applet��Java Application�ڽṹ�������Ҫ��������ڣ�
	��1�����з�ʽ��ͬ��Java Applet�����ܵ������У�������������һ����HTML���Ա�д����ҳ��Ƕ�����У�
	ͨ����Java���ݵ������������ִ�С� Java Application�������ĳ��򣬿��Զ������У�ֻҪ��֧��Java���������
	���Ϳ��Զ������ж�����Ҫ�����ļ���֧�֡�
	��2�����й��߲�ͬ������Java Applet����Ľ��������Ƕ��������������Ƕ�����������Ϊ����������һ���֡�
	Java Application���򱻱����Ժ�����ͨ��Java �������Ϳ���ʹ��߽��ͱ�ִ�У�
	��Java Applet����ͨ���������������Applet�۲�������ִ�С�
	��3������ṹ��ͬ��ÿ��Java Application����ض�����һ������ֻ��һ��main����������ִ��ʱ������Ѱ��main������
	���Դ�Ϊ��� �㿪ʼ���С�����main�������Ǹ��࣬������Ϊ���࣬Ҳ����˵��Java Application���򶼺���һ�����ࡣ
	��Applet������û�к� main���������࣬��Ҳ����Applet�����ܶ������е�ԭ�򡣾���Appletû�к�main���������࣬
	��Appletһ����һ�� �� java.applet.Applet�������࣬������Javaϵͳ�ṩ�ġ�
	��4��Java Applet�������ֱ�������������AppletViewer�ṩ��ͼ���û����棬
	��Java Application���������������дר�ô�����Ӫ���Լ���ͼ�ν��档
	��5���ܵ������Ʋ�ͬJava Application���������Ƴ��ܽ��и��ֲ����ĳ��򣬰�������д�ļ��Ĳ�����
	���� Java Applet ��վ ��Ĵ����ļ��Ȳ��ܽ��ж�������Ҳ���ܽ���д ������Ȼ�������� Applet�����룬
	ʹWebҳ����ж�̬��ý��Ч���Ϳɽ������ܣ���ʹ����Ϊ���ı���ʵΪ���ı���HTML���Ա�д�ɵ�Webҳ�����������˳��ı��� �ܣ�
	����������ʾ�ı���Ϣ�����һ������и���ͼƬЧ���Ͷ�̬ͼ��Ч�����Ӷ�ʹҳ���Ե�����������
	���⣬AppletʹWebҳ�������˰�ť�ȹ��ܣ��Ӷ��� ���˽����ԡ�
     */
	/**
	 * ��������:eclipse�޸Ŀ�ݼ�
	 * 1.���Ϸ�ѡ��Windows
	 * 2.��ѡ����ѡ��preferences
	 * 3.���������ô��ڣ�ѡ��Genaral----keys
	 */
}
