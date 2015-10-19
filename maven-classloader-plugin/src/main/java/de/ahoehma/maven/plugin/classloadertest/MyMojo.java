package de.ahoehma.maven.plugin.classloadertest;

/*
 * Copyright 2015 Andreas Höhmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Goal which try to introspect a given class.
 */
@Mojo(name = "search-class", defaultPhase = LifecyclePhase.VALIDATE)
public class MyMojo extends AbstractMojo {

	@Parameter(property = "className", required = true)
	private String className;

	public void execute() throws MojoExecutionException {
		try {
			getLog().info(String.format("Found '%s' for class-name '%s'", Class.forName(className), className));
		} catch (ClassNotFoundException e) {
			throw new MojoExecutionException(String.format("Can't find class for '%s'", className), e);
		}
	}
}
