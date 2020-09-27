#include <stdio.h>

#define Max_size 9

int row,column,number,size;

int main(){
	do{
		printf("How many rows do you need? Please specify: ");
		scanf("%d",&size);
		while(size<=0 || size >Max_size){
			if(size<0){
				printf("\n\nNegative number of rows.\nTerminating program\n\n");
				return(1);
			}
			else{
				printf("Number of rows must be positive and smaller than 9.\nPlease re-enter the number of rows: ");
				scanf("%d",&size);
			}
		}
		for(row=0;row<size;++row){
			number=row + 1;
			for(column=0;column<size;++column){
				if(column==size - 1){
					if(number>size)
						number=1;
						printf("%d ",number);
						number++;
				}
				else{
					if(number>size)
					number=1;
					printf("%d * ",number);
					number++;
				}
			}
			printf("\n");
		}
	}while(1);
}