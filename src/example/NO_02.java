package example;

import org.omg.CORBA.StringHolder;

/**
 * 单例模式
 * @author acqierement
 * Data: 2018年11月16日
 * Time: 下午8:40:40
 */
public class NO_02 {
	/*
	 * 不好的解法一：懒汉式，线程不安全
	 */
	public static class Singleton1{
		private Singleton1() {	
			
		}
		
		private static Singleton1 instance = null;
		
		public static Singleton1 getInstance() {
			if(instance != null) {
				instance = new Singleton1();
			}
			return instance;
		}
		
	}
	/*
	 * 不好的解法二：线程安全，但效率不高
	 * 在前面的基础上加了synchronized，但是每次调用getinstance都要有加锁的操作。
	 */
	public static class Singleton2{
		private Singleton2() {	
			
		}
		private static Singleton2 instance = null;
		
		public static synchronized Singleton2 getInstance() {
			if (instance == null) {
				instance = new Singleton2();
			}
			return instance;
		}
	}
	
	/*
	 * 可行的解法：双检锁,线程安全。在前面的基础上，在synchronized前面加个判断，避免进入不必要的加锁操作。
	 */
	public static class Singleton3{
		private Singleton3() {	
			
		}
		
		private static Singleton3 instance = null;
		
		public static Singleton3 getInstance() {
			if (instance == null) {
				synchronized (Singleton3.class) {
					if (instance == null) {
						instance = new Singleton3();						
					}
				}
			}
			return instance;
		}
	}
	
	/*
	 * 推荐的解法：饿汉式，线程安全，执行效率高，
	 * 但是一旦有其他情况，在第一次用到Singleton4的时候，
	 * 就会初始化instance，过早的创建实例，降低内存的使用效率。
	 */
	public static class Singleton4{
		private Singleton4() {	
			
		}
		private static Singleton4 instance = new Singleton4();
		
		public static Singleton4 getInstance() {
			return instance;
		}
	}
	
	/*
	 * 推荐的解法：静态内部类，按需创建实例，线程安全
	 * 弥补前面饿汉式的缺点，当Singleton5被装载了，instance也不一定会实例化。
	 * 因为SingletonHolder类没有主动使用。
	 */
	public static class Singleton5{
		private Singleton5() {	
			
		}
		
		private static class SingletonHolder{
			private static final Singleton5 INSTANCE = new Singleton5();
		}
		
		public static final Singleton5 getInstance() {
			return SingletonHolder.INSTANCE;
		}
	}
	
	/*
	 * 用枚举的方式实现。实现单例模式的最佳方法。它更简洁，线程安全，自动支持序列化机制，
	 * 防止反序列化重新创建新的对象，绝对防止多次实例化
	 */
	public enum Singleton6 {
		INSTANCE;
	    public void whateverMethod() {  
	    	
	    }  
	}

}
