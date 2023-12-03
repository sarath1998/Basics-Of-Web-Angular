enum

 -- Enumerations or Java Enum serve the purpose of representing a group of named constants in a programming language. 
 -- Java Enums are used when we know all possible values at ****compile time.
 
 For eg: such as choices on a menu, rounding modes, command-line flags, etc
 
 -- We can not change enums dynamically/at runtime in Java. What ever defined at compile time is final and and neither can be added nor removed.
 -- The first line inside the enum should be a list of constants
 -- According to Java naming conventions, it is recommended that we name constant with all capital letters
 -- Every enum constant is always implicitly ***public static final***. Since it is static, we can access it by using the enum Name. 
    Since it is final, we can’t create child enums.
 
 
 enum Signature:
  
    public abstract class Enum<E extends Enum<E>>
        implements Constable, Comparable<E>, Serializable {
		
		}
		
		
	To observe,

          enum is implemented internally in the form of a class that extends the Enum.class. Since in Java, multiple inheritance is not supported,
          so ideally an enum can not extend any other class.

		 However, it can implement the interface.
		
		
 
 -- A Java enumeration is a class type. 
 
 
    For eg: 
	
	public enum Day 
	{
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}
	
  Explanation:	
	
	
   i.e, Behind the scenes, this enum declaration creates a class named ****Day, which implicitly extends the java.lang.Enum class. 
   
       -- Each constant within the enum (e.g., MONDAY, TUESDAY, etc.) is an ****instance of this class.
   
       -- Therefore, the number of instances of enum is defined at the compile time only. So, we can not create any new instances of enum.. there ****no "new" keyword usage is applicable.
       
       -- Enums in Java can have fields, methods, and constructors like regular classes, allowing you to define behaviors and properties specific to each enum constant. 
   
       -- However, the ***set of enum constants itself is fixed at compile time***, and you cannot dynamically modify or add new constants to the enum at runtime.
	      constants means objects anukovachu.. for eg: Day ane enum lo, constants are  MONDAY, TUESDAY, WEDNESDAY, THURSDAY...

       -- While enums behave like classes, their ***primary purpose is to define a fixed set of related constants**** rather than 
		  serving as general-purpose classes for object instantiation and modification.
	
	       Explanation : behave like classes means ... 
		   
		            public enum Day {
										MONDAY(1),
										TUESDAY(2),
										WEDNESDAY(3),
										THURSDAY(4),
										FRIDAY(5),
										SATURDAY(6),
										SUNDAY(7);

										private final int dayNumber;

										// Constructor for the enum constant
										Day(int dayNumber) {
											this.dayNumber = dayNumber;
										}

										// Getter method to retrieve the day number
										public int getDayNumber() {
											return dayNumber;
										}
									}

				To observe :
				             -- class keyword badulu enum ani vaadam
							 -- enum lo no of objects anevi compile time lone declare cheyyali.. so MONDAY, TUESDAY.. etc., avi objects + constants ani kooda anachu.
							 -- Constants levu anukoni observe, just like a class..

                                   -- firstly, properties of enum declare chesam.. i.e dayNumber
                                   -- followed by constructor .. parameterized constructor.. since manam constants defined chesutunappudu some value pass chestunnam kadha
                                   -- defining the behaviour of enum.. i.e instance methods in enum. In this case.. getDayNumber()


							 -- "dayNumber" field anedi private and final .. so can not access it outside the enum.. hence public getter method is provided.
  
  
  
  
  -- Enum declaration can be done outside a Class or inside a Class but not inside a Method.
 
 
 
			 Sample snippiet :
			 
			 public class Test {
				enum Color {
					RED,
					GREEN,
					BLUE;
				}
			 
				// Driver method
				public static void main(String[] args)
				{
					Color c1 = Color.RED;
					System.out.println(c1);
				}
			}
			
			O/p - RED

			// enum declaration inside a class.
			 
			public class Test {
				enum Color {
					RED,
					GREEN,
					BLUE;
				}
			 
				// Driver method
				public static void main(String[] args)
				{
					Color c1 = Color.RED;
					System.out.println(c1);
				}
			}
			
			O/p - RED
			
			
  -- toString() method is overridden in java.lang.Enum class, which returns enum constant name.
   
     paina program lo, Color.RED ==> will return the object.
	 toString() method aithe String value return chestadi.
	 
	 For eg: 
	 
	 enum Season { WINTER, SPRING, SUMMER, FALL }
	 
	class Sample
	{  
		public static void main(String[] args) 
		{  
			Season winterObject = Season.WINTER;
			System.out.println("winterObject class type: "+winterObject.getClass()+"WinterObject:  "+winterObject);
			String constantName = winterObject.toString();
			System.out.println("is constantName  string type: "+constantName.getClass());
			System.out.println(constantName);
		}	
	}   
	
	O/p --  winterObject class type: class SamplePackage.SeasonWinterObject:  WINTER
			is constantName  string type: class java.lang.String
			WINTER


	
	
	customValue vs ordinalValue of an enum :
	
	
	For each enum constant/object, in Java there are 2 values 
	
	 1. Custom value/explicit value 
	 2. Ordinal value
	 
	 Custom value :
	 
	   -- This will exist only if the programmer will explicitly define it while declaring the enum.
	   -- Java will not provide any default custom values.
	   --  It can be of any data type (such as integers, strings, objects, etc.) and represents specific data or characteristics associated with that constant
	   -- we can define any no of custom values.. based on which the parameterized constructor should hold that many arguments as well.
	      say for eg: if there are 2 values metntioned, then parameterized constructor should be defined with 2 values and also the getters for them must
		  be explicitly defined.
	   
	   How to declare the custom Value :
	   
	      Custom values need to be defined explicitly in the enum declaration.
		  
		  For eg: 
		  
		  public enum ExampleEnum 
		  {
			ONE(1),     // Custom value: 1
			TWO(5),     // Custom value: 5
			THREE(10);  // Custom value: 10
		  }
		  
		  Here, 1, 5, 10 are the custom values we explicitly defined for each constant/object of an enum
		  
	   How to access the custom value : 
		
		    can define getter methods within the enum and use them to retrieve the custom values.
			
		 
		
		eg 1:
			
			public enum ExampleEnum 
			{
				ONE(1),
				TWO(5),
				THREE(10);

				private final int customValue;

				ExampleEnum(int customValue) 
				{
					this.customValue = customValue;
				}

				public int getCustomValue() 
				{
					return customValue;
				}
			}
			
			public class Sample
			{
			  public static void main(String args[])
			  {
			    int valueOfOne = ExampleEnum.ONE.getCustomValue();     // Accessing custom value of ONE (returns 1)
				int valueOfTwo = ExampleEnum.TWO.getCustomValue();     // Accessing custom value of TWO (returns 5)
				int valueOfThree = ExampleEnum.THREE.getCustomValue(); // Accessing custom value of THREE (returns 10)
				
				sysout(valueOfOne +", "+valueOfTwo+", "+valueOfThree);
				
			  }
			}

	        O/p -- 1,5,10
			
			
	  Eg 2:
			public enum Day 
			{
				MONDAY(1, "First"),
				TUESDAY(2, "Second"),
				WEDNESDAY(3, "Third");

				private final int dayNumber;
				private final String ordinal;

				// Constructor for the enum constant
				Day(int dayNumber, String ordinal) 
				{
					this.dayNumber = dayNumber;
					this.ordinal = ordinal;
				}

				// Getter methods to retrieve the day number and ordinal
				public int getDayNumber() 
				{
					return dayNumber;
				}

				public String getOrdinal() 
				{
					return ordinal;
				}
			}
	
			
			
	
	 Ordinal value :
	 
			-- This is an automatically assigned value by Java representing the position or order of the enum constant in the declaration order of the enum. 
			-- Ordinal values are integers starting from 0 for the first constant, 1 for the second constant, and so on.
			-- to fetch this value, we have to invoke ordinal() for each enum constant/object.
		
		/*Java program to demonstrate 
		
		   how to assing custom value and access the custom value. 
		   ordinal value and how to access ordinal value
		   
		 */  
		enum TrafficSignal 
		{ 
			// This will call enum constructor with one 
			// String argument 
			RED(20), GREEN(30), ORANGE(40); 

			// declaring private variable for getting values 
			private int action; 

			// getter method 
			public int getAction() 
			{ 
				return this.action; 
			} 

			// enum constructor - cannot be public or protected 
			private TrafficSignal(int action) 
			{ 
				this.action = action; 
			} 
		} 

		//Driver code 
		public class Sample 
		{ 
			public static void main(String args[]) 
			{ 
				// let's print name of each enum and there action 
				// - Enum values() examples 
				TrafficSignal[] signals = TrafficSignal.values(); 

				for (TrafficSignal signal : signals) 
				{ 
					// use getter method to get the value 
					System.out.println("name : " + signal.name() + 
								" action: " + signal.getAction() +
								   "ordinal : "+signal.ordinal()); 
				} 
			} 
		} 
	
	
	O/p --  name : RED action: 20 ordinal : 0
			name : GREEN action: 30 ordinal : 1
			name : ORANGE action: 40 ordinal : 2
			
	To observe,
	
	   name() is an internal method of an enum similar to the toString() which will give name of the enum constant.
	   getAction() .. a getter method for accessing the custom value .
	   ordinal() .. gives the position of the enum.
	
	
    valueOf(), value()

	
	valueOf() 
	
	-- we can access enum's constants in 2 ways.. 
	    1. Season.WINTER
		2. Season.valueOf("WINTER")
		
		Both of them will return the respective enum constant(i.e the object).
		valueOf() method will take the String argument to fetch the constant. If not found then will throw the exeception.
		For eg:
		
		class EnumExample1
		{  
			//defining enum within class  
			public enum Season { WINTER, SPRING, SUMMER, FALL }  
			
			//creating the main method  
			public static void main(String[] args) 
			{  
				Season s1 = Season.valueOf("WINTER");
				Season s2 = Season.WINTER;
				System.out.println("s1.getClasss(): "+s1.getClass());
				System.out.println("s2.getClasss(): "+s2.getClass());
				System.out.println("s1: "+s1);
				System.out.println("s2: "+s2);
				Season s3 = Season.valueOf("SARATH");
				
			  }
		}  
		
	O/p -- 
	 s1.getClasss(): class SamplePackage.Sample$Season
	 s2.getClasss(): class SamplePackage.Sample$Season
	 s1: WINTER
	 s2: WINTER
	Exception in thread "main" java.lang.IllegalArgumentException: No enum constant SamplePackage.Sample.Season.SARATH
	  at java.base/java.lang.Enum.valueOf(Enum.java:273)
	  at SampleJavaprograms/SamplePackage.Sample$Season.valueOf(Sample.java:1)
	  at SampleJavaprograms/SamplePackage.Sample.main(Sample.java:18)
	
	
	To observe, 
	 Both of the ways are returning the instance.
	 Exception coming for "SARATH"
	 
	 
	 values()
	 
	  -- will return the array of constants
	  
	  For eg:
	  
	   class Sample
		{  
			//defining enum within class  
			public enum Season { WINTER, SPRING, SUMMER, FALL }  
			
			//creating the main method  
			public static void main(String[] args) 
			{  
				Season[] values = Season.values();
				System.out.println(values);
				for (Season s : values)
				{
					System.out.println(s.valueOf(s.toString()));
				}
			  }
		}
		
    O/p -- 
		[LSamplePackage.Sample$Season;@1d251891
		WINTER
		SPRING
		SUMMER
		FALL