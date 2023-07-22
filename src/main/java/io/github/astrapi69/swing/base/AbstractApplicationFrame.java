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
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.UnsupportedLookAndFeelException;

import io.github.astrapi69.lang.ClassExtensions;
import io.github.astrapi69.swing.component.replace.ReplaceContentExtensions;
import io.github.astrapi69.swing.menu.factory.JMenuBarFactory;
import io.github.astrapi69.swing.menu.factory.JToolBarFactory;
import io.github.astrapi69.swing.plaf.LookAndFeels;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;

/**
 * The class {@link AbstractApplicationFrame}
 *
 * @param <T>
 *            the generic type of the model object
 */
@ToString
@EqualsAndHashCode(callSuper = true)
@Log
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class AbstractApplicationFrame<T, C extends JComponent> extends BaseFrame<T>
{

	/**
	 * Constant for the default configuration directory name from the current application. current
	 * value:".config"
	 */
	public static final String DEFAULT_APPLICATION_CONFIGURATION_DIRECTORY_NAME = ".config";
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/** The configuration directory for configuration files. */
	@Getter
	File configurationDirectory;
	/** The current look and feels. */
	@Getter
	@Setter
	LookAndFeels currentLookAndFeels = LookAndFeels.SYSTEM;
	@Getter
	BufferedImage icon;
	/**
	 * The main component.
	 */
	@Getter
	C mainComponent;

	/** The menu. */
	@Getter
	JMenu menu;

	/** The application name */
	@Getter
	String applicationName;

	/**
	 * Instantiates a new {@link AbstractApplicationFrame}
	 *
	 * @param title
	 *            the title
	 */
	public AbstractApplicationFrame(String title)
	{
		super(title);
	}

	@Override
	protected void onBeforeInitialize()
	{
		super.onBeforeInitialize();
		applicationName = newApplicationName();
		configurationDirectory = newConfigurationDirectory(System.getProperty("user.home"),
			newApplicationConfigurationDirectoryName());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();
		setToolBar(newJToolBar());
		menu = newDesktopMenu(this);
		setJMenuBar(newJMenuBar());
		getContentPane().add(mainComponent = newMainComponent());
		getIcon(newIconPath()).ifPresent(i -> {
			AbstractApplicationFrame.this.icon = i;
			setIconImage(i);
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Replace the old main component with the given component
	 * 
	 * @param newMainComponent
	 *            the new main component
	 */
	public void replaceMainComponent(@NonNull C newMainComponent)
	{
		ReplaceContentExtensions.replaceContentAndRevalidate(getContentPane(), mainComponent,
			newMainComponent);
		mainComponent = newMainComponent;
		repaint();
		revalidate();
	}

	/**
	 * Creates a new {@link JMenuBar}
	 *
	 * @return the new {@link JMenuBar}
	 */
	protected JMenuBar newJMenuBar()
	{
		if (menu instanceof BaseDesktopMenu)
		{
			return ((BaseDesktopMenu)menu).getMenubar();
		}
		return JMenuBarFactory.newJMenuBar();
	}

	/**
	 * Factory method for create the new application name. This method is invoked in the constructor
	 * and should be overridden from the derived classes for set the actual application name
	 *
	 * @return the new application name
	 */
	protected String newApplicationName()
	{
		return "";
	}

	/**
	 * Factory method for create a new {@link Optional} object that contains a {@link BufferedImage}
	 * with the icon
	 *
	 * @param iconPath
	 *            the icon path
	 * @return the icon
	 */
	protected Optional<BufferedImage> getIcon(@NonNull String iconPath)
	{
		Optional<BufferedImage> optional = Optional.empty();
		try
		{
			BufferedImage bufferedImage = ImageIO
				.read(ClassExtensions.getResourceAsStream(iconPath));
			optional = Optional.of(bufferedImage);
		}
		catch (IOException e)
		{
			String title = e.getLocalizedMessage();
			String htmlMessage = "<html><body width='650'>" + "<h2>" + title + "</h2>" + "<p>"
				+ e.getMessage();
			JOptionPane.showMessageDialog(this, htmlMessage, title, JOptionPane.ERROR_MESSAGE);
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return optional;
	}

	/**
	 * Factory method for create a new configuration directory {@link File} object if it is not
	 * exists. This method is invoked in the constructor and can be overridden from the derived
	 * classes so users can provide their own version of a new configuration {@link File} object
	 *
	 * @param parent
	 *            the parent
	 * @param child
	 *            the child
	 * @return the new configuration directory {@link File} object or the existing one
	 */
	protected File newConfigurationDirectory(final @NonNull String parent,
		final @NonNull String child)
	{
		File configurationDir = new File(parent, child);
		if (!configurationDir.exists())
		{
			configurationDir.mkdir();
		}
		return configurationDir;
	}

	/**
	 * Factory method for create the new application configuration directory name. This method is
	 * invoked in the constructor and should be overridden from the derived classes for set the
	 * actual application name
	 *
	 * @return the new application configuration directory name
	 */
	protected String newApplicationConfigurationDirectoryName()
	{
		return DEFAULT_APPLICATION_CONFIGURATION_DIRECTORY_NAME;
	}

	/**
	 * Factory method for create a new {@link BaseDesktopMenu} object.
	 *
	 * @param applicationFrame
	 *            the application frame
	 * @return the new {@link JMenu} object
	 */
	protected JMenu newDesktopMenu(@NonNull Component applicationFrame)
	{
		return new BaseDesktopMenu(applicationFrame);
	}

	/**
	 * Abstact factory method that returns the path of the icon of the application
	 *
	 * @return the path of the icon of the application as string
	 */
	protected abstract String newIconPath();

	/**
	 * Factory method for create a new {@link JToolBar} object
	 *
	 * @return the new {@link JToolBar} object
	 */
	protected JToolBar newJToolBar()
	{
		return JToolBarFactory.newJToolBar();
	}

	/**
	 * Factory method for create a new {@link LookAndFeels} object
	 *
	 * @return the new {@link LookAndFeels} object
	 */
	protected LookAndFeels newLookAndFeels()
	{
		return LookAndFeels.SYSTEM;
	}

	/**
	 * Factory method for create a new {@link JComponent} object
	 *
	 * @return the new {@link JComponent} object
	 */
	protected abstract C newMainComponent();

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onAfterInitialize()
	{
		super.onAfterInitialize();
	}

	/**
	 * Sets the given {@link LookAndFeels} to the given {@link Component} and returns given
	 * {@link LookAndFeels}
	 *
	 * @param lookAndFeels
	 *            the look and feels
	 * @param component
	 *            the component
	 * @return the current {@link LookAndFeels}
	 */
	protected LookAndFeels setDefaultLookAndFeel(@NonNull LookAndFeels lookAndFeels,
		Window component)
	{
		try
		{
			LookAndFeels.setLookAndFeel(lookAndFeels, component);
			setCurrentLookAndFeels(lookAndFeels);
		}
		catch (final ClassNotFoundException | InstantiationException | IllegalAccessException
			| UnsupportedLookAndFeelException e)
		{
			String title = e.getLocalizedMessage();
			String htmlMessage = "<html><body width='650'>" + "<h2>" + title + "</h2>" + "<p>"
				+ e.getMessage();
			JOptionPane.showMessageDialog(this, htmlMessage, title, JOptionPane.ERROR_MESSAGE);
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return lookAndFeels;
	}

}
