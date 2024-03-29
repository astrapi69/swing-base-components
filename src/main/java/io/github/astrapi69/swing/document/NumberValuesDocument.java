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
package io.github.astrapi69.swing.document;

import lombok.NonNull;

/**
 * The class {@link NumberValuesDocument} can take any character that is specified in the given
 * regular expression
 */
public class NumberValuesDocument extends RegularExpressionDocument
{

	/** The Constant for the default regular expression. */
	public static final String DEFAULT_REGEX = "^[0-9,;]+$";

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new {@link NumberValuesDocument} object with the default regular expression
	 */
	public NumberValuesDocument()
	{
		this(NumberValuesDocument.DEFAULT_REGEX);
	}

	/**
	 * Instantiates a new {@link NumberValuesDocument} object
	 *
	 * @param regex
	 *            the regular expression
	 */
	public NumberValuesDocument(@NonNull String regex)
	{
		super(regex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String validate(String proposedValue) throws IllegalArgumentException
	{
		if (proposedValue.isEmpty())
		{
			return proposedValue;
		}
		return super.validate(proposedValue);
	}

}