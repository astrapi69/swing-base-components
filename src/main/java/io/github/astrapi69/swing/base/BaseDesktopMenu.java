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
import java.awt.Window;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;

import javax.help.CSH;
import javax.help.DefaultHelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.LookAndFeel;
import javax.swing.MenuElement;
import javax.swing.UIManager;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import io.github.astrapi69.swing.action.ExitApplicationAction;
import io.github.astrapi69.swing.action.OpenBrowserAction;
import io.github.astrapi69.swing.action.OpenBrowserToDonateAction;
import io.github.astrapi69.swing.action.ShowInfoDialogAction;
import io.github.astrapi69.swing.action.ShowLicenseFrameAction;
import io.github.astrapi69.swing.action.ToggleFullScreenAction;
import io.github.astrapi69.swing.dialog.info.InfoDialog;
import io.github.astrapi69.swing.dialog.info.InfoPanel;
import io.github.astrapi69.swing.help.HelpFactory;
import io.github.astrapi69.swing.menu.MenuExtensions;
import io.github.astrapi69.swing.menu.MenuFactory;
import io.github.astrapi69.swing.menu.builder.JMenuItemInfo;
import io.github.astrapi69.swing.plaf.action.LookAndFeelGTKAction;
import io.github.astrapi69.swing.plaf.action.LookAndFeelMetalAction;
import io.github.astrapi69.swing.plaf.action.LookAndFeelMotifAction;
import io.github.astrapi69.swing.plaf.action.LookAndFeelNimbusAction;
import io.github.astrapi69.swing.plaf.action.LookAndFeelSystemAction;

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
	/** The default help broker */
	final DefaultHelpBroker helpBroker;
	/** The help window. */
	final Window helpWindow;
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
		helpBroker = newHelpBroker();
		helpWindow = newHelpWindow(helpBroker);
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
	 * Gets the help set.
	 *
	 * @return the help set
	 */
	public HelpSet getHelpSet()
	{
		HelpSet hs = null;
		final String filename = "simple-hs.xml";
		String directory = "help";
		try
		{
			hs = HelpFactory.newHelpSet(directory, filename);
		}
		catch (final HelpSetException e)
		{
			final String path = directory + "/" + filename;
			String title = e.getLocalizedMessage();
			String htmlMessage = "<html><body width='650'>" + "<h2>" + title + "</h2>" + "<p>"
				+ e.getMessage() + "\n" + path;
			JOptionPane.showMessageDialog(this.getParent(), htmlMessage, title,
				JOptionPane.ERROR_MESSAGE);
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return hs;
	}

	/**
	 * Creates the file menu.
	 *
	 * @return the j menu
	 */
	protected JMenu newEditMenu()
	{
		return JMenuItemInfo.builder().text("Edit").mnemonic(MenuExtensions.toMnemonic('E'))
			.name(BaseMenuId.EDIT.propertiesKey()).build().toJMenu();
	}

	/**
	 * Factory method for create the file <code>JMenu</code>
	 *
	 * @return the j menu
	 */
	protected JMenu newFileMenu()
	{

		// File
		final JMenu fileMenu = JMenuItemInfo.builder().text("File")
			.mnemonic(MenuExtensions.toMnemonic('F')).name(BaseMenuId.FILE.propertiesKey()).build()
			.toJMenu();

		// Fullscreen
		JMenuItem toggleFullscreenMenuItem = JMenuItemInfo.builder().text("Toggle Fullscreen")
			.mnemonic(MenuExtensions.toMnemonic('T'))
			.keyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_F11, InputEvent.ALT_DOWN_MASK))
			.actionListener(new ToggleFullScreenAction("Fullscreen", (JFrame)getApplicationFrame()))
			.name(BaseMenuId.TOGGLE_FULLSCREEN.propertiesKey()).build().toJMenuItem();
		fileMenu.add(toggleFullscreenMenuItem);

		// Exit
		JMenuItem exitMenuItem = JMenuItemInfo.builder().text("Exit")
			.mnemonic(MenuExtensions.toMnemonic('E'))
			.keyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK))
			.actionListener(new ExitApplicationAction("Exit")).name(BaseMenuId.EXIT.propertiesKey())
			.build().toJMenuItem();
		fileMenu.add(exitMenuItem);
		return fileMenu;
	}

	protected DefaultHelpBroker newHelpBroker()
	{
		return (DefaultHelpBroker)getHelpSet().createHelpBroker();
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
		final JMenu menuHelp = JMenuItemInfo.builder().text(newLabelTextHelp())
			.mnemonic(MenuExtensions.toMnemonic('H')).name(BaseMenuId.HELP.propertiesKey()).build()
			.toJMenu();

		// Help JMenuItems
		// Help content
		final JMenuItem mihHelpContent = JMenuItemInfo.builder().text(newLabelTextContent())
			.mnemonic(MenuExtensions.toMnemonic('c'))
			.keyStroke(KeyStroke.getKeyStroke('H', Event.CTRL_MASK))
			.name(BaseMenuId.HELP_CONTENT.propertiesKey()).build().toJMenuItem();
		menuHelp.add(mihHelpContent);

		// 2. assign help to components
		CSH.setHelpIDString(mihHelpContent, newLabelTextOverview());
		// 3. handle events
		final CSH.DisplayHelpFromSource displayHelpFromSource = new CSH.DisplayHelpFromSource(
			helpBroker);
		mihHelpContent.addActionListener(displayHelpFromSource);
		// Donate
		final JMenuItem mihDonate = JMenuItemInfo.builder().text(newLabelTextDonate())
			.actionListener(newOpenBrowserToDonateAction(newLabelTextDonate(), applicationFrame))
			.name(BaseMenuId.HELP_DONATE.propertiesKey()).build().toJMenuItem();
		menuHelp.add(mihDonate);
		// Licence
		final JMenuItem mihLicence = JMenuItemInfo.builder().text(newLabelTextLicence())
			.actionListener(
				newShowLicenseFrameAction(newLabelTextLicence() + "Action", newLabelTextLicence()))
			.name(BaseMenuId.HELP_LICENSE.propertiesKey()).build().toJMenuItem();
		menuHelp.add(mihLicence);
		// Info
		final JMenuItem mihInfo = JMenuItemInfo.builder().text(newLabelTextInfo())
			.mnemonic(MenuExtensions.toMnemonic('i'))
			.keyStroke(KeyStroke.getKeyStroke('I', Event.CTRL_MASK))
			.actionListener(newShowInfoDialogAction(newLabelTextInfo(),
				(Frame)getApplicationFrame(), newLabelTextInfo()))
			.name(BaseMenuId.HELP_INFO.propertiesKey()).build().toJMenuItem();

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


	protected Window newHelpWindow(final DefaultHelpBroker helpBroker)
	{
		return HelpFactory.newHelpWindow(helpBroker);
	}

	/**
	 * Creates a new {@link JMenuBar}
	 *
	 * @return the new {@link JMenuBar}
	 */
	protected JMenuBar newJMenuBar()
	{
		return MenuFactory.newJMenuBar();
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
		final JMenu menuLookAndFeel = JMenuItemInfo.builder().text("Look and Feel")
				.mnemonic(MenuExtensions.toMnemonic('L'))
				.name(BaseMenuId.LOOK_AND_FEEL.propertiesKey())
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
		JMenuItem jmiPlafMetal = MenuFactory.newJMenuItem("Metal", 'm', 'M');

		jmiPlafMetal.setName(BaseMenuId.LOOK_AND_FEEL_METAL.propertiesKey());
		jmiPlafMetal.addActionListener(new LookAndFeelMetalAction("Metal", this.applicationFrame));
		menuLookAndFeel.add(jmiPlafMetal);
		// Metal Ocean theme
		JMenuItem jmiPlafOcean = MenuFactory.newJMenuItem("Ocean", 'o', 'O');
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
