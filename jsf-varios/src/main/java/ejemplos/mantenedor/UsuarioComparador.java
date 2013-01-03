package ejemplos.mantenedor;

import java.util.Comparator;

public class UsuarioComparador implements Comparator<Usuario> {

	@Override
	public int compare(Usuario o1, Usuario o2) {
		Long cod1 = o1.getCodigo();
		Long cod2 = o2.getCodigo();
		return cod1.compareTo(cod2);
	}

}
