package com.manage.handle;

import java.util.LinkedList;
import java.util.List;

import com.manage.model.Lop;
import com.manage.model.Student;

public interface IStudentHandler {
	public void add(Student student, LinkedList<Student> studentList);

	public void show(Student student);

	public void editStudent(int findId, LinkedList<Student> studentList);

	public void sortStudentByGpa(LinkedList<Student> studentList);

	public void sortStudentByName(LinkedList<Student> studentList);

	public void deleteStudent(int idDelete, LinkedList<Student> studentList);

	public String buildFileContent(LinkedList<Student> studentList);

	public void addStudentToClass(Student student, List<Lop> classList);

	public void writeToMemory(LinkedList<Student> studentList, List<String> memory);

	public void showListStudent(LinkedList<Student> studentList);
}
