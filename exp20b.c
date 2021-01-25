#include <stdio.h>
#include <conio.h>
#include <process.h>
#include <dir.h>
#include <stdlib.h>


int main(){
    int check;
    char * dirname = "test3";

    check = mkdir(dirname);

    if(!check){
        printf("Directory created\n");
    }else{
        printf("Directory creation failed\n");
        exit(1);
    }
    getch();
    // system("dir/p");
    // getch();
    return 0;
}