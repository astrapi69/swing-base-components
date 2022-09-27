package io.github.astrapi69.swing.base;

import javax.swing.JLabel;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.test.object.ApplicationTestModel;
import net.miginfocom.swing.MigLayout;

public class LabelBasePanel extends BasePanel<ApplicationTestModel<String>>
{

	private JLabel lblText;

	/**
	 * creates a new {@link LabelBasePanel}
	 */
	public LabelBasePanel()
	{
		this(BaseModel.of(ApplicationTestModel.<String> builder().build()));
	}

	public LabelBasePanel(final IModel<ApplicationTestModel<String>> model)
	{
		super(model);
	}

	@Override
	protected void onInitializeComponents()
	{
        lblText = new JLabel();
		lblText.setText(getModelObject().getModel());
		add(lblText);
	}

	@Override
	protected void onInitializeLayout()
	{
        MigLayout migLayout = new MigLayout("");
        setLayout(migLayout);
    }

}
