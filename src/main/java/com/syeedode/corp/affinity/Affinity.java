package com.syeedode.corp.affinity;

public class Affinity {
    private final String site;
    private final String user;

    private Affinity(String website, String visitingUser) {
        site = website;
        user = visitingUser;
    }

    public static Affinity valueOfSiteUser(String site, String user) {
        return new Affinity(site,user);
    }

    public String getSite() {
        return site;
    }

    public String getUser() {
        return user;
    }
}
