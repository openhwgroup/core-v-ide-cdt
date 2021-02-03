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

public final class Toolchain {

	private final String name;
	private final String id;

	public Toolchain(String id, String name) {
		this.name = name;
		this.id = id;
	}

	public String name() {
		return name;
	}

	public String id() {
		return id;
	}

}