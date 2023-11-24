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
package io.github.astrapi69.swing.component;

import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.util.Optional;
import java.util.logging.Level;

import javax.swing.SwingUtilities;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;

/**
 * The class {@link ComponentExtensions} provides extension methods for components
 */
@UtilityClass
@Log
public class ComponentExtensions
{

	/**
	 * Resolves the a component over the name
	 * 
	 * @param container
	 *            the parent container
	 * @param componentName
	 *            the name of the component to find
	 * @return an optional with the component if the search was successful otherwise an empty
	 *         optional
	 */
	private static Optional<Component> getComponentByName(final @NonNull Container container,
		final @NonNull String componentName)
	{

		if (0 < container.getComponents().length)
		{
			for (Component component : container.getComponents())
			{
				if (componentName.equals(component.getName()))
				{
					return Optional.of(component);
				}
				if (component instanceof Container)
				{
					return getComponentByName((Container)component, componentName);
				}
			}
		}
		return Optional.empty();
	}

	/**
	 * Enables or disables the given {@link Component} object from the given enable flag
	 *
	 * @param container
	 *            the {@link Component} object to enable or disable
	 * @param enable
	 *            the flag for enable or disable
	 */
	public static void setComponentEnabled(Component container, boolean enable)
	{
		container.setEnabled(enable);
		try
		{
			Component[] components = ((Container)container).getComponents();
			for (Component component : components)
			{
				setComponentEnabled(component, enable);
			}
		}
		catch (ClassCastException exception)
		{
			log.log(Level.INFO, exception.getMessage(), exception);
		}
	}

	/**
	 * Resolves the application frame from the given Component
	 *
	 * @param eventSource
	 *            the event source
	 * @return the application frame
	 */
	public static Frame getApplicationFrame(Component eventSource)
	{
		Frame frame = (Frame)SwingUtilities.getAncestorOfClass(Frame.class, eventSource);
		return frame;
	}
}
