package domain

import java.util.ArrayList
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.Entity

@Observable
class Materia extends Entity

{
	@Property String nombre;
	@Property int anioCursada;
	@Property String profesor;
	@Property Boolean finalAprobado;
	@Property String ubicacion;
}