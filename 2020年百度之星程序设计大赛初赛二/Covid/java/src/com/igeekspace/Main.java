package com.igeekspace;

import java.io.*;
import java.util.ArrayList;

class Path {
    int time;
    int place;

    Path(int t, int p) {
        time = t;
        place = p;
    }
}

class Person {
    boolean isInfection = false;
    ArrayList<Path> paths;

    Person() {
        paths = new ArrayList<Path>();
    }
}

public class Main {
    //记录第i时刻j位置是否会被感染
    static boolean[][] infections;

    private static void init() {
        for (int i = 0; i < infections.length; i++) {
            for (int j = 0; j < infections[i].length; j++) {
                infections[i][j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        infections = new boolean[101][11];

        in.nextToken();
        int testCases = (int) in.nval;

        while (testCases-- > 0) {
            init();
            in.nextToken();
            int n = (int) in.nval;

            Person[] persons = new Person[n];
            for (int i = 0; i < n; i++) {
                persons[i] = new Person();

                if (i == 0) {
                    persons[i].isInfection = true;
                }

                in.nextToken();
                int len = (int) in.nval;

                for (int j = 0; j < len; j++) {
                    in.nextToken();
                    int t = (int) in.nval;

                    in.nextToken();
                    int p = (int) in.nval;

                    if (persons[i].isInfection) {
                        infections[t][p] = true;
                    } else {
                        if (infections[t][p]) {
                            persons[i].isInfection = true;
                        }
                    }

                    persons[i].paths.add(new Path(t, p));
                }
            }

            while (true) {
                boolean newInfection = false;
                for (int i = 0; i < persons.length; i++) {
                    if (!persons[i].isInfection) {
                        for (Path path : persons[i].paths) {
                            if (infections[path.time][path.place]) {
                                persons[i].isInfection = true;
                                newInfection = true;
                            }

                            if (persons[i].isInfection) {
                                infections[path.time][path.place] = true;
                            }
                        }
                    }
                }

                if (!newInfection) {
                    break;
                }
            }

            out.print(1);
            for (int i = 1; i < persons.length; i++) {
                if (persons[i].isInfection) {
                    out.print(" " + (i + 1));
                }
            }
            out.println();
        }
        out.flush();
    }
}
