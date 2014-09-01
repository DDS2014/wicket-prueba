package applicationModel;

import domain.Materia;
import domain.Nota;
import home.HomeMaterias;
import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings("all")
public class SeguidorDeCarrera {
  private HomeMaterias homeMaterias;
  
  private Materia _materiaSeleccionada;
  
  public Materia getMateriaSeleccionada() {
    return this._materiaSeleccionada;
  }
  
  public void setMateriaSeleccionada(final Materia materiaSeleccionada) {
    this._materiaSeleccionada = materiaSeleccionada;
  }
  
  private ArrayList<Materia> _materiasDisponibles;
  
  public ArrayList<Materia> getMateriasDisponibles() {
    return this._materiasDisponibles;
  }
  
  public void setMateriasDisponibles(final ArrayList<Materia> materiasDisponibles) {
    this._materiasDisponibles = materiasDisponibles;
  }
  
  private Nota _notaSeleccionada;
  
  public Nota getNotaSeleccionada() {
    return this._notaSeleccionada;
  }
  
  public void setNotaSeleccionada(final Nota notaSeleccionada) {
    this._notaSeleccionada = notaSeleccionada;
  }
  
  public SeguidorDeCarrera() {
    HomeMaterias _homeMaterias = new HomeMaterias();
    this.homeMaterias = _homeMaterias;
  }
  
  public boolean agregarNota() {
    boolean _xblockexpression = false;
    {
      Nota notaNueva = new Nota();
      Date _date = new Date();
      notaNueva.setFecha(_date);
      notaNueva.setDescripcion("TP");
      notaNueva.setAprobado(true);
      Materia _materiaSeleccionada = this.getMateriaSeleccionada();
      ArrayList<Nota> _notas = _materiaSeleccionada.getNotas();
      _xblockexpression = _notas.add(notaNueva);
    }
    return _xblockexpression;
  }
}
