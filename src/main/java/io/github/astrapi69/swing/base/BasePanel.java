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

import java.awt.LayoutManager;

import javax.swing.JPanel;

import io.github.astrapi69.model.api.IModel;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link BasePanel} for swing panels to provide an initialization cycle where the user
 * can overwrite the callback methods for interaction.
 *
 * @param <T>
 *            the generic type of the model object
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BasePanel<T> extends JPanel
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The model. */
	IModel<T> model;

	/**
	 * Instantiates a new {@link BasePanel} object.
	 */
	public BasePanel()
	{
		initialize();
	}

	/**
	 * Instantiates a new {@link BasePanel} object.
	 *
	 * @param isDoubleBuffered
	 *            the is double buffered
	 */
	public BasePanel(final boolean isDoubleBuffered)
	{
		super(isDoubleBuffered);
		initialize();
	}

	/**
	 * Instantiates a new {@link BasePanel} object.
	 *
	 * @param layout
	 *            the layout
	 */
	public BasePanel(final LayoutManager layout)
	{
		super(layout);
	}

	/**
	 * Instantiates a new {@link BasePanel} object.
	 *
	 * @param layout
	 *            the layout
	 * @param isDoubleBuffered
	 *            the is double buffered
	 */
	public BasePanel(final LayoutManager layout, final boolean isDoubleBuffered)
	{
		super(layout, isDoubleBuffered);
		initialize();
	}

	/**
	 * Instantiates a new {@link BasePanel} object.
	 *
	 * @param model
	 *            the model
	 */
	public BasePanel(final IModel<T> model)
	{
		this.model = model;
		initialize();
	}

	/**
	 * Getter for the model's object
	 *
	 * @return the model object
	 */
	public final T getModelObject()
	{
		return getModel().getObject();
	}

	/**
	 * Setter for the model object.
	 *
	 * @param modelObject
	 *            the new model object
	 * @return this for chaining
	 */
	public final BasePanel<T> setModelObject(final T modelObject)
	{
		getModel().setObject(modelObject);
		return this;
	}

	/**
	 * Initialize the component.
	 */
	private final void initialize()
	{
		onInitialize();
	}

	/**
	 * Initialize components from the component.
	 */
	private final void initializeComponents()
	{
		onInitializeComponents();
	}

	/**
	 * Initialize layout from the component.
	 */
	private final void initializeLayout()
	{
		onInitializeLayout();
	}

	/**
	 * Callback method to interact when the initialization of the component is finished.
	 */
	protected void onAfterInitialize()
	{
	}

	/**
	 * Callback method to interact when the initialization is finished of the components from the
	 * component.
	 */
	protected void onAfterInitializeComponents()
	{
	}

	/**
	 * Callback method to interact when the initialization of the layout is finished.
	 */
	protected void onAfterInitializeLayout()
	{
	}

	/**
	 * Callback method to interact on before initialization of the component.
	 */
	protected void onBeforeInitialize()
	{
	}

	/**
	 * Callback method to interact on before initialization of the components from the component.
	 */
	protected void onBeforeInitializeComponents()
	{
	}

	/**
	 * Callback method to interact on before initialization of the layout.
	 */
	protected void onBeforeInitializeLayout()
	{
	}

	/**
	 * Callback method to initialize the component.
	 */
	protected void onInitialize()
	{
		onBeforeInitialize();
		onBeforeInitializeComponents();
		initializeComponents();
		onAfterInitializeComponents();
		onBeforeInitializeLayout();
		initializeLayout();
		onAfterInitializeLayout();
		onAfterInitialize();
	}

	/**
	 * Callback method to initialize components from the component.
	 */
	protected void onInitializeComponents()
	{
	}

	/**
	 * Callback method to initialize layout from the component.
	 */
	protected void onInitializeLayout()
	{
	}


}
