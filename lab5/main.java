
import java.io.*;

class lab0 {
	public static boolean isNumeric(char sign){
		return sign >= '0' && sign <='9';
	}

	public static String reverserStr(String number){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(number);
		stringBuilder.reverse();
		return stringBuilder.toString();
		
	}

	public static boolean isIntegerString(String number){
		for(int i=0; i<number.length();i++){
			if(!isNumeric(number.charAt(i)))
				return false;
			
		}
		return true;
	}

	public static void my_printf(String format_string, String param){
		for(int i=0;i<format_string.length();i++){
			if((format_string.charAt(i) == '#') && (format_string.charAt(i+1) == 'k')){
				System.out.print(param);
				i++;
			}else if(format_string.charAt(i) == '#' && (format_string.charAt(i+1) == 'g'))
			{
				i++;
				if(isIntegerString(param)){
					System.out.print(reverserStr(param));					
				}else
					System.out.print("0");		
			}else{
				System.out.print(format_string.charAt(i));
			}
		}
		System.out.println("");
	}

	public static void main(String[] args) throws IOException {
		//System.out.println("Hello, World!"); 
		BufferedReader bufferReader=new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc=new Scanner(System.in);
		String format_string, param;
		while(bufferReader.ready()) {
			format_string=bufferReader.readLine();
			param=bufferReader.readLine();
			my_printf(format_string,param);
		}
	}
}
