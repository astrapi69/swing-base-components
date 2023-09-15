/**
 * The MIT License
 *
 * Copyright (C) 2021 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.swing.panel.splitpane;

import javax.swing.JComponent;
import javax.swing.JEditorPane;

import io.github.astrapi69.swing.component.factory.JComponentFactory;

public class TestComponentFactory
{

	private static final String dummyText = "<html>" + " <head>"
		+ "  <title>JXMultiSplitPane Demo</title>" + "</head>" + "<body>"
		+ "JXMultiSplitPane is a container that can be split into multiple resizeable"
		+ "areas. The layout is configured using MultiSplitLayout layout manager." + "<p>"
		+ "The MultiSplitLayout layout manager recursively arranges its components in"
		+ "row and column groups called Splits. Elements of the layout are"
		+ "separated by gaps called Dividers. The overall layout is defined with a"
		+ "simple tree model whose nodes are instances of MultiSplitLayout.Split,"
		+ "MultiSplitLayout. Divider, and MultiSplitLayout.Leaf. Named Leaf nodes"
		+ "represent the space allocated to a component that was added with a"
		+ "constraint that matches the Leaf's name. Extra space is distributed among"
		+ "row/column siblings according to their 0.0 to 1.0 weight. If no weights"
		+ "are specified then the last sibling always gets all of the extra space,"
		+ "or space reduction." + "<p>"
		+ "Although MultiSplitLayout can be used with any Container, it's the default"
		+ "layout manager for JXMultiSplitPane. JXMultiSplitPane supports"
		+ "interactively dragging the Dividers, accessibility, and other features"
		+ "associated with split panes." + "</body>" + "</html>";

	private static final String htmlURL = "MultiSplitPaneDemo.html";


	public static JComponent createEditorSetText()
	{
		final JEditorPane editor = JComponentFactory.newJEditorPane("text/html", false);
		editor.setText(dummyText);
		return editor;
	}

}
