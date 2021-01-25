#include<iostream>
#include <unordered_set>
#include <queue>
using namespace std;

int fifo(int pages[],int n, int cap){
    unordered_set<int> s;
    queue<int> pg;
    int pfault=0;
    for(int i=0; i< n; i++){
        if(s.size()<cap){       //if queue is less than cpacity size
            if(s.find(pages[i])==s.end())//element not found in set
            {   
                s.insert(pages[i]);
                pg.push(pages[i]);
                pfault++;

            }
        }else{
            if(s.find(pages[i])==s.end()) //check if already present or not(condition of not found)
            {
                int val = pg.front();
                pg.pop();
                s.erase(val);
                s.insert(pages[i]);
                pg.push(pages[i]);
                pfault++;
            }
        }
    }

    return pfault;
}


int main(){
     int pages[] = {0, 2, 1, 6, 4, 0, 1, 0, 3, 1, 2, 1};
     int cap;
     cin>>cap;
    int n = sizeof(pages)/sizeof(pages[0]);
    int res = fifo(pages,n,cap);
     cout<<"The page faults are: "<<res<<endl;;

    return 0;
}