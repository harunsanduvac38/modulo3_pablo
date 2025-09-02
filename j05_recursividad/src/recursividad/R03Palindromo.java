package recursividad;

public class R03Palindromo {

	private static boolean esPalindromoRec(String cad) {
		if(cad.length() <= 1)
			return true;
		int ultimo = cad.length() - 1;
		return cad.charAt(0) == cad.charAt(ultimo) && esPalindromoRec(cad.substring(1, ultimo));
	}
	
	public static boolean esPalindromo(String cad) {
		cad = prepara(cad);
		return esPalindromoRec(cad);
	}
	
	public static boolean esPalindromoIt(String cad) {
		cad = prepara(cad);
		boolean esPalindromo = true;
		int i = 0, d = cad.length() - 1;
		while(esPalindromo && i < d) {
			if(cad.charAt(i++) != cad.charAt(d--))
				esPalindromo = false;
		}
		return esPalindromo;
	}
	
	public static boolean esPalindromoIt2(String cad) {
		cad = prepara(cad);
		boolean esPalindromo = true;
		
		for(int i = 0, d = cad.length() - 1; i < d && esPalindromo; i++, d--) {
			if(cad.charAt(i) != cad.charAt(d))
				esPalindromo = false;
		}
		return esPalindromo;
	}
	
	private static String prepara(String cad) {
		return cad.toLowerCase().replace(" ", "");
	}
	
	public static void main(String[] args) {
		System.out.println(esPalindromo("hola"));
		System.out.println(esPalindromo("ala"));
		System.out.println(esPalindromo("eme"));
		System.out.println(esPalindromo("erre"));
		System.out.println();
		
		System.out.println(esPalindromoIt("hola"));
		System.out.println(esPalindromoIt("ala"));
		System.out.println(esPalindromoIt("eme"));
		System.out.println(esPalindromoIt("erre"));
		System.out.println();
		
		System.out.println(esPalindromoIt2("hola"));
		System.out.println(esPalindromoIt2("ala"));
		System.out.println(esPalindromoIt2("eme"));
		System.out.println(esPalindromoIt2("erre"));
		System.out.println();
		
		System.out.println(esPalindromoIt("Dabale arroz a la zorra el Abad"));
		System.out.println(esPalindromoIt2("Dabale arroz a la zorra el Abad"));
	}
}
