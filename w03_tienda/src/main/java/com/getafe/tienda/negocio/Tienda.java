package com.getafe.tienda.negocio;

import java.util.Set;

import com.getafe.tienda.modelo.Producto;

public interface Tienda {

	/**
	 * Devuelve todos los productos ordenados por su descripción
	 * @return Un Set de productos ordenados
	 */
	Set<Producto> getProductos();
	
	/**
	 * Devuelve los productos que contienen descripcion ordenados por su descripción
	 * @param descripcion Descripcion de los productos a buscar
	 * @return Un Set de productos ordenados
	 */
	Set<Producto> getProductos(String descripcion);
}
