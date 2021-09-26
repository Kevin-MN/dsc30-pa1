/**
 * Name: Kevin Morales-Nguyen
 * PID: A17186624
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.text.DecimalFormat;

/**
 * @author Kevin Morales-Nguyen
 * @since 9/24/2021
 */
public class Startup {

    private static int NUM_SYMPTOMS=6;
    private static int NUM_FILES=3;
    private static int ASCII_ZERO=48;

    public static String convertUnits(int option, String currentUnit, double value){
        double kg, gram, pound, ounce; // variables for weights
        kg = gram = pound = ounce = 0.00;
        double meter, mile, yard, foot; // variables for distances
        meter = mile = yard = foot = 0.00;

        DecimalFormat df = new DecimalFormat("#.00"); // using Math.round(d * 100) / 100 did not work properly

        switch(option){
            case 1:
                if(currentUnit == "kg"){
                    kg = value;

                    gram = kg * 1000;
                    pound = kg * 2.204622621849;
                    ounce = kg * 35.27396194958;
                }
                else if(currentUnit == "gram"){
                    gram = value;

                    kg = gram * 0.001;
                    pound = gram * 0.002204622622;
                    ounce = gram * 0.035273961952;

                }
                else if(currentUnit == "pound"){
                    pound = value;

                    kg = pound * 0.453592370031;
                    gram = pound * 453.59237003084;
                    ounce = pound * 16.000000001088;
                }
                else if(currentUnit == "ounce"){
                    ounce = value;

                    kg = ounce * 0.028349523127;
                    gram = ounce * 28.349523127013;
                    pound = ounce * 0.062500000004;
                }
                else{
                    return "Invalid unit";
                }

                return "kg: " + String.format("%.2f" ,kg) + "\ngram: " + String.format("%.2f" ,gram)  +  "\npounds: " + String.format("%.2f" ,pound)+ "\nounce: " + String.format("%.2f" ,ounce);
            case 2:
                if(currentUnit == "meter"){
                    meter = value;

                    mile = meter * 0.000621371192;
                    yard = meter * 1.09361329834;
                    foot = meter * 3.280839895013;
                }
                else if(currentUnit == "mile"){
                    mile = value;

                    meter = mile * 1609.344;
                    yard = mile * 1760 ;
                    foot = mile * 5280 ;


                }
                else if(currentUnit == "yard"){
                    yard = value;

                    meter = yard * 0.9144;
                    mile = yard * 0.000568181818;
                    foot = yard * 3;
                }
                else if(currentUnit == "foot"){
                    foot = value;

                    meter = foot * 0.3048;
                    mile = foot * 0.000189393939;
                    yard = foot * 0.333333333333;
                }
                else{
                    return "Invalid unit";
                }

                return "meter: " + String.format("%.2f", meter) + "\nmile: " + String.format("%.2f", mile) + "\nyard: " + String.format("%.2f", yard) + "\nfoot: " + String.format("%.2f", foot);

            default:
                return "Invalid option.\n";
            }
    }



    public static String removeComments(String input, char boundary){





        return null;
    }

    public static String determineSeat(){
        Random random = new Random();




        return null;
    }

    public static String processTransfer(int amount){
        /*TODO*/
        return null;
    }

    public static String decompressString(String input){
        /*TODO*/
        return null;
    }


    public static String calculateTime(String startTime, int[] intervals){
        /*TODO*/
        return null;
    }

    public static String summarizeResponse(String[] namesArray, boolean[][] responses){
        /*TODO*/
        return null;
    }

    public static void main(String[] args) {

        //System.out.println(convertUnits(2,"mile",1));






        /*
        //Below are the tests for #7. Input files are already transformed into a namesArray and a response array
        //Your task would be to get information from the arrays and summarize the responses in desired format
        //See input text and writeup for more details
        for(int i=1;i<NUM_FILES+1;i++){
            String path=String.format("src/students-092%d.txt",i);
            int numLines=getNumberLines(path);
            String[] namesArray=new String[numLines];
            boolean[][] respArr=new boolean[numLines][NUM_SYMPTOMS];
            readResponses(path, namesArray, respArr);
            System.out.println("__________________________");
            System.out.println(summarizeResponse(namesArray, respArr));
        }
        */

    }

    /**
     * helper method to count number of lines within the input file
     * Don't change the code within it.
     * @param path the input file path
     * @return the number of lines in the input file
     */
    public static int getNumberLines(String path){
        try {
            Scanner sc =new Scanner(new File(path));
            int numLines=0;
            while(sc.hasNextLine()){
                numLines++;
                sc.nextLine();
            }
            return numLines;
        } catch (FileNotFoundException e) {
            System.out.println("File is not found. Make sure input files is under the src folder");
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Helper method to read the files
     * Don't change the code within it.
     * @return the student responses within the input file as a 2D String array
     */
    public static void readResponses(String path, String[] namesArray, boolean[][] respArr){
        try {
            Scanner sc = new Scanner(new File(path));
            int lineNum=0;
            while(sc.hasNextLine()){
                String s=sc.nextLine();
                respArr[lineNum]=new boolean[NUM_SYMPTOMS];
                String[] values=s.split(",");
                for (int i=0;i<values.length;i++){
                    if(i==0){ namesArray[lineNum]=values[i];}
                    else{ respArr[lineNum][i-1]=((int)values[i].charAt(0)-ASCII_ZERO)==1;}
                }
                lineNum++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
