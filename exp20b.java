import java.util.Scanner;
import java.io.File;
class exp20b{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String args[]){
        System.out.println("Enter the path where to create directory");
        String path = scn.next();
        System.out.println("Enter the name of the directory");
        path = path + scn.next();

        File file = new File(path);

        boolean bool = file.mkdirs();
        if(bool){
            System.out.println("Directory created successfully");
        }else{
            System.out.println("Directory creation failed");
        }
    }

}