package excepciones;

import java.io.FileNotFoundException;
import java.io.IOException;

public class E04 {
	public static void main(String[] args) throws Exception {
		try {
			otroProblematico(33);
			System.out.println("Esto cuando se ejecuta????");			
//			return;
		} finally {
			System.out.println("Esto si o si debe ejecutarse");			
		}
		
	}
	
	//arregla problemas de file notfound pero no sabe como arreglar ioexception
	//ni caso a las Runtime
	public static void metodo1() throws IOException {
		try {
			otroProblematico(0);
		} catch (FileNotFoundException e) {
			// arreglo filenot found;
		}		
	}
	
	public static void metodo2() {
		try {
			otroProblematico(0);
		} catch (FileNotFoundException e) {
			//arregla filenotf
		} catch (IOException e) {
			// arregla ioe
		} catch (ArrayIndexOutOfBoundsException e) {
			// arregla arrayindex
		} catch (RuntimeException e) {
			// arregla runtime
		}
	}
	
	public static void metodo3() {
		try {
			otroProblematico(0);
		} catch (Exception e) {
			//arregla cualquier excepción CUIDADO!!!
		}
	}
	
	public static void metodo4() {
		try {
			otroProblematico(0);
		} catch(ArrayIndexOutOfBoundsException | FileNotFoundException e) {
			//arregla array o fileno
		} catch (RuntimeException | IOException e){
			//arregla runtime o ioe
		}
	}
	
	public static void otroProblematico(int num) throws FileNotFoundException, IOException {
		switch(num) {
		case 1:
			throw new ArrayIndexOutOfBoundsException();
		case 2:
			throw new RuntimeException();
		case 3:
			throw new FileNotFoundException();
		case 4:
			throw new IOException();
		}
	}
}
