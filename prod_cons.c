#include <stdio.h>
#include<stdlib.h>
#include <unistd.h>
#define Size 3

int mutex = 1,x=0,full=0,empty=Size;
void producer();
void consumer();
//semaphore s shows if the resource is currently available if s=1 else unavailable
//here they are providing mutual exclusion betweeen producing and consuming 
int signal(int s){
return ++s;    
}

int wait(int s){
    while(s<=0);
   return --s;
}



void main(){

int n;
printf("Enter\n 1.Producer\n2.Consumer\n3.Exit\n");
while(1){
    printf("Enter your choice: ");
    scanf("%d",&n);
    switch(n){
        case 1: if(mutex==1 && empty!=0) 
                {producer();}
                else {printf("Buffer is full\n");}
                break;
        case 2: if(mutex==1 && full!=0) {consumer();}
                else
                {
                    printf("Buffer is empty\n");
                }
                break;
        case 3: exit(0);
                break;       
    }
}

}

void producer(){
    mutex = wait(mutex);
    full = signal(full);
    empty = wait(empty);
    x++;
    printf("Producer produces item %d\n",x);
    mutex = signal(mutex);
}

void consumer(){
    mutex = wait(mutex);
    full = wait(full);
    empty = signal(empty);
    printf("Consumer consumes item %d\n",x);
    x--;
    mutex = signal(mutex);
}