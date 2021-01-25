import java.util.Scanner;
import java.util.*;
class exp14{
    public static Scanner scn = new Scanner(System.in);

    public static int mfu(int [] pages, int cap){
        HashSet<Integer> s = new HashSet<>();
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        int pfault = 0;
        for(int i = 0; i< pages.length;i++){
            if(s.size()<cap){//when not full
                if(!s.contains(pages[i])){//doesnt have a page
                    s.add(pages[i]);
                    map.put(pages[i],1);
                    pfault++;
                }else{
                    int count = map.get(pages[i]);
                    map.put(pages[i],count+1); 
                }
            }else{
                if(!s.contains(pages[i])){
                    int rpage = Collections.max(map.keySet());
                    int count = map.get(rpage);
                    if(count>0)
                    map.put(rpage,count-1);
                    else
                    map.remove(rpage);
                    s.remove(rpage);
                    s.add(pages[i]);
                    map.put(pages[i],1);
                    pfault++;
                }else{
                    int count = map.get(pages[i]);
                    map.put(pages[i],count+1); 
                    
                }

            }

        }
        return pfault;
    }


    public static void main(String args[]){
        int[] pages = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2,1,2};
        int cap = scn.nextInt();

        System.out.println("Page faults: "+ mfu(pages,cap));
    }
}