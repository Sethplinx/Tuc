#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

#define Minsize 5
#define Maxsize 20
#define Minascii 97
#define Maxascii 122

int i,size;
char **string;
char *randomString(int minsize,int maxsize);
void selectionSort(char **strArray, int strArraySize);
void swap(char **strA, char **strB);

time_t t;

int main(){

 srand((unsigned) time(&t));

 printf("Tell how many alpharithmetics do you want to create -> ");
 scanf("%d", &size);

 string=malloc(size*sizeof(char *));
 if (string==NULL)
	 printf("Can't allocate memory");

 for (i=0;i<size;i++){
   string[i]=randomString(Minascii,Maxascii);
   }

 selectionSort(string,size);

 for(i=0;i<size;i++)
	 printf("string %d is %s",i+1,string[i]);
}



char *randomString(int minsize,int maxsize){
 char*word;
 int i,number;

 word=malloc((maxsize + 1)*sizeof(char));

 for (i=0;i<Maxsize;i++){
	number=minsize + rand() % (maxsize - minsize + 1);
    word[i]=number;
    }

 word[i]=0;
return(word);
}

void selectionSort(char **strArray, int strArraySize) {
    int j, K, minIndex;

    for (j = 0; j < strArraySize; j++)
    {
        minIndex = j;
        for (K = j+1; K < strArraySize; K++) {
            if (strcmp(strArray[K],strArray[minIndex])<0 ) {
                minIndex = K;
            }
        }
        swap( &strArray[j], &strArray[minIndex] );
    }
}

void swap(char **strA, char **strB) {
	char * temp;

	temp  = *strA;
	*strA = *strB;
	*strB = temp;
}
