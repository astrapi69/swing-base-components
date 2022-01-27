package io.github.astrapi69.swing.panel.help;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HelpModelBean
{

	String title;
	String content;
	@Builder.Default
	Size size = Size.SMALL;
}
