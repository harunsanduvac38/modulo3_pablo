package threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Th06EcuacionSegundoGrado {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		double a = 1;
		double b = 1;
		double c = 2;
		
		// Calcular b^2
		CompletableFuture<Double> bCuadrado = CompletableFuture.supplyAsync(() -> {
			ThreadUtil.sleep(1000);
			System.out.println("Calculando b^2");
			return b * b;
		});
		
		// Calcular 4 * a * c
		CompletableFuture<Double> cuatroAC = CompletableFuture.supplyAsync(() ->{
			ThreadUtil.sleep(1000);
			System.out.println("Calculando 4ac");
			return 4 * a * c;
		});
		
		// Calcular el discriminante => b^2 - 4ac
		// A bCuadrado lo combinamos con cuatroAC. Esa operación se realizará cuando los dos hayan finalizado
		// Usar thenCombine y le pasaremos un BiFunction
		CompletableFuture<Double> discriminante = bCuadrado.thenCombine(cuatroAC, (b2,ac4) -> {
			ThreadUtil.sleep(1000);
			System.out.println("Calculando discriminante");
			return b2 - ac4;
		});
		
		// Calcular la raiz del discriminante
		// Si el discriminante es menor que 0, lanzamos una excepción
		CompletableFuture<Double> raizDiscriminante = discriminante.thenApply(d -> {
			ThreadUtil.sleep(1000);
			if(d < 0)
				throw new RuntimeException("Discriminante negativo: no hay raices reales");
			System.out.println("Calculando raiz del discriminante");
			return Math.sqrt(d);
		});
		
		// Calcular -b
		CompletableFuture<Double> menosB = CompletableFuture.supplyAsync(() -> {
			System.out.println("comienza a calcular -b");
			ThreadUtil.sleep(10000);
			System.out.println("Calculando -b");
			return -b;
		});
		
		// Calcular 2a
		CompletableFuture<Double> dosA = CompletableFuture.supplyAsync(() -> {
			ThreadUtil.sleep(750);
			System.out.println("Calculando 2a");
			return 2 * a;
		});
		
		// Calcular x1 (   (-b + raiz(discr) / 2a   )
		// combinar menosB con raizDiscriminante y al resultado (cuando termine) lo combinamos con dosA
		CompletableFuture<Double> x1 = menosB.thenCombine(raizDiscriminante, (mB, raiz) -> {
			ThreadUtil.sleep(500);
			System.out.println("Calculando x1");
			return mB + raiz;
		}).thenCombine(dosA, (num, dA) -> num / dA);
		
		// Calcular x2 (   (-b - raiz(discr) / 2a   )
		// combinar menosB con raizDiscriminante y al resultado (cuando termine) lo combinamos con dosA
		CompletableFuture<Double> x2 = menosB.thenCombine(raizDiscriminante, (mB, raiz) -> {
			ThreadUtil.sleep(500);
			System.out.println("Calculando x2");
			return mB - raiz;
		}).thenCombine(dosA, (num, dA) -> num / dA);
		
		System.out.println("x1 = " + x1.get());
		System.out.println("x2 = " + x2.get());
	}
}
