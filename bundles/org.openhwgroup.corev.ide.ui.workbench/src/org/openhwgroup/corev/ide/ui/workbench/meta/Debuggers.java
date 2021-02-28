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
package org.openhwgroup.corev.ide.ui.workbench.meta;

import org.eclipse.core.resources.IProject;
import org.openhwgroup.corev.ide.ui.workbench.WorkbenchPlugin;

public final class Debuggers extends PropertyNode {

	public Debuggers(IProject project) {
		super(project);
	}

	@Override
	public String title() {
		return "Debuggers";
	}

	@Override
	public String icon() {
		return WorkbenchPlugin.IMAGE_DEBUGGERS;
	}

}
