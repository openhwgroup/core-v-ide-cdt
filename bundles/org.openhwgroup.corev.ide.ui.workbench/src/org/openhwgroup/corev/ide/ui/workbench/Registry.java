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

import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public abstract class Registry<T> {

	private final String point;

	public Registry(String point) {
		this.point = point;
	}

	protected IConfigurationElement[] elements() {
		return Platform.getExtensionRegistry().getConfigurationElementsFor(point);
	}

	public abstract List<T> get();

	public abstract List<String> names();
	
}
