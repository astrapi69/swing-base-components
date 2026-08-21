JAVA_HOME ?= /home/astrapi69/.sdkman/candidates/java/24.0.2-tem

.PHONY: build build-stacktrace build-warning clean dependencies \
	dependency-updates jacoco-coverage jacoco-report jar javadoc \
	license-format publish publish-local release spotless-apply \
	spotless-check spotless-java spotless-misc tag-release test \
	version-catalog-format version-catalog-update

build:
	JAVA_HOME=$(JAVA_HOME) ./gradlew build

build-stacktrace:
	JAVA_HOME=$(JAVA_HOME) ./gradlew build --stacktrace --warning-mode all

build-warning:
	JAVA_HOME=$(JAVA_HOME) ./gradlew build --warning-mode all

clean:
	JAVA_HOME=$(JAVA_HOME) ./gradlew clean

test:
	JAVA_HOME=$(JAVA_HOME) ./gradlew test

# --- mirrors Gradle "Run Configurations" panel ---

dependencies:
	JAVA_HOME=$(JAVA_HOME) ./gradlew dependencies

dependency-updates:
	JAVA_HOME=$(JAVA_HOME) ./gradlew dependencyUpdates

jacoco-coverage:
	JAVA_HOME=$(JAVA_HOME) ./gradlew jacocoTestCoverageVerification

jacoco-report:
	JAVA_HOME=$(JAVA_HOME) ./gradlew jacocoTestReport

jar:
	JAVA_HOME=$(JAVA_HOME) ./gradlew jar

javadoc:
	JAVA_HOME=$(JAVA_HOME) ./gradlew javadoc

# license headers are managed by the spotless licenseHeaderFile step
license-format:
	JAVA_HOME=$(JAVA_HOME) ./gradlew spotlessApply

publish:
	JAVA_HOME=$(JAVA_HOME) ./gradlew publish

publish-local:
	JAVA_HOME=$(JAVA_HOME) ./gradlew publishMavenJavaPublicationToMavenLocal

# full release: clean, publish to local and remote, tag the release
release:
	JAVA_HOME=$(JAVA_HOME) ./gradlew clean publishMavenJavaPublicationToMavenLocal publish tagRelease

spotless-apply:
	JAVA_HOME=$(JAVA_HOME) ./gradlew spotlessApply

spotless-check:
	JAVA_HOME=$(JAVA_HOME) ./gradlew spotlessCheck

spotless-java:
	JAVA_HOME=$(JAVA_HOME) ./gradlew spotlessJavaApply

spotless-misc:
	JAVA_HOME=$(JAVA_HOME) ./gradlew spotlessMiscApply

tag-release:
	JAVA_HOME=$(JAVA_HOME) ./gradlew tagRelease

version-catalog-format:
	JAVA_HOME=$(JAVA_HOME) ./gradlew versionCatalogFormat

version-catalog-update:
	JAVA_HOME=$(JAVA_HOME) ./gradlew versionCatalogUpdate
