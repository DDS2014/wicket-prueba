package applicationModel;

import domain.Materia;
import home.HomeMaterias;
import java.io.Serializable;
import java.util.List;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class SeguidorDeCarrera implements Serializable {
  private List<Materia> _materias;
  
  public List<Materia> getMaterias() {
    return this._materias;
  }
  
  public void setMaterias(final List<Materia> materias) {
    this._materias = materias;
  }
  
  private Materia _materiaSeleccionada;
  
  public Materia getMateriaSeleccionada() {
    return this._materiaSeleccionada;
  }
  
  public void setMateriaSeleccionada(final Materia materiaSeleccionada) {
    this._materiaSeleccionada = materiaSeleccionada;
  }
  
  private List<String> _ubicaciones;
  
  public List<String> getUbicaciones() {
    return this._ubicaciones;
  }
  
  public void setUbicaciones(final List<String> ubicaciones) {
    this._ubicaciones = ubicaciones;
  }
  
  public HomeMaterias getHomeMaterias() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    HomeMaterias _singleton = _instance.<HomeMaterias>getSingleton(Materia.class);
    return _singleton;
  }
  
  public void refresh() {
    HomeMaterias _homeMaterias = this.getHomeMaterias();
    List<Materia> _refresh = _homeMaterias.refresh();
    this.setMaterias(_refresh);
    List<Materia> _materias = this.getMaterias();
    Materia _get = _materias.get(0);
    this.setMateriaSeleccionada(_get);
  }
  
  public void seleccionarMateria(final Materia materia) {
    this.setMateriaSeleccionada(materia);
  }
}
