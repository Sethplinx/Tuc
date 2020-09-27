#include <stdio.h>

float weight, height, BMI,extraW,extraw,Wminus,x,y;
char answer;

int main(){
	
	printf("Press y to continue -> ");
	scanf("%c", &answer);
	while (answer == 'y'){
		printf("Enter your weight in Kg -> ");
		scanf("%f", &weight);
		
		while (weight <= 0){
			printf("The value of your weight must be positive,enter your weight again -> ");
			scanf("%f", &weight);
		}
    
		printf("Enter your height in meters -> ");
		scanf("%f", &height);
		
		while (height <= 0){	
			printf("The value of your height must be positive,enter your height again ->");
			scanf("%f", &height);
		}
		
		BMI = weight / (height*height);
		x = 20*(height*height);    /* The weight(x) when the BMI is 20*/
		y = 25*(height*height);    /* The weight(y) when the BMI is 25*/
		extraW = x - weight ;      /* Weight to be gained for BMI 20 */
		extraw = y - weight;       /* weight to be gained for BMI 25 (ONLY FOR BMI BETWEEN 20 AND 25*/
		Wminus = weight - y;       /* The weight to be lost for BMI 25*/

		if (BMI <= 20)
			printf("Underweight.\nMinimum extra weight for normal BMI is %f", extraW);

		else if (BMI <= 25)
	
			printf("Normal, \nMinimum weight to be lost and still have normal BMI is %f, \nMaximum extra weight to be gained and still have normal BMI is %f", extraW, extraw);

		else if (BMI <= 30)
			printf("Overweight.\nMinimum weight to be lost for normal BMI is %f", Wminus);

		else
			printf("Obese.\nMinimum weight to be lost for normal BMI is %f", Wminus);
   
		printf("\nif you want to go again press y, if you want to stop press any other key -> ");
		scanf(" %c", &answer);
	}
	printf("Thanks for using the program");
}
