package phase1;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class LockedMe {
	static String directory;
	File folder_name;

	LockedMe() {
		directory = System.getProperty("user.dir");
		folder_name = new File(directory + "/myfiles");
	}

	String Welcomescreen = "" + "\t|\t\t𝗟𝗢𝗖𝗞𝗘𝗗𝗠𝗘.𝗖0𝗠\t\t\t\t |\n"
			+ "\t|--------------------------------------------------------|\n" + "\t|\t\tBy Manasa Joshi\t\t\t\t |\n"
			+ "\t|\t\tEmp id: 10827\t\t\t\t |\n" + "\t|\t github.com/ManasaJoshi-ops\t\t\t |\n"
			+ "\t|gitrep:https://github.com/ManasaJoshi-ops/LockedMe.com  |\n"
			+ "\t|--------------------------------------------------------|\n";

	String FirstMenu = "\n1.List all files from the application\n" + "2.Business Level Operations\n"
			+ "3.Exit from the application";
	String SecondMenu = "\n1.Add file to the application\n" + "2.Delete from an application\n" + "3.Search for a file\n"
			+ "4.Go back to Main Menu";

	void mainMenu() {
		System.out.println(FirstMenu);
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Select any option from above:");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				listFiles();
				mainMenu();
				break;
			case 2:
				BusinessLevelOperations();
				break;
			case 3:
				System.exit(0);
			default:
				mainMenu();
			}
		} catch (Exception e) {
			System.out.println("Invalid Input. Kindly choose from the above menu");
		}

	}

	private void listFiles() {
		File fs = new File("myfiles");
		File file[] = fs.listFiles();
		TreeSet<String> ts = new TreeSet<String>();

		if (fs.length() != 0) {
			for (File i : file) {
				ts.add(i.getName());
			}
		} else {
			System.out.println("Directory is Empty..");
		}
		for (String i : ts) {
			System.out.println(i);
		}

	}

	private void BusinessLevelOperations() {
		System.out.println(SecondMenu);
		try {
			System.out.println("Select any option from above:");
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				createFile();
				BusinessLevelOperations();
				break;
			case 2:
				deleteFile();
				BusinessLevelOperations();
				break;
			case 3:
				searchFile();
				BusinessLevelOperations();
				break;
			case 4:
				mainMenu();
			default:
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("Kindly select from the above menu");
		}
	}

	private void createFile() {
		System.out.println("Enter the name of the file :");
		Scanner sc = new Scanner(System.in);
		String file_name = sc.next();
		File file = new File("myfiles", file_name);
		try {
			if (file.createNewFile()) {
				System.out.println("File created successfully");
			} else {
				System.out.println("File already exists");
			}
		} catch (IOException e) {
			System.out.println("Exception occured"+e.getMessage());
		}

	}

	private void deleteFile() {
		System.out.println("Enter the name of the file to be deleted..");
		Scanner sc = new Scanner(System.in);
		String file_name = sc.next();
		File file = new File(folder_name, file_name);
		String[] str = folder_name.list();
		for (String s1 : str) {
			if (file_name.equals(s1) && file.delete()) {
				System.out.println("File deleted..");
				return;
			}
		}
		System.out.println("File not found FNF");

	}

	private void searchFile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the file to be searched..");
		String file_name = sc.next();
		String[] list = folder_name.list();
		for (String s1 : list) {
			if (file_name.equals(s1)) {
				System.out.println("File " + file_name + " exists\n\n");
				return;
			}
		}
		System.out.println("File " + file_name + " doesnt exists");
	}

	public static void main(String[] args) {
		LockedMe obj = new LockedMe();
		System.out.println(obj.Welcomescreen);
		obj.mainMenu();

	}
}
