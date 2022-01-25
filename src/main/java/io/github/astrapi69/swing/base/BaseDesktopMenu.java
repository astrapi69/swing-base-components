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

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;

import javax.help.CSH;
import javax.help.DefaultHelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.help.WindowPresentation;
import javax.swing.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import io.github.astrapi69.swing.help.HelpFactory;
import io.github.astrapi69.swing.menu.MenuExtensions;
import io.github.astrapi69.swing.menu.MenuFactory;
import io.github.astrapi69.swing.plaf.actions.LookAndFeelGTKAction;
import io.github.astrapi69.swing.plaf.actions.LookAndFeelMetalAction;
import io.github.astrapi69.swing.plaf.actions.LookAndFeelMotifAction;
import io.github.astrapi69.swing.plaf.actions.LookAndFeelNimbusAction;
import io.github.astrapi69.swing.plaf.actions.LookAndFeelSystemAction;

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
		editMenu = newEditMenu(null);
		editMenu = menubar.add(editMenu);
		lookAndFeelMenu = newLookAndFeelMenu(null);
		lookAndFeelMenu = menubar.add(lookAndFeelMenu);
		helpMenu = newHelpMenu(null);
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
		final String path = directory + "/" + filename;
		try
		{
			hs = HelpFactory.newHelpSet(directory, filename);
		}
		catch (final HelpSetException e)
		{
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
	 * @param listener
	 *            the listener
	 *
	 * @return the j menu
	 */
	protected JMenu newEditMenu(final ActionListener listener)
	{
		return MenuFactory.newJMenu("Edit", 'E');
	}

	/**
	 * Factory method for create the file <code>JMenu</code>
	 *
	 * @return the j menu
	 */
	protected JMenu newFileMenu()
	{
		return MenuFactory.newJMenu("File", KeyEvent.VK_F);
	}

	protected DefaultHelpBroker newHelpBroker()
	{
		final HelpSet hs = getHelpSet();
		final DefaultHelpBroker helpBroker = (DefaultHelpBroker)hs.createHelpBroker();

		return helpBroker;
	}

	/**
	 * Creates the help menu.
	 *
	 * @param listener
	 *            the listener
	 * @return the j menu
	 */
	protected JMenu newHelpMenu(final ActionListener listener)
	{
		// Help menu
		final JMenu menuHelp = MenuFactory.newJMenu(newLabelTextHelp(), 'H');

		// Help JMenuItems
		// Help content
		final JMenuItem mihHelpContent = MenuFactory.newJMenuItem(newLabelTextContent(), 'c', 'H');
		menuHelp.add(mihHelpContent);

		// 2. assign help to components
		CSH.setHelpIDString(mihHelpContent, newLabelTextOverview());
		// 3. handle events
		final CSH.DisplayHelpFromSource displayHelpFromSource = new CSH.DisplayHelpFromSource(
			helpBroker);
		mihHelpContent.addActionListener(displayHelpFromSource);

		// Info
		final JMenuItem mihInfo = MenuFactory.newJMenuItem(newLabelTextInfo(), 'i', 'I');
		menuHelp.add(mihInfo);

		return menuHelp;
	}

	protected Window newHelpWindow(final DefaultHelpBroker helpBroker)
	{
		// found bug with the javax.help
		// Exception in thread "main" java.lang.SecurityException: no manifiest
		// section for signature file entry
		// com/sun/java/help/impl/TagProperties.class
		// Solution is to remove the rsa files from the jar
		final WindowPresentation pres = helpBroker.getWindowPresentation();
		pres.createHelpWindow();
		Window helpWindow = pres.getHelpWindow();

		helpWindow.setLocationRelativeTo(null);

		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (final Exception e)
		{
			String title = e.getLocalizedMessage();
			String htmlMessage = "<html><body width='650'>" + "<h2>" + title + "</h2>" + "<p>"
				+ e.getMessage();
			JOptionPane.showMessageDialog(this.getParent(), htmlMessage, title,
				JOptionPane.ERROR_MESSAGE);
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return helpWindow;
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
	 * Creates the look and feel menu.
	 *
	 * @param listener
	 *            the listener
	 * @return the j menu
	 */
	protected JMenu newLookAndFeelMenu(final ActionListener listener)
	{

		final JMenu menuLookAndFeel = MenuFactory.newJMenu("Look and Feel", 'L');

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
		MenuExtensions.setCtrlAccelerator(jmiPlafGTK, 'G');
		jmiPlafGTK.addActionListener(new LookAndFeelGTKAction("GTK", this.applicationFrame));
		menuLookAndFeel.add(jmiPlafGTK);
		// Metal default Metal theme
		JMenuItem jmiPlafMetal = MenuFactory.newJMenuItem("Metal", 'm', 'M');
		jmiPlafMetal.addActionListener(new LookAndFeelMetalAction("Metal", this.applicationFrame));
		menuLookAndFeel.add(jmiPlafMetal);
		// Metal Ocean theme
		JMenuItem jmiPlafOcean = MenuFactory.newJMenuItem("Ocean", 'o', 'O');
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
		MenuExtensions.setCtrlAccelerator(jmiPlafSystem, 'W');
		jmiPlafSystem
			.addActionListener(new LookAndFeelSystemAction("System", this.applicationFrame));
		menuLookAndFeel.add(jmiPlafSystem);

		return menuLookAndFeel;

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
