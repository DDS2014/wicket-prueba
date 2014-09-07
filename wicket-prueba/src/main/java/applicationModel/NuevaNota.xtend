package applicationModel

import domain.Nota

class NuevaNota 
{
	@Property Nota nota;
	SeguidorDeCarrera seguidor;
	
	new(SeguidorDeCarrera seguidor)
	{
		this.seguidor = seguidor;
		this.nota = new Nota()
	}
		
		
	def agregarse()
	{
		this.seguidor.materiaSeleccionada.notas.add(this.nota); //FIXME
	}

}