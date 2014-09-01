package main;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.eclipse.xtext.xbase.lib.Extension;
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods;

/**
 * @author ?
 */
@SuppressWarnings("all")
public class HomePage extends WebPage {
  @Extension
  private WicketExtensionFactoryMethods _wicketExtensionFactoryMethods = new WicketExtensionFactoryMethods();
  
  public HomePage() {
    Label _label = new Label("prueba", "esto es un texto de prueba");
    this._wicketExtensionFactoryMethods.addChild(this, _label);
  }
}
