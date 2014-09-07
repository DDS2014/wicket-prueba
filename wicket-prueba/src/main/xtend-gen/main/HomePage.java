package main;

import applicationModel.NuevaMateria;
import applicationModel.NuevaNota;
import applicationModel.SeguidorDeCarrera;
import domain.Materia;
import domain.Nota;
import main.AgregarMateriaPage;
import main.AgregarNotaPage;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;
import org.uqbar.wicket.xtend.XButton;
import org.uqbar.wicket.xtend.XListView;

/**
 * @author ?
 */
@SuppressWarnings("all")
public class HomePage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  private SeguidorDeCarrera _seguidor;
  
  public SeguidorDeCarrera getSeguidor() {
    return this._seguidor;
  }
  
  public void setSeguidor(final SeguidorDeCarrera seguidor) {
    this._seguidor = seguidor;
  }
  
  public HomePage() {
    SeguidorDeCarrera _seguidorDeCarrera = new SeguidorDeCarrera();
    this.setSeguidor(_seguidorDeCarrera);
    SeguidorDeCarrera _seguidor = this.getSeguidor();
    _seguidor.refresh();
    SeguidorDeCarrera _seguidor_1 = this.getSeguidor();
    CompoundPropertyModel<SeguidorDeCarrera> _compoundPropertyModel = new CompoundPropertyModel<SeguidorDeCarrera>(_seguidor_1);
    final Form<SeguidorDeCarrera> materiasForm = new Form<SeguidorDeCarrera>("materiasForm", _compoundPropertyModel);
    this.agregarGrillaMaterias(materiasForm);
    this.agregarGrillaNotas(materiasForm);
    this.agregarAccionesMateria(materiasForm);
    this.agregarEditarMateria(materiasForm);
    this.agregarFormNotas(materiasForm);
    this._wicketExtensionFactoryMethods.addChild(this, materiasForm);
  }
  
  public MarkupContainer agregarAccionesMateria(final Form<SeguidorDeCarrera> parent) {
    MarkupContainer _xblockexpression = null;
    {
      final XButton botonAgregarMateria = new XButton("nuevaMateria");
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          HomePage.this.agregarMateria();
        }
      };
      botonAgregarMateria.setOnClick(_function);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(parent, botonAgregarMateria);
    }
    return _xblockexpression;
  }
  
  public void agregarMateria() {
    SeguidorDeCarrera _seguidor = this.getSeguidor();
    NuevaMateria _nuevaMateria = new NuevaMateria(_seguidor);
    AgregarMateriaPage _agregarMateriaPage = new AgregarMateriaPage(this, _nuevaMateria);
    this.setResponsePage(_agregarMateriaPage);
    SeguidorDeCarrera _seguidor_1 = this.getSeguidor();
    _seguidor_1.refresh();
  }
  
  public Object agregarFormNotas(final Form<SeguidorDeCarrera> parent) {
    return this.agregarAccionesNotas(parent);
  }
  
  public Object agregarAccionesNotas(final Form<SeguidorDeCarrera> parent) {
    return null;
  }
  
  public MarkupContainer agregarGrillaMaterias(final Form<SeguidorDeCarrera> parent) {
    MarkupContainer _xblockexpression = null;
    {
      final XListView<Materia> listView = new XListView<Materia>("materias");
      final Procedure1<ListItem<Materia>> _function = new Procedure1<ListItem<Materia>>() {
        public void apply(final ListItem<Materia> item) {
          Materia _modelObject = item.getModelObject();
          CompoundPropertyModel<Materia> _asCompoundModel = HomePage.this._wicketExtensionFactoryMethods.<Materia>asCompoundModel(_modelObject);
          item.setModel(_asCompoundModel);
          Label _label = new Label("nombre");
          HomePage.this._wicketExtensionFactoryMethods.addChild(item, _label);
          XButton _xButton = new XButton("editar");
          final Procedure0 _function = new Procedure0() {
            public void apply() {
              SeguidorDeCarrera _seguidor = HomePage.this.getSeguidor();
              Materia _modelObject = item.getModelObject();
              _seguidor.seleccionarMateria(_modelObject);
            }
          };
          XButton _setOnClick = _xButton.setOnClick(_function);
          HomePage.this._wicketExtensionFactoryMethods.addChild(item, _setOnClick);
        }
      };
      listView.setPopulateItem(_function);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(parent, listView);
    }
    return _xblockexpression;
  }
  
  public MarkupContainer agregarGrillaNotas(final Form<SeguidorDeCarrera> form) {
    MarkupContainer _xblockexpression = null;
    {
      XListView<Nota> listNotas = new XListView<Nota>("materiaSeleccionada.notas");
      final Procedure1<ListItem<Nota>> _function = new Procedure1<ListItem<Nota>>() {
        public void apply(final ListItem<Nota> item) {
          Nota _modelObject = item.getModelObject();
          CompoundPropertyModel<Nota> _asCompoundModel = HomePage.this._wicketExtensionFactoryMethods.<Nota>asCompoundModel(_modelObject);
          item.setModel(_asCompoundModel);
          Label _label = new Label("fecha");
          HomePage.this._wicketExtensionFactoryMethods.addChild(item, _label);
          Label _label_1 = new Label("descripcion");
          HomePage.this._wicketExtensionFactoryMethods.addChild(item, _label_1);
          Label _label_2 = new Label("aprobado");
          HomePage.this._wicketExtensionFactoryMethods.addChild(item, _label_2);
          XButton _xButton = new XButton("editarNota");
          final Procedure0 _function = new Procedure0() {
            public void apply() {
              Nota _modelObject = item.getModelObject();
              HomePage.this.editarNota(_modelObject);
            }
          };
          XButton _setOnClick = _xButton.setOnClick(_function);
          HomePage.this._wicketExtensionFactoryMethods.addChild(item, _setOnClick);
        }
      };
      listNotas.setPopulateItem(_function);
      XButton _xButton = new XButton("agregarNota");
      final Procedure0 _function_1 = new Procedure0() {
        public void apply() {
          HomePage.this.agregarNota();
        }
      };
      XButton _setOnClick = _xButton.setOnClick(_function_1);
      this._wicketExtensionFactoryMethods.addChild(form, _setOnClick);
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(form, listNotas);
    }
    return _xblockexpression;
  }
  
  public void agregarNota() {
    SeguidorDeCarrera _seguidor = this.getSeguidor();
    NuevaNota _nuevaNota = new NuevaNota(_seguidor);
    AgregarNotaPage _agregarNotaPage = new AgregarNotaPage(this, _nuevaNota);
    this.setResponsePage(_agregarNotaPage);
    SeguidorDeCarrera _seguidor_1 = this.getSeguidor();
    _seguidor_1.refresh();
  }
  
  public void editarNota(final Nota nota) {
    AgregarNotaPage _agregarNotaPage = new AgregarNotaPage(this, nota);
    this.setResponsePage(_agregarNotaPage);
    SeguidorDeCarrera _seguidor = this.getSeguidor();
    _seguidor.refresh();
  }
  
  public MarkupContainer agregarEditarMateria(final Form<SeguidorDeCarrera> parent) {
    MarkupContainer _xblockexpression = null;
    {
      Label _label = new Label("materiaSeleccionada.nombre");
      this._wicketExtensionFactoryMethods.addChild(parent, _label);
      TextField<String> _textField = new TextField<String>("materiaSeleccionada.anioCursada");
      this._wicketExtensionFactoryMethods.addChild(parent, _textField);
      TextField<String> _textField_1 = new TextField<String>("materiaSeleccionada.profesor");
      this._wicketExtensionFactoryMethods.addChild(parent, _textField_1);
      DropDownChoice<String> _dropDownChoice = new DropDownChoice<String>("materiaSeleccionada.ubicacion");
      final Procedure1<DropDownChoice<String>> _function = new Procedure1<DropDownChoice<String>>() {
        public void apply(final DropDownChoice<String> it) {
        }
      };
      DropDownChoice<String> _doubleArrow = ObjectExtensions.<DropDownChoice<String>>operator_doubleArrow(_dropDownChoice, _function);
      this._wicketExtensionFactoryMethods.addChild(parent, _doubleArrow);
      CheckBox _checkBox = new CheckBox("materiaSeleccionada.finalAprobado");
      _xblockexpression = this._wicketExtensionFactoryMethods.addChild(parent, _checkBox);
    }
    return _xblockexpression;
  }
}
