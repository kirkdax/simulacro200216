package diccionario;

import java.util.Comparator;

public class ComparaPalabraEsp implements Comparator<Entrada> {

	@Override
	public int compare(Entrada ent1, Entrada ent2) {
		return ent1.getSpanishWord().compareTo(ent2.getSpanishWord());
	}

}
