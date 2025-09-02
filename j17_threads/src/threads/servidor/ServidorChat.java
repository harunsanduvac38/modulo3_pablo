package threads.servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.DateFormatter;

public class ServidorChat {

	private int puerto;
	
	public ServidorChat(int puerto) {
		this.puerto = puerto;
	}
	
	public void start() {
		
		System.out.println("Servidor esperando conexiones");
		try(ServerSocket server = new ServerSocket(puerto)){
			
			while(true) {
				Socket cliente = server.accept();
				new AtiendeCliente(cliente);
			}
			
		} catch (IOException e) {
			System.err.println("No se puede abrir el puerto " + puerto);
		}
	}
	
	private class AtiendeCliente implements Runnable{

		private Socket socket;
		private String user;
		private PrintWriter out;
		
		private static int cant;		
		private static Map<String, AtiendeCliente> sala = new HashMap<>();
		
		public AtiendeCliente(Socket socket) {
			this.socket = socket;
			new Thread(this).start();
		}
		
		@Override
		public void run() {
			
			log("Nuevo cliente conectado");
			
			try(PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
				
				this.out = out;
				
				out.println("Bienvenido al NUEVO GUASÁ!!!");
				
				out.println("Por favor identifícate");
				user = in.readLine();
				user = user.replaceAll(" ", "_");
				
				while(sala.containsKey(user) || user.length() == 0) {
					out.println("El usuario es incorrecto o ya existe");
					out.println("Ingresa tu usuario");
					user = in.readLine();
					user = user.replaceAll(" ", "_");
				}
				
				out.println(user + " ya estas en la sala");
				help();
				sala.put(user, this);
				cant++;
				log(user + " se ha conectado");
				log("Hay " + cant + " usuarios en la sala");
				difusion("SRV: " + user + " se ha conectado");
				
				
				String linea;
				boolean sesion = true;
				while (sesion && (linea = in.readLine()) != null) {
					
					if(linea.length() > 0 && linea.charAt(0) == '@') { //mensaje privado
						if(linea.contains(" ")) {
							String usrDestino = linea.substring(1, linea.indexOf(" "));
							String mensaje = linea.substring(linea.indexOf(" ") + 1);
							if(sala.containsKey(usrDestino)) {
								sala.get(usrDestino).out.println("PRIVADO DE " + user + ": " + mensaje);
							} else {
								out.println(usrDestino + " no está conectado");
							}
						}else {
							out.println("Formato incorrecto. No se ha enviado mensaje");
						}
					} else {  // no es un mensaje privado
						switch(linea.toLowerCase()) {
							case "-w", "-who":
								for(String usr : sala.keySet()) {
									out.println("SRV: " + usr);
								}
								break;
							case "-h", "-help":
								help();
								break;
							case "-q", "-quit":
								out.println("SRV: " + "Hasta la vista Baby!!!");
								sala.remove(user);
								cant--;
								difusion("SRV: " + user + " se ha desconectado");
								log(user + " se ha desconectado");
								sesion = false;
								socket.close();
								break;
							default:
								difusion(user + ": " + linea);
						}
					}								
				}			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		private void log(String mje) {
			System.out.println(now() + " - " + mje);
		}
		
		private String now() {
			LocalDateTime ahora = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
			return dtf.format(ahora);
		}
		
		private void difusion(String mje) {
			for (AtiendeCliente cli : sala.values()) {
				cli.out.println(mje);
			}
		}
		
		private void help() {
			out.println("---------------------------------------------");
			out.println(" Ayuda del Guasá");
			out.println("---------------------------------------------");
			out.println(" -q: terminar sesion");
			out.println(" -h: mostrar esta ayuda");
			out.println(" -w: consultar usuarios");
			out.println(" @Usuario mensaje: para mensajes privados");
			out.println("---------------------------------------------");
		}
	}
	
	public static void main(String[] args) {
		new ServidorChat(1234).start();
	}
}
