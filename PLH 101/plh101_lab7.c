#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_NAME 128

typedef struct student {
char *Name;
float Grade;
}student;

void input(student *student_array,int ammount){
	char buf[MAX_NAME];
	for(int i=0;i<ammount;++i){
		printf("Name of student number #%d ",i+1);
		gets(buf);
		
		student_array[i].Name=malloc((strlen(buf) + 1)* sizeof(char));
		strcpy(student_array[i].Name,buf);
		
		printf("Average grade ");
		scanf("\n%f", &student_array[i].Grade);
		getchar();
		printf("*******************\n");
	}
}

void print(student *student_array,int ammount){
	for(int i=0;i<ammount;++i){
		printf("Name of student #%d is %s \n", i+1, student_array[i].Name);
		printf("And his grade is %.2f \n", student_array[i].Grade);
	}
}

void cleanmemory(student *student_array,int ammount){
	for(int i=0;i<ammount;++i){
		if (student_array[i].Name != NULL)
			free(student_array[i].Name);
		free(student_array);
	}
}

int main(){
	int size;
	student *students;

	printf("How many students do you want to archive ");
	scanf("%d",&size);
	getchar();

	students=malloc(size*sizeof(student));
    if (students==NULL){
		printf("ERROR alocating memory.\nProgram is terminating.");
		return(1);
    }
	input(students,size);
	print(students,size);
	cleanmemory(students,size);
}