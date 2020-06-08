package diccionario;

import java.util.Comparator;

public class ComparaPalabraIng implements Comparator<Entrada> {

	@Override
	public int compare(Entrada ent1, Entrada ent2) {
		return ent1.getEnglishWord().compareTo(ent2.getEnglishWord());
	}

}
