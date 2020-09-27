#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct students{
	char *name;
	float avg;
}students;

char get_string (FILE *ptr,students *a,int index){
    char buf[60];
	char temp;
    char space=' ';

    do{
        fscanf(ptr,"%c",&temp);
    }while(temp == space);
 
	fgets(buf,sizeof buf,ptr);
    a[index].name=malloc((strlen(buf)+1)*sizeof(char));
    strcpy(a[index].name,buf);
	return(temp);
}

void fill_info (FILE *ptr,students *array,int num){

	for(int i=0;i<num;++i){
		fscanf(ptr,"%f",&array[i].avg);
		get_string(ptr,array,i);
	}
}

void print_info(FILE *ptr,students *array,int num){
	for(int i=0;i<num;++i){
		printf("student #%d\n",i+1);
		printf("Name:%s\n",array[i].name);
		printf("Average grade: %.1f",array[i].avg);
		printf("\n\n");
	}
}

void free_memory(FILE *ptr,students *array){

	free(array);
	fclose(ptr);
}

int main(){

	FILE *pointer;
	int number;
	students *student;
	char first_letter[number];

	pointer=fopen("C:\\users\\Alexander\\desktop\\students-ext.txt","r");
	if (pointer==NULL){
		printf("Error opening file.\nExiting.");
		exit(0);
	}

	fscanf(pointer,"%d",&number);
	//printf("%d",number);
	student=malloc(number*sizeof(students));
	if (student==NULL){
		printf("Error alocating memory.\nExiting.");
		exit(0);
	}
	fill_info(pointer,student,number);
	print_info(pointer,student,number);
	free_memory(pointer,student);
}

