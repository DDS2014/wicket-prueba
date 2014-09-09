package domain


import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.Entity
import java.util.ArrayList


@Observable
class Materia extends Entity

{
	@Property String nombre;
	@Property int anioCursada;
	@Property String profesor;
	@Property Boolean finalAprobado;
	@Property String ubicacion;
	@Property ArrayList<Nota> notas;
	
}