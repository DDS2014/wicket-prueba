package applicationModel;

import domain.Materia;
import domain.Nota;
import home.HomeMaterias;
import java.util.ArrayList;

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
  
  private ArrayList<Nota> _notas;
  
  public ArrayList<Nota> getNotas() {
    return this._notas;
  }
  
  public void setNotas(final ArrayList<Nota> notas) {
    this._notas = notas;
  }
  
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private int _anio_cursada;
  
  public int getAnio_cursada() {
    return this._anio_cursada;
  }
  
  public void setAnio_cursada(final int anio_cursada) {
    this._anio_cursada = anio_cursada;
  }
  
  private boolean _final_aprobado;
  
  public boolean isFinal_aprobado() {
    return this._final_aprobado;
  }
  
  public void setFinal_aprobado(final boolean final_aprobado) {
    this._final_aprobado = final_aprobado;
  }
  
  private String _profesor;
  
  public String getProfesor() {
    return this._profesor;
  }
  
  public void setProfesor(final String profesor) {
    this._profesor = profesor;
  }
  
  private String _ubicacion;
  
  public String getUbicacion() {
    return this._ubicacion;
  }
  
  public void setUbicacion(final String ubicacion) {
    this._ubicacion = ubicacion;
  }
  
  public SeguidorDeCarrera() {
    HomeMaterias _homeMaterias = new HomeMaterias();
    this.homeMaterias = _homeMaterias;
  }
  
  public void cargarDatosMateria() {
    Materia _materiaSeleccionada = this.getMateriaSeleccionada();
    String _nombre = _materiaSeleccionada.getNombre();
    this.setNombre(_nombre);
    Materia _materiaSeleccionada_1 = this.getMateriaSeleccionada();
    int _anio_cursada = _materiaSeleccionada_1.getAnio_cursada();
    this.setAnio_cursada(_anio_cursada);
    Materia _materiaSeleccionada_2 = this.getMateriaSeleccionada();
    boolean _isFinal_aprobado = _materiaSeleccionada_2.isFinal_aprobado();
    this.setFinal_aprobado(_isFinal_aprobado);
    Materia _materiaSeleccionada_3 = this.getMateriaSeleccionada();
    String _profesor = _materiaSeleccionada_3.getProfesor();
    this.setProfesor(_profesor);
    Materia _materiaSeleccionada_4 = this.getMateriaSeleccionada();
    String _ubicacion = _materiaSeleccionada_4.getUbicacion();
    this.setUbicacion(_ubicacion);
    Materia _materiaSeleccionada_5 = this.getMateriaSeleccionada();
    ArrayList<Nota> _notas = _materiaSeleccionada_5.getNotas();
    this.setNotas(_notas);
  }
  
  public void guardarDatosMateria() {
    Materia _materiaSeleccionada = this.getMateriaSeleccionada();
    String _nombre = this.getNombre();
    _materiaSeleccionada.setNombre(_nombre);
    Materia _materiaSeleccionada_1 = this.getMateriaSeleccionada();
    int _anio_cursada = this.getAnio_cursada();
    _materiaSeleccionada_1.setAnio_cursada(_anio_cursada);
    Materia _materiaSeleccionada_2 = this.getMateriaSeleccionada();
    boolean _isFinal_aprobado = this.isFinal_aprobado();
    _materiaSeleccionada_2.setFinal_aprobado(_isFinal_aprobado);
    Materia _materiaSeleccionada_3 = this.getMateriaSeleccionada();
    String _profesor = this.getProfesor();
    _materiaSeleccionada_3.setProfesor(_profesor);
    Materia _materiaSeleccionada_4 = this.getMateriaSeleccionada();
    String _ubicacion = this.getUbicacion();
    _materiaSeleccionada_4.setUbicacion(_ubicacion);
    Materia _materiaSeleccionada_5 = this.getMateriaSeleccionada();
    ArrayList<Nota> _notas = this.getNotas();
    _materiaSeleccionada_5.setNotas(_notas);
  }
  
  public void crearMateriaDefault(final String nombre) {
    Materia _addMateriaDefault = this.homeMaterias.addMateriaDefault(nombre);
    this.setMateriaSeleccionada(_addMateriaDefault);
    this.cargarDatosMateria();
  }
  
  public void removerNotaSeleccionada() {
    Materia _materiaSeleccionada = this.getMateriaSeleccionada();
    ArrayList<Nota> _notas = _materiaSeleccionada.getNotas();
    Nota _notaSeleccionada = this.getNotaSeleccionada();
    _notas.remove(_notaSeleccionada);
  }
}
