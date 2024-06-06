package basics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicsAgain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList<String> a = new ArrayList<String>();
//		a.add("string1");
//		a.add("string2");
//		System.out.println(a.get(1));
//		
//		for(int i = 0; i<a.size(); i++) {
//			System.out.println(a.get(i));
//		}
//		for(String val: a) {
//			System.out.println(val);
//		}
//		System.out.println(a.contains("string2"));
		
//		String[] name  = {"Levan", "Gabriel"};
//		List<String> namesList = Arrays.asList(name);
//		
		
//		strings
//		
//		String s = "Levan"; //literal
//		String s2 = new String("Tchumburidze tch"); //new keyword
//		String[] arr = s2.split(" ");
//		System.out.println(arr);
//		
//		for(int i = s.length()-1; i>=0; i--) {
//			System.out.println(s.charAt(i));
//		}
//		
		
//		BasicsAgain demo = new BasicsAgain();
//		demo.getData();
//		String name = demo.getData();
//		System.out.println(name);
		MethodsDemo2 demo2 = new MethodsDemo2();
		String name = demo2.getData();
		System.out.println(name);
		
		String name1 = getData(); //static class level
		System.out.println(name1);
	}
	
	public static String getData() {
//		System.out.println("hello world");
		return "levan tchumburidze";
	}

}
