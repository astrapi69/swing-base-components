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

import java.io.Serial;

import javax.swing.text.BadLocationException;

import lombok.NonNull;

/**
 * The class {@link DecimalNumberValuesDocument} provides a document for text components that only
 * allows decimal number values.
 */
public class DecimalNumberValuesDocument extends RegularExpressionDocument
{

	/** The Constant serialVersionUID. */
	@Serial
	private static final long serialVersionUID = 1L;

	/** The Constant for the default regular expression. */
	public static final String DEFAULT_REGEX = "^-?\\d*(\\.\\d*)?$"; // Updated regex to allow
																		// partial input

	/**
	 * Constructs a new <code>DecimalNumberValuesDocument</code> with the default regular
	 * expression.
	 */
	public DecimalNumberValuesDocument()
	{
		this(DEFAULT_REGEX);
	}

	/**
	 * Constructs a new <code>DecimalNumberValuesDocument</code> with the specified regular
	 * expression.
	 *
	 * @param regex
	 *            the regular expression to be used for validation
	 */
	public DecimalNumberValuesDocument(@NonNull String regex)
	{
		super(regex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
		throws BadLocationException
	{
		String currentText = getText(0, getLength());
		String proposedValue = currentText.substring(0, offs) + str + currentText.substring(offs);
		if (proposedValue.matches(DEFAULT_REGEX))
		{
			super.insertString(offs, str, a);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void replace(int offset, int length, String text, javax.swing.text.AttributeSet attrs)
		throws BadLocationException
	{
		String currentText = getText(0, getLength());
		String proposedValue = currentText.substring(0, offset) + text
			+ currentText.substring(offset + length);
		if (proposedValue.matches(DEFAULT_REGEX))
		{
			super.replace(offset, length, text, attrs);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String validate(String proposedValue) throws IllegalArgumentException
	{
		if (proposedValue.isEmpty() || proposedValue.matches(DEFAULT_REGEX))
		{
			return proposedValue;
		}
		else
		{
			throw new IllegalArgumentException("Value does not match the required format");
		}
	}
}
