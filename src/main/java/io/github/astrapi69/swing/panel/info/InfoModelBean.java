package io.github.astrapi69.swing.panel.info;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InfoModelBean
{
	String applicationName;
	String copyright;
	String version;
	String licence;
	String labelApplicationName;
	String labelCopyright;
	String labelVersion;
}
