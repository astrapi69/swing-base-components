package io.github.astrapi69.swing.panel.info;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.swing.base.BasePanel;

import javax.swing.*;
import java.awt.*;

public class AppInfoPanel extends BasePanel<InfoModelBean>
{

	private static final long serialVersionUID = 1L;

	/** The application name. */
	private JLabel applicationName;

	/** The copyright. */
	private JLabel copyright;

	/** The text area for the license text */
	private JTextArea jtaLicense;

	/** The label application name. */
	private JLabel labelApplicationName;

	/** The label copyright. */
	private JLabel labelCopyright;

	/** The labelversion number. */
	private JLabel labelversionNumber;

	/** The version number. */
	private JLabel versionNumber;

	public AppInfoPanel(final IModel<InfoModelBean> model)
	{
		super(model);
	}

	/**
	 * Creates new form HelpPanel
	 */
	public AppInfoPanel()
	{
		this(BaseModel.of(InfoModelBean.builder().build()));
	}

	@Override
	protected void onInitializeComponents()
	{
		labelApplicationName = new JLabel(getModelObject().getLabelApplicationName());
		applicationName = new JLabel(getModelObject().getApplicationName());
		labelversionNumber = new JLabel(getModelObject().getLabelVersion());
		versionNumber = new JLabel(getModelObject().getVersion());
		labelCopyright = new JLabel(getModelObject().getLabelCopyright());
		copyright = new JLabel(getModelObject().getCopyright());
		jtaLicense = new JTextArea(getModelObject().getLicence());
		jtaLicense.setLineWrap(true);
		jtaLicense.setWrapStyleWord(true);
		jtaLicense.setEditable(false);
	}

	@Override
	protected void onInitializeLayout()
	{
		final Insets oneInsent = new Insets(1, 1, 1, 1);
		final GridBagLayout gbl = new GridBagLayout();
		final GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gbl);

		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = oneInsent;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 1;
		gbc.weightx = 1;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbl.setConstraints(labelApplicationName, gbc);
		add(labelApplicationName);

		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = oneInsent;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 1;
		gbc.weightx = 1;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbl.setConstraints(applicationName, gbc);
		add(applicationName);

		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = oneInsent;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 1;
		gbc.weightx = 1;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbl.setConstraints(labelversionNumber, gbc);
		add(labelversionNumber);

		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = oneInsent;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 1;
		gbc.weightx = 1;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbl.setConstraints(versionNumber, gbc);
		add(versionNumber);

		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = oneInsent;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 1;
		gbc.weightx = 1;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbl.setConstraints(labelCopyright, gbc);
		add(labelCopyright);

		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = oneInsent;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 1;
		gbc.weightx = 1;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbl.setConstraints(copyright, gbc);
		add(copyright);
	}
}
