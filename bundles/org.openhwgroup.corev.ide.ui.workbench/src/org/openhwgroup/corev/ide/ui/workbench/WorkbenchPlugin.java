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
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class WorkbenchPlugin extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.openhwgroup.corev.ide.ui.workbench"; //$NON-NLS-1$
	public static final String IMAGE_BOARDS = "boards"; //$NON-NLS-1$
	public static final String IMAGE_TOOLCHAINS = "toolchains"; //$NON-NLS-1$
	public static final String IMAGE_SDKS = "sdks"; //$NON-NLS-1$
	public static final String IMAGE_DEBUGGERS = "debuggers"; //$NON-NLS-1$

	private static AbstractUIPlugin plugin;
	private BundleContext context;

	public static AbstractUIPlugin getDefault() {
		return plugin;
	}

	@Override
	protected void initializeImageRegistry(ImageRegistry registry) {
		addIcon(registry, IMAGE_BOARDS, "images/board.png"); //$NON-NLS-1$
		addIcon(registry, IMAGE_TOOLCHAINS, "images/shell.png"); //$NON-NLS-1$
		addIcon(registry, IMAGE_SDKS, "images/box.png"); //$NON-NLS-1$
		addIcon(registry, IMAGE_DEBUGGERS, "images/debug.png"); //$NON-NLS-1$
	}

	@Override
	public void start(BundleContext context) throws Exception {
		plugin = this;
		this.context = context;
		super.start(context);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		this.context = null;
		plugin = null;
	}

	private void addIcon(ImageRegistry registry, String key, String path) {
		URL url = FileLocator.find(context.getBundle(), new Path(path), null);
		ImageDescriptor image = ImageDescriptor.createFromURL(url);
		registry.put(key, image);
	}

}
