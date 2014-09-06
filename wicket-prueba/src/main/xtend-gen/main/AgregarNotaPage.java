package main;

import domain.Nota;
import main.HomePage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;

@SuppressWarnings("all")
public class AgregarNotaPage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  private final HomePage mainPage;
  
  private boolean alta;
  
  public AgregarNotaPage(final HomePage mainPage, final Nota nota) {
    this.mainPage = mainPage;
    CompoundPropertyModel<Nota> _compoundPropertyModel = new CompoundPropertyModel<Nota>(nota);
    Form<Nota> notaForm = new Form<Nota>("notaForm", _compoundPropertyModel);
    this._wicketExtensionFactoryMethods.addChild(this, notaForm);
  }
}
