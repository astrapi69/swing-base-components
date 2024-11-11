/**
 * The MIT License
 *
 * Copyright (C) 2021 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
module io.github.astrapisixtynine.swing.base.components
{
	requires java.desktop;
	requires io.github.astrapisixtynine.silly.collection;
	requires lombok;
	requires silly.math;
	requires java.logging;
	requires io.github.astrapisixtynine.jobj.core;
	requires io.github.astrapisixtynine.menu.action;
	requires model.data;
	requires io.github.astrapisixtynine.awt.extensions;
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