#include <stdio.h>

#define MAX 9

int main(){
	int answer=0,number=1,i=0,j=0,count=2,space=0,sum=0;

	printf("Enter the number of rows you want between 1 and 9: ");
	scanf("%d",&answer);
	while( answer <=0 || answer > MAX){
		printf("\nError, re-enter the number of rows: ");
		scanf("%d",&answer);
	}

    j=answer ;

	for(;i < answer; ++i){
		printf("%d",number);
		for(space=j; space > 0; --space){
            printf(" ");
		}
		printf("* 8 + 1 =");
		sum = number * 8 + count - 1 ;
		printf("%d",sum);
		number = number * 10 + count;
		count++;
        j--;
		printf("\n");
	}
}