## Change log
----------------------

Version 2.6
-------------

ADDED:

- new dependency silly-math in version 2.2

CHANGED:

- update gradle to new version 8.3-rc-1
- update of gradle-plugin dependency 'io.freefair.gradle:lombok-plugin' to new version 8.1.0
- update of gradle-plugin dependency 'com.diffplug.spotless:spotless-plugin-gradle' to new version 6.20.0
- update of test dependencies junit-jupiter-* version to 5.10.0-RC2
- moved document classes from swing-components repository to this repository
- moved 'filechooser' classes from swing-components repository to this repository
- moved model classes from swing-components repository to this repository

Version 2.5
-------------

ADDED:

- new methods for add components to JInternalFrame and to ApplicationPanelFrame

CHANGED:

- update gradle to new version 8.2-rc-2
- update of gradle-plugin dependency 'com.github.ben-manes.versions.gradle.plugin' to new version 0.47.0
- moved all classes from package utils to new package util

Version 2.4
-------------

ADDED:

- new base panel for info or about dialogs with corresponding model object
- new info or about dialog

CHANGED:

- update gradle to new version 8.1.1
- update of gradle-plugin dependency 'io.freefair.gradle:lombok-plugin' to new version 8.0.1
- update of gradle-plugin dependency 'com.github.ben-manes.versions.gradle.plugin' to new version 0.46.0
- update of gradle-plugin dependency 'org.ajoberstar.grgit:grgit-gradle' to new version 5.2.0
- update of gradle-plugin dependency 'com.diffplug.spotless:spotless-plugin-gradle' to new version 6.18.0
- update of lombok dependency to new patch version 1.18.26
- update of dependency menu-action version to 2.7
- update of dependency jobj-core version to 7.1
- update of dependency silly-collection to new major version 21
- update of test dependency randomizer to new major version 9
- update of test dependency silly-io version to 2.2
- update of test dependency miglayout-swing version to 11.1

Version 2.3
-------------

ADDED:

- new enum for represent the frame mode

CHANGED:

- update gradle to new version 7.6
- update of gradle-plugin dependency 'com.diffplug.spotless:spotless-plugin-gradle' to new version 6.12.1
- update of gradle-plugin dependency 'com.github.ben-manes.versions.gradle.plugin' to new version 0.44.0
- update of gradle-plugin dependency 'io.freefair.gradle:lombok-plugin' to new version 6.6.1
- update of dependency menu-action version to 2.6
- update of dependency silly-collection to new minor version 20.2
- update of test dependency file-worker version to 11.6
- update of test dependency test-object version to 7.2

Version 2.2
-------------

ADDED:

- new panel class with a JDesktopPane
- new panel class with a JLabel
- new methods for replace Components in extension class ReplaceContentExtensions
- new method replaceMainComponent in class AbstractApplicationFrame that replaces the main component in the frame

CHANGED:

- removed unused test dependency commons-text
- moved class ReplaceContentExtensions to a more appropriate package 'io.github.astrapi69.swing.component.replace'
- update of dependency model-data to new minor module version 2.1
- update of test dependency file-worker module version to 11.4

Version 2.1
-------------

CHANGED:

- update of test dependency file-worker version to 11.3
- update of dependency model-data to new major version 2
- removed dependency io.github.astrapi69:jobj-reflect
- update of test dependency junit-jupiter-api to new patch version 5.9.1
- update of test dependency icon-img-extensions to new major version 2

Version 2
-------------

ADDED:

- new method for create a Dialog component from the given JPanel object with title and focus component
- new method that can enable or disable a component and all it descendants
- new dependency io.github.astrapi69:jobj-reflect in version 1
- new test dependency org.assertj:assertj-swing in version 3.17.1
- new test dependency io.github.astrapi69:junit-jupiter-extensions in version 1.1

CHANGED:

- update of JDK to newer version 11
- update gradle to new version 7.5.1
- update of gradle plugin dependency io.freefair.gradle:lombok-plugin to new version 6.5.1
- update of gradle plugin dependency com.diffplug.spotless:spotless-plugin-gradle to new version 6.11.0
- update of dependency silly-collection to new major version 20
- update of dependency jobj-core version to 7
- update of dependency throwable to new minor version 2.3
- update of test dependency file-worker version to 11.2
- update of test dependency test-objects version to 7.1
- update of test dependency silly-io version to 2.1
- update of test dependency junit-jupiter-api version to 5.9.0
- update of test dependency miglayout-swing version to 11.0

Version 1.4
-------------

ADDED:

- new method for create a Dialog component from the given JPanel object and other related parameters

  CHANGED:

- update gradle to new version 7.4.2
- update of lombok dependency to new patch version 1.18.24
- update of gradle plugin dependency io.freefair.gradle:lombok-plugin to new version 6.4.3
- update of gradle plugin dependency com.diffplug.spotless:spotless-plugin-gradle to new version 6.6.1
- update of test dependency randomizer to new minor version 8.6
- update of dependency silly-collections to new minor version 18.2
- removed enum RenderMode, is now in new module repository component-model

Version 1.3
-------------

ADDED:

- new factory method in class AbstractApplicationFrame for set the application name
- new factory method in class AbstractApplicationFrame for set the application configuration directory name
- new enum RenderMode created that indicates in which render mode a component is

CHANGED:

- update gradle to new version 7.4.1
- update of gradle plugin dependency com.github.ben-manes.versions.gradle.plugin to new version 0.42.0
- update of gradle plugin dependency com.diffplug.spotless:spotless-plugin-gradle to new version 6.3.0
- update of gradle plugin dependency io.freefair.gradle:lombok-plugin to new version 6.4.1
- update of test dependency file-worker version to 8.2
- update of test dependency test-objects version to 6
- update of test dependency silly-io version to 1.9
- update of test dependency icon-img-extensions version to 1.2

Version 1.2
-------------

ADDED:

- new method in class DialogExtensions for confirm messages
- new class ComponentExtensions for provide extension methods for components
- new method getComponentByName in class ComponentExtensions for resolve a component with a name
- new enum class BaseMenuId for add a unique id to a menu or menu item
- new helper method for get a map with all ids from enum BaseMenuId
- new menu items 'toggle to fullscreen' and 'exit' to the file menu
- update of test dependency test-objects version to 5.7

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
