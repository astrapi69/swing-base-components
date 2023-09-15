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
package io.github.astrapi69.swing.component.replace;

import java.awt.Container;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

import lombok.experimental.UtilityClass;

/**
 * The class {@link ReplaceContentExtensions} provides algorithms for replace components in the
 * given containers
 */
@UtilityClass
public class ReplaceContentExtensions
{

	/**
	 * Replace the content of the given container without a call to the method revalidate
	 *
	 * @param container
	 *            the container
	 * @param newComponent
	 *            the new component to add to the given container
	 * @param scrollable
	 *            the flag if true the new content will be embedded in a {@link JScrollPane}
	 */
	public static void replaceContent(final Container container, final JComponent newComponent,
		final boolean scrollable)
	{
		container.removeAll();
		if (scrollable)
		{
			container.add(new JScrollPane(newComponent));
		}
		else
		{
			container.add(newComponent);
		}
	}

	/**
	 * Replace the content of the given container without a call to the method revalidate. <br>
	 * <br>
	 * Note: only the given old component will be removed from the given container and the new
	 * component will be added without a call to the method revalidate
	 *
	 * @param container
	 *            the container
	 * @param oldComponent
	 *            the component to remove from the given container
	 * @param newComponent
	 *            the new component to add to the given container
	 */
	public static void replaceContent(final Container container, final JComponent oldComponent,
		final JComponent newComponent)
	{
		container.remove(oldComponent);
		container.add(newComponent);
	}

	/**
	 * Replace the content of the given container without a call to the method revalidate
	 *
	 * @param container
	 *            the container
	 * @param oldComponent
	 *            the component to remove from the given container
	 * @param newComponent
	 *            the new component to add to the given container
	 */
	public static void replaceContentAndRevalidate(final Container container,
		final JComponent oldComponent, final JComponent newComponent)
	{
		replaceContent(container, oldComponent, newComponent);
		container.revalidate();
	}

	/**
	 * Replace the content of the given container with a call to the method revalidate
	 *
	 * @param container
	 *            the container
	 * @param newComponent
	 *            the new component to add to the given container
	 * @param scrollable
	 *            the flag if true the new content will be embedded in a {@link JScrollPane}
	 */
	public static void replaceContentAndRevalidate(final Container container,
		final JComponent newComponent, final boolean scrollable)
	{
		replaceContent(container, newComponent, scrollable);
		container.revalidate();
	}

}
