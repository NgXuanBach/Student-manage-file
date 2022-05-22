package com.manage.handle;

import java.util.LinkedList;
import java.util.List;

import com.manage.model.Lop;
import com.manage.model.Student;

/**
 * 
 * @author XUAN BACH
 *
 */
public interface ILopHandler {
	public void add(Lop lop, List<Lop> classList);

	/**
	 * 
	 * @param studentList: show list student cua class
	 */
	public void showStudentByClass(LinkedList<Student> studentList);

	public void showClass(Lop lop);

	public void editClass(int findId, List<Lop> classList);

	public void sortClassByName(List<Lop> classList);

	public void showClassById(int name, List<Lop> classList);

	public boolean showAllClass(List<Lop> classList);

	public void deleteClass(int idDelete, List<Lop> classList);

	public String buildFileContent(List<Lop> classList);

	public void writeToMemory(List<Lop> classList, List<String> memory);
}
