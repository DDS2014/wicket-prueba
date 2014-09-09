package domain

import java.util.Date
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.UserException

@Observable
class Nota
{
	@Property Date fecha;
	@Property String descripcion;
	@Property boolean aprobado;	
	
	
	
	def void validarDescripcion(String descripcion){
		if (descripcion == null){
			throw new UserException("El campo descripcion esta vacio")
		}
	}
	
	
	def void validarFecha(Date fecha){
		if (fecha == null){
			throw new UserException("No se indico fecha de la nota")
		}
	}

}