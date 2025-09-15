package main;

import presentacion.BancoVista;
import presentacion.BancoVistaInterface;

public class A01_MainAplicacion {
	public static void main(String[] args) {
		BancoVistaInterface bancoVista = new BancoVista();
		bancoVista.iniciarAplicacion();
	}
}
