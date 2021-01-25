#include <iostream>
using namespace std;

int main()
{   
    int n = 5;//no of processes
    int m = 3;//no of resources

    int alloc[5][3] = { { 0, 1, 0 }, // P0 // Allocation Matrix 
                        { 2, 0, 0 }, // P1 
                        { 3, 0, 2 }, // P2 
                        { 2, 1, 1 }, // P3 
                        { 0, 0, 2 } }; // P4 
  
    int max[5][3] = { { 7, 5, 3 }, // P0 // MAX Matrix 
                    { 3, 2, 2 }, // P1 
                    { 9, 0, 2 }, // P2 
                    { 2, 2, 2 }, // P3 
                    { 4, 3, 3 } }; // P4 
  
    int avail[3] = { 3, 3, 2 }; // Available Resources 

    int f[n], ans[n], idx =0;

    for(int i = 0; i<n; i++){
        f[i]=0;
    }

    int need[n][m];

    for(int i =0; i<n;i++){
        for(int j =0; j<m;j++){
            need[i][j]=max[i][j]-alloc[i][j];
        }
    }


    bool mark = false;

    while(mark!=true){


        for(int i = 0; i< n; i++){
            if(f[i]==0){
                int flag = 0;
                for(int j=0; j<m; j++){
                    if(need[i][j]>avail[j])         //need greater than available
                    {
                        flag = 1;                   
                        break;
                    }
                }

                if(flag == 0){
                    ans[idx++]=i;

                    f[i]=1;                                     //process executed

                    for(int j =0; j< m; j++){
                        avail[j] = avail[j]+alloc[i][j];        //safe state condition
                    }
                }
            }
        }


        for(int k =0; k<n;k++){
            mark = true;
            if(f[k]==0){
                mark = false;                       //check if any process is remaining
                break;
            }
        }
    }

    cout<<"The safe sequence is: "<<endl;
    for(int i = 0; i< n-1; i++){
        cout<<"P"<<ans[i]<<"->";
    }
    cout<<"P"<<ans[n-1]<<endl;

    return 0;
}