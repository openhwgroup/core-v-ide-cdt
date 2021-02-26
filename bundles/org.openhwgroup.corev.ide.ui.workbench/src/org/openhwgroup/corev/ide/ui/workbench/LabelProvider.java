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

import org.eclipse.swt.graphics.Image;
import org.openhwgroup.corev.ide.ui.workbench.meta.PropertyNode;

public final class LabelProvider extends org.eclipse.jface.viewers.LabelProvider {

	@Override
	public Image getImage(Object element) {
		if (element instanceof PropertyNode) {
			return ((PropertyNode) element).image();
		}
		return null;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof PropertyNode) {
			return ((PropertyNode) element).title();
		}
		return null;
	}

}
