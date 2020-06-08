package diccionario;

public interface DiccionarioInterface {

	
	// Punto 1 ---------------------------------------------------------------------------------------------------
	
	/**
	 * Menú. Ejercicio 1
	 * Método que insertar una entrada en el diccionario
	 * @param e (Entrada)
	 * @throws Exception el diccionario está lleno
	 * @throws Exception La entrada ya existe
	 */
	public void nuevaEntrada(Entrada e) throws Exception;
	
	/**
	 * Método que comprueba si la palabra española o inglesa ya existen en el diccionario.
	 * Método de apoyo para nuevaEntrada()
	 * @param e (Entrada)
	 * @return boolean (True si la palabra española o inglesa existen)
	 */
	public boolean entradaExiste(Entrada e);
	
	
	
	// Punto 2 ---------------------------------------------------------------------------------------------------

	/**
	 * Menú. Ejercicio 2
	 * Método que solicita una palabra y devuelve la traducción 
	 * @param idioma (int)
	 * @param palabraTraducir (String)
	 * @return palabraTraducida (String)
	 * @throws Exception idioma seleccionado incorrecto
	 */
	public String consultarDiccionario(int idioma, String palabraTraducir) throws Exception;

	/**
	 * Método que comprueba si la palabra española existe, si es así devuelve la traducción (palabra inglesa).
	 * Método de apoyo para consultarDiccionario()
	 * @param palabraEspanola (String)
	 * @return palabraInglesa (String)
	 * @throws Exception La palabra española a traducir no existe
	 */
	public String traducirPalabraEspanola(String palabraEspanola) throws Exception;
	
	/**
	 * Método que comprueba si la palabra ingles existe, si es así devuelve la traducción (palabra española).
	 * Método de apoyo para consultarDiccionario()
	 * @param palabraInglesa (String)
	 * @return palabraEspanola (String)
	 * @throws Exception Exception La palabra inglesa a traducir no existe
	 */
	public String traducirPalabraInglesa(String palabraInglesa) throws Exception;
	
	
	
	// Punto 3 ---------------------------------------------------------------------------------------------------

	/**
	 * Menú. Ejercicio 3
	 * Método que devuelve el listado de palabras que empiezan por la letra introducida
	 * @param letra (char)
	 * @return String
	 * @throws Exception No hay palabras que empiecen por la letra introducida
	 */
	public String entradasEmpiezanPorLetra(char letra) throws Exception;
	
	
	
	// Punto 4 ---------------------------------------------------------------------------------------------------

	/**
	 * Menú. Ejercicio 4
	 * Método que devuelve el número de consultas realizadas
	 * @return número de consultas (int)
	 * @throws Exception No se han realizado consultas
	 */
	public int numeroConsultas() throws Exception;
	
	
	
	// Punto 5 ---------------------------------------------------------------------------------------------------

	/**
	 * Menú. Ejercicio 5
	 * Método que muestra el diccionario en orden alfabético por las palabras en español.
	 * @return String
	 * @throws Exception No existen palabras en el diccionario
	 */
	public String mostrarDiccionarioEspanol() throws Exception;
	
	
	
	// Punto 6 ---------------------------------------------------------------------------------------------------

	/**
	 * Menú. Ejercicio 6
	 * Método que muestra el diccionario en orden alfabético por las palabras en inglés.
	 * @return String
	 * @throws Exception No existen palabras en el diccionario
	 */
	public String mostrarDiccionarioIngles() throws Exception;



	
}
