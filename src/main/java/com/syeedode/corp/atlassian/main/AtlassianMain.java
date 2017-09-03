package com.syeedode.corp.atlassian.main;

import java.io.*;
import java.util.Scanner;

import static com.syeedode.corp.atlassian.Solution.*;

/**
 * Atlassian Coding Interview
 * Date: 20170517
 * Author: Syeed Ode
 */
public class AtlassianMain {
        public static void convertToAtlassian(String [] args) throws IOException {
            Scanner scanner = new Scanner(System.in);
            long _in;
            _in = Long.parseLong(scanner.nextLine());
            scanner.close();
            System.out.println(convert(_in));
        }

    public static void mainLookAndSay(String [] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String fileName = System.getenv("OUTPUT_PATH");
        fileName = "/Users/syeedode/java_projects/auth/src/main/resources/linkedList";
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        String _start;
        try {
            _start = in.nextLine();
        } catch (Exception e) {
            _start = null;
        }

        int _n;
        _n = Integer.parseInt(in.nextLine());

        res = lookAndSay(_start, _n);
        bw.write(res);
        bw.newLine();

        bw.close();
    }


    /*****
     *
     *
     * PROBABLY THE BEST
     *
     *
     *
     ********/
    public static void main(String [] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String fileName = System.getenv("OUTPUT_PATH");
        fileName = "/Users/syeedode/java_projects/auth/src/main/resources/linkedList";
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        int res;

        int _list_size //= Integer.parseInt(in.nextLine())
                , _list_i;
        String _list_item, originalListLine = br.readLine();
        LinkedListNode _list = null;

        for(String _listItem : originalListLine.split(" ")) {
            _list_item = _listItem.trim();
            _list = _insert_node_into_singlylinkedlist(_list, _list_item);
        }


        // int _sublist_size = Integer.parseInt(in.nextLine()), _sublist_i;
        String subListLine = br.readLine();
        LinkedListNode _sublist = null;
        for(String _sublist_item : subListLine.split(" ")) {
            _sublist_item = _sublist_item.trim();
            _sublist = _insert_node_into_singlylinkedlist(_sublist, _sublist_item);
        }

        res = findSublistWithinList(_list, _sublist,false, 2);
        System.out.println(res);
//        br.write(String.valueOf(res));
//        br.newLine();

        br.close();
    }
}
