package recursividad;

public class R07_08CambioBase {

	
	public static String toBinaryString(int num) {
		if (num < 2)
			return num + "";
		return toBinaryString(num / 2) + (num % 2);
	}
	
	public static String toHexString(int num) {
		if (num < 16)
			return toDigitoHexString(num);
		return toHexString(num / 16) + toDigitoHexString(num % 16);
	}
	
	
	private static String toDigitoHexString(int num){
		if (num < 10)
			return num + "";
		return "" + (char)('A' + num - 10);
	}
	
	
	public static void main(String[] args) {
		System.out.println(toBinaryString(2));
		System.out.println(toBinaryString(1678));
		System.out.println(Integer.toBinaryString(1678));

		System.out.println(toHexString(16548));
		System.out.println(Integer.toHexString(16548));
	}
}
