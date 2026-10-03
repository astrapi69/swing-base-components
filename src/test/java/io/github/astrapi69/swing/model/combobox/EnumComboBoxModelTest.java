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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Test class for the class {@link EnumComboBoxModel}
 */
public class EnumComboBoxModelTest
{

	/**
	 * Enum with a deliberate declaration order that differs from the alphabetical order
	 */
	enum Season
	{
		WINTER, SPRING, SUMMER, AUTUMN
	}

	/**
	 * Collects the items of the given model through {@link EnumComboBoxModel#getElementAt(int)}
	 */
	private static <E extends Enum<E>> List<E> elementsOf(final EnumComboBoxModel<E> model)
	{
		final List<E> elements = new ArrayList<>();
		for (int i = 0; i < model.getSize(); i++)
		{
			elements.add(model.getElementAt(i));
		}
		return elements;
	}

	/**
	 * Test that the items are in the declaration order of the enum and that the default selected
	 * item is the first element
	 */
	@Test
	public void testDeclarationOrder()
	{
		final EnumComboBoxModel<Season> model = new EnumComboBoxModel<>(Season.class);
		assertEquals(List.of(Season.WINTER, Season.SPRING, Season.SUMMER, Season.AUTUMN),
			elementsOf(model));
		assertEquals(Season.WINTER, model.getSelectedItem());
		assertEquals(model.getElementAt(0), model.getSelectedItem());
	}

	/**
	 * Test that excluded values are removed and the remaining items keep the declaration order
	 */
	@Test
	public void testDeclarationOrderWithExcludeValues()
	{
		final EnumComboBoxModel<Season> model = new EnumComboBoxModel<>(Season.class,
			EnumSet.of(Season.WINTER, Season.SUMMER));
		assertEquals(List.of(Season.SPRING, Season.AUTUMN), elementsOf(model));
		assertEquals(Season.SPRING, model.getSelectedItem());
	}

	/**
	 * Test that a given selected item is kept and the items keep the declaration order
	 */
	@Test
	public void testDeclarationOrderWithSelectedItem()
	{
		final EnumComboBoxModel<Season> model = new EnumComboBoxModel<>(Season.class,
			Season.SUMMER);
		assertEquals(List.of(Season.WINTER, Season.SPRING, Season.SUMMER, Season.AUTUMN),
			elementsOf(model));
		assertEquals(Season.SUMMER, model.getSelectedItem());
	}

}
