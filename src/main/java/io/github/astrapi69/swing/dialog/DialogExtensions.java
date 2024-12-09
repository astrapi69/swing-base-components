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
package io.github.astrapi69.swing.dialog;

import java.awt.Component;
import java.awt.HeadlessException;
import java.util.stream.Stream;

import javax.swing.Icon;
import javax.swing.JOptionPane;

import io.github.astrapi69.throwable.ExceptionExtensions;
import lombok.experimental.UtilityClass;

/**
 * The class {@link DialogExtensions} provides methods for show dialogs.
 */
@UtilityClass
public class DialogExtensions
{

	/**
	 * Show exception dialog.
	 *
	 * @param exception
	 *            the exception
	 * @param parentComponent
	 *            determines the <code>Frame</code> in which the dialog is displayed; if
	 *            <code>null</code>, or if the <code>parentComponent</code> has no
	 *            <code>Frame</code>, a default <code>Frame</code> is used
	 * @param additionalMessages
	 *            the additional messages
	 */
	public static void showExceptionDialog(Exception exception, Component parentComponent,
		String... additionalMessages)
	{
		String title = exception.getLocalizedMessage();
		final StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<body width='650'>");
		sb.append("<h2>");
		sb.append(exception.getLocalizedMessage());
		sb.append("</h2>");
		sb.append("<p>");
		sb.append(ExceptionExtensions.getStackTraceElements(exception));
		Stream.of(additionalMessages).forEach(am -> sb.append("<p>" + am));
		String htmlMessage = sb.toString();
		JOptionPane.showMessageDialog(parentComponent, htmlMessage, title,
			JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Show an information message.
	 *
	 * @param parentComponent
	 *            determines the <code>Frame</code> in which the dialog is displayed; if
	 *            <code>null</code>, or if the <code>parentComponent</code> has no
	 *            <code>Frame</code>, a default <code>Frame</code> is used
	 * @param title
	 *            the title
	 * @param message
	 *            the information message
	 */
	public static void showInformationDialog(Component parentComponent, String title,
		String message)
	{
		showMessageDialog(parentComponent, title, message, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Show an information message.
	 *
	 * @param parentComponent
	 *            determines the <code>Frame</code> in which the dialog is displayed; if
	 *            <code>null</code>, or if the <code>parentComponent</code> has no
	 *            <code>Frame</code>, a default <code>Frame</code> is used
	 * @param title
	 *            the title
	 * @param message
	 *            the information message
	 * @param messageType
	 *            the information type
	 */
	public static void showMessageDialog(Component parentComponent, String title, String message,
		int messageType)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<html>").append("<body>").append(message).append("</body>").append("</html>");
		String htmlMessage = sb.toString();
		JOptionPane.showMessageDialog(parentComponent, htmlMessage, title, messageType);
	}

	/**
	 * Show a confirmation message for selecting one of a choice
	 *
	 * @param parentComponent
	 *            determines the <code>Frame</code> in which the dialog is displayed; if
	 *            <code>null</code>, or if the <code>parentComponent</code> has no
	 *            <code>Frame</code>, a default <code>Frame</code> is used
	 * @param title
	 *            the title
	 * @param message
	 *            the information message
	 * @param messageType
	 *            the information type
	 * @param optionType
	 *            an integer designating the options available on the dialog:
	 *            <code>YES_NO_OPTION</code>, <code>YES_NO_CANCEL_OPTION</code>, or
	 *            <code>OK_CANCEL_OPTION</code>
	 * @return an integer indicating the option selected by the user
	 */
	public static int showConfirmDialog(Component parentComponent, String title, String message,
		int optionType, int messageType, Icon icon)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<html>").append("<body>").append(message).append("</body>").append("</html>");
		String htmlMessage = sb.toString();
		return JOptionPane.showConfirmDialog(parentComponent, htmlMessage, title, optionType,
			messageType, icon);
	}

	/**
	 * Displays a dialog with customizable options and returns the user's selection.
	 *
	 * @param parentComponent
	 *            the parent component of the dialog, can be {@code null} to create a dialog with a
	 *            default frame
	 * @param message
	 *            the message to be displayed in the dialog
	 * @param title
	 *            the title of the dialog
	 * @param optionType
	 *            an integer indicating the options available on the dialog; one of
	 *            {@code JOptionPane.DEFAULT_OPTION}, {@code JOptionPane.YES_NO_OPTION},
	 *            {@code JOptionPane.YES_NO_CANCEL_OPTION}, or {@code JOptionPane.OK_CANCEL_OPTION}
	 * @param messageType
	 *            an integer indicating the type of message to be displayed; one of
	 *            {@code JOptionPane.ERROR_MESSAGE}, {@code JOptionPane.INFORMATION_MESSAGE},
	 *            {@code JOptionPane.WARNING_MESSAGE}, {@code JOptionPane.QUESTION_MESSAGE}, or
	 *            {@code JOptionPane.PLAIN_MESSAGE}
	 * @param icon
	 *            an icon to be displayed in the dialog, can be {@code null}
	 * @param options
	 *            an array of objects representing the options to display in the dialog; can be
	 *            {@code null} for default options
	 * @param initialValue
	 *            the value that is initially selected; can be {@code null}
	 * @return an integer indicating the option chosen by the user, or
	 *         {@code JOptionPane.CLOSED_OPTION} if the dialog is closed without a selection
	 * @throws HeadlessException
	 *             if GraphicsEnvironment.isHeadless() returns {@code true}
	 */
	public static int showOptionDialog(Component parentComponent, Object message, String title,
		int optionType, int messageType, Icon icon, Object[] options, Object initialValue)
		throws HeadlessException
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<html>").append("<body>").append(message).append("</body>").append("</html>");
		String htmlMessage = sb.toString();
		return JOptionPane.showOptionDialog(parentComponent, htmlMessage, title, optionType,
			messageType, icon, options, initialValue);
	}

	/**
	 * Show an information message.
	 *
	 * @param title
	 *            the title
	 * @param message
	 *            the information message
	 */
	public static void info(String title, String message)
	{
		showInformationDialog(null, title, message);
	}


}
