package phase1;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMe {
	static String directory;
	File folder_name;
	LockedMe(){
		directory=System.getProperty("user.dir");
		folder_name=new File(directory+"/myfiles");
		
	}
	

	String Welcomescreen="\t\t*******WELCOME TO LockedMe.com*******\n"
			+ "\t\t**********By Manasa Joshi**********\n"
			+ "\t\t*******github.com/ManasaJoshi-ops*******";
	
	String FirstMenu="1.List all files from the application\n"
			+ "2.Secondary functions\n"
			+ "3.Exit from the application";
	String SecondMenu="1.Add file to the application\n"
			+ "2.Delete from an application\n"
			+ "3. search for a file\n"
			+ "4.Go back to Main Menu";
	
	void mainMenu() {
		System.out.println(FirstMenu);
		try {
		Scanner sc=new Scanner(System.in);
		System.out.println("Select any option from above:");
		int option=sc.nextInt();
		switch(option) {
		case 1: listFiles();
		        mainMenu();
		        break;
		case 2: secondaryFunctions();
		        break;
		case 3: System.exit(0);
		default: mainMenu();
		}
		}catch(Exception e) {
			System.out.println("Invalid Input. Kindly choose from the above menu");
		}
		
	}
	
	
private void listFiles() {
	  String [] list=folder_name.list();
	  if(list.length==0) {
		  System.out.println("The directory is Empty..");
	  }else {
	  System.out.println("The files are");
	  Arrays.sort(list);
	  for(String s:list) {
		  System.out.println(s);
	  }
	  }
  }
	


private void secondaryFunctions() {
		System.out.println(SecondMenu);
		try {
		System.out.println("Select any option from above:");
		Scanner scan=new Scanner(System.in);
		int choice=scan.nextInt();
		switch(choice) {
		case 1: createFile();
		        secondaryFunctions();
		        break;
		case 2: deleteFile();
		        break;
		case 3: searchFile();
		        break;
		case 4: mainMenu();
		default: System.exit(0);
		}
		}catch(Exception e) {
			System.out.println("Kindly select from the above menu");
		}
}
	
private void createFile() {
	System.out.println("Enter the name of the file :");
	Scanner sc=new Scanner(System.in);
	String file_name=sc.next();
	File file=new File("myfiles",file_name);
	try {
		if(file.createNewFile()) {
			System.out.println("File created successfully");
		}
		else {
			System.out.println("File already exists");
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
}
private void deleteFile() {
	
	
}
private void searchFile() {
	
}


public static void main(String[] args) {
	LockedMe obj=new LockedMe();
	System.out.println(obj.Welcomescreen);
	obj.mainMenu();
	
}
}
