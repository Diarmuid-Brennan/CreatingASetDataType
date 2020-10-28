package ie.itcarlow;

import java.util.Scanner;

public class Dsa 

	// Student Name : 		Diarmuid Brennan/ ConorKerrigan
	// Student Id Number : 	CO0133947/ C00243093
	// Date :				19/9/2019
	// Purpose : 			Write a menu providing methods as options for editing, modifying an array 




	{
		public static int addName(String theName, String[] arr, int theNum)
		{
			if(isEmpty(theNum))// IF THE ARRAY IS EMPTY 
				{
					arr[0] = theName;
					theNum++ ;
				}
			else if(theNum == arr.length)//IT THE ARRAY IS FULL
				{
					System.out.println("The array is full. You must delete an entry first.") ;
				}
			else if(contains(theName, arr, theNum) == true)//USE CONTAINS METHOD TO TEST IF THE ENTRY IS ALREADY IN THE ARRAY
				{
					System.out.println("The entry is already in the array. NO DUPLICATES. Please enter another entry.") ;
				}
			else
				{//ASSIGN ENTRY TO NEXT POSITION IN THE ARRAY
					arr[theNum] = theName;
					System.out.println(theName + " has been entered into the array") ;
					theNum++ ;	
				}
			return theNum;
		}
		
		public static boolean contains(String theName, String[] arr, int theNum)
		{
			boolean result ;
			result = false ;
			int index ;
			//LOOP THROUGH THE ARRAY
			for(index = 0; index < theNum; index++)
				{//IF ENTERED NAME IS IN THE ARRAY SET RESUTLT TO TRUE
					if(arr[index].equalsIgnoreCase(theName))
						{
							result = true ;
						}
				}
			return result;	
			
		}
		
		//FIND WHAT ENTRIES ARE IN ONE SET ONLY
		public static int findSetDiff(String [] arr, int theNum, String [] arr1, int theNum1)
		{
			for(int i = 0; i < theNum ; i++)
				{
					for(int j = 0; j < theNum1 ; j++)
						{//LOOP THROUGH BOTH SETS AND COMPARE ENTRIES
							if(arr[i].equalsIgnoreCase(arr1[j]))
								{//IF THERE IS A MATCH DELETE ENTRY FROM TE ARRAY
									for (int step = i ; step < theNum - 1; step ++)
										{
											 arr[step]= arr[step +1]; 	
										}	
									arr[theNum - 1] = null ;
									//DECREMENT NUMBER OF ELEMENTS AND INDEX POSITION
									i--;
									theNum-- ;
									
								}
						}
				}
			if(theNum == 0){
				System.out.println("\nThere is no set difference betweeen the arrays") ;
			}
			return theNum ;
		}
		

		public static void listAllNames(String[] arr, int theNum )
		{
			int index;
			if(isEmpty(theNum))// IF THE ARRAY IS EMPTY 
				{
					System.out.println("The array is empty. You must enter in an entry first.") ;
				}
			else
				{//OUTPUT EACH ENTRY IN THE ARRAY
					System.out.println() ;
					for (index = 0; index < theNum ; index ++)
	    				{
	    					System.out.print("\t" + arr[index] + " [" + index + "]" )  ;
	    				}
	    			System.out.println() ;	
				}
			
		}
		
		public static int deleteName(String theName, String[] arr, int theNum)
		{
			int step ;
			int place ;
			
			step = 0 ;
			place = 0 ;
			if(isEmpty(theNum))// IF THE ARRAY IS EMPTY 
				{
					System.out.println("The array is empty. You must enter in an entry first.") ;
				}
			else
			{//WHILE LESS THAN NUMBER OF ELEMENTS AND NOT EQUAL TO INPUT NAME STEP THROUGH THE ARRAY
				while (step < theNum && arr[step].equalsIgnoreCase(theName) == false)
					{
						step++ ;
					}
				if(step < theNum)//IF NAME IS THE SAME AS AN ENTRY IN THE ARRAY ASSIGN IT TO PLACE
					{
						place = step ;
					}	
				else//IF THE NAME IS NOT FOUND IN THE ARRAY ASSIGN IT TO -1
					{
						place = -1 ;
					}
				if(place != -1)//IF NAME IS FOUND IN THE ARRAY CARRY OUT THIS
					{
						
						for (step = place ; step < theNum - 1; step ++)
							{
								 arr[step]= arr[step +1]; 	
							}
						System.out.println(theName + " has been removed from the array") ;
						System.out.println() ;
						arr[theNum - 1] = "" ;
						//DECREMENT THE NUMBER OF ELEMENTS
						theNum-- ;
					}
				else
					{
						System.out.println("The name you have entered is not in the array.") ;
					}
			}		
			return theNum;
		}
		
		public static void listAllNamesBeginningWith(String[] arr, int theNum, char theChar)
		{
			int index;;
			int count = 0;
			theChar = Character.toUpperCase(theChar) ;
			if(isEmpty(theNum))//IF THE ARRAY IS EMPTY
				{
					System.out.println("The array is empty. You must enter in an entry first.") ;
				}
			else
				{
					System.out.println() ;
					for (index = 0; index < theNum ; index ++)
	    				{//LOOP THROUGH THE ARRAY. IF THE FIRST CHARACTER IN N ENTRY MATCHES THECHAR, OUTPUT TO THE SCREEN
	    					arr[index] = arr[index].toUpperCase() ;
	    					if(arr[index].charAt(0) == theChar )
	    					{
	    						System.out.print("\t" + arr[index] + " [" + index + "]" )  ;
	    						count++ ;
	    					}
	    					
	    				}
	    			if(count == 0)//IF THERE ARE NO MATCHES
	    			{
	    				System.out.print("There are no mtches in the array" )  ;
	    			}
	    			System.out.println() ;	
				}
			
		}
		
		public static boolean isEmpty(int theNum)
		{
			if(theNum== 0){//IF ARRAY IS EMPTY
				return true ;
			}
			
			return false ;
		}
		
		public static void initialize(String arr[])
		{//INITIALIZE ARRAYS TO ""
			for(int index = 0; index < arr.length; index++){
				arr[index] = "" ;
			}
		}
		
		public static int choice(int option, String arr[], int theNum, String arr1[], int theNum1)
		{
			
			switch(option)
				{
					
				   	case 1 ://OPTION ONE ADD A NAME
				   		System.out.print("\nOption 1 :	Add Entry(No duplicates)") ;
				    	System.out.print("\nEnter name to be entered to the set :	") ;
				    	Scanner in = new Scanner(System.in);
				    	String name = in.nextLine() ;
				    	//String name = EasyIn.getString() ;
						theNum = addName(name, arr, theNum) ; 
						System.out.print("Set now contains ;	") ;
				    	for (int index = 0; index < theNum ; index ++)
				    		{
				    			System.out.print("\t" + arr[index] + " [" + index + "]" )  ;
				    		}
				    	System.out.println() ;
				    	System.out.println() ;	 
						break ;
					case 2	://OPTION 2 SEARCH THE ARRAY TO SEE IF A NAME IS ALREADY IN IT
						System.out.print("\nOption 2 :	Search if a Name is in the array") ;
						System.out.print("\nEnter name to be searched for in the set :	") ;
						Scanner im = new Scanner(System.in);
						String searchName = im.nextLine() ;
				    	//String searchName = EasyIn.getString() ; 
				    	if(contains(searchName, arr, theNum) == true)
				    		{
				    			System.out.println("The entry is already in the array. NO DUPLICATES allowed.\n") ;
				    		}
				    	else{
				    			System.out.println("The entry is not in the array.\n") ;
				    		} 
						break ;
					case 3 ://OPTION 3 OUTPUT THE SET DIFFERENCE BETWEEN THE TWO ARRAYS
						System.out.print("\nOption 3 :	Output the Set difference betwwen the two sets") ;
						theNum = findSetDiff(arr, theNum, arr1, theNum1) ;
						System.out.print("\nThe set difference is 	: ") ;
						for (int index = 0; index < theNum ; index ++)
	    					{
	    						System.out.print("\t" + arr[index] + " [" + index + "]" )  ;	
	    					}
	    				System.out.println() ;
						break ;
					case 4 ://OPTION 4 LIST ALL NAMES IN THE ARRAY
						System.out.print("\nOption 4 :	List All Entries ") ;
						listAllNames(arr, theNum) ;
						System.out.println() ;
						break ;	
					case 5 ://OPTION 5 DELETE AN ENTRY FROM THE ARRAY
						System.out.print("\nOption 5 :	Delete an entry ") ;
						System.out.print("\nEnter name to be deleted from the set :	") ;
						Scanner io = new Scanner(System.in);
						String delName = io.nextLine() ;
				    	//String delName = EasyIn.getString() ;
						theNum = deleteName(delName, arr, theNum) ;	
				    	break ;
				    case 6 ://OPTION 6 OUTPUT ENTRIES BEGINNING WITH ?
				    	System.out.print("\nOption 6 :	List only the entries beginning with ") ;
						System.out.print("\nEnter the names beginning letter to be searched from the set :	") ;
						Scanner ip = new Scanner(System.in);
						char initial = ip.next().charAt(0);
						//char initial = EasyIn.getChar() ;
						//CHANE CHARACTER TO IGNORECASE
						listAllNamesBeginningWith(arr, theNum, initial) ;
						System.out.println() ;
						break ;
					default : System.out.println("\nThis is not an option. Enter a number 1-7") ;
						break ;
			}
			return theNum ;		
		}
		
	    public static void main(String[] args)
	    {
	    	final int NUMBEROFNAMES = 6 ;
	    	String set [] ;
	    	set = new String [NUMBEROFNAMES] ;
	    	initialize(set) ;
	    	String set2 [] ;
	    	set2 = new String [NUMBEROFNAMES] ;
	    	initialize(set2) ;
	    	int noOfElements;
	    	int noOfElements2 ;
	    	
	    	noOfElements = 0 ;
	    	noOfElements2 = 0;
	    	String menu ;
	    	int option ;
	    	int choice ;
	    	
	    	menu = 		"\t\t####MENU####\n" ;
	    	menu +=	 "\n1.	Add Entry(No duplicates)" ;
			menu +=	 "\n2.	Search if a Name is in the array" ;
			menu +=	 "\n3	Output the Set difference betwwen the two sets " ;
			menu +=	 "\n4.	List All Entries " ;
			menu +=	 "\n5.	Delete an entry " ;
			menu +=	 "\n6.	List only the entries beginning with " ;
			menu +=	 "\n7.	Exit" ;
			menu += 	"\n\t\t##############\n" ;
	    	
	    	System.out.println(menu)  ;
	    	System.out.print("Please select an option(1-7) :	")  ;
	    	Scanner opt = new Scanner(System.in);
	    	option = opt.nextInt();
	    	//option = EasyIn.getInt() ;
	    	while(option != 7)
	    		{//CHOOSE EITHER SET1 OR SET2 
	    			
	    			System.out.print("Please select which set (1 for set1, 2 for set 2) : 	") ;
	    			Scanner cho = new Scanner(System.in);
			    	choice = cho.nextInt();
	    			//choice = EasyIn.getInt() ;
	    			if(choice == 1) 
	    				{//THIS MODIFIES SET ONE
	    					System.out.print("\n\t\t\t\tSET ONE" )  ;
	    					noOfElements = choice(option, set, noOfElements, set2, noOfElements2) ;	
	    				}
	    			else if(choice == 2)
						{//THIS MODIFIES SET TWO
							System.out.print("\n\t\t\t\tSET TWO" )  ;
	    					noOfElements2 = choice(option, set2, noOfElements2, set, noOfElements) ;	
	    				}
	    			else
		    			{
		    			System.out.println("\n\nINVALID OPTION(1 for set1, 2 for set 2)" )  ;
		    			}
		    		System.out.println(menu)  ;
	    			System.out.print("Please select an option :	" )  ;
	    			//option = EasyIn.getInt() ;
	    			option = opt.nextInt();
	    		}
	    	
	    	System.out.println("\nYou have exited the program" )  ;
		}
	}


