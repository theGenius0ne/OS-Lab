class exp9{

    public static void firstFit(int [] bs, int [] ps){
        
        int [] allocated = new int [ps.length];
        for(int i=0; i<allocated.length; i++){
            allocated[i]=-1;
        }

        for(int i = 0; i< ps.length ; i++){
            for(int j = 0; j< bs.length; j++){
                if(ps[i] < bs[j]){
                    allocated[i]=j;                 // block j+1 allocated to process i+1
                    bs[j] = bs[j]-ps[i];
                    break;
                }
            }
        }
        System.out.println("Process No.\t Process size\t Block No");
        for(int i = 0; i< ps.length; i++){
            System.out.print((i+1)+"\t\t"+ps[i]+"\t\t");
            if(allocated[i]!=-1)
            System.out.print(allocated[i]+1);
            else
            System.out.print("Not allocated");
            System.out.println();
        }

    }

    public static void bestFit(int []bs, int []ps){
        int [] allocated = new int [ps.length];

        for(int i = 0; i< ps.length; i++){
            allocated[i]=-1;
        }

        for(int i = 0; i< ps.length; i++){
           int idx = -1;
            for(int j=0; j<bs.length;j++){
                if(ps[i]<=bs[j]){
                    if(idx == -1){
                        idx = j;
                    }else if(bs[j]<bs[idx]){
                        idx = j;
                    }
                }
            }
            if(idx != -1){
                allocated[i]= idx;
                bs[idx] = bs[idx]-ps[i];
            }
        }
        System.out.println("Process No.\t Process size\t Block No");
        for(int i = 0; i< ps.length; i++){
            System.out.print((i+1)+"\t\t"+ps[i]+"\t\t");
            if(allocated[i]!=-1)
            System.out.print(allocated[i]+1);
            else
            System.out.print("Not allocated");
            System.out.println();
        }

    }

    public static void worstFit(int []bs,int []ps){
        int [] allocated = new int[ps.length];

        for(int i = 0; i< ps.length; i++){
            allocated[i]=-1;
        }

        for(int i = 0; i< ps.length; i++){
            int idx = -1;
            for(int j = 0; j< bs.length; j++){
                if(ps[i]<=bs[j]){
                    if(idx == -1){
                        idx = j;
                    }else if(bs[j]>bs[idx]){
                        idx = j;
                    }
                }
            }
            if(idx != -1){
                allocated[i]=idx;
                bs[idx]=bs[idx]-ps[i];
            }
        }

        System.out.println("Process No.\t Process size\t Block No");
        for(int i = 0; i< ps.length; i++){
            System.out.print((i+1)+"\t\t"+ps[i]+"\t\t");
            if(allocated[i]!=-1)
            System.out.print(allocated[i]+1);
            else
            System.out.print("Not allocated");
            System.out.println();
        }
    }


    public static void main(String args[]){
    int blockSize[] = {100, 500, 200, 300, 600}; 
    int processSize[] = {212, 417, 112, 426}; 

    // firstFit(blockSize,processSize);
    // bestFit(blockSize,processSize);
    worstFit(blockSize,processSize);
    }
}