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

import java.util.LinkedHashMap;
import java.util.Map;

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
	HELP_INFO(BaseMenuId.HELP_INFO_KEY),

	/**
	 * The id for the main look and feel menu
	 */
	LOOK_AND_FEEL(BaseMenuId.LOOK_AND_FEEL_KEY),

	/**
	 * The id for the gtk look and feel menu
	 */
	LOOK_AND_FEEL_GTK(BaseMenuId.LOOK_AND_FEEL_GTK_KEY),

	/**
	 * The id for the metal look and feel menu
	 */
	LOOK_AND_FEEL_METAL(BaseMenuId.LOOK_AND_FEEL_METAL_KEY),

	/**
	 * The id for the ocean look and feel menu
	 */
	LOOK_AND_FEEL_OCEAN(BaseMenuId.LOOK_AND_FEEL_OCEAN_KEY),

	/**
	 * The id for the motif look and feel menu
	 */
	LOOK_AND_FEEL_MOTIF(BaseMenuId.LOOK_AND_FEEL_MOTIF_KEY),

	/**
	 * The id for the nimbus look and feel menu
	 */
	LOOK_AND_FEEL_NIMBUS(BaseMenuId.LOOK_AND_FEEL_NIMBUS_KEY),

	/**
	 * The id for the system look and feel menu
	 */
	LOOK_AND_FEEL_SYSTEM(BaseMenuId.LOOK_AND_FEEL_SYSTEM_KEY),

	/**
	 * The id for the toggle to fullscreen menu
	 */
	TOGGLE_FULLSCREEN(BaseMenuId.TOGGLE_FULLSCREEN_KEY),

	/**
	 * The id for the exit application menu
	 */
	EXIT(BaseMenuId.EXIT_KEY);

	public static final String EDIT_KEY = "global.menu.edit";
	public static final String LOOK_AND_FEEL_KEY = "global.menu.look.and.feel";
	public static final String LOOK_AND_FEEL_GTK_KEY = "global.menu.look.and.feel.gtk";
	public static final String LOOK_AND_FEEL_METAL_KEY = "global.menu.look.and.feel.metal";
	public static final String LOOK_AND_FEEL_OCEAN_KEY = "global.menu.look.and.feel.ocean";
	public static final String LOOK_AND_FEEL_MOTIF_KEY = "global.menu.look.and.feel.motif";
	public static final String LOOK_AND_FEEL_NIMBUS_KEY = "global.menu.look.and.feel.nimbus";
	public static final String LOOK_AND_FEEL_SYSTEM_KEY = "global.menu.look.and.feel.system";
	public static final String FILE_KEY = "global.menu.file";
	public static final String HELP_KEY = "global.menu.help";
	public static final String HELP_CONTENT_KEY = "global.menu.help.content";
	public static final String HELP_DONATE_KEY = "global.menu.help.donate";
	public static final String HELP_LICENSE_KEY = "global.menu.help.license";
	public static final String HELP_INFO_KEY = "global.menu.help.info";
	public static final String TOGGLE_FULLSCREEN_KEY = "global.menu.file.toggle.fullscreen";
	public static final String EXIT_KEY = "global.menu.file.exit";

	/** the properties key from the current menu */
	String propertiesKey;

	BaseMenuId(final String propertiesKey)
	{
		this.propertiesKey = propertiesKey;
	}

	public static Map<String, Boolean> getBaseMenuIdsAsMap()
	{
		Map<String, Boolean> menuIds = new LinkedHashMap<>();
		menuIds.put(BaseMenuId.EDIT.propertiesKey(), true);
		menuIds.put(BaseMenuId.FILE.propertiesKey(), true);
		menuIds.put(BaseMenuId.HELP.propertiesKey(), true);
		menuIds.put(BaseMenuId.HELP_CONTENT.propertiesKey(), true);
		menuIds.put(BaseMenuId.HELP_DONATE.propertiesKey(), true);
		menuIds.put(BaseMenuId.HELP_LICENSE.propertiesKey(), true);
		menuIds.put(BaseMenuId.HELP_INFO.propertiesKey(), true);
		menuIds.put(BaseMenuId.LOOK_AND_FEEL.propertiesKey(), true);
		menuIds.put(BaseMenuId.LOOK_AND_FEEL_GTK.propertiesKey(), true);
		menuIds.put(BaseMenuId.LOOK_AND_FEEL_METAL.propertiesKey(), true);
		menuIds.put(BaseMenuId.LOOK_AND_FEEL_OCEAN.propertiesKey(), true);
		menuIds.put(BaseMenuId.LOOK_AND_FEEL_MOTIF.propertiesKey(), true);
		menuIds.put(BaseMenuId.LOOK_AND_FEEL_NIMBUS.propertiesKey(), true);
		menuIds.put(BaseMenuId.LOOK_AND_FEEL_SYSTEM.propertiesKey(), true);
		menuIds.put(BaseMenuId.LOOK_AND_FEEL_SYSTEM.propertiesKey(), true);
		menuIds.put(BaseMenuId.TOGGLE_FULLSCREEN.propertiesKey(), true);
		menuIds.put(BaseMenuId.EXIT.propertiesKey(), true);
		return menuIds;
	}
}
