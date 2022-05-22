package com.manage;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.manage.handle.FileHandler;
import com.manage.handle.IFileHandler;
import com.manage.handle.ILopHandler;
import com.manage.handle.IStudentHandler;
import com.manage.handle.LopHandler;
import com.manage.handle.StudentHandler;
import com.manage.model.Lop;
import com.manage.model.Student;

public class Main {
	private static LinkedList<Student> studentList;
	private static Scanner scanner;
	public static List<Lop> classList;
	private static ILopHandler iLopHandler;
	private static IStudentHandler iStudentHandler;
	private static IFileHandler fileHandler = new FileHandler();
	private static final String FILECLASS = "D:/java-workspace/class.txt";
	private static final String FILESTUDENT = "D:/java-workspace/student.txt";

	public static void main(String[] args) {
		iLopHandler = new LopHandler();
		iStudentHandler = new StudentHandler();
		studentList = new LinkedList<>();
		classList = new ArrayList<>();
		scanner = new Scanner(System.in);
		int funcionNumber = -1;
		iLopHandler.writeToMemory(classList, fileHandler.read(FILECLASS));
		iStudentHandler.writeToMemory(studentList, fileHandler.read(FILESTUDENT));

		do {
			showMenu();
			try {
				funcionNumber = scanner.nextInt();
				switch (funcionNumber) {
				case 0:
					System.out.println("Ket thuc");
					break;
				case 1:
					try {
						addClass();
					} catch (Exception e) {
						System.out.println("nhap sai vui long nhap lai.");
					}
					break;
				case 2:
					try {
						editClassById();
					} catch (Exception e) {
						System.out.println("nhap sai vui long nhap lai ");
					}
					break;
				case 3:
					try {
						deleteClassById();
					} catch (ConcurrentModificationException e) {
						e.printStackTrace();
					}
					break;
				case 4:
					sortClassByName();
					break;
				case 5:
					addStudent();
					break;
				case 6:
					editStudentById();
					break;
				case 7:
					try {
						deleteStudentById();
					} catch (Exception e) {
						System.out.println("nhap sai vui long nhap lai.");
					}
					break;
				case 8:
					sortStudentGpa();
					break;
				case 9:
					sortStudentByName();
					break;
				case 10:
					showStudent();
					break;
				case 11:
					showClassById();
					break;
				default:
					System.out.println("Nhap sai, moi ban nhap lai.");
					break;
				}
			} catch (Exception e) {
				scanner.next();
				System.out.println("Nhap sai, moi ban nhap lai.");
			}

		} while (funcionNumber != 0);

	}

	public static void addStudent() {
		if (iLopHandler.showAllClass(classList) == false)
			return;
		Student student = new Student();
		iStudentHandler.add(student, studentList);
		iStudentHandler.addStudentToClass(student, classList);
		fileHandler.write(FILESTUDENT, student.toString() + "\n");
	}

	public static void addClass() {
		Lop lop = new Lop();
		iLopHandler.add(lop, classList);
		fileHandler.write(FILECLASS, lop.toString() + "\n");
		System.out.println("add Class thanh cong! ");
	}

	public static void editStudentById() {
		fileHandler.clear(FILESTUDENT);
		System.out.println("Nhap id sinh vien muon edit: ");
		int findId = scanner.nextInt();
		iStudentHandler.editStudent(findId, studentList);
		fileHandler.write(FILESTUDENT, iStudentHandler.buildFileContent(studentList));
	}

	public static void deleteStudentById() {
		fileHandler.clear(FILESTUDENT);
		System.out.println("nhap id sinh vien muon xoa. ");
		int idDelete = scanner.nextInt();
		iStudentHandler.deleteStudent(idDelete, studentList);
		fileHandler.write(FILESTUDENT, iStudentHandler.buildFileContent(studentList));
	}

	public static void deleteClassById() {
		fileHandler.clear(FILECLASS);
		System.out.println("nhap id class muon xoa. ");
		int idDelete = scanner.nextInt();
		iLopHandler.deleteClass(idDelete, classList);
		fileHandler.write(FILECLASS, iLopHandler.buildFileContent(classList));
	}

	public static void editClassById() {
		fileHandler.clear(FILECLASS);
		System.out.println("Nhap id class muon edit: ");
		int findId = scanner.nextInt();
		iLopHandler.editClass(findId, classList);
		fileHandler.write(FILECLASS, iLopHandler.buildFileContent(classList));

	}

	public static void showStudent() {
		iStudentHandler.showListStudent(studentList);
	}

	public static void sortStudentGpa() {
		iStudentHandler.sortStudentByGpa(studentList);
	}

	public static void sortClassByName() {
		iLopHandler.sortClassByName(classList);
	}

	public static void sortStudentByName() {
		iStudentHandler.sortStudentByName(studentList);

	}

	public static void showClassById() {
		System.out.println("nhap ID class muon show: ");
		int id = scanner.nextInt();
		iLopHandler.showClassById(id, classList);
	}

	public static void showMenu() {
		System.out.println("1. Add Lớp\r\n" + "2. Edit Lớp by id.\r\n" + "3. Delete Lớp by id.\r\n"
				+ "4. Sort Lớp by name..\r\n" + "5. Add student.\r\n" + "6. Edit student by id.\r\n"
				+ "7. Delete student by id.\r\n" + "8. Sort student by gpa.\r\n" + "9. Sort student by name.\r\n"
				+ "10. Show student.\r\n" + "11. Show class by ID\r\n" + "0. Exit.\r\n"
				+ "/****************************************/\r\n" + "Moi ban nhap chuc nang: ");
	}

}
