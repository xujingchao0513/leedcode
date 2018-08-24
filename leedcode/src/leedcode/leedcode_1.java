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
		int target = 9;
		//���ó�ʼֵ
//		int[] nums=new int[]{2,7,11,15}; 	//��������
//		int[] nums=new int[]{15,11,7,2}; 	//��������
//		int[] nums=new int[]{15,11,7,8,2}; 	//��������
		//������������ֵ
		int[] nums=new int[]{2,7,11,13,17,19,23,29,31,37,41}; 	//��������
//		int[] nums=new int[]{0,1,2,3,4,5,6,7,8}; 				//��������
		target=38;							//�޸�target���ڲ���
		//����һ
		int[]result=leed1.twoSum_1(nums,target);
		System.out.println("����һ:"+result[0]+","+result[1]);
		//������
		int[]result2=leed1.twoSum_2(nums,target);
		System.out.println("������:"+result2[0]+","+result2[1]);
		//��������һ
		int[]result3=leed1.twoSum_3(nums,target);
		System.out.println("��������һ:"+result3[0]+","+result3[1]);
		//����������
		int[]result4=leed1.twoSum_4(nums,target);
		System.out.println("����������:"+result4[0]+","+result4[1]);
	}
	/**
	 * ˼·:�Ƚ�int[]����ŵ�map��ȥ,ͨ��������ѭ��������
	 * ���ڱ����ƽ�,������Ϊ�㷨��,���Ƽ�
	 */  
	public int[] twoSum_1(int[] nums, int target) {
    	 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	 int times = 1;
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
    			times++;
    		}
    	}
    	System.out.println("����һִ��:"+times+"��");
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
   	 	int[] result=new int[2]; 			 //��ʼ��ΪĬ��ֵ,int��Ϊ0
   	 	int times = 1;
	   	for(int i =0;i<nums.length;i++){
	   	  if (map.containsKey(target - nums[i])) {
	   		result[0]=i;
	   		result[1]=map.get(target - nums[i]);
	   		times++;
	   	  }
	   	  map.put(nums[i],i);	
	   	}
	   	System.out.println("������ִ��:"+times+"��");
	   	return result; 
   }
	/**	������:��������
	 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
		The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
		You may assume that each input would have exactly one solution.
		Input: numbers={2, 7, 11, 15}, target=9
		Output: index1=1, index2=2
	 */
	/**
	 * ˼·:��������ʹ�ö��ַ�
	 * ����һ���л���ϵĽ��
	 * 20180823
	 */
	public int[] twoSum_3(int[] nums, int target) {
		int[] result=new int[2]; 			//��ʼ��
		int[] result_why=new int[]{}; 		//��ʼ��
		int i = 0;							//��ʼ��������С����
		int len = nums.length-1;			//��ʼ������ ��󳤶�
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
		System.out.println("��������һִ��:"+times+"��");
		return result;
	}
	/**
	 * ��������������Ż�
	 * ������鳤���㹻��,����ʹ�÷��εķ�ʽ
	 * 20180823
	 * �Ż�ʧ��,��ʱû���ر�õ��뷨--20180824
	 */
	public int[] twoSum_4(int[] nums, int target) {
		int[] result=new int[2]; 				//��ʼ��
		int[] result_why=new int[]{}; 			//��ʼ��//������֪Ϊʲô�����ᱨ����ֵԽ��,������ķ�������
		int i = 0;								//��ʼ��������С����
		int len = nums.length-1;				//��ʼ������ ��󳤶�
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
		System.out.println("����������:����1ִ��:"+num+"��");
		return result;
	}
	//�Ż�����
	public int GetMedian(int i,int[] nums,int start,int end,int target){
		int left = start;
        int right = end;
        int times =1;
        //���С���ұ�
        while (left < right) {
            //�����м��
            int mid = left + (right - left) / 2;
            if(i==1){
            	if (nums[mid] > target) {
                    //�ұߵĵ���mid-1
                    right = mid - 1<0?0:mid-1;
                } else {
                    //��ߵ���Ŀ��+1��
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
        System.out.println("����������,����2ִ��:"+times+"��");
           if(i==1) return right;
           else return left;
	}
	public int[] bad(int[] nums, int start,int end,int target){
		int[] result=new int[2]; 			//��ʼ��
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
		System.out.println("����������,����3ִ��:"+times+"��");
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
