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
package io.github.astrapi69.swing.model.combobox;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import io.github.astrapi69.collection.list.ListExtensions;
import io.github.astrapi69.collection.set.SetFactory;
import lombok.Getter;
import lombok.NonNull;

/**
 * The class {@link EnumComboBoxModel} is an implementation that safely wraps an {@link Enum}
 *
 * @param <E>
 *            the generic type of the enum
 */
public class EnumComboBoxModel<E extends Enum<E>> extends AbstractComboBoxModel<E>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The enum class. */
	private final Class<E> enumClass;

	/** The value map for the enum values. */
	@Getter
	private final Map<String, E> valueMap;

	/**
	 * Instantiates a new {@link EnumComboBoxModel} from the given enum class.
	 *
	 * @param enumClass
	 *            the enum class
	 */
	public EnumComboBoxModel(@NonNull final Class<E> enumClass)
	{
		this(enumClass, ListExtensions.getFirst(ListExtensions.toList(EnumSet.allOf(enumClass))));
	}

	/**
	 * Instantiates a new {@link EnumComboBoxModel} from the given enum class and set as selected
	 * item the given value.
	 *
	 * @param enumClass
	 *            the enum class
	 * @param selectedItem
	 *            the selected item
	 */
	public EnumComboBoxModel(final Class<E> enumClass, final E selectedItem)
	{
		this(enumClass, selectedItem, SetFactory.newHashSet());
	}

	/**
	 * Instantiates a new {@link EnumComboBoxModel} from the given enum class and set as selected
	 * item the given value.
	 *
	 * @param enumClass
	 *            the enum class
	 * @param selectedItem
	 *            the selected item
	 * @param excludeValues
	 *            the values to exclude
	 */
	public EnumComboBoxModel(final Class<E> enumClass, final E selectedItem,
		final Set<E> excludeValues)
	{
		super(
			newOrderedSet(EnumSet.allOf(enumClass),
				excludeValues != null ? excludeValues : SetFactory.newHashSet()),
			newOrderedSet(EnumSet.allOf(enumClass),
				excludeValues != null ? excludeValues : SetFactory.newHashSet())
					.contains(selectedItem)
						? selectedItem
						: ListExtensions
							.getFirst(ListExtensions.toList(newOrderedSet(EnumSet.allOf(enumClass),
								excludeValues != null ? excludeValues : SetFactory.newHashSet()))));
		this.enumClass = enumClass;
		this.valueMap = new HashMap<>();
		initValueMap();
	}

	/**
	 * Instantiates a new {@link EnumComboBoxModel} from the given enum class and set as selected
	 * item the given value.
	 *
	 * @param enumClass
	 *            the enum class
	 * @param excludeValues
	 *            the values to exclude
	 */
	public EnumComboBoxModel(final Class<E> enumClass, final Set<E> excludeValues)
	{
		this(enumClass,
			ListExtensions.getFirst(ListExtensions.toList(newOrderedSet(EnumSet.allOf(enumClass),
				excludeValues != null ? excludeValues : SetFactory.newHashSet()))),
			excludeValues);
	}

	/**
	 * Factory method for create a new {@link LinkedHashSet} from the given collection without the
	 * excluded elements. The iteration order of the given collection is preserved, so the enum
	 * values keep their declaration order
	 *
	 * @param <T>
	 *            the generic type of the elements
	 * @param collection
	 *            the collection that will be added to the new set
	 * @param exclude
	 *            the elements that have to be excluded
	 * @return the new {@link LinkedHashSet}
	 */
	private static <T> Set<T> newOrderedSet(final Collection<T> collection,
		final Collection<T> exclude)
	{
		final Set<T> set = new LinkedHashSet<>(collection);
		set.removeAll(exclude);
		return set;
	}

	/**
	 * Inits the value map.
	 */
	protected void initValueMap()
	{
		for (final E enumValue : comboList)
		{
			valueMap.put(enumValue.name(), enumValue);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void setSelectedItem(final Object anItem)
	{
		E input;

		if (enumClass.isInstance(anItem))
		{
			input = (E)anItem;
		}
		else
		{
			input = valueMap.get(anItem);
		}

		if (input != null || anItem == null)
		{
			selectedItem = input;
		}
		this.fireContentsChanged(this, 0, getSize());
	}

}
