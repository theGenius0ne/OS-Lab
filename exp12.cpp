#include <iostream>
#include <limits.h>
#include <unordered_set>
#include <unordered_map>
using namespace std;

int lru(int pages[], int n, int cap){
    int pfault = 0;
    unordered_set<int> s;
    unordered_map<int, int> map;

     for(int i = 0; i< n; i++){
         if(s.size()<cap){
            if(s.find(pages[i])==s.end()){
                s.insert(pages[i]);
                pfault++;
            }
            map[pages[i]]=i;            //update if a hit is found or not index update

         }else{
             if(s.find(pages[i])==s.end()){
                int lidx = INT_MAX;
                int val;
                for(int i = 0; i<s.size(); i++){
                    if(map[i]<lidx){
                        lidx = map[i];
                        val = i;
                    }
                }

                s.erase(val);
                s.insert(pages[i]);
                pfault++;
             }

           map[pages[i]]=i;  
         }

     }    


    return pfault;

}


int main()
{
    int pages[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2}; 
    int n = sizeof(pages)/sizeof(pages[0]);
    int cap;
    cin>>cap;
    cout<<"Page fault: "<<lru(pages,n,cap)<<endl;
    return 0;
}