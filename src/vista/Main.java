package vista;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import controlador.BibliotecaController;
import excepciones.CamposObligatorioException;
import excepciones.IsbnException;
import modelo.Libro;

public class Main {

	public static void main(String[] args) {
		
		/*
		String isbn="978-84-8130-252-3";
		String titulo="El Capitan AlaTriste";
		String autor="Arturo Perez Reverte";
		String editorial="Alfaguara";
		String fechaRegistro="2020-2-05";
		String precio="30";
		String prestado="false";
		
		
		try {
			Libro libro=new Libro(isbn, titulo, autor, editorial, fechaRegistro, precio, prestado);
			
			//System.out.println(libro);
		} catch (NumberFormatException | CamposObligatorioException | IsbnException | ParseException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		
		BibliotecaController bibliotecaController=null;
		List<Libro> listadoLibros=new ArrayList<Libro>();
		
		try {
			bibliotecaController=new BibliotecaController();
			listadoLibros=bibliotecaController.getListado();
			
		} catch (NumberFormatException | IOException | CamposObligatorioException | IsbnException | ParseException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		*/
		
		try {
			Formulario frmFormulario=new Formulario();
		} catch (NumberFormatException | IOException | CamposObligatorioException | IsbnException | ParseException e) {
			// TODO Auto-generated catch block
			
		}
		
		
	}

}
