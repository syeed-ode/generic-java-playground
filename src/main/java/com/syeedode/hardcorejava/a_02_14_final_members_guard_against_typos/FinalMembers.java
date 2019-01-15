package com.syeedode.hardcorejava.a_02_14_final_members_guard_against_typos;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * What used to be difficult to find logic bvg is transformed by the
 * keyword 'final' into a minor compile-time bug.
 *
 * Java requires that all instance-scoped 'final' variables and members
 * must be set before the end of the constructor. In a similar mannert,
 * all class-scoped members must be set by the end of the static
 * initialization of the class they are declared in, and all method-
 * scoped 'final's must be set by the end of the method they are
 * declared in.
 */
public class FinalMembers {
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    /** Holds the creation date-time of the instance */
    /** */
    private Date creationDate = Calendar
            .getInstance(GMT)
            .getTime();

    /**
     * Now that {@code creationDate2} is final, any attempts to write to
     * it after it is initialized will cause a compiler error}
     */
    private final Date creationDate2 = Calendar
            .getInstance(GMT)
            .getTime();

    public Date modificationDate = creationDate;

    /**
     * Get the Date-Time when the object was created
     *
     * @return The creation date of the object
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setModificationDate(Date modficationDate) {
        /** */
        if(modficationDate == null) {
            throw new NullPointerException();
        }

        /** */
        this.creationDate = modficationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public static void main(String [] args) {
    }
}
