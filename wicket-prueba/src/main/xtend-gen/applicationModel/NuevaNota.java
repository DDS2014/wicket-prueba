package applicationModel;

import applicationModel.SeguidorDeCarrera;
import domain.Materia;
import domain.Nota;
import java.util.ArrayList;

@SuppressWarnings("all")
public class NuevaNota {
  private Nota _nota;
  
  public Nota getNota() {
    return this._nota;
  }
  
  public void setNota(final Nota nota) {
    this._nota = nota;
  }
  
  private SeguidorDeCarrera seguidor;
  
  public NuevaNota(final SeguidorDeCarrera seguidor) {
    this.seguidor = seguidor;
    Nota _nota = new Nota();
    this.setNota(_nota);
  }
  
  public boolean agregarse() {
    Materia _materiaSeleccionada = this.seguidor.getMateriaSeleccionada();
    ArrayList<Nota> _notas = _materiaSeleccionada.getNotas();
    Nota _nota = this.getNota();
    return _notas.add(_nota);
  }
}
