package leedcode;

import java.util.HashMap;

public class leedcode_1threeSum {
	/**
	 *Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

		Note:

		Elements in a triplet (a,b,c) must be in non-descending order. (ie, a �� b �� c)
		The solution set must not contain duplicate triplets.
 
    	For example, given array S = {-1 0 1 2 -1 -4},

    	A solution set is:
    	(-1, 0, 1)
    	(-1, -1, 2)
		2018.08.24
	 */
	public static void main(String[] args) {
		leedcode_1threeSum leed1=new leedcode_1threeSum();
		//���ó�ʼֵ
		int[] nums=new int[]{-13,-5,-3,2,7,11,13,17}; 	//��������
		
//		int[][] aaa = new int[10][3];
		//����һ
		int[][] result=leed1.threeSum_1(nums);
		System.out.println("����һ:"+result[0][0]+","+result[0][1]+","+result[0][2]);
/*		//������
		int[]result2=leed1.twoSum_2(nums,target);
		System.out.println("������:"+result2[0]+","+result2[1]);
		//��������һ
		int[]result3=leed1.twoSum_3(nums,target);
		System.out.println("��������һ:"+result3[0]+","+result3[1]);
		//����������
		int[]result4=leed1.twoSum_4(nums,target);
		System.out.println("����������:"+result4[0]+","+result4[1]);*/
	}
	/**
	 * ˼·:3����Ϊ0,��������һ��ֵΪ����
	 * ����ȡ���еĵ�һ����,ѭ��ȡ������������ж��Ƿ��з���������ֵ
	 * һ��֮��ȥ�����еĵ�һ����,�ٴ�ѭ��,ֱ�����еĵ�һ�������ڵ���0
	 * 20180827
	 */  
	public int[][] threeSum_1(int[] nums) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int[][] result=new int[10][3]; 			 //��ʼ��ΪĬ��ֵ,int��Ϊ0
    	int times = 1;
    	int a = 0;
    	for(int i =0;i<nums.length;i++){
    		map.put(i,nums[i]);
    	}
    	int check = 0;	
		for(int i= 1;i<map.size();i++){
			for(int j= i+1;j<map.size();j++){
				if(nums[i]+nums[j]==-map.get(check)){
					result[a][0]=map.get(check);
					result[a][1]=nums[i];
					result[a][2]=nums[j];
					a++;
					times++;
				}
			}
    		check++;
    		map.remove(check);//ɾ��map�е���������

    	}
    	System.out.println("����һִ��:"+times+"��");
		return result; 
    }
	/**
	 * break ��  continue������
	 * break��������������ǰѭ���飨for��while��do while�������飨switch������ѭ�����е�������������ǰ����ѭ����ѭ���塣�ڳ�����е��������жϺ���һ��case�����ıȽϡ�
	 * continue���ڽ���ѭ�������������ִ�У�������ѭ�������Ŀ�ͷִ����һ��ѭ���������������жϸ�ѭ���塣
	 */
	
	/**
	 * Java��Vector��ArrayList������
	 * ��ͬ�㣺
	 * 1.ArrayList����õ�Listʵ���࣬�ڲ���ͨ������ʵ�ֵģ��������Ԫ�ؽ��п���������ʡ������ȱ����ÿ��Ԫ��֮�䲻���м����
	 * �������С������ʱ��Ҫ���Ӵ洢��������Ҫ���Ѿ�����������ݸ��Ƶ��µĴ洢�ռ��С�����ArrayList���м�λ�ò������ɾ��Ԫ��ʱ��
	 * ��Ҫ��������и��ơ��ƶ������۱Ƚϸߡ���ˣ����ʺ�������Һͱ��������ʺϲ����ɾ����
	 * 
	 * 2.Vector��ArrayListһ����Ҳ��ͨ������ʵ�ֵģ���ͬ������֧���̵߳�ͬ������ĳһʱ��ֻ��һ���߳��ܹ�дVector��
	 * ������߳�ͬʱд������Ĳ�һ���ԣ���ʵ��ͬ����Ҫ�ܸߵĻ��ѣ���ˣ��������ȷ���ArrayList����
	 * 
	 * 3.LinkedList��������ṹ�洢���ݵģ����ʺ����ݵĶ�̬�����ɾ����������ʺͱ����ٶȱȽ��������⣬�����ṩ��List�ӿ���û�ж���ķ�����
	 * ר�����ڲ�����ͷ�ͱ�βԪ�أ����Ե�����ջ�����к�˫�����ʹ�á�
	 * 
	 * 4.vector���̣߳�Thread��ͬ����Synchronized���ģ�������Ҳ���̰߳�ȫ�ģ���Arraylist���߳��첽��ASynchronized���ģ�
	 * �ǲ���ȫ�ġ���������ǵ��̵߳İ�ȫ���أ�һ����ArraylistЧ�ʱȽϸߡ�
	 * 
	 * 5.��������е�Ԫ�ص���Ŀ����Ŀǰ��������ĳ���ʱ��vector������ΪĿǰ���鳤�ȵ�100%,��arraylist������ΪĿǰ���鳤��
	 * ��50%.����ڼ�����ʹ���������Ƚϴ�����ݣ���vector��һ�������ơ�
	 * 
	 * 6.�������һ��ָ��λ�õ����ݣ�vector��arraylistʹ�õ�ʱ������ͬ�ģ�����0(1),���ʱ��ʹ��vector��arraylist�����ԡ���
	 * ����ƶ�һ��ָ��λ�õ����ݻ��ѵ�ʱ��Ϊ0(n-i)nΪ�ܳ��ȣ����ʱ���Ӧ�ÿ��ǵ�ʹ��Linkedlist,��Ϊ���ƶ�һ��ָ��λ�õ�����
	 * �����ѵ�ʱ��Ϊ0(1),����ѯһ��ָ��λ�õ�����ʱ���ѵ�ʱ��Ϊ0(i)��
	 * ArrayList ��Vector�ǲ������鷽ʽ�洢���ݣ�������Ԫ��������ʵ�ʴ洢�������Ա����ӺͲ���Ԫ�أ�
	 * ������ֱ���������Ԫ�أ����ǲ�������Ҫ��Ƶ�����Ԫ���ƶ� ���ڴ�����������������ݿ������������
	 * Vector����ʹ����synchronized�������̰߳�ȫ�����������ϱ�ArrayListҪ��
	 * ��LinkedListʹ��˫������ʵ�ִ洢�����������������Ҫ������ǰ�������������ǲ�������ʱֻ��Ҫ��¼�����ǰ����ɣ����Բ������ȽϿ죡
	 * 
	 * 7.��ͳ��˵��LinkedList����ɾ�Ŀ�
     *          ArrayList����ѯ�죨�������Ĵ��ڣ�
	 * 
	 * *ArrayList���������췽����
	 * *public ArrayList(int initialCapacity)//����һ������ָ����ʼ�����Ŀ��б� 
	 * *public ArrayList()//����һ����ʼ����Ϊ10�Ŀ��б� 
	 * *public ArrayList(Collection<? extends E> c)//����һ������ָ�� collection ��Ԫ�ص��б� 
	 * 
	 * *Vector���ĸ����췽����
	 * *public Vector()//ʹ��ָ���ĳ�ʼ�����͵������������������һ���������� 
	 * *public Vector(int initialCapacity)//����һ����������ʹ���ڲ���������Ĵ�С�����׼��������Ϊ�㡣 
	 * *public Vector(Collection<? extends E> c)//����һ������ָ�� collection �е�Ԫ�ص����� 
	 * *public Vector(int initialCapacity,int capacityIncrement)//ʹ��ָ���ĳ�ʼ������������������һ���յ����� 
	 *---------------------------------------------------------------------------------------------------------------
	 * //ArrayList������Դ�룺 
  	 * *public boolean add(E e) { 
   	 * *	ensureCapacityInternal(size + 1); // Increments modCount!! 
     * *	elementData[size++] = e; 
     * *	return true; 
  	 * * } 
  	 * *private void ensureCapacityInternal(int minCapacity) { 
     * *	modCount++; 
     * *	// overflow-conscious code 
     * *	//������һ��Ԫ��֮���������Ĵ�С������������������ô���޷���ֵ�ˣ���Ҫ����ռ� 
     * *	if (minCapacity - elementData.length > 0) 
     * *		grow(minCapacity); 
  	 * *} 
  	 * *private void grow(int minCapacity) { 
     * *	// overflow-conscious code 
     * *	int oldCapacity = elementData.length; 
     * *	int newCapacity = oldCapacity + (oldCapacity >> 1); //����Ŀռ�����ԭ����50%������ԭ����1.5���� 
     * *	if (newCapacity - minCapacity < 0) //�����������֮���ǲ�������ô�ɴ�ֱ�ӽ�minCapacity��Ϊ�����Ĵ�С 
     * * 		newCapacity = minCapacity; 
     * *	if (newCapacity - MAX_ARRAY_SIZE > 0) //������������̫���˵Ļ�����ô��ִ��hugeCapacity 
     * *		newCapacity = hugeCapacity(minCapacity); 
     * *	// minCapacity is usually close to size, so this is a win: 
     * *	elementData = Arrays.copyOf(elementData, newCapacity); 
  	 * *} 
	 * --------------------------------------------------------------------------------------------------------------
	 *	//Vector������Դ��:
	 * *public synchronized boolean add(E e) { 
  	 * *	modCount++; 
  	 * *	ensureCapacityHelper(elementCount + 1); 
  	 * *	elementData[elementCount++] = e; 
  	 * *	return true; 
	 * *} 
	 * *private void ensureCapacityHelper(int minCapacity) { 
  	 * *	// overflow-conscious code 
  	 * *	if (minCapacity - elementData.length > 0) 
     * *		grow(minCapacity); 
	 * *} 
	 * *private void grow(int minCapacity) { 
  	 * *	// overflow-conscious code 
  	 * *	int oldCapacity = elementData.length; 
  	 * *	int newCapacity = oldCapacity+((capacityIncrement>0)?capacityIncrement:oldCapacity); 
	 * *
  	 * * //���������Ҫ�����жϣ��������������ʼ���Ĳ���0����ʹ�õ�public Vector(int initialCapacity,int capacityIncrement)���췽�����еĳ�ʼ����
  	 * * //��ô���ݵ�������(oldCapacity+capacityIncrement)������ԭ����������������������ֵ�����û����������������
  	 * * //��ô���ݺ����������(oldCapacity+oldCapacity)������ԭ�������Ķ����� 
  	 * *	if (newCapacity - minCapacity < 0) 
     * *		newCapacity = minCapacity; 
  	 * *	if (newCapacity - MAX_ARRAY_SIZE > 0) 
     * *		newCapacity = hugeCapacity(minCapacity); 
  	 * *	elementData = Arrays.copyOf(elementData, newCapacity); 
	 * *} 
	 * ----------------------------------------------------------------------------------------------------------------
	 * 
	 */
	
	
}
