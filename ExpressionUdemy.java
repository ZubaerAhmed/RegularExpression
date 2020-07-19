package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionUdemy {

	public static void main(String[] args) {
        String string = "I am a string. Yes, I am.";
        System.out.println(string);
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);
// replace i with You -> You am a string. Yes, You am.
        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(alphanumeric.replaceAll(".","Y"));
// line 14, replace all with Y -> YYYYYYYYYYYYYYYYYYYYYYY
        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));
//replace only beginning -> YYYF12Ghhiiiijkl99z
        String secondString = "abcDeeeF12GhhabcDeeeiiiijkl99z";
        System.out.println(secondString.replaceAll("^abcDeee", "YYY"));
//replace only beginning -> YYYF12GhhabcDeeeiiiijkl99z
        System.out.println(alphanumeric.matches("^hello"));
        System.out.println(alphanumeric.matches("^abcDeee"));
        System.out.println(alphanumeric.matches("abcDeeeF12Ghhiiiijkl99z"));
// true false line 22, 23, 24 -> matches
        System.out.println(alphanumeric.replaceAll("ijkl99z$", "THE END"));
//abcDeeeF12GhhiiiTHE END
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));
// XbcDXXXF12GhhXXXXjkl99z         
        System.out.println(alphanumeric.replaceAll("[aei]", "I replaced a letter here"));
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));
// abcDeeX12GhhiiiXkl99z
        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));
// Harry
        String newAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(newAlphanumeric.replaceAll("[^ej]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[a-fA-F3-8]", "X"));
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]", "X"));
// 36,37,37 lines same result 
// XXXDXXXF12Ghhiiiijkl99z
//line 41 (?i) is not case sensetive
        System.out.println(newAlphanumeric.replaceAll("[0-9]", "X"));        
        System.out.println(newAlphanumeric.replaceAll("\\d", "X"));
//43, 44 same, replace digit 
// abcDeeeFXXGhhiiiijklXXz
        System.out.println(newAlphanumeric.replaceAll("\\D", "X"));
// Replace not digit -> XXXXXXXX12XXXXXXXXXX99X
        String hasWhitespace = "I have blanks and\ta tab, and also a newline\n";
        System.out.println(hasWhitespace);
        System.out.println(hasWhitespace.replaceAll("\\s", ""));
// remove white space line 51
// Ihaveblanksandatab,andalsoanewline
        System.out.println(hasWhitespace.replaceAll("\t", "X"));
// replace tab in line 54
        System.out.println(hasWhitespace.replaceAll("\\S", ""));
//line 56: tab, new line, white space STAY and all character replace with ""        
        System.out.println(newAlphanumeric.replaceAll("\\w", "X"));
        System.out.println(hasWhitespace.replaceAll("\\w", "X"));
// W-> replace character but remove white spaces -> XXXXXXXXXXXXXXXXXXXXXXX
// w-> replace character but STAY white spaces -> X XXXX XXXXXX XXX	X XXX, XXX XXXX X XXXXXXX
        System.out.println(hasWhitespace.replaceAll("\\b", "X"));
// b-> surrounded - XIX XhaveX XblanksX XandX	XaX XtabX, XandX XalsoX XaX XnewlineX
        String thirdAlphanumericString = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{3}", "YYY"));      
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe+", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe*", "YYY"));
//line 65, 66, 67 YYYF12Ghhiiiijkl99z 
        String string2 = "abcDF12Ghhiiiijkl99z";
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{3}", "YYY"));      
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe+", "YYY"));
//line 70, 71 no replace -> abcDF12Ghhiiiijkl99z        
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe*", "YYY"));
//replace because of * -> YYYF12Ghhiiiijkl99z
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{2,5}", "YYY"));
//replace abcD and e-range 2-5 -> YYYF12Ghhiiiijkl99z 
        System.out.println(thirdAlphanumericString.replaceAll("h+i*j", "Y"));
//replace h, i and j -> abcDeeeF12GYkl99z
        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2Pattern = ".*<h2>.*";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());
    }
}
