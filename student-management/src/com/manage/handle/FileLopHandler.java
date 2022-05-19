package com.manage.handle;

import java.util.LinkedList;
import java.util.List;

import com.manage.model.Lop;
import com.manage.model.Student;

public class FileLopHandler implements IFileLopHandler {
	public IFileHandler fileHandler = new FileHandler();

	@Override
	public void write(String filePath, List<Lop> classList) {
		for (Lop lop : classList) {
			fileHandler.write(filePath, lop.toString() + "\n");
		}

	}

	@Override
	public void write(String filePath, LinkedList<Student> studentList) {
		// TODO Auto-generated method stub

	}

	@Override
	public void readInToMemory(List<String> lineList, List<Lop> classList) {
		if (lineList == null) {
			return;
		}
		for (String line : lineList) {
			Lop lop = new Lop();
			String[] list = line.split(",");
			lop.setId(Integer.valueOf(list[0]));
			lop.setName(list[1]);
			lop.setQuantily(Integer.valueOf(list[2]));
			classList.add(lop);
		}

	}

}
