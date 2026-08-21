.PHONY: build build-stacktrace build-warning clean dependencies \
	dependency-updates jacoco-coverage jacoco-report jar javadoc \
	license-format publish publish-local release spotless-apply \
	spotless-check spotless-java spotless-misc tag-release test \
	version-catalog-format version-catalog-update

build:
	./gradlew build

build-stacktrace:
	./gradlew build --stacktrace --warning-mode all

build-warning:
	./gradlew build --warning-mode all

clean:
	./gradlew clean

test:
	./gradlew test

# --- mirrors Gradle "Run Configurations" panel ---

dependencies:
	./gradlew dependencies

dependency-updates:
	./gradlew dependencyUpdates

jacoco-coverage:
	./gradlew jacocoTestCoverageVerification

jacoco-report:
	./gradlew jacocoTestReport

jar:
	./gradlew jar

javadoc:
	./gradlew javadoc

# license headers are managed by the spotless licenseHeaderFile step
license-format:
	./gradlew spotlessApply

publish:
	./gradlew publish

publish-local:
	./gradlew publishMavenJavaPublicationToMavenLocal

# full release: clean, publish to local and remote, tag the release
release:
	./gradlew clean publishMavenJavaPublicationToMavenLocal publish tagRelease

spotless-apply:
	./gradlew spotlessApply

spotless-check:
	./gradlew spotlessCheck

spotless-java:
	./gradlew spotlessJavaApply

spotless-misc:
	./gradlew spotlessMiscApply

tag-release:
	./gradlew tagRelease

version-catalog-format:
	./gradlew versionCatalogFormat

version-catalog-update:
	./gradlew versionCatalogUpdate
