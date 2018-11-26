package tansoft.algorithm.data;



import java.io.File;
import java.io.InputStream;
import java.util.Scanner;


public class Import {



    public static void main(String[] args) {


        getPatients();

    }

    public static Patient[] getPatients () {

        String dataSetName;
        int startingLine;

        // Determine which data set to load up and set the properties pertaining to it.
//        if (dataSet == DataSet.bays29) {
//            dataSetName = "bays29.tsp";
//            startingLine = 38;
//        } else {
        dataSetName = "att48.tsp";
        startingLine = 6;
        //}


        String[] lines = read(dataSetName).split("\n");
        String[] words = lines[3].split(" ");
        int numOfCities = Integer.parseInt(words[words.length-1]);

        Patient[] cities = new Patient[numOfCities];

        // Read each line and turn it into a City.
        for (int i = startingLine; i < startingLine+numOfCities; i++) {
            String[] line = removeWhiteSpace(lines[i]).trim().split("");

            int id = (int)Double.parseDouble(line[1].trim());
            int ct = (int)Double.parseDouble(line[2].trim());
            int ushp = (int)Double.parseDouble(line[3].trim());
            int ma = (int)Double.parseDouble(line[4].trim());
            int sesz = (int)Double.parseDouble(line[5].trim());
            int bn = (int)Double.parseDouble(line[6].trim());
            int nn = (int)Double.parseDouble(line[7].trim());
            int m = (int)Double.parseDouble(line[8].trim());
            int aClass=(int)Double.parseDouble(line[9].trim());

            Patient city = new Patient(line[0], id, ct,ushp,ma,sesz,bn,nn,m,aClass);
            cities[i-startingLine] = city;
        }
        System.out.println("*********************************"+cities);
        return cities;
    }

    /**
     * Removes duplicate what spaces in a String.
     * Example: "   2  3  3,2   " becomes " 2 3 3,2 "
     * @param s     the String to parse
     * @return      the String minus the duplicate white spaces
     */
    private static String removeWhiteSpace (String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && s.charAt(i-1) == ' ') {
                if (i != s.length()) {
                    s = s.substring(0, i) + s.substring(i+1, s.length());
                    i--;
                } else {
                    s = s.substring(0, i);
                    i--;
                }
            }
        }
        return s;
    }

    /**
     * Read from a file and load it to a String.
     * @param fileName  the name of the file to read (within the same root as this class)
     * @return          a String with the contents of the file
     */
    private static String read (String fileName) {
        InputStream stream = Import.class.getResourceAsStream(fileName);



        java.util.Scanner s = new java.util.Scanner(stream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public enum DataSet {
        att48,
        bays29
    }

}
