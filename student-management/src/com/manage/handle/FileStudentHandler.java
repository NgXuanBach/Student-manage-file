package com.manage.handle;

import java.util.LinkedList;
import java.util.List;

import com.manage.model.Lop;
import com.manage.model.Student;

public class FileStudentHandler implements IFileStudentHandler {
	public IFileHandler fileHandler = new FileHandler();

	@Override
	public void write(String filePath, LinkedList<Student> studentList) {
		for (Student student : studentList) {
			fileHandler.write(filePath, student.toString() + "\n");
		}
	}

	@Override
	public void readInToMemory(List<String> lineList, LinkedList<Student> studentList) {
		if (lineList == null) {
			return;
		}
		for (String line : lineList) {
			Student student = new Student();
			String[] list = line.split(",");
			student.setId(Integer.valueOf(list[0]));
			student.setName(list[1]);
			student.setAge(Integer.valueOf(list[2]));
			student.setAddress(list[3]);
			student.setGpa(Integer.valueOf(list[4]));
			student.setIdClass(list[5]);
			studentList.add(student);
		}

	}

}
