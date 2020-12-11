package com.bridgelabz.addressbook;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

public class AddressBookMainClass 
{
	static AddressBook familyAddressBook = new AddressBook();//family Address Book
	static AddressBook friendsAddressBook = new AddressBook();//Friends Address Book
	static Scanner scan = new Scanner(System.in);
	
	static String HOME = System.getProperty("C:\\Users\\LENOVO\\eclipse-workspace\\AddressBookApplication");
	
	static String cityFileFamily = HOME + "/AddressBookFile/SearchByCityFamily.txt";
	static String cityFileFriend = HOME + "/AddressBookFile/SearchByCityFriend.txt";
	
	static String stateFileFamily = HOME + "/AddressBookFile/SearchByStateFamily.txt";
	static String stateFileFriend = HOME + "/AddressBookFile/SearchByStateFriend.txt";
	
	static String sortByNameFileFamily = HOME + "/AddressBookFile/SortByNameFamily.txt";
	static String sortByNameFileFriend = HOME + "/AddressBookFile/SortByNameFriend.txt";
	
	static String sortByCityFileFamily = HOME + "/AddressBookFile/SortByCityFamily.txt";
	static String sortByCityFileFriend = HOME + "/AddressBookFile/SortByCityFreind.txt";
	
	static String sortByStateFileFamily = HOME + "/AddressBookFile/SortByStateFamily.txt";
	static String sortByStateFileFriend = HOME + "/AddressBookFile/SortByStatefriend.txt";
	
	static String sortByZipFileFamily = HOME + "/AddressBookFile/SortByZipFamily.txt";
	static String sortByZipFileFriend = HOME + "/AddressBookFile/SortByZipFriend.txt";
	
	public static void main(String[] args) {
	
		@SuppressWarnings("rawtypes")
		HashMap<String, HashMap> addressBooks = new HashMap<String, HashMap>();//Stores Multiple Address Books
		HashMap<String, Person> oneListContacts = new HashMap<String, Person>();//Stores Single AddressBook
		
		System.out.println("\n\tWelcome to Address Book Program");
			       
	    while (true) {
	        System.out.println("\n1: for family \n" +
	        					 "2: for friend \n" +
	                    		 "3: To Search\n" +
	        					 "4: TO Sort\n" +
	        					 "5: To Terminate");
	        int selectedOption = scan.nextInt();
	            
	        switch (selectedOption) {
	        case 1:
	        	oneListContacts = familyAddressBook.userChoice();
	            addressBooks.put("Family", oneListContacts);
	            break;
	        case 2:
	        	oneListContacts = friendsAddressBook.userChoice();	
	        	addressBooks.put("Friend", oneListContacts);   
	        	break;
	        case 3:
	        	search();
	        	break;
	        case 4:
	        	sort();
	        	break;
	        case 5:
	        	System.out.println("\n\tTerminated");
	        	break;
	        } 
	        if(selectedOption == 5)
	        	break;
	    }
	}

	private static void search() {
		
		 System.out.println("\n1.Search by City\n2.Search by State\n3.Count by City\n4.Count by State");
		 int search = scan.nextInt();
		 switch (search) {
		 
		    case 1:
		    	System.out.print("Enter City : ");
		    	String city = scan.next();
		    	System.out.println("Contacts in "+city+" are");
		    	familyAddressBook.searchByCity(city,cityFileFamily);
		    	friendsAddressBook.searchByCity(city,cityFileFriend);
		    	print(cityFileFamily);
		    	print(cityFileFriend);
		    	break;
		    case 2:
		    	System.out.print("Enter State : ");
		    	String state = scan.next();
		    	System.out.println("Contacts in "+state+" are");
		    	familyAddressBook.searchByState(state,stateFileFamily);
		    	friendsAddressBook.searchByState(state,stateFileFriend);
		    	print(stateFileFamily);
		    	print(stateFileFriend);
		    	break;
		    case 3:
		    	System.out.print("Enter City : ");
		    	String CityToCountContacts = scan.next();
		    	Long noOfFamilyContactsInCity = familyAddressBook.countByCity(CityToCountContacts);
		    	Long noOfFriendsContactsInCity = friendsAddressBook.countByCity(CityToCountContacts);
		    	System.out.println("\nNo of Contacts in "+CityToCountContacts+" are "+(noOfFamilyContactsInCity+noOfFriendsContactsInCity));
		    	break;
		    case 4:
		    	System.out.print("Enter State : ");
		    	String StateToCountContacts = scan.next();
		    	Long noOfFamilyContactsInState = familyAddressBook.countByState(StateToCountContacts);
		    	Long noOfFriendsContactsIntate = friendsAddressBook.countByState(StateToCountContacts);
		    	System.out.println("\nNo of Contacts in "+StateToCountContacts+" are "+(noOfFamilyContactsInState+noOfFriendsContactsIntate));
		    	break;
		    default:
		    	System.out.println("\nInvalid Entry\n");
		    	break;
		}		
	}
	
	private static void sort() { //Sorting
		
		System.out.println("\n1: Sort by First Name\n2: Sort by City\n3: Sort by State\n4: Sort by ZIP\n");
		int sortOption = scan.nextInt();
		
		boolean ifNotSorted = false;
		while(!ifNotSorted) {
			switch (sortOption) { 
		
				case 1: // Sorts by First Name
					System.out.println("\nSorted List of Contacts by First Name\n");
					familyAddressBook.sortByName(sortByNameFileFamily);
					friendsAddressBook.sortByName(sortByNameFileFriend);
					print(sortByNameFileFamily);
			    	print(sortByNameFileFriend);
					ifNotSorted = true;
					break;
				case 2: // Sorts by City
					System.out.println("\nSorted List of Contacts by City\n");
					familyAddressBook.sortByCity(sortByCityFileFamily);
					friendsAddressBook.sortByCity(sortByCityFileFriend);
					print(sortByCityFileFamily);
			    	print(sortByCityFileFriend);
					ifNotSorted = true;
					break;
				case 3: // Sorts by State
					System.out.println("\nSorted List of Contacts by State\n");
					familyAddressBook.sortByState(sortByStateFileFamily);
					friendsAddressBook.sortByState(sortByStateFileFriend);
					print(sortByStateFileFamily);
			    	print(sortByStateFileFriend);
					ifNotSorted = true;
					break;
				case 4: // Sorts by ZIP
					System.out.println("\nSorted List of Contacts by ZIP\n");
					familyAddressBook.sortByZip(sortByZipFileFamily);
					friendsAddressBook.sortByZip(sortByZipFileFriend);
					print(sortByZipFileFamily);
			    	print(sortByZipFileFriend);
					ifNotSorted = true;
					break;
				default :
					System.out.println("Enter Correct Option\n");
					sortOption = scan.nextInt();
					break;
			}
		}
	}
	private static void print(String cityFile) {
	
	try {
		FileInputStream fileInputStream = new FileInputStream(cityFile);
		Properties properties = new Properties();
		properties.load(fileInputStream);
		properties.forEach((key, object) -> { 
			System.out.println(" File : "+object);
		});
	} 
	catch (IOException e) {
		e.printStackTrace();
	}
	}
}
