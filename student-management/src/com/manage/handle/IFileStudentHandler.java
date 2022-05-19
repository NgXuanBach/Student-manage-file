package com.manage.handle;

import java.util.LinkedList;
import java.util.List;

import com.manage.model.Lop;
import com.manage.model.Student;

public interface IFileStudentHandler {
	public void write(String filePath, LinkedList<Student> studentList);

	public void readInToMemory(List<String> list, LinkedList<Student> studentList);
}
