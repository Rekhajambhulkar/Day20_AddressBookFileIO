package com.bridgelabz.addressbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class AddressBook {
	
	HashMap<String, Person> contacts = new HashMap<String, Person>();
	
	static String HOME = System.getProperty("C:\\Users\\LENOVO\\eclipse-workspace\\AddressBookApplication");
	String file = HOME + "AddressBook.txt";
	
	static Scanner scanner = new Scanner(System.in);
	String firstName;
	
	int choice = 1;
	public HashMap<String, Person> userChoice() {
		
		while(choice != 5) {
			switch (choice) {
			
				case 1://Adds contact
					System.out.println("Add new Contact");
					Person collect = getUserInput();
					contacts.put(collect.getFirstName(), collect);
					saveToFile(file, collect, true);
					System.out.print("\n1.Create New Contact\n2.Read Existing Contact\n3.Update Existing Contact\n4.Delete Existing Contact\n5.Exit\nOption : ");
					choice = scanner.nextInt();
					break;
					
				case 2: //Reads Contact
					readContacts();
					System.out.print("\n1.Create New Contact\n2.Read Existing Contact\n3.Update Existing Contact\n4.Delete Existing Contact\n5.Exit\nOption : ");
					choice = scanner.nextInt();
					break;

				case 3: //Updates Contact
					updateContacts();
					System.out.print("\n1.Create New Contact\n2.Read Existing Contact\n3.Update Existing Contact\n4.Delete Existing Contact\n5.Exit\nOption : ");
					choice = scanner.nextInt();
					break;
				case 4: //Deletes Contact
					deleteContacts();
					System.out.print("\n1.Create New Contact\n2.Read Existing Contact\n3.Update Existing Contact\n4.Delete Existing Contact\n5.Exit\nOption : ");
					choice = scanner.nextInt();
					break;
				
				case 5: //Terminates Program
					break;
				
				default: //If User Enters Invalid
					while(choice > 0 && choice < 9) {
						System.out.println("Enter valid Option");
						choice = scanner.nextInt();
					}
					break;
			}
		}
		System.out.println("\n\tAddress Book Updated");
		choice = 1;
		return contacts;
	}
	
	private Person getUserInput() { //Takes Input from User
		
		 	System.out.print("First Name : ");
	        String firstName = firstName();
	        System.out.print("Last Name : ");
	        String lastName = scanner.next();
	        System.out.print("Address : ");
	        String address = scanner.next();
	        System.out.print("City : ");
	        String city = scanner.next();
	        System.out.print("Zip Code : ");
	        int zip = scanner.nextInt();
	        System.out.print("State : ");
	        String state = scanner.next();
	        System.out.print("Phone Number : ");
	        long phone = scanner.nextLong();
	        System.out.print("Email : ");
	        String email = scanner.next();;
	        
	        Person collect = new Person(); //POJO class
	        
	        collect.setFirstName(firstName);
	        collect.setLastName(lastName);
	        collect.setAddress(address);
	        collect.setCity(city);
	        collect.setZip(zip);
	        collect.setState(state);
	        collect.setPhoneNumber(phone);
	        collect.setEmailId(email);
		
	        return collect;
	}
	
	private String firstName() {
		boolean check = true;
		
		while(check) {
			firstName = scanner.next();
			if(contacts.containsKey(firstName))
				System.out.print("\nContact Exist\nFirst Name : ");
			else {
				check = false;
			}
		}
		return firstName;
		
	}

	private void readContacts() { //Method to read all contacts
		
		Set<String> allKeys = contacts.keySet(); //Stores All Unique Contact Keys
		
		System.out.println("\nEnter Which contact you want to Read");
		for(String key : allKeys) {
			System.out.println(key);
		}
		
		System.out.print("Key : ");
		String readWithKey = scanner.next();
		
		if(contacts.containsKey(readWithKey)) { //Shows Contact Details Stored in Entered Unique Key
			
			System.out.println("\nContact Details :");
			Person showDetailsToUpdate = contacts.get(readWithKey);
			
			System.out.println("\n\tFirst Name\t:\t"+showDetailsToUpdate.getFirstName()
								+"\n\tLast Name\t:\t"+showDetailsToUpdate.getLastName()
								+"\n\tAddress\t\t:\t"+showDetailsToUpdate.getAddress()
								+"\n\tCity\t\t:\t"+showDetailsToUpdate.getCity()
								+"\n\tZip Code\t:\t"+showDetailsToUpdate.getZip()
								+"\n\tState\t\t:\t"+showDetailsToUpdate.getState()
								+"\n\tPhone Nuber\t:\t"+showDetailsToUpdate.getPhoneNumber()
								+"\n\tEmail ID\t:\t"+showDetailsToUpdate.getEmailId()+"\n");
			
			readFile(file, readWithKey);
		}
		else {
			System.out.println("\nInvalid Key !!!");
		}
	}
	private void updateContacts() { //Updates Contacts
		
		System.out.println("\nEnter Which contact you want to update");
		
		Set<String> allKeys = contacts.keySet(); //Stores All Unique Contact Keys
		
		for(String key : allKeys) {
			System.out.println(key);
		}
		
		System.out.print("Key : ");
		String updateWithKey = scanner.next();
		
		if(contacts.containsKey(updateWithKey)) { //Shows Contact Details Stored in Entered Unique Key
			
			Person showDetailsToUpdate = contacts.get(updateWithKey);
			
			int updateDoneOption = 1;
			while(updateDoneOption == 1) { //Runs Until Completion of Multiple Updates on a contact
				
				System.out.println("\nEnter Choice to Update");
				System.out.println("\n\t1.First Name\t:\t"+showDetailsToUpdate.getFirstName()
									+"\n\t2.Last Name\t:\t"+showDetailsToUpdate.getLastName()
									+"\n\t3.Address\t:\t"+showDetailsToUpdate.getAddress()
									+"\n\t4.City\t\t:\t"+showDetailsToUpdate.getCity()
									+"\n\t5.Zip Code\t:\t"+showDetailsToUpdate.getZip()
									+"\n\t6.State\t\t:\t"+showDetailsToUpdate.getState()
									+"\n\t7.Phone Nuber\t:\t"+showDetailsToUpdate.getPhoneNumber()
									+"\n\t8.Email ID\t:\t"+showDetailsToUpdate.getEmailId());
			
				boolean entry = true;
			
				while(entry) {
					
					System.out.print("Option : ");
					int optionToUpdate = scanner.nextInt(); //Takes Option to update Contact details
				
					switch(optionToUpdate) {
				
					case 1:
						System.out.print("First Name : ");
						String firstName = scanner.next();
						showDetailsToUpdate.setFirstName(firstName);
						System.out.print("Updated\n\n1.Update More Details\n2.Updates Enough\nOption : ");
						updateDoneOption = scanner.nextInt();
						entry = false;
						break;
					
					case 2:
						System.out.print("Last Name : ");
						String lastName = scanner.next();
						showDetailsToUpdate.setLastName(lastName);
						System.out.print("Updated\n\n1.Update More Details\n2.Updates Enough\nOption : ");
						updateDoneOption = scanner.nextInt();
						entry = false;
						break;
					
					case 3:
						System.out.print("Address : ");
						String address = scanner.next();
						showDetailsToUpdate.setAddress(address);
						System.out.print("Updated\n\n1.Update More Details\n2.Updates Enough\nOption : ");
						updateDoneOption = scanner.nextInt();
						entry = false;
						break;
					
					case 4:
						System.out.print("City : ");
						String city = scanner.next();
						showDetailsToUpdate.setCity(city);
						System.out.print("Updated\n\n1.Update More Details\n2.Updates Enough\nOption : ");
						updateDoneOption = scanner.nextInt();
						entry = false;
						break;
					
					case 5:
						System.out.print("Zip Code : ");
						int zip = scanner.nextInt();
						showDetailsToUpdate.setZip(zip);
						System.out.print("Updated\n\n1.Update More Details\n2.Updates Enough\nOption : ");
						updateDoneOption = scanner.nextInt();
						entry = false;
						break;
					
					case 6:
						System.out.print("State : ");
						String state = scanner.next();
						showDetailsToUpdate.setState(state);
						System.out.print("Updated\n\n1.Update More Details\n2.Updates Enough\nOption : ");
						updateDoneOption = scanner.nextInt();
						entry = false;
						break;
					
					case 7:
						System.out.print("Phone Number : ");
						long phoneNumber = scanner.nextLong();
						showDetailsToUpdate.setPhoneNumber(phoneNumber);
						System.out.print("Updated\n\n1.Update More Details\n2.Updates Enough\nOption : ");
						updateDoneOption = scanner.nextInt();
						entry = false;
						break;
					
					case 8:
						System.out.print("Email : ");
						String email = scanner.next();
						showDetailsToUpdate.setEmailId(email);
						contacts.put(showDetailsToUpdate.getEmailId(), showDetailsToUpdate);
						contacts.remove(updateWithKey);
						System.out.print("Updated\n\n1.Update More Details\n2.Updates Enough\nOption : ");
						updateDoneOption = scanner.nextInt();
						entry = false;
						break;
						
					default:
						System.out.println("Enter Valid Option");
						break;
					}
				}
			}
			saveToFile(file, showDetailsToUpdate, true);
		}
		else {
			System.out.println("\nInvalid Key !!!");
		}
	}
	private void deleteContacts() {
		
		Set<String> allKeys = contacts.keySet(); //Stores All Unique Contact Keys
		System.out.println("\nEnter Which contact you want to Delete");
		
		for(String key : allKeys) {
			System.out.println(key);
		}
		System.out.print("Key : ");
		String deleteWithKey = scanner.next();
		
		if(contacts.containsKey(deleteWithKey)) { //Deletes Contact based on Entered Unique Key
			contacts.remove(deleteWithKey);
			System.out.println("Deleted Successfully");
		}
		removeFromFile(deleteWithKey);
	}

	// STREEM API Day 11
	public void searchByCity(String city, String cityFile) {//Search by City
 
		Map<String, String> personInCity = contacts.values()//Dictionary of Person And City
												.stream()
												.filter(map -> map.getCity().contains(city))
												.collect(Collectors.toMap(map -> map.getEmailId()+" ", map -> " "+map.getFirstName()+" "+map.getLastName()+", City : "+map.getCity()));
			searchByCityFile(personInCity,cityFile);
			System.out.println(personInCity);
		}
	
	private void searchByCityFile(Map<String, String> personInCity, String cityFile) {
		try {
			File storageFile = new File(cityFile);
			FileWriter fileWriter = new FileWriter(storageFile);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.print(personInCity);
			printWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void searchByState(String state, String stateFile) { //Search by State
	
		Map<String, String> personInState = contacts.values()//Dictionary of Person And State
				.stream()
				.filter(map -> map.getState().contains(state))
				.collect(Collectors.toMap(map -> map.getEmailId()+" ", map -> " "+map.getFirstName()+" "+map.getLastName()+", State : "+map.getState()));

		addToFile(personInState,stateFile);
		System.out.println(personInState);
	}

	public Long countByCity(String countCityContacts) { // Counts no of Contacts in City
		Long count = contacts.values()
				.stream()
				.filter(map -> map.getCity().contains(countCityContacts))
				.collect(Collectors.counting());
		return count;
	}

	public Long countByState(String countStateContacts) { // Counts no of Contacts in State
		
		Long count = contacts.values()
				.stream()
				.filter(map -> map.getState().contains(countStateContacts))
				.collect(Collectors.counting());
		return count;
	}

	public void sortByName(String sortByNameFile) { //Sorts Alphabetically by First Name
		
		List<Person> sortedList = contacts.values()
											.stream()
											.sorted(Comparator.comparing(Person::getFirstName))
											.collect(Collectors.toList());
		addToSortedFile(sortedList,sortByNameFile);
		System.out.println(sortedList);
	}

	public void sortByCity(String sortByCityFile) { //Sorts Alphabetically by City
		List<Person> sortedList = contacts.values()
											.stream()
											.sorted(Comparator.comparing(Person::getCity))
											.collect(Collectors.toList());
		addToSortedFile(sortedList,sortByCityFile);
		System.out.println(sortedList);	
	}

	public void sortByState(String sortByStateFile) { //Sorts Alphabetically by State
		List<Person> sortedList = contacts.values()
											.stream()
											.sorted(Comparator.comparing(Person::getState))
											.collect(Collectors.toList());
		addToSortedFile(sortedList,sortByStateFile);
		System.out.println(sortedList);	
		
	}

	public void sortByZip(String sortByZipFile) { //Sorts Alphabetically by ZIP
		List<Person> sortedList = contacts.values()
											.stream()
											.sorted(Comparator.comparing(Person::getZip))
											.collect(Collectors.toList());
		addToSortedFile(sortedList,sortByZipFile);
		System.out.println(sortedList);			
	}
	
	public void saveToFile(String file, Person detailsCollector, boolean saveCondition) {
		try {
			File storageFile = new File(file);
			FileWriter fileWriter = new FileWriter(storageFile,saveCondition);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println(detailsCollector);
			printWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void readFile(String file, String keyToSearch) {
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInputStream);
			properties.forEach((key, practicePojo) -> { 
				if(key.equals(keyToSearch)) {
				System.out.println("File : "+practicePojo);
				}
			});
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void removeFromFile(String deleteWithKey) {
		try {
			FileOutputStream fileoutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileoutputStream);

			FileInputStream fileInputStream = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInputStream);
			properties.forEach((key, practicePojo) -> { 
				if(key.equals(deleteWithKey)) {
					properties.keySet();
				}
			});	
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void addToFile(Map<String, String> personInState, String stateFile) {
		try {
			File storageFile = new File(stateFile);
			FileWriter fileWriter = new FileWriter(storageFile);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.print(personInState);
			printWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void addToSortedFile(List<Person> sortedList, String sortByNameFile) {
		try {
			File storageFile = new File(sortByNameFile);
			FileWriter fileWriter = new FileWriter(storageFile);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.print(sortedList);
			printWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
