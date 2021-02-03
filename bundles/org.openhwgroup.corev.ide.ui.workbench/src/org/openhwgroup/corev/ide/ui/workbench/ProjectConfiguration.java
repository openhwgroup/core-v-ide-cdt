/*******************************************************************************
 * Copyright (c) 2021 ArSysOp and others
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Nikifor Fedorov (ArSysOp) - initial API and implementation
 *******************************************************************************/
package org.openhwgroup.corev.ide.ui.workbench;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.cdt.core.templateengine.TemplateCore;
import org.eclipse.cdt.managedbuilder.core.IConfiguration;
import org.eclipse.cdt.managedbuilder.core.ManagedBuildManager;
import org.eclipse.core.runtime.IProgressMonitor;

public final class ProjectConfiguration {

	private Optional<String> folder = Optional.empty();
	private Optional<String> name = Optional.empty();
	private Optional<String> author = Optional.empty();
	private Optional<String> version = Optional.empty();
	private Optional<String> copyright = Optional.empty();
	private Optional<Toolchain> toolchain = Optional.empty();
	private Optional<TemplateCore> template = Optional.empty();

	public void configureFolder(String path) {
		this.folder = Optional.of(path);
	}

	public void configureName(String name) {
		this.name = Optional.of(name);
	}

	public void configureAuthor(String author) {
		this.author = Optional.of(author);
	}

	public void configureVersion(String version) {
		this.version = Optional.of(version);
	}

	public void configureCopyright(String name) {
		this.copyright = Optional.of(name);
	}

	public void configureToolchain(Toolchain toolchain) {
		this.toolchain = Optional.of(toolchain);
	}

	public void configureTemplate(TemplateCore template) {
		this.template = Optional.of(template);
	}

	public String name() {
		return name.get();
	}

	public String path() {
		return folder.get();
	}

	public String author() {
		return author.get();
	}

	public String copyright() {
		return copyright.get();
	}

	public String version() {
		return version.get();
	}

	public void create(IProgressMonitor monitor) {
		if (createable()) {
			template.get().getValueStore().replace("author", author.get());
			template.get().getValueStore().replace("version", version.get());
			template.get().getValueStore().put("projectName", name.get());
			template.get().getValueStore().put("copyright", copyright.get());
			template.get().getValueStore().put("location", folder.get());
			template.get().getTemplateInfo().setToolChainSet(Set.of(toolchain.get().id()));
			template.get().getTemplateInfo().setConfigurations(configurations());
			template.get().executeTemplateProcesses(monitor, true);
		}
	}

	private List<IConfiguration> configurations() {
		return Arrays.asList(ManagedBuildManager.getExtensionConfigurations()).stream()
				.filter(c -> !c.getArtifactExtension().isBlank()) //
				.filter(c -> c.getName() != null) //
				.collect(Collectors.toList());
	}

	public boolean createable() {
		return folder.isPresent() && !folder.get().toString().equals("") && name.isPresent() && !name.get().equals("")
				&& toolchain.isPresent() && template.isPresent();
	}

	public boolean templateSelected() {
		return toolchain.isPresent() && template.isPresent();
	}

}
