package com.manage.handle;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.manage.model.Lop;
import com.manage.model.Student;

public class LopHandler implements ILopHandler {
//	public List<Lop> classList = new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	public IFileHandler fileHandler = new FileHandler();

	@Override
	public void add(Lop lop, List<Lop> classList) {
		boolean check;
		int id;
		do {
			check = true;
			System.out.println("Id class: ");
			id = scan.nextInt();
			for (Lop clas : classList) {
				if (clas.getId() == id) {
					System.out.println("Trung id class vui long nhap lai. ");
					check = false;
					break;
				}
			}
		} while (check == false);
		lop.setId(id);
		System.out.println("name class: ");
		scan.nextLine();
		String name = scan.nextLine();
		lop.setName(name);
		classList.add(lop);
	}

	@Override
	public void showStudentByClass(LinkedList<Student> studentList) {
		if (studentList == null) {
			System.out.println("class nay chua co student nao.");
		} else {
			for (Student student : studentList) {
				System.out.println(student);
				System.out.println(" gpa student: " + student.getGpa());
				System.out.println("/****************************************/");
			}
		}
	}

	@Override
	public void showClass(Lop lop) {
		System.out.println("id class: " + lop.getId());
		System.out.println("name class: " + lop.getName());
		System.out.println("quantily class: " + lop.getQuantity());

	}

	@Override
	public void editClass(int findId, List<Lop> classList) {
		boolean test = false;
		for (Lop clas : classList) {
			if (clas.getId() == findId) {
				test = true;
				add(clas, classList);
				System.out.println("Edit thanh cong");
				break;
			}
		}
		if (test == false) {
			System.out.println("Id: " + findId + " khong ton tai");
		}

	}

	@Override
	public void sortClassByName(List<Lop> classList) {
		Collections.sort(classList, new Comparator<Lop>() {

			@Override
			public int compare(Lop o1, Lop o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}

		});
		System.out.println("da sap xep. ");

	}

	@Override
	public void showClassByName(String name, List<Lop> classList) {
		boolean test = false;
		for (Lop clas : classList) {
			if (clas.getName().toLowerCase().contains(name.toLowerCase())) {
				test = true;
				showClass(clas);
				System.out.println("/****************************************/");
				showStudentByClass(clas.getStudentList());
				System.out.println("/****************************************/");
				break;
			}
		}
		if (test == false) {
			System.out.println("Chua co class nao.");
		}

	}

	@Override
	public boolean showAllClass(List<Lop> classList) {
		if (classList.size() > 0) {
			for (Lop lop : classList) {
				showClass(lop);
			}
			return true;
		}
		System.out.println("chua co class nao moi ban quay lai add Class truoc.");
		return false;

	}

	@Override
	public void deleteClass(int idDelete, List<Lop> classList) {
		boolean test = false;
		for (Lop clas : classList) {
			if (clas.getId() == idDelete) {
				classList.remove(clas);
				test = true;
				System.out.println("Da xoa id: " + idDelete);
				break;
			}
		}
		if (test == false) {
			System.out.println("Id: " + idDelete + " khong ton tai");
		}

	}

	@Override
	public void addStudentToClass(Student student, List<Lop> classList) {
		for (Lop lop : classList) {
			if (lop.getName().toLowerCase().contains(student.getIdClass())) {
				lop.addStudentList(student);
				break;
			}
			;
		}
	}

}
