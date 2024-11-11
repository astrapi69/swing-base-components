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
package io.github.astrapi69.swing.io;

import java.io.OutputStream;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * An {@link OutputStream} implementation that redirects data written to it into a specified
 * {@link JTextArea}. This is particularly useful for capturing console output (e.g.,
 * {@code System.out} or {@code System.err}) and displaying it within a Swing UI component.
 * <p>
 * <b>Example usage:</b>
 * 
 * <pre>
 * {
 * 	&#64;code
 * 	// Redirect System.out and System.err to logTextArea
 * 	TextAreaOutputStream textAreaOutputStream = new TextAreaOutputStream(logTextArea);
 * 	System.setOut(new java.io.PrintStream(textAreaOutputStream));
 * 	System.setErr(new java.io.PrintStream(textAreaOutputStream));
 * }
 * </pre>
 *
 * <p>
 * Alternatively, you can use {@link TeeOutputStream} to copy the output while preserving the
 * original {@code System.out} and {@code System.err} output:
 * 
 * <pre>
 * {
 * 	&#64;code
 * 	// Initialize your JTextArea for logging
 * 	JTextArea logTextArea = new JTextArea();
 * 	TextAreaOutputStream textAreaOutputStream = new TextAreaOutputStream(logTextArea);
 *
 * 	// Create TeeOutputStreams that copy to both the original console streams and the JTextArea
 * 	System
 * 		.setOut(new java.io.PrintStream(new TeeOutputStream(System.out, textAreaOutputStream)));
 * 	System
 * 		.setErr(new java.io.PrintStream(new TeeOutputStream(System.err, textAreaOutputStream)));
 * }
 * </pre>
 */
public class TextAreaOutputStream extends OutputStream
{
	private final JTextArea textArea;

	/**
	 * Constructs a new {@code TextAreaOutputStream} that will direct output to the specified
	 * {@link JTextArea}.
	 *
	 * @param textArea
	 *            the {@link JTextArea} where output data will be displayed
	 */
	public TextAreaOutputStream(JTextArea textArea)
	{
		this.textArea = textArea;
	}

	/**
	 * Writes a single byte to the {@link JTextArea}. This method overrides the
	 * {@code OutputStream.write(int)} method to append the character representation of the byte to
	 * the text area.
	 * <p>
	 * Note: This method schedules the text area update on the Event Dispatch Thread (EDT) to
	 * maintain thread safety.
	 *
	 * @param b
	 *            the byte to be written, with only the lower 8 bits used
	 */
	@Override
	public void write(int b)
	{
		SwingUtilities.invokeLater(() -> textArea.append(String.valueOf((char)b)));
	}

	/**
	 * Writes a portion of an array of bytes to the {@link JTextArea}. This method converts the byte
	 * array segment to a string and appends it to the text area.
	 * <p>
	 * Note: This method schedules the text area update on the Event Dispatch Thread (EDT) to
	 * maintain thread safety.
	 *
	 * @param b
	 *            the byte array to write from
	 * @param off
	 *            the start offset in the data
	 * @param len
	 *            the number of bytes to write
	 */
	@Override
	public void write(byte[] b, int off, int len)
	{
		SwingUtilities.invokeLater(() -> textArea.append(new String(b, off, len)));
	}
}
