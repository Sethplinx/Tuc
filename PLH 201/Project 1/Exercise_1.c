#include <stdio.h>
#include <stdlib.h>

struct list {
    int value;
    struct list *next;
};

struct list * list_Generator(int numb){													//Funtion for generating new nodes and linking them together
    struct list *n1,*n2;																//As n1 we define a pointer that points to the current node and as n2 the pointer that points to the next node
    int i=0;																			//We create nodes begin from the last one

    printf("\n////Generating List\\\\\\\\ \n");

    for(;i<numb;i++){
        n1 = malloc(sizeof(struct list));
        (i==0) ? (n1->next = NULL) : (n1->next = n2);									//If n1 points to the first node n1->next= null because its the last node else n1->next = n2 which is the node next to n1

        printf("Enter the value of node #%d: ",i+1);
        scanf("%d",&n1->value);
        n2 = n1;
    }
    return(n1);
}

void print_list(struct list *ptr){														//Funtion for printing the values of each node
																						//As ptr we define the pointer we want to start printing from 
    printf("\n");
//////////////////////////////
        if(ptr == NULL){								
            printf("The list is empty");
            return;
        }

		while(ptr != NULL){																//Printing values until ptr points to null
                printf("%d ",ptr->value);
                ptr = ptr->next;
            }

    printf("\n");
}

struct list * removeDupl_and_PushBack(struct list * pointer, int number){				//Funtion for removing duplicate nodes and moving the first node with the desired value at the end of the list
    struct list *ptr,*first,*previous,*hea;												//As ptr we define the pointer that points to the current node, first is the pointer that points to the first node with the value we want
    int j=0,index=1,i=1;																//As previous we define the pointer that points to the node previous to the one ptr is pointing to and as hea the pointer that points to the new head

    ptr = pointer;

    printf("\n////Deleting duplicates\\\\\\\\ \n");

    while(ptr != NULL ){	
        if(ptr->value == number){														//Case wrere node ptr is pointing to has the desired value
            if(j==0){																	//Subcase where ptr points to the first node with the desired value 
                first = ptr;
                ptr = ptr->next;
                index++;
                j++;
            }
            else if(first->next == ptr){												//Subcase where ptr points to the node next to the one first points to and it has the desired value
                printf("Deleting node #%d\n",index);
                first->next = ptr->next;
                ptr = first->next;
                index++;
            }
            else{																		//Subcase where ptr points to a node that has the desired value
                printf("Deleting node #%d\n",index);
                previous->next = ptr->next;
                ptr = previous->next;
                index++;
            }
        }
        else{																			//Case where ptr isn't pointing to a node with the desired value
            index++;
            if(j==0)																	//Subcase where we haven't yet found a node with the desired value
                ptr=ptr->next;
            else{																		//Subcase where we have found a node with the desired value
                previous = ptr;
                ptr = ptr->next;
            }
        }
    }
    print_list(pointer);																//Printing list after the deleting process 

    ptr = pointer;
    hea = ptr;

    printf("\n////Swapping nodes\\\\\\\\ \n");
    index = 1;

    if(j==1){																			
        while(ptr != NULL){
            if(pointer==first){															//Case where the first node is the first node that has the desired value 
                if(first->next == NULL){												//Subcase where we only have on node in our list
                    printf("Zero nodes where swapped\n");
                    return(hea);
                }
                else if(ptr->next == NULL){												//Subcase where we have found the last node of the list									
                    printf("Swapping node #%d with #%d\n",index,i);
                    hea = first->next;
                    first->next = NULL;
                    ptr->next = first;
                    return(hea);
                }
                else{																	//Subcase where we haven't found the last node
                    i++;
                    ptr = ptr->next;
                }
            }
            else if(ptr == first){														//Case we ptr points to the first node with the desired value
                if(first->next == NULL){												//Subcase where it is the last node of the list
                    printf("Zero nodes where swapped\n");
                    return(hea);
                }
				if(ptr->next == NULL){													
                    printf("Swapping node #%d with #%d\n",index,i);
                    return(hea);
                }
                previous->next = ptr->next;
                while(ptr->next != NULL){
                    ptr = ptr->next;
                    i++;
                }
                ptr->next = first;
                first->next = NULL;
                printf("Swapping node #%d with #%d\n",index,i);							//Swapping nodes
                return(pointer);
            }
            else {																		//We haven't found the node first is pointing to 
                previous = ptr;
                ptr = ptr->next;
                index++;
                i++;
            }
        }
    }
}

void free_list(struct list *node){														//Function to free the memory
	struct list *tmp = node;

    while(tmp != NULL){
		node = node->next;
		free(tmp);
		tmp = node;
    }
}

int main(){
    struct list *head = NULL;
    int num0Flists,number;

    printf("Enter the number of integers you want: ");
    scanf("%d",&num0Flists);
    if(num0Flists <= 0){																//Cheacking if user gave a valid number for creating the list
        printf("Invalid number.\nExiting");
        return -1;
    }

    head = list_Generator(num0Flists);													//Creating the list
    print_list(head);																	//Printing the list

    printf("\nEnter the number you want to search: ");									//Getting the value the user wants to search in the list
    scanf("%d",&number);

    head = removeDupl_and_PushBack(head,number);										//Removing the duplicates nodes and moving the first at the end of the list
    printf("\n////List in final form\\\\\\\\ ");
    print_list(head);																	//Printing the list

	free_list(head);
}

