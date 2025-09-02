package sets;

import java.util.Comparator;

public class Test03PruebaComparator {
	public static void main(String[] args) {
		Comparator<String> comp = new StringComparatorCantLetras();
		
		System.out.println(comp.compare("un string largo", "uno muy pero muy largo"));
		System.out.println("un string largo".compareTo(" este uno muy pero muy largo"));
	}
}
