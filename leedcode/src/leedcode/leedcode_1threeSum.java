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
		//设置初始值
		int[] nums=new int[]{-13,-5,-3,2,7,11,13,17}; 	//例子数据
		
//		int[][] aaa = new int[10][3];
		//方法一
		int[][] result=leed1.threeSum_1(nums);
		System.out.println("方法一:"+result[0][0]+","+result[0][1]+","+result[0][2]);
/*		//方法二
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
	 * 思路:3数和为0,则至少有一个值为负数
	 * 依次取数列的第一个数,循环取后面的两数和判断是否有符合条件的值
	 * 一次之后去掉数列的第一个数,再次循环,直到数列的第一个数大于等于0
	 * 20180827
	 */  
	public int[][] threeSum_1(int[] nums) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int[][] result=new int[10][3]; 			 //初始化为默认值,int型为0
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
    		map.remove(check);//删除map中的无用数据

    	}
    	System.out.println("方法一执行:"+times+"次");
		return result; 
    }
	/**
	 * break 和  continue的区别
	 * break的作用是跳出当前循环块（for、while、do while）或程序块（switch）。在循环块中的作用是跳出当前正在循环的循环体。在程序块中的作用是中断和下一个case条件的比较。
	 * continue用于结束循环体中其后语句的执行，并跳回循环程序块的开头执行下一次循环，而不是立刻中断该循环体。
	 */
	
	/**
	 * Java中Vector和ArrayList的区别
	 * 相同点：
	 * 1.ArrayList是最常用的List实现类，内部是通过数组实现的，它允许对元素进行快速随机访问。数组的缺点是每个元素之间不能有间隔，
	 * 当数组大小不满足时需要增加存储能力，就要讲已经有数组的数据复制到新的存储空间中。当从ArrayList的中间位置插入或者删除元素时，
	 * 需要对数组进行复制、移动、代价比较高。因此，它适合随机查找和遍历，不适合插入和删除。
	 * 
	 * 2.Vector与ArrayList一样，也是通过数组实现的，不同的是它支持线程的同步，即某一时刻只有一个线程能够写Vector，
	 * 避免多线程同时写而引起的不一致性，但实现同步需要很高的花费，因此，访问它比访问ArrayList慢。
	 * 
	 * 3.LinkedList是用链表结构存储数据的，很适合数据的动态插入和删除，随机访问和遍历速度比较慢。另外，他还提供了List接口中没有定义的方法，
	 * 专门用于操作表头和表尾元素，可以当作堆栈、队列和双向队列使用。
	 * 
	 * 4.vector是线程（Thread）同步（Synchronized）的，所以它也是线程安全的，而Arraylist是线程异步（ASynchronized）的，
	 * 是不安全的。如果不考虑到线程的安全因素，一般用Arraylist效率比较高。
	 * 
	 * 5.如果集合中的元素的数目大于目前集合数组的长度时，vector增长率为目前数组长度的100%,而arraylist增长率为目前数组长度
	 * 的50%.如过在集合中使用数据量比较大的数据，用vector有一定的优势。
	 * 
	 * 6.如果查找一个指定位置的数据，vector和arraylist使用的时间是相同的，都是0(1),这个时候使用vector和arraylist都可以。而
	 * 如果移动一个指定位置的数据花费的时间为0(n-i)n为总长度，这个时候就应该考虑到使用Linkedlist,因为它移动一个指定位置的数据
	 * 所花费的时间为0(1),而查询一个指定位置的数据时花费的时间为0(i)。
	 * ArrayList 和Vector是采用数组方式存储数据，此数组元素数大于实际存储的数据以便增加和插入元素，
	 * 都允许直接序号索引元素，但是插入数据要设计到数组元素移动 等内存操作，所以索引数据快插入数据慢，
	 * Vector由于使用了synchronized方法（线程安全）所以性能上比ArrayList要差
	 * ，LinkedList使用双向链表实现存储，按序号索引数据需要进行向前或向后遍历，但是插入数据时只需要记录本项的前后项即可，所以插入数度较快！
	 * 
	 * 7.笼统来说：LinkedList：增删改快
     *          ArrayList：查询快（有索引的存在）
	 * 
	 * *ArrayList有三个构造方法：
	 * *public ArrayList(int initialCapacity)//构造一个具有指定初始容量的空列表。 
	 * *public ArrayList()//构造一个初始容量为10的空列表。 
	 * *public ArrayList(Collection<? extends E> c)//构造一个包含指定 collection 的元素的列表 
	 * 
	 * *Vector有四个构造方法：
	 * *public Vector()//使用指定的初始容量和等于零的容量增量构造一个空向量。 
	 * *public Vector(int initialCapacity)//构造一个空向量，使其内部数据数组的大小，其标准容量增量为零。 
	 * *public Vector(Collection<? extends E> c)//构造一个包含指定 collection 中的元素的向量 
	 * *public Vector(int initialCapacity,int capacityIncrement)//使用指定的初始容量和容量增量构造一个空的向量 
	 *---------------------------------------------------------------------------------------------------------------
	 * //ArrayList类的添加源码： 
  	 * *public boolean add(E e) { 
   	 * *	ensureCapacityInternal(size + 1); // Increments modCount!! 
     * *	elementData[size++] = e; 
     * *	return true; 
  	 * * } 
  	 * *private void ensureCapacityInternal(int minCapacity) { 
     * *	modCount++; 
     * *	// overflow-conscious code 
     * *	//如果添加一个元素之后，新容器的大小大于容器的容量，那么就无法存值了，需要扩充空间 
     * *	if (minCapacity - elementData.length > 0) 
     * *		grow(minCapacity); 
  	 * *} 
  	 * *private void grow(int minCapacity) { 
     * *	// overflow-conscious code 
     * *	int oldCapacity = elementData.length; 
     * *	int newCapacity = oldCapacity + (oldCapacity >> 1); //扩充的空间增加原来的50%（即是原来的1.5倍） 
     * *	if (newCapacity - minCapacity < 0) //如果容器扩容之后还是不够，那么干脆直接将minCapacity设为容器的大小 
     * * 		newCapacity = minCapacity; 
     * *	if (newCapacity - MAX_ARRAY_SIZE > 0) //如果扩充的容器太大了的话，那么就执行hugeCapacity 
     * *		newCapacity = hugeCapacity(minCapacity); 
     * *	// minCapacity is usually close to size, so this is a win: 
     * *	elementData = Arrays.copyOf(elementData, newCapacity); 
  	 * *} 
	 * --------------------------------------------------------------------------------------------------------------
	 *	//Vector类的添加源码:
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
  	 * * //这个扩容需要做个判断：如果容量增量初始化的不是0，即使用的public Vector(int initialCapacity,int capacityIncrement)构造方法进行的初始化，
  	 * * //那么扩容的容量是(oldCapacity+capacityIncrement)，就是原来的容量加上容量增量的值；如果没有设置容量增量，
  	 * * //那么扩容后的容量就是(oldCapacity+oldCapacity)，就是原来容量的二倍。 
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
