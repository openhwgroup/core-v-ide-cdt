package org.openhwgroup.corev.ide.internal.toolchain.gnu.ui.wizards;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.openhwgroup.corev.ide.internal.toolchain.gnu.ui.wizards.messages"; //$NON-NLS-1$
	public static String GnuToolchainWizardPage_help_message;
	public static String GnuToolchainWizardPage_help_title;
	public static String GnuToolchainWizardPage_page_massage;
	public static String GnuToolchainWizardPage_page_name;
	public static String GnuToolchainWizardPage_page_title;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
