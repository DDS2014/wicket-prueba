package domain

import java.util.Date
import org.uqbar.commons.utils.Observable

@Observable
class Nota
{
	@Property Date fecha;
	@Property String descripcion;
	@Property boolean aprobado;	
}