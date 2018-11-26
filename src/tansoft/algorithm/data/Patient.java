package tansoft.algorithm.data;

import java.util.Random;


public class Patient {

    private String name;
   private int id;	//Sample ID
    private int ct; // Clump thickness
    private int usz; // Uniformity of Cell Size
    private int ushp; // Uniformity of Cell Shape
    private int ma; // Marginal Adhesion
    private int sesz; // SingleEpithelial Cell Size
    private int bn; // Bare Nuclei
    private int bc; // Bland Chromatin
    private int nn; // Normal Nucleoli
    private int m; // Mitoses
    private int AClass; //  class - 2 for benign, 4 for malignant

    public static final int BENIGN = 2;
    public static final int MALIGNANT = 4;

    public Patient(String name, int id, int ct, int ushp, int ma, int sesz, int bn, int nn, int m, int aClass) {
this.name=name;
        this.id = id;
        this.ct = ct;
        this.usz = usz;
        this.ushp = ushp;
        this.ma = ma;
        this.sesz = sesz;
        this.bn = bn;
        this.bc = bc;
        this.nn = nn;
        this.m = m;
        this.AClass = aClass;
    }

    public int getId() {
        return id;
    }

    public int getCt() {
        return ct;
    }

    public int getUsz() {
        return usz;
    }

    public int getUshp() {
        return ushp;
    }

    public int getMa() {
        return ma;
    }

    public int getSesz() {
        return sesz;
    }

    public int getBn() {
        return bn;
    }

    public int getBc() {
        return bc;
    }

    public int getNn() {
        return nn;
    }

    public int getM() {
        return m;
    }

    public int getAClass() {
        return AClass;
    }

    public String getName () {
        return name;
    }

    public Patient(int id, int ct, int usz, int ushp, int ma, int sesz, int bn, int bc, int nn, int m, int AClass) {
        this.id = id;
        this.ct = ct;
        this.usz = usz;
        this.ushp = ushp;
        this.ma = ma;
        this.sesz = sesz;
        this.bn = bn;
        this.bc = bc;
        this.nn = nn;
        this.m = m;
        this.AClass = AClass;
    }

    public static Patient getRandomClassifaction (Random random) {
        String name = getRandomName(random);
        int id = random.nextInt(500);
        int ct = random.nextInt(500);
        int ushp = random.nextInt(500);
        int ma = random.nextInt(500);
        int sesz = random.nextInt(500);
        int bn = random.nextInt(500);
        int nn = random.nextInt(500);
        int m = random.nextInt(500);
        int AClass = random.nextInt(500);

        return new Patient(name,id,ct,ushp,ma,sesz,bn,nn,m,AClass);
    }

    private static String getRandomName (Random random) {

        // Create an array with random integers.
        int[] name = new int[random.nextInt(5)+3];
        for (int i = 0; i < name.length; i++) {
            name[i] = random.nextInt(26) + 65;
        }

        // Convert the integers in the array to chars.
        // Add each char to StringBuilder.
        StringBuilder sb = new StringBuilder();
        for (int i : name) {
            sb.append((char) i);
        }

        return new String(sb);
    }




}
