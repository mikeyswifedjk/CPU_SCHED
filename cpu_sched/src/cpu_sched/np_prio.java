/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpu_sched;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author maikaordonez
 */
public class np_prio {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> iID = new ArrayList();
        ArrayList<Integer> iAT = new ArrayList();
        ArrayList<Integer> iBT = new ArrayList();
        ArrayList<Integer> iPR = new ArrayList();

        ArrayList<Integer> oID = new ArrayList();
        ArrayList<Integer> oAT = new ArrayList();
        ArrayList<Integer> oBT = new ArrayList();
        ArrayList<Integer> oPR = new ArrayList();

        ArrayList<Integer> CT = new ArrayList();

        int [] TT, WT;
        int lp, ft=0, nums, test=0, tt=0, wt=0;

        Scanner scan = new Scanner(System.in);
        DecimalFormat deci = new DecimalFormat("0.00");
        
        System.out.print("Enter the number of processes (between 3 and 6): ");
        lp = scan.nextInt();

        if (lp>=3 && lp<=6){
            TT = new int[lp];
            WT = new int[lp];
            
            for (int i=0; i<lp; i++){
                iID.add(i+1);
            }
            
            System.out.println("");
            for (int i=0; i<lp; i++){
                System.out.print("Enter burst time for P"+ iID.get(i)+": ");
                iBT.add(scan.nextInt());
            }
            
            System.out.println("");
            for (int i=0; i<lp; i++){
                System.out.print("Enter priority for P"+ iID.get(i)+": ");
                iPR.add(scan.nextInt());
            }
            
            
        }
    }
}
