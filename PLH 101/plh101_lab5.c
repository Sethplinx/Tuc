#include <stdio.h>

#define MAX_SIZE 10

int quadruple(int array[],int index);

int main() {
  int i, retValue;
  int array[MAX_SIZE];

  for (i = 0; i < MAX_SIZE; ++i) {
    printf("Give me a number for array %d ", i+1);
    scanf("%d", &array[i]);
  }

  printf("O pinakas periexei: \n");
  for (i = 0; i < MAX_SIZE; ++i)
    printf("Array[%d] = %d \n", i+1,array[i]);

 retValue=quadruple(array,0);

}

int quadruple(int array[],int index){

if (index + 3 >= MAX_SIZE)
	printf("No quadruple found\n");

if((array[index]+ array[index+3]) == (array[index+1] + array[index+2])){
    printf("quadruple for i=%d\n",index);
    return index;
    }

return(quadruple(array,index + 1));

}

