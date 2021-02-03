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

public class ToolchainRegistry extends Registry<Toolchain> {

	public ToolchainRegistry() {
		super("org.eclipse.cdt.managedbuilder.core.buildDefinitions");
	}

	@Override
	public List<Toolchain> get() {
		return Arrays.asList(elements()).stream() //
				.filter(element -> element.getName().equals("toolChain")) //
				.map(toolchain -> new Toolchain(toolchain.getAttribute("id"), toolchain.getAttribute("name"))) //
				.collect(Collectors.toList());
	}

	@Override
	public List<String> names() {
		return get().stream().map(Toolchain::name).collect(Collectors.toList());
	}

}
