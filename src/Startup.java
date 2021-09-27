/**
 * Name: Kevin Morales-Nguyen
 * PID: A17186624
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Kevin Morales-Nguyen
 * @since 9/24/2021
 */
public class Startup {

    private static int NUM_SYMPTOMS = 6;
    private static int NUM_FILES = 3;
    private static int ASCII_ZERO = 48;

    public static String convertUnits(int option, String currentUnit, double value) {
        double kg, gram, pound, ounce; // variables for weights
        kg = gram = pound = ounce = 0.00;
        double meter, mile, yard, foot; // variables for distances
        meter = mile = yard = foot = 0.00;

        switch (option) {
            case 1:
                if (currentUnit == "kg") {
                    kg = value;

                    gram = kg * 1000;
                    pound = kg * 2.204622621849;
                    ounce = kg * 35.27396194958;
                } else if (currentUnit == "gram") {
                    gram = value;

                    kg = gram * 0.001;
                    pound = gram * 0.002204622622;
                    ounce = gram * 0.035273961952;

                } else if (currentUnit == "pound") {
                    pound = value;

                    kg = pound * 0.453592370031;
                    gram = pound * 453.59237003084;
                    ounce = pound * 16.000000001088;
                } else if (currentUnit == "ounce") {
                    ounce = value;

                    kg = ounce * 0.028349523127;
                    gram = ounce * 28.349523127013;
                    pound = ounce * 0.062500000004;
                } else {
                    return "Invalid unit";
                }

                return "kg: " + String.format("%.2f", kg) + "\ngram: " + String.format("%.2f", gram) + "\npounds: " + String.format("%.2f", pound) + "\nounce: " + String.format("%.2f", ounce);
            case 2:
                if (currentUnit == "meter") {
                    meter = value;

                    mile = meter * 0.000621371192;
                    yard = meter * 1.09361329834;
                    foot = meter * 3.280839895013;
                } else if (currentUnit == "mile") {
                    mile = value;

                    meter = mile * 1609.344;
                    yard = mile * 1760;
                    foot = mile * 5280;


                } else if (currentUnit == "yard") {
                    yard = value;

                    meter = yard * 0.9144;
                    mile = yard * 0.000568181818;
                    foot = yard * 3;
                } else if (currentUnit == "foot") {
                    foot = value;

                    meter = foot * 0.3048;
                    mile = foot * 0.000189393939;
                    yard = foot * 0.333333333333;
                } else {
                    return "Invalid unit";
                }

                return "meter: " + String.format("%.2f", meter) + "\nmile: " + String.format("%.2f", mile) + "\nyard: " + String.format("%.2f", yard) + "\nfoot: " + String.format("%.2f", foot);

            default:
                return "Invalid option.\n";
        }
    }


    public static String removeComments(String input, char boundary) {

        if (input.contains(String.valueOf(boundary))) {
            ArrayList<Integer> indeces = new ArrayList<Integer>();
            char[] input_chars = new char[100000];

            input.getChars(0, input.length(), input_chars, 0);


            for (int i = 0; i < input.length(); i++) {
                if (input_chars[i] == boundary) {
                    indeces.add(i);
                }
            }

            String result = "";
            boolean add;


            if (indeces.get(0) == 0) {
                add = false;
            } else {
                add = true;
            }

            for (int l = 0; l < indeces.size(); l++) {
                System.out.println(indeces.get(l));
            }

            for (int l = 0; l < input_chars.length; l++) {
                if (add && !indeces.isEmpty() && indeces.get(0) != l) {

                    result = result.concat(String.valueOf(input_chars[l]));
                } else if (add && !indeces.isEmpty() && indeces.get(0) == l) {
                    add = false;
                    indeces.remove(0);
                } else if (!add && !indeces.isEmpty() && indeces.get(0) == l) {
                    add = true;
                }

            }
            result = result.replace(String.valueOf('\u0000'), "");

            return result;

        } else {
            return input;
        }

    }

    public static String determineSeat() {
        Random random = new Random();

        int int1, int2, sum1, sum2;
        int1 = int2 = sum1 = sum2 = 0;
        String int_str1, int_str2;
        int_str1 = int_str2 = "";


        boolean battle = true;
        boolean winner = false;

        while (battle) {
            int1 = random.nextInt(13);
            int2 = random.nextInt(4);

            int_str1 = String.valueOf(int1);
            int_str2 = String.valueOf(int2);

            System.out.println("Random int 1: "  + int_str1);
            System.out.println("Random int 2: " + int_str2);


            char[] int1_chars = int_str1.toCharArray();
            char[] int2_chars = int_str2.toCharArray();

            for (int i = 0; i < int1_chars.length; i++) {
                sum1 += Integer.parseInt(String.valueOf(int1_chars[i]));
                System.out.println(int1_chars[i]);
            }

            for (int l = 0; l < int2_chars.length; l++) {
                sum2 += Integer.parseInt(String.valueOf(int2_chars[l]));
                System.out.println(int2_chars[l]);
            }

            System.out.println("Sum 1: " + sum1);
            System.out.println("Sum 2: " + sum2);

            //System.out.println(int1 + " -- " + int_str1 + " -- " +  int1_chars.length + " -- " +  int_str1.length());
            //System.out.println(int2 + " -- " + int_str2 + " -- " +  int2_chars.length + " -- " +  int_str2.length());

            if (sum1 > sum2) {
                winner = true;
                battle = false;
            } else if (sum2 > sum1) {
                winner = false;
                battle = false;
            }
            else if(int1_chars.length < int2_chars.length){
                winner = true;
                battle = false;
            }
            else if(int1_chars.length > int2_chars.length){
                winner = false;
                battle = false;
            }
            else {
               battle = true;
            }
        }

        if(winner){
            return "You win the battle with value " + int1;
        }
        else{
            return"The other student wins the battle with value " + int2;
        }
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

        String[] time_split = startTime.split(":");
        int hours = Integer.parseInt(time_split[0]);
        int minutes = Integer.parseInt(time_split[1]);


        for(int i = 0; i < intervals.length;i++){
            if(minutes + intervals[i] > 60 ){
                minutes = (minutes + intervals[i]) % 60;
                hours++;

                if(hours == 24){

                    hours = 0;
                }

            }
            else if(minutes + intervals[i] == 60){
                minutes= 0;
                hours++;

                if(hours == 24){

                    hours = 0;
                }
            }
            else{
                minutes = (minutes + intervals[i]);
            }

            String str_hours = String.valueOf(hours);
            String str_minutes = String.valueOf(minutes);

            if(hours < 10){
                str_hours = "0".concat(str_hours);
            }

            if(minutes < 10){
               str_minutes =  "0".concat(str_minutes);
            }


            startTime = startTime.concat("\n" + str_hours + ":" +  str_minutes);

        }
        return startTime;
    }

    public static String summarizeResponse(String[] namesArray, boolean[][] responses){
        /*TODO*/
        return null;
    }

    public static void main(String[] args) {

        //System.out.println(convertUnits(2,"mile",1));


        System.out.println(determineSeat());

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
