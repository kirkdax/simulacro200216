package diccionario;

public interface DiccionarioInterface {

	
	// Punto 1 ---------------------------------------------------------------------------------------------------
	
	/**
	 * Men�. Ejercicio 1
	 * M�todo que insertar una entrada en el diccionario
	 * @param e (Entrada)
	 * @throws Exception el diccionario est� lleno
	 * @throws Exception La entrada ya existe
	 */
	public void nuevaEntrada(Entrada e) throws Exception;
	
	/**
	 * M�todo que comprueba si la palabra espa�ola o inglesa ya existen en el diccionario.
	 * M�todo de apoyo para nuevaEntrada()
	 * @param e (Entrada)
	 * @return boolean (True si la palabra espa�ola o inglesa existen)
	 */
	public boolean entradaExiste(Entrada e);
	
	
	
	// Punto 2 ---------------------------------------------------------------------------------------------------

	/**
	 * Men�. Ejercicio 2
	 * M�todo que solicita una palabra y devuelve la traducci�n 
	 * @param idioma (int)
	 * @param palabraTraducir (String)
	 * @return palabraTraducida (String)
	 * @throws Exception idioma seleccionado incorrecto
	 */
	public String consultarDiccionario(int idioma, String palabraTraducir) throws Exception;

	/**
	 * M�todo que comprueba si la palabra espa�ola existe, si es as� devuelve la traducci�n (palabra inglesa).
	 * M�todo de apoyo para consultarDiccionario()
	 * @param palabraEspanola (String)
	 * @return palabraInglesa (String)
	 * @throws Exception La palabra espa�ola a traducir no existe
	 */
	public String traducirPalabraEspanola(String palabraEspanola) throws Exception;
	
	/**
	 * M�todo que comprueba si la palabra ingles existe, si es as� devuelve la traducci�n (palabra espa�ola).
	 * M�todo de apoyo para consultarDiccionario()
	 * @param palabraInglesa (String)
	 * @return palabraEspanola (String)
	 * @throws Exception Exception La palabra inglesa a traducir no existe
	 */
	public String traducirPalabraInglesa(String palabraInglesa) throws Exception;
	
	
	
	// Punto 3 ---------------------------------------------------------------------------------------------------

	/**
	 * Men�. Ejercicio 3
	 * M�todo que devuelve el listado de palabras que empiezan por la letra introducida
	 * @param letra (char)
	 * @return String
	 * @throws Exception No hay palabras que empiecen por la letra introducida
	 */
	public String entradasEmpiezanPorLetra(char letra) throws Exception;
	
	
	
	// Punto 4 ---------------------------------------------------------------------------------------------------

	/**
	 * Men�. Ejercicio 4
	 * M�todo que devuelve el n�mero de consultas realizadas
	 * @return n�mero de consultas (int)
	 * @throws Exception No se han realizado consultas
	 */
	public int numeroConsultas() throws Exception;
	
	
	
	// Punto 5 ---------------------------------------------------------------------------------------------------

	/**
	 * Men�. Ejercicio 5
	 * M�todo que muestra el diccionario en orden alfab�tico por las palabras en espa�ol.
	 * @return String
	 * @throws Exception No existen palabras en el diccionario
	 */
	public String mostrarDiccionarioEspanol() throws Exception;
	
	
	
	// Punto 6 ---------------------------------------------------------------------------------------------------

	/**
	 * Men�. Ejercicio 6
	 * M�todo que muestra el diccionario en orden alfab�tico por las palabras en ingl�s.
	 * @return String
	 * @throws Exception No existen palabras en el diccionario
	 */
	public String mostrarDiccionarioIngles() throws Exception;



	
}
