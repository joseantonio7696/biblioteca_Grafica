package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import excepciones.CamposObligatorioException;
import excepciones.ContainsException;
import excepciones.IsbnException;
import modelo.Libro;

public class BibliotecaController {
	
	private List<Libro> listado=new ArrayList<Libro>();
	
	public BibliotecaController() throws IOException, NumberFormatException, CamposObligatorioException, IsbnException, ParseException {

		File file=new File("biblioteca.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		
		FileReader fr=new FileReader("biblioteca.txt");
		BufferedReader br=new BufferedReader(fr);
		
		String isbn;
		String titulo;
		String autor;
		String editorial;
		String fechaRegistro;
		String precio;
		String prestado;
		
		String [] datos=null;
		
		String linea="";
		
		while ((linea=br.readLine())!=null) {
			
			datos=linea.split(",");
			
			isbn=datos[0];
			titulo=datos[1];
			autor=datos[2];
			editorial=datos[3];
			fechaRegistro=datos[4];
			precio=datos[5];
			prestado=datos[6];
			
			Libro libro=new Libro(isbn, titulo, autor, editorial, fechaRegistro, precio, prestado);
			
			listado.add(libro);
			
			libro=null;
			
			
			
		}
		
		br.close();br=null;
		fr.close();fr=null;
		
		
	}
	
	
	public Libro agregarLibro(String isbn, String titulo, String autor, String editorial, String fechaRegistro, String precio, String prestado) throws NumberFormatException, CamposObligatorioException, IsbnException, ParseException, ContainsException {
		
		Libro libro=null;
		
		libro=new Libro(isbn, titulo, autor, editorial, fechaRegistro, precio, prestado);
		
		if (listado.contains(libro)) {
			throw new ContainsException();
		}else {
			listado.add(libro);
		}
		
		
		return libro;
	}
	
	public List<Libro> getLibros() {
		List<Libro> listadoLibros=new ArrayList<Libro>();
		
		listadoLibros=listado;
		
		if (listadoLibros.size()==0) {
			listadoLibros=null;
		}
		
		return listadoLibros;
		
	}
	
	public void borrarLibro(String isbn) {
		
		
		for (Libro libro : listado) {
			
			if (libro.getIsbn().equals(isbn)) {
				
				listado.remove(libro);
				
			}
		}
		
	}
	
	public List<Libro> filtradoAutor(String autor){
		
		List<Libro> filtrado=new ArrayList<Libro>();
		
		
		for (Libro libro : listado) {
			if (libro.getAutor().equals(autor)) {
				filtrado.add(libro);
			}
		}
		
		if (filtrado.size()==0) {
			filtrado=null;
		}
		
		
		return filtrado;
		
		
	}
	
	public List<Libro> filtradoPrecio(String precio){
		
		List<Libro> filtrado=new ArrayList<Libro>();
		
		
		for (Libro libro : listado) {
			if (libro.getPrecio()==Double.parseDouble(precio)) {
				filtrado.add(libro);
			}
		}
		
		if (filtrado.size()==0) {
			filtrado=null;
		}
		
		
		return filtrado;
		
		
	}
	
	public List<Libro> filtradoEditorial(String editorial){
		
		List<Libro> filtrado=new ArrayList<Libro>();
		
		
		for (Libro libro : listado) {
			if (libro.getEditorial().equals(editorial)) {
				filtrado.add(libro);
			}
		}
		
		if (filtrado.size()==0) {
			filtrado=null;
		}
		
		
		return filtrado;
		
		
	}
	
	
	
	public Libro buscarLibro(String isbn){
		
		Libro libro=null;
		
		for (Libro libro2 : listado) {
			
			if (libro2.getIsbn().equals(isbn)) {
				libro=libro2;
			}
			
		}
		
		return libro;
	}
	
public Libro editarLibro(String isbn,String isbn2, String titulo, String autor, String editorial, String fechaRegistro, String precio, String prestado) throws NumberFormatException, CamposObligatorioException, IsbnException, ParseException {
		
		
		Libro libro=null;
		
		libro=buscarLibro(isbn);
		
		if (!libro.getIsbn().equals(isbn2)) {
			libro.setIsbn(isbn2);
		}
		if (!libro.getTitulo().equals(titulo)) {
			libro.setTitulo(titulo);
		}
		if (!libro.getAutor().equals(autor)) {
			libro.setAutor(autor);
		}
		if (!libro.getEditorial().equals(editorial)) {
			libro.setEditorial(editorial);
		}
		if (!libro.getFechaRegistro().equals(fechaRegistro)) {
			libro.setFechaRegistro(fechaRegistro);
		}
		if (libro.getPrecio()!=(Double.parseDouble(precio))) {
			libro.setPrecio(precio);
		}
		if (libro.isPrestado()!=(Boolean.parseBoolean(prestado))) {
			libro.setPrestado(prestado);
		}
		
		
		return libro;
	}


	public void guardarDatos() throws IOException {
		
		FileWriter fw=new FileWriter("biblioteca.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		
		for (Libro libro : listado) {
			
			bw.write(libro.toString());
			bw.newLine();
			
		}
		
		bw.close();bw=null;
		fw.close();fw=null;
		
		
	}
	
	public void borrarDatos(String isbn) {
		
		for (Libro libro : listado) {
			
			if (libro.getIsbn().equals(isbn)) {
				listado.remove(libro);
				break;
			}
				
			}
		
		
	}
	

	public List<Libro> getListado() {
		
		return listado;
	}
	
	

}
