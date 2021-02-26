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

import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

public abstract class Property {

	private final IProject project;

	Property(IProject project) {
		this.project = project;
	}

	public final Image image() {
		Bundle bundle = Platform.getBundle("org.openhwgroup.corev.ide.ui.workbench");
		URL url = FileLocator.find(bundle, new Path(icon()), null);
		ImageDescriptor imageDesc = ImageDescriptor.createFromURL(url);
		return imageDesc.createImage();
	}

	public abstract String title();

	public abstract String icon();

	public final IProject project() {
		return project;
	}

}
