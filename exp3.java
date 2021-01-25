//round robin algo
import java.util.Scanner;
class exp3{
    public static Scanner scn = new Scanner(System.in);

    //assuming processes are sorted by order of their arrival time
    //0 5 1 3 2 1 3 2 4 3
    // public static void main(String[] args){
    //     System.out.println("Enter the no. of processes:");
    //     int n = scn.nextInt();
    //     int [] at  = new int[n];
    //     int [] bt  = new int[n];
    //     int [] rat = new int[n];  //remaining time
    //     int [] rbt = new int [n];
    //     for(int i =0; i<n; i++){
    //         System.out.print("Enter the arrival time and burst time for process "+(i+1)+": ");
    //         at[i]=scn.nextInt();
    //         bt[i]=scn.nextInt();
    //         rat[i]=bt[i];
    //         rbt[i]=at[i];
    //     }
    //     // for(int i = 0; i< n; i++){
    //     //     System.out.println(rt[i]);
    //     // }
    //     System.out.println("Enter the time quanta:");
    //     int tq = scn.nextInt();

    //     calculate(at,bt,rat,rbt,tq);
    // }

    // public static void calculate(int []at, int [] bt, int[]rat,int[]rbt ,int tq){
    //     int t =0;
    //     int []wt = new int[at.length];
    //     int []tat = new int[at.length];
    //     while(true){
    //         boolean flag = true;
    //         for(int i = 0; i<at.length; i++){

    //             if(rat[i]<=t){
    //                 if(rat[i]<=tq){
    //                     if(rbt[i]>0){
    //                         flag = false;
    //                         if(rbt[i]<=tq){
    //                             t += rbt[i];
    //                             tat[i]=t - at[i];
    //                             wt[i]=tat[i]-bt[i];
    //                             rbt[i]=0;
    //                         }else{
    //                             t += tq;
    //                             rbt[i]=rbt[i]-tq;
    //                             rat[i]=rat[i]+tq;
    //                         }
    //                     }

    //                 }else if(rat[i]>tq){

    //                     for(int j = 0; j< at.length; j++){      //queueing process having arrival time before exectution of ith process < tq
    //                         if(rat[j]<rat[i]){
    //                             if(rbt[j]>0){
    //                                 flag = false;
    //                                 if(rbt[j]<= tq){
    //                                     t+= rbt[j];
    //                                     tat[j] = t - at[j];
    //                                     wt[j]= t- bt[j];
    //                                     rbt[j]=0;
    //                                 }else{
    //                                     t += tq;
    //                                     rbt[j] -=tq;
    //                                     rat[j] += tq;
    //                                 }
    //                             }
    //                         }
    //                     }

    //                     if(rbt[i]>0){
    //                         flag = false;
    //                         if(rbt[i] <= tq){
    //                             t+= rbt[i];
    //                             tat[i]= t - at[i];
    //                             wt[i] = tat[i] - bt[i];
    //                             rbt[i] = 0;
    //                         }else{
    //                             t += tq;
    //                             rbt[i] -= tq;
    //                             rat[i] += tq;
    //                         }
    //                     }

    //                 }
    //             }else if(rat[i]>t){
    //                     t++;
    //                     i--;
    //             }


    //         }if(flag){
    //             break;
    //         }


    //     }
    //     System.out.println("Process\t Arrival\t BurstTime\t Waiting-time\t Turnaroundtime");
    //     for(int i = 0; i<at.length; i++){
    //         System.out.println((i+1)+"\t"+at[i]+"\t"+bt[i]+"\t"+wt[i]+"\t"+tat[i]+"\t"+rat[i]+"\t"+rbt[i]);
    //     }


    // }
    
 public static void roundRobin(String p[], int a[], 
                                  int b[], int n) 
    { 
        // result of average times 
        int res = 0; 
        int resc = 0; 
  
        // for sequence storage 
        String seq = new String(); 
  
        // copy the burst array and arrival array 
        // for not effecting the actual array 
        int res_b[] = new int[b.length]; 
        int res_a[] = new int[a.length]; 
  
        for (int i = 0; i < res_b.length; i++) { 
            res_b[i] = b[i]; 
            res_a[i] = a[i]; 
        } 
  
        // critical time of system 
        int t = 0; 
  
        // for store the waiting time 
        int w[] = new int[p.length]; 
  
        // for store the Completion time 
        int comp[] = new int[p.length]; 
  
        while (true) { 
            boolean flag = true; 
            for (int i = 0; i < p.length; i++) { 
  
                // these condition for if 
                // arrival is not on zero 
  
                // check that if there come before qtime 
                if (res_a[i] <= t) { 
                    if (res_a[i] <= n) { 
                        if (res_b[i] > 0) { 
                            flag = false; 
                            if (res_b[i] > n) { 
  
                                // make decrease the b time 
                                t = t + n; 
                                res_b[i] = res_b[i] - n; 
                                res_a[i] = res_a[i] + n; 
                                seq += "->" + p[i]; 
                            } 
                            else { 
  
                                // for last time 
                                t = t + res_b[i]; 
  
                                // store comp time 
                                comp[i] = t - a[i]; 
  
                                // store wait time 
                                w[i] = t - b[i] - a[i]; 
                                res_b[i] = 0; 
  
                                // add sequence 
                                seq += "->" + p[i]; 
                            } 
                        } 
                    } 
                    else if (res_a[i] > n) { 
  
                        // is any have less arrival time 
                        // the coming process then execute them 
                        for (int j = 0; j < p.length; j++) { 
  
                            // compare 
                            if (res_a[j] < res_a[i]) { 
                                if (res_b[j] > 0) { 
                                    flag = false; 
                                    if (res_b[j] > n) { 
                                        t = t + n; 
                                        res_b[j] = res_b[j] - n; 
                                        res_a[j] = res_a[j] + n; 
                                        seq += "->" + p[j]; 
                                    } 
                                    else { 
                                        t = t + res_b[j]; 
                                        comp[j] = t - a[j]; 
                                        w[j] = t - b[j] - a[j]; 
                                        res_b[j] = 0; 
                                        seq += "->" + p[j]; 
                                    } 
                                } 
                            } 
                        } 
  
                        // now the previous porcess according to 
                        // ith is process 
                        if (res_b[i] > 0) { 
                            flag = false; 
  
                            // Check for greaters 
                            if (res_b[i] > n) { 
                                t = t + n; 
                                res_b[i] = res_b[i] - n; 
                                res_a[i] = res_a[i] + n; 
                                seq += "->" + p[i]; 
                            } 
                            else { 
                                t = t + res_b[i]; 
                                comp[i] = t - a[i]; 
                                w[i] = t - b[i] - a[i]; 
                                res_b[i] = 0; 
                                seq += "->" + p[i]; 
                            } 
                        } 
                    } 
                } 
  
                // if no process is come on thse critical 
                else if (res_a[i] > t) { 
                    t++; 
                    i--; 
                } 
            } 
            // for exit the while loop 
            if (flag) { 
                break; 
            } 
        } 
  
        System.out.println("name  ctime  wtime"); 
        for (int i = 0; i < p.length; i++) { 
            System.out.println(" " + p[i] + "    " + comp[i] 
                               + "    " + w[i]); 
  
            res = res + w[i]; 
            resc = resc + comp[i]; 
        } 
  
        System.out.println("Average waiting time is "
                           + (float)res / p.length); 
        System.out.println("Average compilation  time is "
                           + (float)resc / p.length); 
        System.out.println("Sequence is like that " + seq); 
    } 
  
    // Driver Code 
    public static void main(String args[]) 
    { 
        // name of the process 
        String name[] = { "p0", "p1", "p2", "p3","p4" }; 
  
        // arrival for every process 
        int arrivaltime[] = { 0, 1, 2, 3, 4 }; 
  
        // burst time for every process 
        int bursttime[] = { 5, 3, 1, 2 ,3}; 
  
        // quantum time of each process 
        int q = 2; 
  
        // cal the function for output 
        roundRobin(name, arrivaltime, bursttime, q); 
    } 
    
}