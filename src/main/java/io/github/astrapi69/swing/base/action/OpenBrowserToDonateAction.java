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
package io.github.astrapi69.swing.base.action;

import java.awt.Component;

import io.github.astrapi69.browser.BrowserControlExtensions;
import io.github.astrapi69.swing.action.BaseOpenBrowserAction;
import lombok.NonNull;

/**
 * The class {@link OpenBrowserToDonateAction} is the action class for this project donation
 */
public class OpenBrowserToDonateAction extends BaseOpenBrowserAction
{
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/** The Constant URL_TO_DONATE. */
	private static final String URL_TO_DONATE = "http://sourceforge.net/donate/index.php?group_id=207406";

	/** The parent component */
	Component component;

	/**
	 * Instantiates a new {@link OpenBrowserToDonateAction}
	 */
	public OpenBrowserToDonateAction()
	{
		this("Donate", null);
	}

	/**
	 * Instantiates a new {@link OpenBrowserToDonateAction}.
	 *
	 * @param name
	 *            the name
	 * @param component
	 *            the component
	 */
	public OpenBrowserToDonateAction(final String name, final @NonNull Component component)
	{
		super();
		putValue(NAME, name);
		setUrl(URL_TO_DONATE);
		this.component = component;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onDisplayURLonStandardBrowser(String url)
	{
		if (this.component != null)
		{
			BrowserControlExtensions.displayURLonStandardBrowser(this.component, url);
		}
		else
		{
			BrowserControlExtensions.displayURLonStandardBrowser(url);
		}
	}
}
