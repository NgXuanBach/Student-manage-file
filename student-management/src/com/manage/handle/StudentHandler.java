package com.manage.handle;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.manage.Main;
import com.manage.constant.Constant;
import com.manage.model.Lop;
import com.manage.model.Student;

public class StudentHandler implements IStudentHandler {
	Scanner scan = new Scanner(System.in);
	String checkk;

	@Override
	public void add(Student student, LinkedList<Student> studentList) {
		boolean check;
		int idStudent;
		try {
			do {
				check = false;
				System.out.println("Id student: ");
				idStudent = scan.nextInt();
				for (Student student1 : studentList) {
					if (idStudent == student1.getId()) {
						System.out.println("Trung id vui long nhap lai");
						check = true;
						break;
					}
				}

			} while (check == true);
			student.setId(idStudent);
			System.out.println("student class ID: ");
			student.setIdClass(scan.nextInt());
			System.out.println("student name: ");
			scan.nextLine();
			student.setName(scan.nextLine());
			System.out.println("student age: ");
			student.setAge(scan.nextInt());
			System.out.println(" student address: ");
			scan.nextLine();
			student.setAddress(scan.nextLine());
			System.out.println("student gpa: ");
			student.setGpa(scan.nextFloat());
			System.out.println("add Student thanh cong! ");
			scan.nextLine();
		} catch (Exception e) {
			System.out.println("nhap sai vui long nhap lai. ");
		}
	}

	@Override
	public void show(Student student) {
		System.out.println("Id student: " + student.getId());
		System.out.println("Id class student: " + student.getIdClass());
		System.out.println("name student: " + student.getName());
		System.out.println("age student: " + student.getAge());
		System.out.println("address student: " + student.getAddress());
		System.out.println(" gpa student: " + student.getGpa());
	}

	@Override
	public void editStudent(int findId, LinkedList<Student> studentList) {
		boolean test = false;
		for (Student student : studentList) {
			if (student.getId() == findId) {
				test = true;
				add(student, studentList);
				System.out.println("Edit thanh cong");
				break;
			}
			if (test == false) {
				System.out.println("Id: " + findId + " khong ton tai");
			}
		}

	}

	@Override
	public void sortStudentByGpa(LinkedList<Student> studentList) {
		boolean test = false;
		for (int i = 0; i < studentList.size() - 1; i++) {
			test = true;
			Student min = studentList.get(i);
			int viTriMin = i;
			for (int j = i + 1; j < studentList.size(); j++) {
				if (studentList.get(i).getGpa() > studentList.get(j).getGpa()) {
					min = studentList.get(j);
					viTriMin = j;
				}
			}
			studentList.set(viTriMin, studentList.get(i));
			studentList.set(i, min);
		}
		if (test == false) {
			System.out.println("Chua co sinh vien nao de sap xep.");
		} else {
			System.out.println("Da sap xep tang dan. ");
		}

	}

	@Override
	public void sortStudentByName(LinkedList<Student> studentList) {
		Collections.sort(studentList, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());

			}
		});
		System.out.println("da sap xep. ");

	}

	@Override
	public void deleteStudent(int idDelete, LinkedList<Student> studentList) {
		boolean test = false;
		for (Student student : studentList) {
			if (student.getId() == idDelete) {
				studentList.remove(student);
				test = true;
				System.out.println("Da xoa id" + idDelete);
			}
		}
		if (test == false) {
			System.out.println(" khong co id nay.");
		}

	}

	@Override
	public String buildFileContent(LinkedList<Student> studentList) {
		StringBuilder builder = new StringBuilder();
		for (Student student : studentList) {
			builder.append(student + "\n");
		}
		return builder.toString();
	}

	@Override
	public void writeToMemory(LinkedList<Student> studentList, List<String> memory) {
		for (String line : memory) {
			String[] list = line.split(Constant.REGEX_SPLIT_STRING);
			Student student = new Student();
			student.setId(Integer.valueOf(list[0]));
			student.setIdClass(Integer.valueOf(list[1]));
			student.setName(list[2]);
			student.setAge(Integer.valueOf(list[3]));
			student.setAddress(list[4]);
			student.setGpa(Float.valueOf(list[5]));
			studentList.add(student);
			addStudentToClass(student, Main.classList);
		}

	}

	@Override
	public void addStudentToClass(Student student, List<Lop> classList) {
		for (Lop lop : classList) {
			if (lop.getStudentList() == null) {
				lop.setStudentList(new LinkedList<Student>());
			}
			if (lop.getId() == student.getIdClass()) {
				lop.addStudent(student);
				break;
			}
		}

	}

	@Override
	public void showListStudent(LinkedList<Student> studentList) {
		boolean test = false;
		for (Student student : studentList) {
			test = true;
			show(student);
			System.out.println("/****************************************/");
		}
		if (test == false) {
			System.out.println("Chua co sinh vien nao.");
		}
	}

}
