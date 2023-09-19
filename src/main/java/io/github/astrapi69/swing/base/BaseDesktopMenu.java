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

import java.awt.Component;
import java.awt.Event;
import java.awt.Frame;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.LookAndFeel;
import javax.swing.MenuElement;
import javax.swing.UIManager;

import io.github.astrapi69.swing.action.ExitApplicationAction;
import io.github.astrapi69.swing.action.OpenBrowserAction;
import io.github.astrapi69.swing.action.ShowInfoDialogAction;
import io.github.astrapi69.swing.action.ToggleFullScreenAction;
import io.github.astrapi69.swing.base.action.OpenBrowserToDonateAction;
import io.github.astrapi69.swing.base.action.ShowLicenseFrameAction;
import io.github.astrapi69.swing.dialog.info.InfoDialog;
import io.github.astrapi69.swing.dialog.info.InfoPanel;
import io.github.astrapi69.swing.menu.KeyStrokeExtensions;
import io.github.astrapi69.swing.menu.MenuExtensions;
import io.github.astrapi69.swing.menu.factory.JMenuBarFactory;
import io.github.astrapi69.swing.menu.factory.JMenuItemFactory;
import io.github.astrapi69.swing.menu.model.KeyStrokeInfo;
import io.github.astrapi69.swing.menu.model.MenuInfo;
import io.github.astrapi69.swing.menu.model.MenuItemInfo;
import io.github.astrapi69.swing.plaf.action.LookAndFeelGTKAction;
import io.github.astrapi69.swing.plaf.action.LookAndFeelMetalAction;
import io.github.astrapi69.swing.plaf.action.LookAndFeelMotifAction;
import io.github.astrapi69.swing.plaf.action.LookAndFeelNimbusAction;
import io.github.astrapi69.swing.plaf.action.LookAndFeelSystemAction;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;

/**
 * The class {@link BaseDesktopMenu} holds the base menu items for an application
 */
@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class BaseDesktopMenu extends JMenu
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The application frame. */
	final Component applicationFrame;
	/** The JMenuBar from the DesktopMenu. */
	final JMenuBar menubar;
	/** The edit menu. */
	JMenu editMenu;
	/** The file menu. */
	JMenu fileMenu;
	/** The help menu. */
	JMenu helpMenu;
	/** The look and feel menu. */
	JMenu lookAndFeelMenu;

	/**
	 * Instantiates a new {@link BaseDesktopMenu}
	 *
	 * @param applicationFrame
	 *            the application frame
	 */
	public BaseDesktopMenu(@NonNull Component applicationFrame)
	{
		this.applicationFrame = applicationFrame;
		menubar = newJMenuBar();
		fileMenu = newFileMenu();
		fileMenu = menubar.add(fileMenu);
		editMenu = newEditMenu();
		editMenu = menubar.add(editMenu);
		lookAndFeelMenu = newLookAndFeelMenu();
		lookAndFeelMenu = menubar.add(lookAndFeelMenu);
		helpMenu = newHelpMenu();
		helpMenu = menubar.add(helpMenu);
		onRefreshMenus(fileMenu, editMenu, lookAndFeelMenu, helpMenu);
	}

	/**
	 * Creates the file menu.
	 *
	 * @return the j menu
	 */
	protected JMenu newEditMenu()
	{
		return MenuItemInfo.builder().menuInfo(MenuInfo.builder().text("Edit")
			.mnemonic(MenuExtensions.toMnemonic('E')).name(BaseMenuId.EDIT.propertiesKey()).build())
			.build().toJMenu();
	}

	/**
	 * Factory method for create the file <code>JMenu</code>
	 *
	 * @return the j menu
	 */
	protected JMenu newFileMenu()
	{

		// File
		final JMenu fileMenu = MenuItemInfo.builder()
			.menuInfo(MenuInfo.builder().text("File").mnemonic(MenuExtensions.toMnemonic('F'))
				.name(BaseMenuId.FILE.propertiesKey()).build())

			.build().toJMenu();

		// Fullscreen
		JMenuItem toggleFullscreenMenuItem = MenuItemInfo.builder()

			.menuInfo(MenuInfo.builder().text("Toggle Fullscreen")
				.mnemonic(MenuExtensions.toMnemonic('T'))
				.keyStrokeInfo(KeyStrokeInfo.toKeyStrokeInfo(
					KeyStroke.getKeyStroke(KeyEvent.VK_F11, InputEvent.ALT_DOWN_MASK)))
				.name(BaseMenuId.TOGGLE_FULLSCREEN.propertiesKey()).build())

			.actionListener(new ToggleFullScreenAction("Fullscreen", (JFrame)getApplicationFrame()))
			.build().toJMenuItem();
		fileMenu.add(toggleFullscreenMenuItem);

		// Exit
		JMenuItem exitMenuItem = MenuItemInfo.builder()

			.menuInfo(MenuInfo.builder().text("Exit").mnemonic(MenuExtensions.toMnemonic('E'))
				.name(BaseMenuId.EXIT.propertiesKey())
				.keyStrokeInfo(KeyStrokeInfo
					.toKeyStrokeInfo(KeyStrokeExtensions.getKeyStroke("alt pressed F4")))
				.build())


			.actionListener(new ExitApplicationAction("Exit")).build().toJMenuItem();
		fileMenu.add(exitMenuItem);
		return fileMenu;
	}

	/**
	 * Creates the help menu.
	 * 
	 * @return the j menu
	 */
	protected JMenu newHelpMenu()
	{
		// @formatter:on
		// Help menu
		final JMenu menuHelp = MenuItemInfo.builder()

			.menuInfo(
				MenuInfo.builder().text(newLabelTextHelp()).mnemonic(MenuExtensions.toMnemonic('H'))
					.name(BaseMenuId.HELP.propertiesKey()).build())

			.build().toJMenu();

		// Donate
		final JMenuItem mihDonate = MenuItemInfo.builder()

			.menuInfo(MenuInfo.builder().text(newLabelTextDonate())
				.name(BaseMenuId.HELP_DONATE.propertiesKey()).build())

			.actionListener(newOpenBrowserToDonateAction(newLabelTextDonate(), applicationFrame))
			.build().toJMenuItem();
		menuHelp.add(mihDonate);
		// Licence
		final JMenuItem mihLicence = MenuItemInfo.builder()

			.menuInfo(MenuInfo.builder().text(newLabelTextLicence())
				.name(BaseMenuId.HELP_LICENSE.propertiesKey()).build())

			.actionListener(
				newShowLicenseFrameAction(newLabelTextLicence() + "Action", newLabelTextLicence()))
			.build().toJMenuItem();
		menuHelp.add(mihLicence);
		// Info
		final JMenuItem mihInfo = MenuItemInfo.builder()

			.menuInfo(MenuInfo.builder().text(newLabelTextInfo())
				.name(BaseMenuId.HELP_INFO.propertiesKey()).mnemonic(MenuExtensions.toMnemonic('i'))
				.keyStrokeInfo(
					KeyStrokeInfo.toKeyStrokeInfo(KeyStroke.getKeyStroke('I', Event.CTRL_MASK)))
				.build())

			.actionListener(newShowInfoDialogAction(newLabelTextInfo(),
				(Frame)getApplicationFrame(), newLabelTextInfo()))
			.build().toJMenuItem();

		menuHelp.add(mihInfo);
		// @formatter:off
		return menuHelp;
	}

	protected ShowLicenseFrameAction newShowLicenseFrameAction(final String name,
		final @NonNull String title)
	{
		return new ShowLicenseFrameAction(name, title)
		{
			private static final long serialVersionUID = 1L;

			@Override
			protected String newLicenseText()
			{
				return onNewLicenseText();
			}
		};
	}

	protected OpenBrowserAction newOpenBrowserToDonateAction(final String name,
		final @NonNull Component component)
	{
		return new OpenBrowserToDonateAction(name, component);
	}

	protected ShowInfoDialogAction newShowInfoDialogAction(final String name,
		final @NonNull Frame owner, final @NonNull String title)
	{
		return new ShowInfoDialogAction(name, owner, title)
		{
			@Override
			protected JDialog newJDialog(Frame frame, String s)
			{
				return BaseDesktopMenu.this.onNewInfoDialog(owner, title);
			}
		};
	}

	protected InfoDialog onNewInfoDialog(Frame owner, String title)
	{
		return new InfoDialog(owner, title)
		{

			@Override
			protected InfoPanel newInfoPanel()
			{
				return new InfoPanel()
				{

					@Override
					protected String newLabelTextApplicationName()
					{
						return BaseDesktopMenu.this.newLabelTextApplicationName();
					}

					@Override
					protected String newLabelTextCopyright()
					{
						return BaseDesktopMenu.this.newLabelTextCopyright();
					}

					@Override
					protected String newLabelTextLabelApplicationName()
					{
						return BaseDesktopMenu.this.newLabelTextLabelApplicationName();
					}

					@Override
					protected String newLabelTextLabelCopyright()
					{
						return BaseDesktopMenu.this.newLabelTextLabelCopyright();
					}

					@Override
					protected String newLabelTextLabelVersion()
					{
						return BaseDesktopMenu.this.newLabelTextLabelVersion();
					}

					@Override
					protected String newLabelTextVersion()
					{
						return BaseDesktopMenu.this.newLabelTextVersion();
					}

					@Override
					protected String newTextWarning()
					{
						return BaseDesktopMenu.this.newTextWarning();
					}

				};
			}

			@Override
			protected String newLabelTextPlaceholder()
			{
				return "";
			}

		};
	}

	/**
	 * Creates a new {@link JMenuBar}
	 *
	 * @return the new {@link JMenuBar}
	 */
	protected JMenuBar newJMenuBar()
	{
		return JMenuBarFactory.newJMenuBar();
	}

	protected String newLabelTextApplicationName()
	{
		return "";
	}

	protected String newLabelTextContent()
	{
		return "Content";
	}


	protected String newLabelTextCopyright()
	{
		return "";
	}


	protected String newLabelTextDonate()
	{
		return "Donate";
	}


	protected String newLabelTextHelp()
	{
		return "Help";
	}


	protected String newLabelTextInfo()
	{
		return "Info";
	}


	protected String newLabelTextLabelApplicationName()
	{
		return "";
	}


	protected String newLabelTextLabelCopyright()
	{
		return "";
	}

	protected String newLabelTextLabelVersion()
	{
		return "";
	}

	protected String newLabelTextLicence()
	{
		return "Licence";
	}

	protected String newLabelTextOverview()
	{
		return "Overview";
	}


	protected String newLabelTextVersion()
	{
		return "";
	}

	/**
	 * Creates the look and feel menu
	 *
	 * @return the j menu
	 */
	protected JMenu newLookAndFeelMenu()
	{
		final JMenu menuLookAndFeel = MenuItemInfo.builder()

				.menuInfo(MenuInfo.builder()
						.text("Look and Feel")
						.mnemonic(MenuExtensions.toMnemonic('L'))
						.name(BaseMenuId.LOOK_AND_FEEL.propertiesKey())
						.build())

				.build().toJMenu();

		// Look and Feel JMenuItems
		// GTK
		JMenuItem jmiPlafGTK;
		jmiPlafGTK = new JMenuItem("GTK", 'g')
		{
			@Override
			public boolean isEnabled()
			{
				LookAndFeel lookAndFeel = UIManager.getLookAndFeel();
				if (lookAndFeel != null && lookAndFeel.getID().equalsIgnoreCase("GTK"))
				{
					return false;
				}
				return super.isEnabled();
			}
		}; // $NON-NLS-1$
		jmiPlafGTK.setName(BaseMenuId.LOOK_AND_FEEL_GTK.propertiesKey());
		MenuExtensions.setCtrlAccelerator(jmiPlafGTK, 'G');
		jmiPlafGTK.addActionListener(new LookAndFeelGTKAction("GTK", this.applicationFrame));
		menuLookAndFeel.add(jmiPlafGTK);
		// Metal default Metal theme
		JMenuItem jmiPlafMetal = JMenuItemFactory.newJMenuItem("Metal", 'm', 'M');

		jmiPlafMetal.setName(BaseMenuId.LOOK_AND_FEEL_METAL.propertiesKey());
		jmiPlafMetal.addActionListener(new LookAndFeelMetalAction("Metal", this.applicationFrame));
		menuLookAndFeel.add(jmiPlafMetal);
		// Metal Ocean theme
		JMenuItem jmiPlafOcean = JMenuItemFactory.newJMenuItem("Ocean", 'o', 'O');
		jmiPlafOcean.setName(BaseMenuId.LOOK_AND_FEEL_OCEAN.propertiesKey());
		jmiPlafOcean.addActionListener(new LookAndFeelMetalAction("Ocean", this.applicationFrame));
		menuLookAndFeel.add(jmiPlafOcean);
		// Motif
		JMenuItem jmiPlafMotiv = new JMenuItem("Motif", 't')
		{
			@Override
			public boolean isEnabled()
			{
				LookAndFeel lookAndFeel = UIManager.getLookAndFeel();
				if (lookAndFeel != null && lookAndFeel.getID().equalsIgnoreCase("Motif"))
				{
					return false;
				}
				return super.isEnabled();
			}
		}; // $NON-NLS-1$
		jmiPlafMotiv.setName(BaseMenuId.LOOK_AND_FEEL_MOTIF.propertiesKey());
		MenuExtensions.setCtrlAccelerator(jmiPlafMotiv, 'T');
		jmiPlafMotiv.addActionListener(new LookAndFeelMotifAction("Motif", this.applicationFrame));
		menuLookAndFeel.add(jmiPlafMotiv);
		// Nimbus
		JMenuItem jmiPlafNimbus = new JMenuItem("Nimbus", 'n')
		{
			@Override
			public boolean isEnabled()
			{
				LookAndFeel lookAndFeel = UIManager.getLookAndFeel();
				if (lookAndFeel != null && lookAndFeel.getID().equalsIgnoreCase("Nimbus"))
				{
					return false;
				}
				return super.isEnabled();
			}
		}; // $NON-NLS-1$
		jmiPlafNimbus.setName(BaseMenuId.LOOK_AND_FEEL_NIMBUS.propertiesKey());
		MenuExtensions.setCtrlAccelerator(jmiPlafNimbus, 'N');
		jmiPlafNimbus
			.addActionListener(new LookAndFeelNimbusAction("Nimbus", this.applicationFrame));
		menuLookAndFeel.add(jmiPlafNimbus);
		// Windows
		JMenuItem jmiPlafSystem = new JMenuItem("System", 'd')
		{
			@Override
			public boolean isEnabled()
			{
				LookAndFeel lookAndFeel = UIManager.getLookAndFeel();
				String systemLookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();
				if (lookAndFeel != null && lookAndFeel.getClass().getCanonicalName()
					.equalsIgnoreCase(systemLookAndFeelClassName))
				{
					return false;
				}
				return super.isEnabled();
			}
		}; // $NON-NLS-1$
		jmiPlafSystem.setName(BaseMenuId.LOOK_AND_FEEL_SYSTEM.propertiesKey());
		MenuExtensions.setCtrlAccelerator(jmiPlafSystem, 'W');
		jmiPlafSystem
			.addActionListener(new LookAndFeelSystemAction("System", this.applicationFrame));
		menuLookAndFeel.add(jmiPlafSystem);

		return menuLookAndFeel;

	}

	protected String newTextWarning()
	{
		return "";
	}

	protected String onNewLicenseText()
	{
		return "Licence Text";
	}

	protected void onRefreshMenus(JMenu... menus)
	{
		for (JMenu menu : menus)
		{
			refreshMenu(menu);
		}
	}

	protected void refreshMenu(JMenu menu)
	{
		MenuElement[] subElements = menu.getSubElements();
		menu.setVisible(subElements.length != 0);
	}

}
