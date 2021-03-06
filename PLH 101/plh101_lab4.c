#include <stdio.h>

#define TENS        10
#define HUNDREDS    100
#define THOUSANDS   1000
#define KEY_ENC     7
#define KEY_DEC     3

int encrypt (int number) {
 int digit1,digit2,digit3, digit4;
 
 digit1= number / THOUSANDS;
 number %= THOUSANDS;
 digit2= number / HUNDREDS;
 number %= HUNDREDS;
 digit3= number / TENS;
 number %= TENS;
 digit4 = number;
 
 digit1 = (digit1 + KEY_ENC) % TENS;
 digit2 = (digit2 + KEY_ENC) % TENS;
 digit3 = (digit3 + KEY_ENC) % TENS;
 digit4 = (digit4 + KEY_ENC) % TENS;

number=(digit4*THOUSANDS + digit3*HUNDREDS + digit2*TENS + digit1);

return (number);
}  

int decrypt(number) {
   int digit1,digit2,digit3,digit4;

   digit1 = number / THOUSANDS;              
   number %= THOUSANDS;
   digit2 = number / HUNDREDS;               
   number %= HUNDREDS;
   digit3 = number / TENS;                
   number %= TENS;
   digit4 = number;

   digit1 = (digit1 + KEY_DEC) % TENS;          
   digit2 = (digit2 + KEY_DEC) % TENS;          
   digit3 = (digit3 + KEY_DEC) % TENS;
   digit4 = (digit4 + KEY_DEC) % TENS;

   
   number = (digit4*THOUSANDS + digit3*HUNDREDS + digit2*TENS + digit1);

   return (number);
}

int main(){
	int choice,number;
	printf("Enter the four digit number: ");
	scanf("%d", &number);
	while (number < 0 || number > 9999){
		printf("The number must be positive and have 4 digits\nGive me another 4 digit number");
		scanf("%d",&number);
	}
  
	printf("Select one of the following:\n");
	printf("   1. Encode a number.\n");
	printf("   2. Decode a number.\n");
	printf("\nEnter choice: ");
	scanf("%d", &choice);
   
	switch (choice){
		case 1: number = encrypt(number);
			printf("The encrypted number is: %d\n", number);
		break;
		case 2: number = decrypt(number);
			printf("The decrypted number is: %d\n", number);
		break;}
		  
}
