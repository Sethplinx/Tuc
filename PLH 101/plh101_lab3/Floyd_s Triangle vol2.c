#include <stdio.h>

int row, x,column, number=1,y, space;

int main()
{
 printf("How many rows do you want -> ");
 scanf("%d", &row);
 space=row;
 
 for(x=1; x <= row; x++)
  {
   y= space - 1;
   for (; y>0;y--)
      printf(" ");
   for(column=1; column <= x ; column++)
     {
      printf("%d", number);
      number++;
     }
    printf("\n");
	space--;
  }
}
