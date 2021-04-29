package excepciones;

public class CamposObligatorioException extends Exception{

	public CamposObligatorioException(String campo) {
		super("EL "+campo+" NO PUEDE ESTAR VACIO");
	}

}
