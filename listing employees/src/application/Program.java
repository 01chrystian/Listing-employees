package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Employee employee = new Employee();

		Integer id;
		String name;
		Double salary;

		List<Employee> list = new ArrayList<>();

		System.out.print("How many employees will be registered? ");
		int numeroDeFuncionarios = sc.nextInt();

		for (int i = 0; i < numeroDeFuncionarios; i++) {

			System.out.println("\nEmployee #" + (i + 1) + ": ");
			System.out.print("Id: ");
			id = sc.nextInt();

			while (hasId(list, id)) {
				System.out.print("Id already taken! Try again: ");
				System.out.print("Id: ");
				id = sc.nextInt();
			}

			System.out.print("Name: ");
			sc.nextLine();
			name = sc.nextLine();
			System.out.print("Salary: ");
			salary = sc.nextDouble();
			Employee employee1 = new Employee(id, name, salary);

			list.add(employee1);
		}
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int idSalary = sc.nextInt();

		Integer pos = position(list, idSalary);
		if (pos == null) {
			System.out.print("this id does not exist! ");
		} else {
			System.out.print("enter the percentage: ");
			double percent = sc.nextDouble();
			list.get(pos).increaseSalary(percent);
		}

		System.out.println();
		System.out.print("\nList of employees: ");
		for (Employee x : list) {
			System.out.print(x.Print());
		}

		sc.close();
	}

	public static Integer position(List<Employee> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}

	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}
