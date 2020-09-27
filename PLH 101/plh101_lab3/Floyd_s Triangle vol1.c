#include <stdio.h>

int row, x,column, number=1;

int main()
{
 printf("How many rows do you want -> ");
 scanf("%d", &row);
 for(x=1; x <= row; x++)
  {
   for(column=1; column <= x ; column++)
     {
      printf("%d ", number);
      number++;
     }
    printf("\n");
  }
}
