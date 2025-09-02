package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class E02LecturaTeclado {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		int edad = 0;
		System.out.print("Ingresa tu edad: ");
		try {
			edad = tec.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("torpe!!!!");
		};
		
		System.out.println(edad);
	}
}
