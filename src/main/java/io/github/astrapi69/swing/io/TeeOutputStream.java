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

import java.io.IOException;
import java.io.OutputStream;

/**
 * A {@link TeeOutputStream} duplicates the data written to it, sending output to both the specified
 * {@code originalStream} and an {@code additionalStream}. This is useful for cases where you want
 * to mirror output to two different destinations, such as logging to the console and displaying in
 * a GUI component.
 */
public class TeeOutputStream extends OutputStream
{
	private final OutputStream originalStream;
	private final OutputStream additionalStream;

	/**
	 * Constructs a new {@code TeeOutputStream} that writes to both the specified
	 * {@code originalStream} and {@code additionalStream}.
	 *
	 * @param originalStream
	 *            the primary output stream where data will be written first
	 * @param additionalStream
	 *            the secondary output stream that will receive a copy of all data
	 */
	public TeeOutputStream(OutputStream originalStream, OutputStream additionalStream)
	{
		this.originalStream = originalStream;
		this.additionalStream = additionalStream;
	}

	/**
	 * Writes a single byte to both the {@code originalStream} and {@code additionalStream}.
	 *
	 * @param b
	 *            the byte to be written
	 * @throws IOException
	 *             if an I/O error occurs when writing to either output stream
	 */
	@Override
	public void write(int b) throws IOException
	{
		originalStream.write(b);
		additionalStream.write(b);
	}

	/**
	 * Writes a portion of a byte array to both the {@code originalStream} and
	 * {@code additionalStream}.
	 *
	 * @param b
	 *            the byte array containing the data to write
	 * @param off
	 *            the start offset in the data
	 * @param len
	 *            the number of bytes to write
	 * @throws IOException
	 *             if an I/O error occurs when writing to either output stream
	 */
	@Override
	public void write(byte[] b, int off, int len) throws IOException
	{
		originalStream.write(b, off, len);
		additionalStream.write(b, off, len);
	}

	/**
	 * Flushes both the {@code originalStream} and {@code additionalStream}, ensuring any buffered
	 * data is fully written out.
	 *
	 * @throws IOException
	 *             if an I/O error occurs while flushing either output stream
	 */
	@Override
	public void flush() throws IOException
	{
		originalStream.flush();
		additionalStream.flush();
	}

	/**
	 * Closes both the {@code originalStream} and {@code additionalStream}, releasing any resources
	 * associated with each stream.
	 *
	 * @throws IOException
	 *             if an I/O error occurs while closing either output stream
	 */
	@Override
	public void close() throws IOException
	{
		originalStream.close();
		additionalStream.close();
	}
}
