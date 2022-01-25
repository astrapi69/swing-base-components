package io.github.astrapi69.swing.component;

import java.awt.*;
import java.util.Optional;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

/**
 * The class {@link ComponentExtensions} provides extension methods for components
 */
@UtilityClass
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
}
