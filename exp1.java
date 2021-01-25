//first come first serve job scheduling algorithm
class exp1{
    
    public static void waiting_time(int[] at ,int [] bt, int[] wt){
        int [] st = new int [at.length];//service time means the amount of time after which the process can start execution
                                        //service time can be more or less than arrival time 
                                        //if st is less than at then waiting time would be -ve i.e put wt = 0
                                        //if st is more than at then waiting time would be +ve i.e note it
        for(int i = 1; i < st.length; i++){
            st[i]= bt[i-1] + st[i-1];   
        }

        for(int i = 1; i< wt.length; i++){
            wt[i] = st[i]- at[i];
         if(wt[i]<0){        //if waiting time is negative, process doesnt have to wait so put wt = 0;
            wt[i]=0;
            }
        }

        
    }   

    public static void turn_around(int []at, int []bt, int[] wt, int[]tat){

        for(int i = 0; i<tat.length; i++){
            tat[i]=bt[i]+wt[i];
        }

    }


    public static void find_time(int [] process,int []at ,int [] bt){
        int [] wt = new int[process.length];
        int [] tat = new int [process.length];

        waiting_time(at,bt,wt);

        turn_around(at,bt,wt,tat);
        System.out.println("Process Arrival  Burst-time  Waiting time  TurnAroundTime");
            
        for(int i = 0; i< process.length; i++){
            System.out.println(process[i]+" \t "+at[i]+" \t "+bt[i]+" \t\t "+ wt[i]+" \t\t "+tat[i]);
        }

    }



    public static void main(String args[]){

        int [] process = {1,2,3};
        int [] at = {0,7,20};
        int [] burst_time = {5,9,6};

        find_time(process,at,burst_time);

    }
}