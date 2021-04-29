package excepciones;

public class CamposObligatorioException extends Exception{

	public String getMessage() {
		
		return "EL CAMPO NO PUEDE ESTAR VACIO";
	}

}
