package RegularExpression;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular {
	static String str = "9as78";
	
	public static void main(String[] args) {
		count();
		countLetter();
		countNumber();
		findCharacter();
		
		regularExp();
		java8Feature();
		
		System.out.println("harry".replaceAll("[H | h]arry", "Larry"));
		// Or operator ' | ' replace h OR H
		//Output -> Larry
	}
//  string.replaceAll("[aeiou][gh]", "X")  a/e/i/o/u followed by g or h
//==string.toCharArray()==================================================
	public static void count(){
		String string = "Aa kiu, I swd skieo 236587. GH kiu: sieo?? 25.33";
		char[] ch = string.toCharArray();
		int letter = 0;
		int space = 0;
		int num = 0;
		int other = 0;
		for(int i = 0; i < string.length(); i++){
			if(Character.isLetter(ch[i])){
				letter ++ ;
			}else if(Character.isDigit(ch[i])){
				num ++ ;
			}else if(Character.isSpaceChar(ch[i])){
				space ++ ;
			}else{
				other ++; 
			}
		}
		System.out.println(string);
		System.out.println("letter: " + letter);
		System.out.println("space: " + space);
		System.out.println("number: " + num);
		System.out.println("other: " + other);
}//OUTPUT
//	Aa kiu, I swd skieo 236587. GH kiu: sieo?? 25.33
//			letter: 23
//			space: 9
//			number: 10
//			other: 6
//------str.charAt(i)---------------------------------------
	public static void countLetter() {	
		int countLetter = 0;
		int countNumber = 0;
		System.out.println("Counting String of: "+ str);
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i))) {
				countLetter++;
			}else {
				countNumber++;
			}
		}
		System.out.println("Letters-isLetter Method: "+ countLetter);
		System.out.println("Numbers-isLetter: "+ countNumber);
	}//OUTPUT
//	Counting String of: 9as78
//	Letters-isLetter Method: 2
//	Numbers-isLetter: 3
	//---------------------------------------------
	public static void countNumber() {
		int countNumber = 0;
		System.out.println("---------------------");
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				countNumber++;
			}
		}
		System.out.println("Numbers-isDigit: "+ countNumber);
	}//OUTPUT
	//Numbers-isDigit: 3
	//--------------------------------------------------------------------
	public static void findCharacter() {
		String someString = "elephant";
		char someChar = 'e';
		int count = 0;

		for (int i = 0; i < someString.length(); i++) {
			if (someString.charAt(i) == someChar) {
				count++;
			}
		}
		System.out.println("Character e-count: " + count);
	}//OUTPUT
	//Character e-count: 2
	//---------------------------------------------------------------------
	private static int countOccurences(String someString, char searchedChar, int index) {
		if (index >= someString.length()) {
			return 0;
		}

		int count = someString.charAt(index) == searchedChar ? 1 : 0;
		return count + countOccurences(someString, searchedChar, index + 1);
	}
//-------------------------------------------------------------------------
	public static void regularExp() {
		Pattern pattern = Pattern.compile("[^e]*e");
		Matcher matcher = pattern.matcher("elephant");
		int count = 0;
		while (matcher.find()) {
		    count++;
		}
		System.out.println("elephant, e-count-> "+ count);
	}//OUTPUT
	//elephant, e-count-> 2
//---------------------------------------------------------------------------
	public static void java8Feature() {
		String someString = "elephant";
		long count = someString.chars().filter(ch -> ch == 'e').count();
		System.out.println("java8Feature(), elephant, e-count-> " + count);
	}//OUTPUT
	//java8Feature(), elephant, e-count-> 2
//---------------------------------------------------------------------------
}
// Using External Libraries
//	commons-lang3
//	guava
//	Using Spring
//	int count = StringUtils.countOccurrencesOf("elephant", "e");
