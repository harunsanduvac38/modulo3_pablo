package arrays;

public class PruebaParametroArray {

	public static void otroMetodo(String algo, String otro, int... nums) {
		
	}

	
	public static int suma(int... nums) {
		var suma = 0;
		for (var i = 0; i < nums.length; i++) {
			suma += nums[i];
		}
		return suma;
	}
	
	
	public static void main(String[] args) {
		System.out.println(suma(17, 25));
		System.out.println(suma(17, 25, 44));
		
		int[] numeritos = {1,5,4,7,8};
		var otrosNumeritos = new int[10];
		
		System.out.println(suma(numeritos));
	}
}
