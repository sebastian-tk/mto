#include <stdio.h>
#include <string.h>

void swapLetters(char *param)
{
	for (int j = 0; j < strlen(param); j++)
	{
		if (param[j] >= 65 && param[j] <= 90)
		{
			param[j] = param[j] + 32;
		}
		else if (param[j] >= 97 && param[j] <= 122)
		{
			param[j] = param[j] - 32;
		}
	}
}
int convertToNumber(const char *str)
{
	int numb;
	for (int i = 0;i < strlen(str); i++)
	{
		if (i == 0)
		{
			numb = (int)str[i];
		}
		numb = numb * 10 + (int)str[i];
	}
	return numb;
}

char* addSpaces(char* str, int amount)
{
	char spaces[amount]={' '}
	char dest[strlen(str)+amount];

	strcpy( dest, spaces);
	strcat( dest, str);
	return dest;
}

int my_printf(char *format_string, char *param)
{
	for (int i = 0; i < strlen(format_string); i++)
	{
		if ((format_string[i] == '#') && (format_string[i + 1] == 'k'))
		{
			i++;
			swapLetters(param);
			printf("%s", param);
		}
		else if ((format_string[i] == '#') && (format_string[i + 1] == '.'))
		{
			i += 2;
			int number = 0;
			int start = i;
			while (format_string[i] >= '0' && format_string[i] <= '9' &&  i < strlen(format_string))
			{
					number  = (number*10)+((int)format_string[i]-'0');

				i++;
			}

			swapLetters(param);
			if (format_string[i] == 'k')
			{

				if (number < strlen(param))
				{
					for (int i = 0; i < number; i++){
						printf("%c", param[i]);						
					}	
				}else
				printf("%s", param);
			}else{
				printf("%s", param);
			}
		}
		else if ((format_string[i] == '#') && (format_string[i+1] >= '0' && format_string[i+1] <= '9'))
		{
			i += 2;
			int number = 0;
			int start = i;
			while (format_string[i] >= '0' && format_string[i] <= '9' &&  i < strlen(format_string))
			{
					number  = (number*10)+((int)format_string[i]-'0');

				i++;
			}

			swapLetters(param);
			if (format_string[i] == 'k')
			{

				if (number < strlen(param))
				{
					for (int i = 0; i < number; i++){
						printf("%c", param[i]);						
					}	
				}else{

				printf("%s", param);

				}
			}else{
				printf("%s", param);
			}
		}
		else
			putchar(format_string[i]);
	}
	puts("");
	return 0;
}


int main(int argc, char *argv[])
{
	char buf[1024], buf2[1024];
	while (gets(buf))
	{
		gets(buf2);
		my_printf(buf, buf2);
	}
	return 0;
}