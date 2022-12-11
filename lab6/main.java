
import java.io.*;
import java.util.Arrays;


class lab0 {
	  public static boolean isCharNumeric(char sign){
        return Character.isDigit(sign);
    }

    public static boolean isZero(char sign){
        return sign =='0';
    }

    public static int convertStringToInt(String exp){
        return Integer.parseInt(exp);
    }

    public static String createStringWithFillSign(int length,char sign){
        char arrays[] = new char[length];
        Arrays.fill(arrays, sign);
        return new String(arrays);
    }

    public static String fillOrCropExpression(String expression, int length, boolean fillZero){
        int expressionLength = expression.length();
        if(expressionLength ==length){
            return expression;
        }else if(expressionLength > length){
            return expression.substring(0,length);
        }else{
            int missingLength = length - expressionLength;
            return createStringWithFillSign(missingLength, fillZero ? '0' : ' ') +
                    expression;
        }
    }

   public static String convertDigitsOfValue(String number){
        StringBuilder stringBuilder = new StringBuilder();
        for(var sign : number.toCharArray()){
            stringBuilder.append(sign == '0' ? '9' : calculateDigit(sign));
        }
        return stringBuilder.toString();
    }

    public static char calculateDigit(char sign){
        return 0;
    }
    public static String reverserStr(String number){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(number);
        stringBuilder.reverse();
        return stringBuilder.toString();

    }

    public static boolean isIntegerString(String number){
        for(int i=0; i<number.length();i++){
            if(!isCharNumeric(number.charAt(i)))
                return false;

        }
        return true;
    }

    public static String decreaseValue(String number){
        StringBuilder stringBuilder = new StringBuilder();
        for(var sign : number.toCharArray()){
            stringBuilder.append(sign == '0' ? '9' : (char) (sign-1));
        }
        return stringBuilder.toString();
    }

    public static int findCharPositionIfDigits(String expression, int start, char limitSign){
        int idx = start;
        for(int i = start; i<expression.length();i++){
            if(isCharNumeric(expression.charAt(i))){
                idx++;
            }else if(expression.charAt(i) == limitSign){
                return idx;
            }
            else {
                return -1;
            }
        }
        return idx;
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
            }else if(format_string.charAt(i) == '#' && isCharNumeric(format_string.charAt(i+1))){
                i++;
                char signLimit='g';
                int value;
                boolean fillZero;
                int stop = findCharPositionIfDigits(format_string,i,signLimit);
                if(stop!=-1){
                    fillZero = isZero(format_string.charAt(i));
                    value = convertStringToInt(format_string.substring(i,stop));
                    String changedParam = fillOrCropExpression(decreaseValue(param),value, fillZero);
                    System.out.print(changedParam);
                    i = stop;
                }else {
                    System.out.print(format_string.charAt(i));
                }
            } else if(format_string.charAt(i) == '#' && format_string.charAt(i+1) == '.'){
                i++;
                if(isCharNumeric(format_string.charAt(i+1))){
                    char signLimit='g';
                    int value;
                    boolean fillZero;
                    int stop = findCharPositionIfDigits(format_string,i,signLimit);
                    if(stop!=-1){
                        fillZero = isZero(format_string.charAt(i));
                        value = convertStringToInt(format_string.substring(i,stop));
                        String changedParam = fillOrCropExpression(convertDigitsOfValue(param),value, fillZero);
                        System.out.print(changedParam);
                        i = stop;
                    }else {
                        System.out.print(format_string.charAt(i));
                    }
                } else {
                    System.out.print(format_string.charAt(i));
                }
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
