package com.syeedode.corp.affinity;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AffinityFileReader {

    public List<Affinity> readFile(String file) {
        BufferedReader br = null;
        FileReader fr = null;
        List<Affinity> affinityList = new ArrayList<>();
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String sCurrentLine;

            br = new BufferedReader(new FileReader(file));

            while ((sCurrentLine = br.readLine()) != null) {
                String [] temp = sCurrentLine.split(",");
                // TODO: valid error checking here
                Affinity affinity = Affinity.valueOfSiteUser(temp[0].trim(),temp[1].trim());
                affinityList.add(affinity);
            }
            return affinityList;
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
        return new ArrayList<>();
    }
}
