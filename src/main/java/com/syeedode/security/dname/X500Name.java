package com.syeedode.security.dname;

import java.util.Objects;

/**
 * O'Reilly Java Security Second Edition
 * JSSE Certificates - Chapter 14: SSL and HTTPS
 * <p>
 * Author: syeedode
 * Date: 9/5/17
 */
public class X500Name {
    private final String CN, OU, O, L, ST, C;
    private final String distinguisheDName;
    private static final String CN_TAG = "CN=", OU_TAG = "OU=", O_TAG = "O="
            , L_TAG = "L=", ST_TAG = "ST=", C_TAG = "C=";

    private X500Name(Builder builder) {
        CN = builder.cn;
        OU = builder.ou;
        O  = builder.o;
        L  = builder.l;
        ST = builder.st;
        C  = builder.c;
        distinguisheDName = builder.distinqushedName;
    }

    public static class Builder {
        private String cn, ou, o, l, st, c;
        private final String distinqushedName;
        private char [] nameAsCharArray;


        public Builder(String dn) {
             distinqushedName = dn;
             commonName(parse(CN_TAG))
                     .organizationUnit(parse(OU_TAG))
                     .organization(parse(O_TAG))
                     .locale(parse(L_TAG))
                     .state(parse(ST_TAG))
                     .country(parse(C_TAG));
        }

        public X500Name build(){
            return new X500Name(this);
        }

        public Builder commonName(String CN) {
            cn = CN;
            return this;
        }

        public Builder organizationUnit(String OU) {
            ou = OU;
            return this;
        }

        public Builder organization(String O) {
            o = O;
            return this;
        }

        public Builder locale(String city) {
            l = city;
            return this;
        }

        public Builder state(String ST) {
            st = ST;
            return this;
        }

        public Builder country(String country) {
            c = country;
            return this;
        }

        private String parse(String target) {
            if(Objects.isNull(nameAsCharArray)) {
                nameAsCharArray = distinqushedName.toCharArray();
            }
            char [] targetCharArray = target.toCharArray();
            for(int i = 0; i < targetCharArray.length; i++) {
                if(nameAsCharArray[i] == targetCharArray[0]){
                    // Possible match, check further
                    boolean found = true;
                    for(int j = 0; j < targetCharArray.length; j++){
                        try {
                            if(nameAsCharArray[i + j] != targetCharArray[j]) {
                                // This is naot a match so continue on..
                                found = false;
                                break;
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Couldn't find a match");
                            return null;
                        }
                    }
                    if(found) {
                        int firstPos = i + targetCharArray.length;
                        int lastPos, endChar;
                        if(nameAsCharArray[firstPos] == '\"'){
                            endChar = '\"';
                        } else {
                            endChar = ',';
                        }
                        // The substring will be terminated by a quote if
                        // the substring is quoted (CN="My Name",OU=...)
                        // or by a comma otherwise (L=New York,ST=...)
                        // or by the end of the string
                        // A badly formed substring will throw an
                        // ArrayIndexOutOfBoundsException
                        for(lastPos = firstPos + 1;
                            lastPos < nameAsCharArray.length; lastPos++){
                            if(nameAsCharArray[lastPos] == endChar)
                                break;
                        }
                        // If the lastPos is a quote, we need to
                        // include it in the string; if it's a comma
                        // we don't
                        return new String(nameAsCharArray,firstPos
                                ,(endChar == ',' ? lastPos - firstPos : lastPos - firstPos + 1));
                    }
                } //end if character matches first position
            }
            return null;
        }
    }

    public String getCN() {
        return CN;
    }

    public String getOU() {
        return OU;
    }

    public String getO() {
        return O;
    }

    public String getL() {
        return L;
    }

    public String getST() {
        return ST;
    }

    public String getC() {
        return C;
    }

    @Override
    public String toString() {
        return distinguisheDName;
    }
}
