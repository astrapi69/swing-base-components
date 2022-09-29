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
package io.github.astrapi69.swing.action;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

import lombok.experimental.UtilityClass;

import org.jdesktop.swingx.JXMultiSplitPane;
import org.jdesktop.swingx.SwingXUtilities;

import java.awt.Component;
import java.awt.Container;

/**
 * The class {@link ReplaceContentExtensions}
 */
@UtilityClass
public class ReplaceContentExtensions
{

	/**
	 * Replace the content of the given container without a call to the method revalidate
	 *
	 * @param container
	 *            the container
	 * @param content
	 *            the content
	 * @param scrollable
	 *            the flag if true the new content will be embedded in a {@link JScrollPane}
	 */
	public static void replaceContent(Container container, JComponent content, boolean scrollable) {
		container.removeAll();
		if (scrollable)
		{
			container.add(new JScrollPane(content));
		}
		else
		{
			container.add(content);
		}
	}

	/**
	 * Replace the content of the given container without a call to the method revalidate
	 *
	 * @param container
	 *            the container
	 * @param oldContent
	 *            the component to remove
	 * @param content
	 *            the new component
	 */
	public static void replaceContent(Container container, JComponent oldContent, JComponent content) {
		container.remove(oldContent);
		container.add(content);
	}
	/**
	 * Replace the content of the given container without a call to the method revalidate
	 *
	 * @param container
	 *            the container
	 * @param oldContent
	 *            the component to remove
	 * @param content
	 *            the new component
	 */
	public static void replaceContentAndRevalidate(Container container, JComponent oldContent, JComponent content) {
		replaceContent(container, oldContent, content);
		container.revalidate();
	}

	/**
	 * Replace the content of the given container.
	 *
	 * @param container
	 *            the container
	 * @param content
	 *            the content
	 * @param scrollable
	 *            the flag if true the new content will be embedded in a {@link JScrollPane}
	 */
	public static void replaceContentInMultiSplitPane(final JComponent container, final JComponent content,
									  boolean scrollable)
	{
		replaceContentAndRevalidate(container, content, scrollable);
		replaceContentAndCreateJXMultiSplitPane(container, content, scrollable);
	}
	/**
	 * Replace the content of the given container with a call to the method revalidate
	 *
	 * @param container
	 *            the container
	 * @param content
	 *            the content
	 * @param scrollable
	 *            the flag if true the new content will be embedded in a {@link JScrollPane}
	 */
	public static void replaceContentAndRevalidate(Container container, JComponent content, boolean scrollable) {
		replaceContent(container, content, scrollable);
		container.revalidate();
	}

	/**
	 * Replace the content of the given container.
	 *
	 * @param container
	 *            the container
	 * @param content
	 *            the content
	 * @param scrollable
	 *            the flag if true the new content will be embedded in a {@link JScrollPane}
	 */
	public static void replaceContentAndCreateJXMultiSplitPane(final JComponent container,
		final JComponent content, boolean scrollable)
	{
		replaceContent(container, content, scrollable);
		JXMultiSplitPane pane = SwingXUtilities.getAncestor(JXMultiSplitPane.class, container);
		if (pane != null)
		{
			pane.revalidate();
		}
		else
		{
			container.revalidate();
		}
	}
}
