import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class Driver {
	
	public static int menu() {
		Scanner input = new Scanner(System.in);
		int userInput;
		
		do {
			System.out.println("What do you want to do? \n1 - add student "
					+ "\n2 - display student \n3 - remove student"
					+ "\n4 quit");
			
			userInput = input.nextInt();
			if (userInput <= 0 || userInput > 4) {
			    System.out.println("Invalid input, please choose again");
			} else {
				return userInput;
			}
		} while (true);
	}
	
	public static Student addStudent() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		String name = input.nextLine();
		
		System.out.println("Please enter your email: ");
		String email = input.nextLine();
		
		System.out.println("Please enter your id: ");
		int id = input.nextInt();
		
		Student s = new Student(name, email, id);
		
		return s;
	}
	
	public static void studentsList(LinkedList<Student> students) {
		Iterator<Student> s = students.iterator();
		
		while(s.hasNext()) {
			System.out.println(s.next());
			System.out.println();
		}	
	}
	
	public static Student findStudent(LinkedList<Student> students) {
		Scanner input = new Scanner(System.in);
		boolean isFound = false;
		int userId;
		
		do {
			System.out.println("Please enter id to remove: ");
			userId = input.nextInt();
			
			for (Student s : students) {
				if (userId == s.getId()) {
					return s;
				}
			}
			
			System.err.println("\nInvalid ID, please try again.");
		} while(true);
	}
	
	public static void removeStudent(LinkedList<Student> students) {
		Student st = findStudent(students);
		students.remove(st);
		System.out.println(st + "\nHAS BEEN REMOVED.");	
	}

	public static void main(String[] args) {
		
		Student s1 = new Student ("Petr", "Petr@gmail.com", 1111);
		Student s2 = new Student ("John", "John@gmail.com", 2222);
		Student s3 = new Student ("Jack", "Jack@gmail.com", 3333);
		
		LinkedList<Student> students = new LinkedList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		int userChoice;
		
	
			userChoice = menu();
			switch (userChoice) {
					case 1: Student s = addStudent();
						students.add(s);
						System.out.println(s + "\nhas been added.");
						break;
					case 2: studentsList(students);
						break;
					case 3: removeStudent(students);
						//System.out.println(students);
						break;
					case 4: System.out.println("The end");
						break;
				}
		
	}
}	