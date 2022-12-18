import java.io.*;
import java.util.Arrays;


class Main {

    public static long convertStringToLong(String exp){
        return Long.parseLong(exp);
    }

    public static String convertLongToHex(long val) {
        return Long.toHexString(val);
    }

    public static String swapLetter(String expression) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < expression.length() ; i++) {
            stringBuilder.append(mapChar(expression.charAt(i)));
        }
        return stringBuilder.toString();
    }

    public static char mapChar(char sign) {
        char convertedChar = sign;
        switch (sign){
            case 'a': convertedChar = 'g'; break;
            case 'b': convertedChar = 'h'; break;
            case 'c': convertedChar = 'i'; break;
            case 'd': convertedChar = 'j'; break;
            case 'e': convertedChar = 'k'; break;
            case 'f': convertedChar = 'l'; break;
        }
        return convertedChar;
    }

    public static void my_printf(String format_string, String param){
        for(int i=0;i<format_string.length();i++){
            if(format_string.charAt(i) == '#' && format_string.charAt(i+1) == 'j'){
                i++;
                long number = convertStringToLong(param);
                String hexValue = swapLetter(convertLongToHex(number));
                System.out.print(hexValue);
            
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