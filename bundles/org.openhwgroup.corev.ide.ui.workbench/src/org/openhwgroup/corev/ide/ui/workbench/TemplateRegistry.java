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
import java.util.stream.Collectors;

import org.eclipse.cdt.core.templateengine.TemplateCore;
import org.eclipse.cdt.core.templateengine.TemplateEngine;

public class TemplateRegistry extends Registry<TemplateCore> {

	private final TemplateEngine templateEngine = TemplateEngine.getDefault();

	public TemplateRegistry() {
		super("org.eclipse.cdt.core.templates");
	}

	@Override
	public List<TemplateCore> get() {
		return Arrays.asList(templateEngine.getTemplates("org.eclipse.cdt.build.core.buildArtefactType.exe"));
	}

	@Override
	public List<String> names() {
		return get().stream().map(core -> core.getLabel()).collect(Collectors.toList());
	}

	public List<TemplateCore> get(String filter) {
		return Arrays.asList(templateEngine.getTemplates("org.eclipse.cdt.build.core.buildArtefactType.exe", filter));
	}

	public List<String> names(String filter) {
		return get(filter).stream().map(core -> core.getLabel()).collect(Collectors.toList());
	}

}
