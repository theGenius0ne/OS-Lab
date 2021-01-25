#include <iostream>
#include <cstdlib>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int disk_size = 200;
 
void cscan(int arr[], int n, int head, string direction)
{
    vector<int> left;
    left.push_back(0);
    vector<int> right;
    right.push_back(disk_size-1);
    vector <int> sequence;
    int tot_distance =0;
    int temp_head = head;

    for(int i =0; i< n; i++){
        if(arr[i]<head){
            left.push_back(arr[i]);
        }else{
            right.push_back(arr[i]);
        }
    }

    sort(left.begin(),left.end());
    sort(right.begin(),right.end());

    if(direction=="left"){
        for(int i = left.size()-1; i>=0; i-- ){
            sequence.push_back(left[i]);
            tot_distance += abs(left[i]-temp_head);
            temp_head = left[i];
        }
        // temp_head = right[right.size()-1];
        for(int i = right.size()-1; i>=0; i--){
            sequence.push_back(right[i]);
            tot_distance += abs(right[i]-temp_head);
            temp_head = right[i];
        }


    }else if(direction=="right"){
        for(int i = 0; i<right.size(); i++ ){
            sequence.push_back(right[i]);
            tot_distance += abs(right[i]-temp_head);
            // cout<<tot_distance<<endl;
            temp_head = right[i];
        }
        // temp_head = right[right.size()-1];
        for(int i = 0; i<left.size(); i++){
            sequence.push_back(left[i]);
            tot_distance += abs(left[i]-temp_head);
            // cout<<tot_distance<<endl;
            temp_head = left[i];
        }
    }

    cout<<tot_distance<<endl;
    // for(int i =0; i< sequence.size();i++){
    //     cout<<sequence[i]<<endl;
    // }


}

int main(){
    int arr[] = { 176, 79, 34, 60,92, 11, 41, 114 }; 
    int head = 50; 
    string direction = "right";
    int n = sizeof(arr)/sizeof(arr[0]); 
  
    cscan(arr,n, head, direction);

    return 0;
}