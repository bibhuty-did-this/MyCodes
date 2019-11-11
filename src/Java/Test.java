package Java;

public class Test{
	public static void main(String[] args){
		//String s="\\\\[\\\\sqrt 3 \\\\,s\\\\]";
		String s="\\\\[{\\\\left( {\\\\frac{{3{v_0}}}{{2\\\\alpha }}} \\\\right)^{1/3}}\\\\]";
		//System.out.println(s.replaceAll("[^a-zA-Z ]", ""));
		System.out.println(s.replaceAll("\\\\", ""));
	}
}
