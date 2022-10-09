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

char* cutoff(const char* str, int from , int to)
{
    if (from >= to)
        return  NULL;

    char* cut = calloc(sizeof(char), (to - from) + 1);
    char* begin = cut;
    if (!cut)
        return  NULL;

    const char* fromit = str+from;
    const char* toit = str+to;
    (void)toit;
    memcpy(cut, fromit, to);
    return begin;
}

bool isFinishChars(char *param, int idx)
{
	return idx < strlen(format_string)
}

int my_printf(char *format_string, char *param)
{
	for (int i = 0; isFinishChars(format_string,i); i++)
	{
		if ((format_string[i] == '#') && (format_string[i + 1] == 'k'))
		{
			i++;
			convert_letters(param);
			printf("%s", param);
		}
		esle if ((format_string[i] == '#') && (format_string[i + 1] == '.'))
		{
			i += 2;
			int number;
			int start = i + 1;
			int finish = -1;
			while (param[i] >= '0' && param[i] <= '9' && isFinishChars(format_string,i))
			{
				if (isFinishChars(format_string,i))
				{
					finish = i;
				}
				i++;
			}

			if(param[i] == 'k'){

			}

			convert_letters(param);
			printf("%s", param);
		}

		else putchar(format_string[i]);
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