package com.manage.handle;

import java.util.LinkedList;
import java.util.List;

import com.manage.model.Lop;
import com.manage.model.Student;

public interface IFileLopHandler {
	public void write(String filePath, LinkedList<Student> studentList);

	public void write(String filePath, List<Lop> classList);
    public void readInToMemory(List<String> list, List<Lop> classList);
}
