package basics;

public class Child2 extends Child3 {
	int a;
	
//	use constructor;
	
	public Child2(int a) { //<-- constructor
		super(a);
		this.a = a;
	}
	public int increment() {
		a= a+1;
		return a;
	}
	public int decrement() {
		a=a-1;
		return a;
	}

}
