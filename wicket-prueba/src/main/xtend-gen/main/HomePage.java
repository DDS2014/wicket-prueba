package main;

import applicationModel.SeguidorDeCarrera;
import domain.Materia;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
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
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new Function0<WicketExtensionFactoryMethods>() {
    public WicketExtensionFactoryMethods apply() {
      WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
      return _wicketExtensionFactoryMethods;
    }
  }.apply();
  
  private SeguidorDeCarrera seguidor;
  
  public HomePage() {
    SeguidorDeCarrera _seguidorDeCarrera = new SeguidorDeCarrera();
    this.seguidor = _seguidorDeCarrera;
    this.seguidor.refresh();
    CompoundPropertyModel<SeguidorDeCarrera> _compoundPropertyModel = new CompoundPropertyModel<SeguidorDeCarrera>(this.seguidor);
    Form<SeguidorDeCarrera> _form = new Form<SeguidorDeCarrera>("materiasForm", _compoundPropertyModel);
    final Form<SeguidorDeCarrera> materiasForm = _form;
    this.agregarGrillaMaterias(materiasForm);
    this.agregarEditarMateria(materiasForm);
    this.agregarFormNotas(materiasForm);
    this._wicketExtensionFactoryMethods.addChild(this, materiasForm);
  }
  
  public Object agregarFormNotas(final Form<SeguidorDeCarrera> parent) {
    Object _agregarAccionesNotas = this.agregarAccionesNotas(parent);
    return _agregarAccionesNotas;
  }
  
  public Object agregarAccionesNotas(final Form<SeguidorDeCarrera> parent) {
    return null;
  }
  
  public MarkupContainer agregarGrillaMaterias(final Form<SeguidorDeCarrera> parent) {
    MarkupContainer _xblockexpression = null;
    {
      XListView<Materia> _xListView = new XListView<Materia>("materias");
      final XListView<Materia> listView = _xListView;
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
              Materia _modelObject = item.getModelObject();
              HomePage.this.seguidor.seleccionarMateria(_modelObject);
            }
          };
          XButton _setOnClick = _xButton.setOnClick(_function);
          HomePage.this._wicketExtensionFactoryMethods.addChild(item, _setOnClick);
        }
      };
      listView.setPopulateItem(_function);
      MarkupContainer _addChild = this._wicketExtensionFactoryMethods.addChild(parent, listView);
      _xblockexpression = (_addChild);
    }
    return _xblockexpression;
  }
  
  public MarkupContainer agregarEditarMateria(final Form<SeguidorDeCarrera> parent) {
    MarkupContainer _xblockexpression = null;
    {
      TextField<String> _textField = new TextField<String>("materiaSeleccionada.anioCursada");
      this._wicketExtensionFactoryMethods.addChild(parent, _textField);
      TextField<String> _textField_1 = new TextField<String>("materiaSeleccionada.profesor");
      this._wicketExtensionFactoryMethods.addChild(parent, _textField_1);
      CheckBox _checkBox = new CheckBox("materiaSeleccionada.finalAprobado");
      MarkupContainer _addChild = this._wicketExtensionFactoryMethods.addChild(parent, _checkBox);
      _xblockexpression = (_addChild);
    }
    return _xblockexpression;
  }
}
