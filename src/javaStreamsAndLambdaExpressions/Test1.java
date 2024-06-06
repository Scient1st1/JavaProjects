package javaStreamsAndLambdaExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class Test1 {
//	count the number of names starting with "a"
	
	
//	@Test
//	public static  void main(String[] args) {
//		ArrayList<String> names = new ArrayList<String>();
//		names.add("Anna");
//		names.add("Adam");
//		names.add("Levan");
//		names.add("Gabriel");
//		names.add("Someone");
//		int count = 0;
//		for(int i =0; i<names.size(); i++) {
//			String actualName =  names.get(i);
//			
//			if(actualName.startsWith("A")) {
//				count++;
//			}
//		}
//		System.out.println(count);
//
//	}
	
//	@Test2 with streams 
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Anna");
		names.add("Adam");
		names.add("Levan");
		names.add("Gabriel");
		names.add("Someone");
		
		ArrayList<String> names1 = new ArrayList<String>();
		names1.add("Nona");
		names1.add("Fridoni");
		
		
//		count with stream
		Long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
//		print all the names from arrayList
		
		names.stream().filter(s->s.length() > 4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
//		manipulate stream and print every name which has last letter a to uppercase
		names.stream().filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
//		print every name starts with a to uppercase and sorted 
		names.stream().filter(s-> s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		
//		merge two array into one 
		Stream<String> newStream =  Stream.concat(names.stream(), names1.stream());
//		newStream.sorted().forEach(s->System.out.println(s));
		boolean flag = newStream.anyMatch(s-> s.equalsIgnoreCase("Adam"));
		Assert.assertTrue(flag);
		
		
//		@TEST 3 stream collect
		List<String> ls = names.stream().filter(s-> s.startsWith("A")).sorted().map(s->s.toUpperCase()).collect(Collectors.toList());
		ls.get(0);
		
		
		List<Integer> vals = Arrays.asList(3,2,2,7,5,1,9,7);
//		print uniques and sort vals - give 3rd index;
		vals.stream().distinct().forEach(item->System.out.println(item));
		List<Integer> v = vals.stream().distinct().sorted().collect(Collectors.toList());
		v.get(2);
	}
	
}
