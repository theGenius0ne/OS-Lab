import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
class exp21b{
    public static void main(String []args){
        moveFile("E:/ankit.txt","E:/OS/test.txt");
    }

    private static void moveFile(String src,String dst){
        Path result = null;
        try{
            result = Files.move(Paths.get(src),Paths.get(dst));
        }catch(IOException e){
            System.out.println("Error while moving file "+ e.getMessage());
        }

        if(result!=null){
            System.out.println("Files moved successfully");
        }else{
            System.out.println("File moving failed!");
        }

    }
}
