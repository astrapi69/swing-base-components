# Overview

<div style="text-align: center">

[![Java CI with Gradle](https://github.com/astrapi69/swing-base-components/actions/workflows/gradle.yml/badge.svg)](https://github.com/astrapi69/swing-base-components/actions/workflows/gradle.yml)
[![Open Issues](https://img.shields.io/github/issues/astrapi69/swing-base-components.svg?style=flat)](https://github.com/astrapi69/swing-base-components/issues)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.astrapi69/swing-base-components?style=plastic)](https://search.maven.org/artifact/io.github.astrapi69/swing-base-components)
[![Javadocs](https://javadoc.io/badge2/io.github.astrapi69/swing-base-components/javadoc.svg)](http://www.javadoc.io/doc/io.github.astrapi69/swing-base-components)
[![MIT license](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Donate](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)
[![Hits Of Code](https://hitsofcode.com/github/astrapi69/swing-base-components?branch=develop)](https://hitsofcode.com/github/astrapi69/swing-base-components/view?branch=develop)

</div>

This project holds generic base components for create swing applications.

> Please support this project by simply putting a Github <!-- Place this tag where you want the button to render. -->
<a class="github-button" href="https://github.com/astrapi69/swing-base-components" data-icon="octicon-star" aria-label="Star astrapi69/swing-base-components on GitHub">Star ⭐</a>
>
> Share this library with friends on Twitter and everywhere else you can
>
> If you love this project [![donation](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)

## Note

No animals were harmed in the making of this library.

## License

The source code comes under the liberal MIT License, making swing-base-components great for all
types of applications.

## gradle dependency

Replace the variable ${latestVersion} with the current latest version: [![Maven Central](https://img.shields.io/maven-central/v/io.github.astrapi69/swing-base-components?style=plastic)](https://search.maven.org/artifact/io.github.astrapi69/swing-base-components)

You can first define the version in the ext section and add than the following gradle dependency to
your project `build.gradle` if you want to import the core functionality of swing-base-components:

define version in file gradle.properties

```
swingBaseComponentsVersion=${latestVersion}
```

or in build.gradle ext area

```
    swingBaseComponentsVersion = "${latestVersion}"
```

then add the dependency to the dependencies area

```
    implementation("io.github.astrapi69:swing-base-components:$swingBaseComponentsVersion")
```

## Maven dependency

The library is on Maven Central. Check out [Maven Central](https://central.sonatype.com/artifact/io.github.astrapi69/swing-base-components) for the latest release.

Add the following maven dependency to your project `pom.xml` if you want to import the core
functionality of swing-base-components:

Then you can add the dependency to your dependencies:

    <properties>
            ...
        <!-- swing-base-components version -->
        <swing-base-components.version>${latestVersion}</swing-base-components.version>
            ...
    </properties>
            ...
        <dependencies>
            ...
            <!-- swing-base-components DEPENDENCY -->
            <dependency>
                <groupId>io.github.astrapi69</groupId>
                <artifactId>swing-base-components</artifactId>
                <version>${swing-base-components.version}</version>
            </dependency>
            ...
        </dependencies>


## 📸 Snapshots

This section describes how to import snapshot versions into your project.
Add the following code snippet to your gradle file in the repositories section:
```
repositories {
   //...
```
```groovy
    maven {
        name "Central Portal Snapshots"
        url "https://central.sonatype.com/repository/maven-snapshots/"
        mavenContent {
            snapshotsOnly()
        }
    }
```
```
}
```

## Support this project

If swing-base-components is useful to you, a star on [GitHub](https://github.com/astrapi69/swing-base-components) helps others find it.
Sharing it or reporting a bug helps just as much.

If you would like to contribute financially, the channels are on the repository's Sponsor button, which
reads [.github/FUNDING.yml](.github/FUNDING.yml): GitHub Sponsors, Liberapay, Ko-fi and PayPal.

## Semantic Versioning

The versions of swing-base-components are maintained with the Semantic Versioning guidelines.

Release version numbers will be incremented in the following format:

`<major>.<minor>.<patch>`

For detailed information on versioning you can visit
the [wiki page](https://github.com/lightblueseas/mvn-parent-projects/wiki/Semantic-Versioning).

## Want to Help and improve it? ###

The source code for swing-base-components are on GitHub. Please feel free to fork and send pull
requests!

Create your own fork
of [astrapi69/swing-base-components/fork](https://github.com/astrapi69/swing-base-components/fork)

To share your
changes, [submit a pull request](https://github.com/astrapi69/swing-base-components/pull/new/develop)
.

Don't forget to add new units tests on your changes.

## Contacting the Developers

Do not hesitate to contact the swing-base-components developers with your questions, concerns,
comments, bug reports, or feature requests.

- Feature requests, questions and bug reports can be reported at
  the [issues page](https://github.com/astrapi69/swing-base-components/issues).

## Similar projects

## Credits

## Git hooks

The repository's git hooks live in `.githooks`: `commit-msg` where present, and `pre-commit`, which refuses a
commit whose files Spotless would format. Activate them once per clone or worktree:

```bash
git config core.hooksPath .githooks
```
