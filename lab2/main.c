#include <stdio.h>
#include <string.h>

void convert_letters(char *param)
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

int my_printf(char *format_string, char *param)
{
	for (int i = 0; i < strlen(format_string); i++)
	{
		if ((format_string[i] == '#') && (format_string[i + 1] == 'k'))
		{
			i++;
			convert_letters(param);
			printf("%s", param);
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