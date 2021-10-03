/**
 * Name: Kevin Morales-Nguyen
 * PID: A17186624
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This class is used to implement and test methods defined in
 * programming assignment 1
 *
 * @author Kevin Morales-Nguyen
 * @since 9/24/2021
 */
public class Startup {

    private static int NUM_SYMPTOMS = 6;
    private static int NUM_FILES = 3;
    private static int ASCII_ZERO = 48;

    /**
     *This method will print out a list of related measurements, either weight or
     * distance, that are converted between different units.
     *
     * @param option 1 specifies weights conversions and 2 specifies distance conversions
     * @param currentUnit the starting unit type that is to be converted to other types,
     *                    dependent on option 1
     * @return String that has additional conversions for weight/distance based on the
     * option argument
     */
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

                return "kg: " + String.format("%.2f", kg) + "\ngram: " +
                        String.format("%.2f", gram) + "\npounds: " +
                        String.format("%.2f", pound) + "\nounce: " +
                        String.format("%.2f", ounce);
            case 2:
                if (currentUnit.equals("meter")) {
                    meter = value;

                    mile = meter * 0.000621371192;
                    yard = meter * 1.09361329834;
                    foot = meter * 3.280839895013;
                } else if (currentUnit.equals("mile")) {
                    mile = value;

                    meter = mile * 1609.344;
                    yard = mile * 1760;
                    foot = mile * 5280;

                } else if (currentUnit.equals("yard")) {
                    yard = value;

                    meter = yard * 0.9144;
                    mile = yard * 0.000568181818;
                    foot = yard * 3;

                } else if (currentUnit.equals("foot")) {
                    foot = value;

                    meter = foot * 0.3048;
                    mile = foot * 0.000189393939;
                    yard = foot * 0.333333333333;

                } else {
                    return "Invalid unit";
                }

                return "meter: " + String.format("%.2f", meter) + "\nmile: " +
                        String.format("%.2f", mile) + "\nyard: " +
                        String.format("%.2f", yard) + "\nfoot: " +
                        String.format("%.2f", foot);
            default:
                return "Invalid option.\n";
        }
    }

    /**
     *This method takes in a string along with a delimiter and returns a string that has
     * segments removed based on the position of the pair(s) of delimiters
     *
     * @param input raw string of text that includes delimiters in paris for removing text
     * @param boundary the character that specifies the start or end of text to be removed
     * @return A string that has removed text specified by the boundary argument
     */
    public static String removeComments(String input, char boundary) {
        if (input.contains(String.valueOf(boundary))) {
            ArrayList<Integer> indeces = new ArrayList<Integer>();
            char[] input_chars = input.toCharArray();

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

            return result;

        }
        else {
            return input;
        }

    }

    /**
     *This method uses the Random class to generate random integers and then compares
     * them to determine who should get the seat, the person with the largest sum of digits,
     * or lower number of overall digits if the sum is equal, wins
     *
     * @return A string that describes the winner and the value they won with
     */
    public static String determineSeat() {
        Random random = new Random(1);

        int int1, int2, sum1, sum2;
        int1 = int2 = sum1 = sum2 = 0;
        String int_str1, int_str2;
        int_str1 = int_str2 = "";
        boolean battle = true;
        boolean winner = false;

        while (battle) {
            int1 = random.nextInt(100);
            int2 = random.nextInt(100);

            int_str1 = String.valueOf(int1);
            int_str2 = String.valueOf(int2);

            char[] int1_chars = int_str1.toCharArray();
            char[] int2_chars = int_str2.toCharArray();

            for (int i = 0; i < int1_chars.length; i++) {
                sum1 += Integer.parseInt(String.valueOf(int1_chars[i]));
            }

            for (int l = 0; l < int2_chars.length; l++) {
                sum2 += Integer.parseInt(String.valueOf(int2_chars[l]));
            }

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

    /**
     *This method takes a total amount of money and processes how much can be transferred
     * after transaction fees have been subtracted, it also will not transfer some funds if
     * the appropriate fee requirements are not met.
     *
     * @param amount the total amount of money input
     * @return A string that describes the amount available to transfer and the
     * fees accrued to initiate the transfer
     */
    public static String processTransfer(int amount){

        int max_transfer = 0;
        int fees = 0;

        while(amount > 7){
            if(amount > 107){
                max_transfer += 100;
                fees += 7;
                amount -= 107;
            }
            else{
                max_transfer += (amount - 7);
                fees+= 7;
                amount -= (amount + 7);
            }
        }
        return "Max amount: " + max_transfer + ", transaction fee is " +  fees ;
    }


    /**
     *This method takes a raw string which could have parentheses delimiters and
     * returns a string that repeats the delimiters preceding character by N times,
     * N being the numeric value within the parentheses
     *
     * @param input a raw string that could have parentheses delimiters
     * @return A that has any delimiters removed and the appropriate amount of charaters
     * printed out as specified by the delimiter
     */
    public static String decompressString(String input){

        String result = "";

        if(input.contains(String.valueOf('('))){
            char[] chars = input.toCharArray();
            ArrayList<Integer> start_indeces = new ArrayList<Integer>();
            ArrayList<Integer> end_indeces = new ArrayList<Integer>();
            for (int i = 0; i < input.length(); i++) {
                if (chars[i] == '(') {
                    start_indeces.add(i);
                }
            }

            for (int i = 0; i < input.length(); i++) {
                if (chars[i] == ')') {
                    end_indeces.add(i);
                }
            }


            for(int l = 0; l < chars.length;l++){
                if(!start_indeces.isEmpty() && l == start_indeces.get(0)){
                    int num = 0;

                    String number = input.substring(start_indeces.get(0) + 1,
                            end_indeces.get(0));

                    for(int p = 1; p < Integer.parseInt(String.valueOf(number)); p++){

                        result = result.concat(String.valueOf(chars[l-1]));
                    }

                    start_indeces.remove(0);
                    end_indeces.remove(0);
                    l+= number.length() + 1;
                }
                else{
                    result = result.concat(String.valueOf(chars[l]));
                }
            }

            return result;
        }
        else{
            return input;
        }
    }

    /**
     *This method calculates a time table and prints it out as a string
     * based on a given initial time and an array that contains subsequent times,
     * the time is based on 24-hour format
     *
     * @param startTime A String that indicates the initail starting time for the time table
     * @param intervals A integer array that contains the subsequent times for boarding
     * @return
     */
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


    /**
     *This method prints a summary about the classes students based on the names and
     * corresponding array that is used to keep track of symptoms for covid-19.
     * The summary includes number of students who should stay home, their names, and the
     * average number of symptoms per student.
     *
     *
     * @param namesArray An String array that holds all the names of the students
     * @param responses An 2d boolean Array that stores 0 indicated negative symptom or 1
     *                  for a positive symptom
     * @return A string that has detailed information about the number of students that should
     * not attend class, the names of those students, and the average number of symptoms per student
     */
    public static String summarizeResponse(String[] namesArray, boolean[][] responses){

        ArrayList<String> names = new ArrayList<String>();
        int num_symptoms = 0;
        int total_symptoms = 0;

        int[] symptoms = new int[namesArray.length];

                for(int row = 0; row < responses.length;row++){
                    for(int col = 0; col < responses[0].length;col++) {
                        if(responses[row][col] == true){
                            total_symptoms++;
                            num_symptoms++;
                        }
                    }

                    if(num_symptoms >= 3){
                        names.add(namesArray[row]);
                    }
                    num_symptoms = 0;

                }

            int num_sick = names.size();
                String names_string = "The names are ";

                if(num_sick == 0){
                    names_string = names_string.concat("none");

                }
                else if(num_sick == 1){
                    names_string = names_string.concat(names.get(0));

                }
                else {
                    for (int i = 0; i < names.size(); i++) {
                        if (i == 0) {
                            names_string = names_string.concat(names.get(i) + ", ");

                        } else if (i == (names.size() - 1)) {
                            names_string = names_string.concat("and " + names.get(i));
                        } else {
                            names_string = names_string.concat(names.get(i) + ", ");
                        }

                    }
                }

                double max_symptoms = responses.length * responses[0].length;
                double total_symptoms_double = (double) total_symptoms;
                double avg_symptoms =  total_symptoms_double /(double) namesArray.length ;


        return names.size() + "/" + namesArray.length + " students should stay home.\n" +
                names_string + ".\n" + "On this date, the students reported " +
                String.format("%.1f",avg_symptoms) + " symptoms on average.";

    }

    public static void main(String[] args) {

        //Below are the tests for #7. Input files are already transformed into a
        // namesArray and a response arrayYour task would be to get information
        // from the arrays and summarize the responses in desired format See input
        // text and writeup for more details

        for(int i=1;i<NUM_FILES+1;i++){
            String path=String.format("src/students-092%d.txt",i);
            int numLines=getNumberLines(path);
            String[] namesArray=new String[numLines];
            boolean[][] respArr=new boolean[numLines][NUM_SYMPTOMS];
            readResponses(path, namesArray, respArr);
            System.out.println("__________________________");
            System.out.println(summarizeResponse(namesArray, respArr));
        }


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
                    else{
                        respArr[lineNum][ i - 1 ]=((int)values[i].charAt(0)-ASCII_ZERO) == 1;
                    }
                }
                lineNum++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
