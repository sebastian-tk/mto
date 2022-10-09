#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>



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
	for (int i = 0; isFinishChars(str, i); i++)
	{
		if (i == 0)
		{
			numb = (int)str[i];
		}
		numb = numb * 10 + (int)str[i];
	}
	return numb;
}

char *cutoff(const char *str, int from, int to)
{
	if (from >= to)
		return NULL;

	char *cut = calloc(sizeof(char), (to - from) + 1);
	char *begin = cut;
	if (!cut)
		return NULL;

	const char *fromit = str + from;
	const char *toit = str + to;
	(void)toit;
	memcpy(cut, fromit, to);
	return begin;
}

bool isFinishChars(char *format_string, int idx)
{
	return idx < strlen(format_string);
}

int my_printf(char *format_string, char *param)
{
	for (int i = 0; isFinishChars(format_string, i); i++)
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
			int number;
			int start = i + 1;
			int finish = -1;
			while (format_string[i] >= '0' && format_string[i] <= '9' && isFinishChars(format_string, i))
			{
				if (isFinishChars(format_string, i))
				{
					finish = i;
				}
				i++;
			}

			if (finish != -1 && format_string[i] == 'k')
			{
				int val = convertToNumber(cutoff(format_string, start, finish));
				if (val < strlen(param))
				{
					param = cutoff(param, 0, val);
				}
				swapLetters(param);
				printf("%s", param);
			}

			swapLetters(param);
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