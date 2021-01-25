import java.util.Scanner;
import java.util.ArrayList;
class exp11{
    public static Scanner scn = new Scanner(System.in);


    public static int check(ArrayList<Integer>al, int[] pages, int idx){
        int res =-1;//will store index of arraylist
        int farthest = idx;//will stroe farthest index of page array
        int i;
        for(int k =0; k<al.size(); k++){
            for(i = idx; i<pages.length; i++){
                if(al.get(k)==pages[i]){
                    if(i > farthest){
                        farthest = i;
                        res = k;
                    }
                    break;
                }
            }if(i == pages.length){
                return k;
            }

        }

        return (res==-1)?0:res;
    }

    public static int optimal(int [] pages, int cap){
        ArrayList<Integer> qu = new ArrayList<>();
        int pfault = 0;
        for(int i = 0; i<pages.length; i++){
            if(qu.size()<cap){
                if(!qu.contains(pages[i])){
                    qu.add(pages[i]);
                    pfault++;
                }

            }else{
                if(!qu.contains(pages[i])){
                    int idx = check(qu,pages,i+1);
                    qu.set(idx,pages[i]);
                    pfault++;
                }

            }

        }
        return pfault;
    }


    public static void main(String args[]){
    int [] pages={0, 2, 1, 6, 4, 0, 1, 0, 3, 1, 2, 1};
    int cap = scn.nextInt();
    int fault= optimal(pages,cap);
    System.out.println("Page Faults: "+fault);
    }

}