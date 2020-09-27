#include <stdio.h>
#include <stdlib.h>

struct list {
	int value;
	struct list *next;
};

struct list * list_Generator(int numb){															//Funtion for generating new nodes and linking them together
    struct list *n1,*n2,*first;																	//As n1 we define a pointer that points to the current node and as n2 the pointer that points to the previus node
    int i=0;																					//As first we define a pointer that points to the first node of the list

    printf("\n////Generating List\\\\\\\\ \n");

    for(;i<numb;i++){
        n1 = malloc(sizeof(struct list));
        n1->next = NULL;
        (i==0) ? (first = n1) : (n2->next = n1);												//If we are creating the first node we set first pointing to that node else we link the previus node with the next
        n2 = n1;
        printf("Enter the value of node #%d: ",i+1);
        scanf("%d",&n1->value);
    }
    return(first);
}

void print_list(struct list *ptr){																//Funtion for printing the values of each node			
																								//As ptr we define the pointer we want to start printing from 
    printf("\n");
//////////////////////////////
        if(ptr == NULL){
            printf("The list is empty");
            return;
        }

		while(ptr != NULL){																		//Printing values until ptr points to null
                printf("%d ",ptr->value);
                ptr = ptr->next;
            }

    printf("\n");
}

int checkSumOfOdds(struct list * node){															//Function that checks if the sum odd values in the next node is bigger than the square of the current nodes value
    //struct list *n1;																			//We move the pointer node to the node after the last node of the list which is null, we return 0
	int sum=0,sqrt=0,mod=0;																		//After that we if check the square of the value we are in is bigger than the current sum.
																								//Lastly we check if the number is even or odd.We do this process until we get to the first node
	
	if(node==NULL)																				//If node points to null return the value
        return 0;

	sum = checkSumOfOdds(node->next);															//Calling the function with the next node from the one node points to at the moment.This process is done until node points to null															

	sqrt = node->value * node->value;															//Calculating the square of the value

	if(sqrt > sum)																				//Printing yes or no according to the comparison
		printf("%d[%d](YES) ",node->value,sum);
	else
		printf("%d[%d](NO) ",node->value,sum);

	mod = node->value % 2;																		//Checking if the value of the node is even or odd

	if(mod == 0)																				//If its even we retun the value of sum
		return(sum);
	else																						//If its odd we return the value of sum plus the value of the node
		return(sum + node->value);
}

void free_list(struct list *node){																//Function to free the memory
	struct list *tmp = node;

    while(tmp != NULL){
		node = node->next;
		free(tmp);
		tmp = node;
    }
}

int main(){
	int numOFlists,*numbers;
	struct list *head=NULL;

	printf("Enter the number of integers you want to archive: ");
	scanf("%d",&numOFlists);
	if(numOFlists <= 0)																			//Cheacking if user gave a valid number for creating the list
        return -1;
                                                                            
	head = malloc(sizeof(struct list));
	if(head == NULL){
        printf("Error allocating memory");
        return(0);
	}
	numbers = malloc(numOFlists * sizeof(int));
    if(numbers == NULL){
        printf("Error allocating memory");
        return(0);
	}
	head = list_Generator(numOFlists);  							       						//Creating the list
	print_list(head);																			//Printing the list
	printf("\n");
	
	checkSumOfOdds(head);																		//Checking if the square is bigger that the sum of odd numbers in the next nodes

	free_list(head);																			//Cleaning memory
}