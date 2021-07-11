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
package org.openhwgroup.corev.ide.definition.storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.openhwgroup.corev.ide.definition.api.Board;
import org.openhwgroup.corev.ide.definition.api.Storage;
import org.openhwgroup.corev.ide.definition.api.Toolchain;
import org.osgi.framework.FrameworkUtil;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public final class JsonStorage implements Storage {

	private final Gson gson = new Gson();
	private final File boards;
	private final File toolchains;

	public JsonStorage() {
		this.boards = FrameworkUtil.getBundle(getClass()).getDataFile("boards"); //$NON-NLS-1$
		this.toolchains = FrameworkUtil.getBundle(getClass()).getDataFile("toolchains"); //$NON-NLS-1$
	}

	@Override
	public void put(Board board) {
		List<Board> boards = boards();
		boards.add(board);
		write(this.boards, gson.toJson(boards));
	}

	@Override
	public List<Board> boards() {
		return gson.fromJson(read(boards), new TypeToken<ArrayList<Board>>() {
		}.getType());
	}

	@Override
	public void put(Toolchain toolchain) {
		List<Toolchain> toolchains = toolchains();
		toolchains.add(toolchain);
		write(this.toolchains, gson.toJson(toolchains));
	}

	@Override
	public List<Toolchain> toolchains() {
		return gson.fromJson(read(toolchains), new TypeToken<ArrayList<Toolchain>>() {
		}.getType());
	}

	private void write(File file, String json) {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.getPath()))) {
			writer.write(json);
		} catch (IOException e) {
			Platform.getLog(getClass()).error(e.getMessage(), e);
		}
	}

	private String read(File file) {
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(file.getPath()))) {
			return reader.readLine();
		} catch (IOException e) {
			Platform.getLog(getClass()).error(e.getMessage(), e);
		}
		return "[]"; //$NON-NLS-1$
	}

}
