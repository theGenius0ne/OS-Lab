import java.io.File;
import java.util.Scanner;
class exp20a{
    public static void  main(String args[]){
        File dir = new File("E:\\OS\\Practicals");
        String [] children = dir.list();

        if(children==null){
            System.out.println("Directory doesn't exist");
        }else{

            for(int i =0; i<children.length; i++){
                String filename = children[i];
                System.out.println(filename);
            }
        }

    }


}