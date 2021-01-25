//shortest job first job scheduling algorithm
#include <iostream>
using namespace std;

void swap(int* a, int* b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

void sort_arrival(int mat[][6], int n){

 for(int i = 0; i<n; i++){      //using bubble sort to sort on the basis of arrival time

    for(int j=0; j<n-i-1; j++){

        if(mat[j][1]>mat[j+1][1]){

            for(int k=0; k<6;k++){
                swap(mat[j][k],mat[j+1][k]);
            }

        }
  
    } 
 }   
}    


void complete(int mat[][6], int n){
    int val = 0;
    mat[0][3]=mat[0][1]+mat[0][2];//completion time = at + bt
    mat[0][5]=mat[0][3]-mat[0][1]; //tat = completiontime- arrival time
    mat[0][4]=mat[0][5]-mat[0][2]; //waiting time = tat - bt


    for(int i = 1; i<n ; i++){//after inner loop process rearranges
    int temp = mat[i-1][3];//completion time of previous process
    int low = mat[i][2];   //burst time for current process

    for(int j =i ; j<n; j++){
        if(mat[j][1]<= temp && mat[j][2]<=low){//if arrival time of other process is less than completion time && burst time is least check
            low = mat[j][2];
            val = j;
        }
    }
    mat[val][3]= temp + mat[val][2]; // next process having min burst time , completion time update
    mat[val][5]=mat[val][3]-mat[val][1];//turnaround time update of next process
    mat[val][4]=mat[val][5]-mat[val][2];//waiting time update of next process

    for(int k =0; k<6;k++){
        swap(mat[i][k],mat[val][k]);  //swap the smallest burst process with the next(upwards)
    }
}

}



int main(){ 
    int n;
    cout<<"Enter the number of processes: ";
    cin >> n;
    int mat[n][6];

    for(int i = 0; i< n; i++){
        cout<<"Enter the processs id: "<<endl;
        cin>>mat[i][0];
        cout<<"Enter it's arrival time: "<<endl;
        cin>>mat[i][1];
        cout<<"Enter its burst time:"<<endl;
        cin>>mat[i][2];
    }

    sort_arrival(mat,n);//sorting on the basis of arrival time
    // 1 2 3 2 0 4 3 4 2 4 5 4
    complete(mat,n);

    cout<<"Process id\t Arrival\t Burst-time\t Completion\t Waiting-time\t Turnarroundtime\n";
    for(int i=0;i<n; i++){
        cout<<mat[i][0]<<"\t\t"<<mat[i][1]<<"\t\t"<<mat[i][2]<<"\t\t"<<mat[i][3]<<"\t\t"<<mat[i][4]<<"\t\t"<<mat[i][5]<<endl;
    } 

    return 0;
}