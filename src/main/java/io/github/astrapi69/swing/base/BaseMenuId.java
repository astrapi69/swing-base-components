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
package io.github.astrapi69.swing.base;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Accessors(fluent = true)
public enum BaseMenuId
{

	/**
	 * The id for the edit menu
	 */
	EDIT(BaseMenuId.EDIT_KEY),

	/**
	 * The id for the file menu
	 */
	FILE(BaseMenuId.FILE_KEY),

	/**
	 * The id for the help menu
	 */
	HELP(BaseMenuId.HELP_KEY),

	/**
	 * The id for the help content menu
	 */
	HELP_CONTENT(BaseMenuId.HELP_CONTENT_KEY),

	/**
	 * The id for the help donate menu
	 */
	HELP_DONATE(BaseMenuId.HELP_DONATE_KEY),

	/**
	 * The id for the help license menu
	 */
	HELP_LICENSE(BaseMenuId.HELP_LICENSE_KEY),

	/**
	 * The id for the help information menu
	 */
	HELP_INFO(BaseMenuId.HELP_INFO_KEY);

	public static final String EDIT_KEY = "global.menu.edit";
	public static final String FILE_KEY = "global.menu.file";
	public static final String HELP_KEY = "global.menu.help";
	public static final String HELP_CONTENT_KEY = "global.menu.help.content";
	public static final String HELP_DONATE_KEY = "global.menu.help.donate";
	public static final String HELP_LICENSE_KEY = "global.menu.help.license";
	public static final String HELP_INFO_KEY = "global.menu.help.info";

	/** the properties key from the current menu */
	String propertiesKey;

	BaseMenuId(final String propertiesKey)
	{
		this.propertiesKey = propertiesKey;
	}
}
