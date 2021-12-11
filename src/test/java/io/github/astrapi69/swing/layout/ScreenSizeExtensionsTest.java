/**
 * The MIT License
 * <p>
 * Copyright (C) 2015 Asterios Raptis
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.swing.layout;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * The unit test class for the class {@link ScreenSizeExtensions}.
 *
 * @version 1.0
 * @author Asterios Raptis
 */
public class ScreenSizeExtensionsTest
{


	/**
	 * Test method for {@link ScreenSizeExtensions#computeDialogPositions(int, int)}
	 */
	@Test public void testComputeDialogPositions()
	{
		boolean actual;
		final List<Point> expected = new ArrayList<>();
		final int dialogHeight = 200;
		final int dialogWidth = 250;
		final int windowBesides = ScreenSizeExtensions.getScreenWidth() / dialogWidth;
		final int windowBelow = ScreenSizeExtensions.getScreenHeight() / dialogHeight;
		final int listSize = windowBesides * windowBelow;
		final List<Point> dialogPositions = ScreenSizeExtensions.computeDialogPositions(dialogWidth,
			dialogHeight);
		actual = listSize == dialogPositions.size();
		assertTrue(actual);
		int dotWidth = 0;
		int dotHeight = 0;

		for (int y = 0; y < windowBelow; y++)
		{
			dotWidth = 0;
			for (int x = 0; x < windowBesides; x++)
			{
				final Point p = new Point(dotWidth, dotHeight);
				expected.add(p);
				dotWidth = dotWidth + dialogWidth;
			}
			dotHeight = dotHeight + dialogHeight;
		}

		for (final Point point : dialogPositions)
		{
			actual = expected.contains(point);
			assertTrue(actual);

		}

	}

	/**
	 * Test method for {@link ScreenSizeExtensions#getPoint()}
	 */
	@Test public void testGetPoint()
	{
		boolean actual;
		final Point screenpoint = ScreenSizeExtensions.getPoint();
		actual = screenpoint.x == ScreenSizeExtensions.getScreenWidth();
		assertTrue(actual);

		actual = screenpoint.y == ScreenSizeExtensions.getScreenHeight();
		assertTrue(actual);
	}

	/**
	 * Test method for {@link ScreenSizeExtensions#getScreenHeight()}
	 */
	@Test public void testGetScreenHeight()
	{
		boolean actual;
		final int expected = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		final int compare = ScreenSizeExtensions.getScreenHeight();
		actual = expected == compare;
		assertTrue(actual);
	}

	/**
	 * Test method for  {@link ScreenSizeExtensions#getScreenWidth()}
	 */
	@Test public void testGetScreenWidth()
	{
		boolean actual;
		final int expected = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		final int compare = ScreenSizeExtensions.getScreenWidth();
		actual = expected == compare;
		assertTrue(actual);
	}

}
