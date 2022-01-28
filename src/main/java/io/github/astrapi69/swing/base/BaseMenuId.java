package io.github.astrapi69.swing.base;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Accessors(fluent = true)
public enum BaseMenuId {

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
    HELP_INFO(BaseMenuId.HELP_INFO_KEY);

    public static final String EDIT_KEY = "global.menu.edit";
    public static final String FILE_KEY = "global.menu.file";
    public static final String HELP_KEY = "global.menu.help";
    public static final String HELP_CONTENT_KEY = "global.menu.help.content";
    public static final String HELP_DONATE_KEY = "global.menu.help.donate";
    public static final String HELP_LICENSE_KEY = "global.menu.help.license";
    public static final String HELP_INFO_KEY = "global.menu.help.info";

    /** the properties key from the current menu */
    String propertiesKey;

    BaseMenuId(final String propertiesKey){
        this.propertiesKey = propertiesKey;
    }
}
