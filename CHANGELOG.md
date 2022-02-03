## Change log
----------------------

Version 1.2
-------------

ADDED:

- new method in class DialogExtensions for confirm messages
- new class ComponentExtensions for provide extension methods for components
- new method getComponentByName in class ComponentExtensions for resolve a component with a name
- new enum class BaseMenuId for add a unique id to a menu or menu item
- new helper method for get a map with all ids from enum BaseMenuId
- new menu items 'toggle to fullscreen' and 'exit' to the file menu

CHANGED:

- update gradle to new version 7.3.3
- update of dependency com.github.ben-manes.versions.gradle.plugin to new version 0.41.0
- update of dependency jobj-core version to 5.3
- update of dependency model-data version to 1.12
- update of dependency menu-actions version to 1.4
- update of test dependency test-objects version to 5.7
- update of test dependency silly-io version to 1.7
- return type to general class JMenu in factory method newDesktopMenu from class AbstractApplicationFrame
- moved class ShowLicenseFrameAction from module swing-components to this module
- moved help components from module swing-components to this module
- renamed package panels to panel


Version 1.1
-------------

CHANGED:

- moved dialog classes from swing-components repository to this repository
- moved GraphicsDeviceExtensions class from swing-components repository to this repository

Version 1
-------------

ADDED:

- new CHANGELOG.md file created
- all relevant classes from swing-components repository

Notable links:
[keep a changelog](http://keepachangelog.com/en/1.0.0/) Don’t let your friends dump git logs into
changelogs
