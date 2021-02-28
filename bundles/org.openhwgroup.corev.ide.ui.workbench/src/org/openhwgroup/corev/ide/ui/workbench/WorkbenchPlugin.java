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

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;

public class WorkbenchPlugin extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.openhwgroup.corev.ide.ui.workbench";
	public static final String IMAGE_BOARDS = "boards";
	public static final String IMAGE_TOOLCHAINS = "toolchains";
	public static final String IMAGE_SDKS = "sdks";
	public static final String IMAGE_DEBUGGERS = "debuggers";
	
	public static WorkbenchPlugin plugin;

	public static AbstractUIPlugin get() {
		if (plugin == null) {
			plugin = new WorkbenchPlugin();
		}
		return plugin;
	}

	@Override
	protected void initializeImageRegistry(ImageRegistry registry) {
		addIcon(registry, IMAGE_BOARDS, "images/board.png");
		addIcon(registry, IMAGE_TOOLCHAINS, "images/shell.png");
		addIcon(registry, IMAGE_SDKS, "images/box.png");
		addIcon(registry, IMAGE_DEBUGGERS, "images/debug.png");
	}

	private void addIcon(ImageRegistry registry, String key, String path) {
		Bundle bundle = Platform.getBundle(PLUGIN_ID);
		URL url = FileLocator.find(bundle, new Path(path), null);
		ImageDescriptor image = ImageDescriptor.createFromURL(url);
		registry.put(key, image);
	}
}
