import java.util.Collections;
import java.util.ArrayList;
class exp16{
//scan algorithm goes at only one end
    static int disk_size = 200;

    public static void scan(int [] arr, int head, String direction){
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<Integer> sequence = new ArrayList<>();

        if(direction.equals("left")) 
        left.add(0);
        else if (direction.equals("right"))
         right.add(disk_size-1);

        int tot_distance = 0;

        for(int i =0; i< arr.length; i++){
            if(arr[i]<head){
                left.add(arr[i]);
            }else{
                right.add(arr[i]);
            }
        }

        Collections.sort(left);
        Collections.sort(right);

        int run = 2;
        // sequence.add(head);
        int temp_head = head;
        while(run-->0){
            if(direction.equals("left")){
                for(int i = left.size()-1; i>=0; i--){
                    sequence.add(left.get(i));
                    tot_distance += Math.abs(left.get(i)-temp_head);
                    // System.out.println(tot_distance);
                    temp_head = left.get(i);
                }
                direction="right";
            }else if(direction.equals("right")){
                for(int i =0; i<right.size(); i++){
                    sequence.add(right.get(i));
                    tot_distance += Math.abs(right.get(i)-temp_head);
                    // System.out.println(tot_distance);
                    temp_head = right.get(i);
                }
              direction="left";      
            }

        }
        System.out.println("The total seek distance is: "+tot_distance);
        System.out.println("The sequence will be :");
        for(int val: sequence){
            System.out.print(val+" ");
        }
    }


    public static void main(String args[]){
    int []arr = { 176, 79, 34, 60,92, 11, 41, 114 }; 
    int head = 50; 
    String direction = "left"; 
  
    scan(arr, head, direction); 
    }
}