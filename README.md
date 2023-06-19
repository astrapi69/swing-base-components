# Overview

<div style="text-align: center">

[![Java CI with Gradle](https://github.com/astrapi69/swing-base-components/actions/workflows/gradle.yml/badge.svg)](https://github.com/astrapi69/swing-base-components/actions/workflows/gradle.yml)
[![Open Issues](https://img.shields.io/github/issues/astrapi69/swing-base-components.svg?style=flat)](https://github.com/astrapi69/swing-base-components/issues)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.astrapi69/swing-base-components?style=plastic)](https://search.maven.org/artifact/io.github.astrapi69/swing-base-components)
[![Javadocs](http://www.javadoc.io/badge/io.github.astrapi69/swing-base-components.svg)](http://www.javadoc.io/doc/io.github.astrapi69/swing-base-components)
[![MIT license](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Donate](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)
[![Hits Of Code](https://hitsofcode.com/github/astrapi69/swing-base-components?branch=develop)](https://hitsofcode.com/github/astrapi69/swing-base-components/view?branch=develop)
[![Lines Of Code](https://tokei.rs/b1/github/astrapi69/swing-base-components)](https://github.com/astrapi69/swing-base-components)

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

You can first define the version in the ext section and add than the following gradle dependency to
your project `build.gradle` if you want to import the core functionality of swing-base-components:

define version in file gradle.properties

```
swingBaseComponentsVersion=2.5
```

or in build.gradle ext area

```
    swingBaseComponentsVersion = "2.5"
```

then add the dependency to the dependencies area

```
    implementation("io.github.astrapi69:swing-base-components:$swingBaseComponentsVersion")
```

## Maven dependency

Maven dependency is now on sonatype. Check
out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;gav~io.github.astrapi69~swing-base-components~~~)
for latest snapshots and releases.

Add the following maven dependency to your project `pom.xml` if you want to import the core
functionality of swing-base-components:

Than you can add the dependency to your dependencies:

    <properties>
            ...
        <!-- swing-base-components version -->
        <swing-base-components.version>2.5</swing-base-components.version>
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


# Donations

This project is kept as an open source product and relies on contributions to remain being
developed. If you like this library, please consider a donation

over paypal:
<br>
<br>
<a href="https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=MJ7V43GU2H386" target="_blank">
<img src="https://www.paypalobjects.com/en_US/GB/i/btn/btn_donateCC_LG.gif"
alt="PayPal this"
title="PayPal – The safer, easier way to pay online!"
style="border: none" />
</a>
<br>
<br>
or over bitcoin(BTC) with this address:

bc1ql2y99q7e8psndhcc3gferk03esw3qqf677rhjy

<img
src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/bc1ql2y99q7e8psndhcc3gferk03esw3qqf677rhjy.png"
alt="Donation Bitcoin Wallet" width="250"/>

or over FIO with this address:

FIO7tFMUVAA9cHiPPqKMfMXiSxHrbpiFyRYqTketNuM67aULuwjop

<img
src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/FIO7tFMUVAA9cHiPPqKMfMXiSxHrbpiFyRYqTketNuM67aULuwjop.png"
alt="Donation FIO Wallet" width="250"/>

or over Ethereum(ETH) with:

0xc057D159D3C8f3311E73568b334FF6fE82EB2b7D

<img
src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/0xc057D159D3C8f3311E73568b334FF6fE82EB2b7D.png"
alt="Donation Ethereum Wallet" width="250"/>

or over Ethereum Classic(ETC) with:

0xF708cA86D86C246B69c3F4BAe431eBbe0c2bfddD

<img
src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/0xF708cA86D86C246B69c3F4BAe431eBbe0c2bfddD.png"
alt="Donation Ethereum Classic Wallet" width="250"/>

or over Dogecoin(DOGE) with:

D5yi4Um8cpakd6yPRm2hGWuQ5nrVzhSSW1

<img
src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/D5yi4Um8cpakd6yPRm2hGWuQ5nrVzhSSW1.png"
alt="Donation Dogecoin Wallet" width="250"/>

or over Monero(XMR) with:

49bqeRQ7Bf49oJFVC72pqpe5hFbb62pfXDYPdLsadGGF81KZW2ZfrPZ8PbAVu5X2v1TYAspeczMya3cYQysNS4usRRPQHVw

<img
src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/49bqeRQ7Bf49oJFVC72pqpe5hFbb62pfXDYPdLsadGGF81KZW2ZfrPZ8PbAVu5X2v1TYAspeczMya3cYQysNS4usRRPQHVw.png"
alt="Donation Monero Wallet" width="250"/>

or over the donation buttons at the top.

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
