/**
 * The MIT License
 *
 * Copyright (C) 2021 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.swing.base;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * Test that the module of this library resolves on the module path from the built jar and the
 * runtime class path a consumer gets (#21). A module that is needed at compile time only, as
 * lombok, is on no consumer's runtime path, so a {@code requires} on it without {@code static}
 * makes the module fail to resolve with a {@link java.lang.module.FindException} that names the
 * missing module. Gradle's test task hands the jar and the runtime class path over in the system
 * properties {@value #MODULE_JAR_PROPERTY} and {@value #RUNTIME_CLASSPATH_PROPERTY}
 * (gradle/testing.gradle)
 */
public class ModulePathTest
{

	/**
	 * The name of the module of this library
	 */
	private static final String MODULE_NAME = "io.github.astrapisixtynine.swing.base.components";

	/**
	 * The system property with the path of the built jar
	 */
	private static final String MODULE_JAR_PROPERTY = "module.path.test.jar";

	/**
	 * The system property with the runtime class path, separated by the platform's path separator
	 */
	private static final String RUNTIME_CLASSPATH_PROPERTY = "module.path.test.runtime.classpath";

	/**
	 * Builds the module path from the built jar and the runtime class path. A missing property
	 * fails the test: a check that has nothing to resolve does not pass
	 *
	 * @return the module path
	 */
	private static Path[] modulePath()
	{
		final String moduleJar = System.getProperty(MODULE_JAR_PROPERTY);
		final String runtimeClasspath = System.getProperty(RUNTIME_CLASSPATH_PROPERTY);
		assertNotNull(moduleJar, "the system property " + MODULE_JAR_PROPERTY + " is not set");
		assertNotNull(runtimeClasspath,
			"the system property " + RUNTIME_CLASSPATH_PROPERTY + " is not set");
		return Arrays
			.stream((moduleJar + File.pathSeparator + runtimeClasspath).split(File.pathSeparator))
			.filter(entry -> !entry.isBlank()).map(Path::of).toArray(Path[]::new);
	}

	/**
	 * Test that the module resolves on the module path with the runtime class path of this library
	 * alone, so a requires on a compile-only module makes it fail with the name of that module
	 */
	@Test
	public void testResolvesOnTheModulePath()
	{
		final Configuration configuration = assertDoesNotThrow(
			() -> ModuleLayer.boot().configuration().resolve(ModuleFinder.of(modulePath()),
				ModuleFinder.of(), Set.of(MODULE_NAME)),
			"the module does not resolve on the module path");
		assertTrue(configuration.findModule(MODULE_NAME).isPresent());
	}

}
