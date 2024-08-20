module swing.base.components.main
{
	requires java.desktop;
	requires silly.collection;
	requires lombok;
	requires silly.math;
	requires java.logging;
	requires jobj.core.main;
	requires menu.actions.main;
	requires model.data;
	requires awt.extensions.main;
	requires io.github.astrapisixtynine.throwable;

	exports io.github.astrapi69.swing.base;
	exports io.github.astrapi69.swing.base.action;
	exports io.github.astrapi69.swing.component;
	exports io.github.astrapi69.swing.component.factory;
	exports io.github.astrapi69.swing.component.replace;
	exports io.github.astrapi69.swing.desktoppane;
	exports io.github.astrapi69.swing.dialog;
	exports io.github.astrapi69.swing.dialog.factory;
	exports io.github.astrapi69.swing.dialog.help;
	exports io.github.astrapi69.swing.dialog.info;
	exports io.github.astrapi69.swing.document;
	exports io.github.astrapi69.swing.document.filter;
	exports io.github.astrapi69.swing.enumeration;
	exports io.github.astrapi69.swing.filechooser;
	exports io.github.astrapi69.swing.help;
	exports io.github.astrapi69.swing.model.combobox;
	exports io.github.astrapi69.swing.model.label;
	exports io.github.astrapi69.swing.model.layout;
	exports io.github.astrapi69.swing.model.radio;
	exports io.github.astrapi69.swing.panel.desktoppane;
	exports io.github.astrapi69.swing.panel.help;
	exports io.github.astrapi69.swing.panel.info;
	exports io.github.astrapi69.swing.panel.label;
	exports io.github.astrapi69.swing.util;
}