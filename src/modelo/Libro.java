package modelo;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import excepciones.CamposObligatorioException;
import excepciones.IsbnException;

public class Libro {

	private String isbn,titulo,autor,editorial;
	private java.sql.Date fechaRegistro;
	private double precio;
	private boolean prestado;
	
	public Libro() {
		
		this.isbn=null;
		this.titulo=null;
		this.autor=null;
		this.editorial=null;
		this.fechaRegistro=null;
		this.precio=0;
		this.prestado=false;
	}
	
	




	public Libro(String isbn, String titulo, String autor, String editorial, String fechaRegistro, String precio,
			String prestado) throws NumberFormatException, CamposObligatorioException, IsbnException, ParseException {
		super();
		this.setIsbn(isbn);
		this.setTitulo(titulo);
		this.setAutor(autor);
		this.setEditorial(editorial);
		this.setFechaRegistro(fechaRegistro);
		this.setPrecio(precio);
		this.setPrestado(prestado);
		
		
	}






	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) throws CamposObligatorioException, IsbnException,NumberFormatException {

		String isbnNumericoSinGuion= isbn.replaceAll("-","");
		if (isbn.equals("")) {
			throw new CamposObligatorioException();
		}else if (isbnNumericoSinGuion.length()!=13) {
			throw new IsbnException();
		}else {
			
			
			String isbnNumerico= isbnNumericoSinGuion.substring(0,12);
			int DC=Integer.parseInt(Character.toString(isbnNumericoSinGuion.charAt(12)));
			
			int suma=0;
			boolean impar=true;
			
			for (int x = 0; x < isbnNumerico.length(); x++) {
				
				if (impar) {
					suma+=Integer.parseInt(Character.toString(isbnNumerico.charAt(x)))*1;
					impar=false;
				}else {
					suma+=Integer.parseInt(Character.toString(isbnNumerico.charAt(x)))*3;
					impar=true;
				}
				
			}
			
			int resto=suma%10;
			
			int dc=10-resto;
			
			if (dc==10) {
				dc=0;
			}
			
			if (dc==DC) {
				this.isbn = isbn;
			}else {
				throw new IsbnException();
			}
			
			
		}
		
		
		
		
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws CamposObligatorioException {
		
		if (titulo.equals("")) {
			throw new CamposObligatorioException();
		}
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) throws CamposObligatorioException {
		if (autor.equals("")) {
			throw new CamposObligatorioException();
		}
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) throws CamposObligatorioException {
		if (editorial.equals("")) {
			throw new CamposObligatorioException();
		}
		this.editorial = editorial;
	}

	public java.sql.Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) throws ParseException, CamposObligatorioException {
		if (fechaRegistro.equals("")) {
			throw new CamposObligatorioException();
		}
		
		
		java.util.Date fechaUtil;
		
		SimpleDateFormat formateador=new SimpleDateFormat("yyyy-MM-dd");
		formateador.setLenient(false);
		
		fechaUtil=formateador.parse(fechaRegistro);
		
		this.fechaRegistro = new java.sql.Date(fechaUtil.getTime());
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) throws NumberFormatException, CamposObligatorioException{
		if (precio.equals("")) {
			throw new CamposObligatorioException();
		}
		
		double precio2=Double.parseDouble(precio);
		this.precio = precio2;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(String prestado) throws CamposObligatorioException {
		if (prestado.equals("")) {
			throw new CamposObligatorioException();
		}
		
		boolean prestado2=Boolean.parseBoolean(prestado);
		
		this.prestado = prestado2;
	}
	
	
	

	@Override
	public String toString() {
		return isbn + "," + titulo + "," + autor + "," + editorial
				+ "," + fechaRegistro + "," + precio + "," + prestado;
	}






	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

}
