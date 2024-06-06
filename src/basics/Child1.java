package basics;

import org.testng.annotations.Test;

public class Child1 extends Parent {

	@Test
	public void testRun() {
//		access via extends or creating new class instance 
		Child2 ch2 = new Child2(3);
		int a = 3;
		doThis(); //from parent class via extends;
		System.out.println(ch2.increment());
		System.out.println(ch2.decrement());
		
//		Child3 ch3 = new Child3(3);
		System.out.println(ch2.multiplyByTwo());
		
	}

	
	
	
	
}
