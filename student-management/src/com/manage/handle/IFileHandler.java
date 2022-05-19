package com.manage.handle;

import java.util.List;

public interface IFileHandler {
	public void write(String filePath, String content);

	public List<String> read(String filePath);

	public void clear(String filePath);
}
