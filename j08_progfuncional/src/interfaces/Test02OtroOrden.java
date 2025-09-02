package interfaces;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Test02OtroOrden {
	public static void main(String[] args) {

//		Set<String> set = new TreeSet<String>(new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o2.length() - o1.length();
//			}
//		});	

//		Set<String> set = new TreeSet<String>((String o1, String o2) -> {
//			return o2.length() - o1.length();
//		});
		
		Set<String> set = new TreeSet<String>((o1, o2) -> o2.length() - o1.length());
		
		set.add("uno");
		set.add("dos");
		set.add("tres");
		set.add("cuatro");
		set.add("cinco");
		set.add("AS");
		set.add("ZAPATO");
		set.add("Ávila");
		set.add("ágil");
		
		set.forEach(s -> System.out.println(s));
		
		set.forEach(System.out::println);
		

	}
}
