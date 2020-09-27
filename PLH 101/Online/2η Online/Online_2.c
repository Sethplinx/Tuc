#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_SIZE 50

typedef struct athlete{
	char* name;
	int points;
	float time;
}athlete;

void input(athlete* athlete_array,int ammount){
	char buf[MAX_SIZE];
	for(int i=0;i<ammount;++i){
		printf("\nName of athlete number #%d: ",i+1);
		gets(buf);

		athlete_array[i].name=malloc((strlen(buf) + 1)*sizeof(char));
        strcpy(athlete_array[i].name,buf);

		printf("Number of points scored: ");
		scanf("\n%d",&athlete_array[i].points);
		printf("Time in game: ");
		getchar();
		scanf("\n%f",&athlete_array[i].time);
		getchar();
		printf("**************************************");
    }
}

float ppm(athlete* athlete_array,int ammount){
	float ppm[ammount],max=0;
	for(int i=0; i<ammount; i++){
		ppm[i]=athlete_array[i].points/athlete_array[i].time;
			if (ppm[i]>max)
				max=ppm[i];
	}
	return(max);
}

void printBest(athlete* athlete_array,int ammount,float points ){
	int cur;
    printf("*******************\n");
	printf("Players with the most points per minute\n");
	for(int i=0;i<ammount;++i){
		cur=athlete_array[i].points/athlete_array[i].time;
		if (cur>=points)
			printf("%s with a ppm of %.2f",athlete_array[i].name,points);
	}
}

void cleanMemory(athlete* athlete_array,int ammount){
	for(int i=0;i<ammount;++i)
		if(athlete_array[i].name != NULL)
			free(athlete_array[i].name);
	free(athlete_array);
}

int main(){

	int size,i=0;
	float maxPoints;
	athlete *athletes;

	printf("How many players do you want; Please specify: ");
	scanf("%d", &size);
	getchar();

	athletes=malloc(size*sizeof(athlete));
	if (athletes==NULL){
		printf("ERROR allocating memory.\nProgram is terminating.");
		return(1);
	}

 	input(athletes,size);
    maxPoints=ppm(athletes,size);
    printBest(athletes,size,maxPoints);
	cleanMemory(athletes,size);
}