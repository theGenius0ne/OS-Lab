#include <iostream>
#include <cstdlib>
using namespace std;

void FCFS(int arr[],int n, int head){
    
    int tot_dist = abs(arr[0]-head);
    for(int i = 1; i< n ;i++){
        tot_dist += abs(arr[i]-arr[i-1]);
    }

    cout<<"Seek distance: "<<tot_dist<<endl;

}



int main(){
    int arr[] = { 176, 79, 34, 60, 92, 11, 41, 114 }; 
    int head = 50; 
    int n = sizeof(arr)/sizeof(arr[0]);
    FCFS(arr,n, head); 

    return 0;
}