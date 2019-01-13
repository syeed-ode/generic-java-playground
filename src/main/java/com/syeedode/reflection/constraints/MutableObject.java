package com.syeedode.reflection.constraints;

import com.syeedode.reflection.constraints.DateConstraint;
import com.syeedode.reflection.constraints.Gender;
import com.syeedode.reflection.constraints.ObjectConstraint;
import com.syeedode.reflection.constraints.StringConstraint;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MutableObject {

    public static final ObjectConstraint GENDER_CONSTRAINT =
            new ObjectConstraint("gender", false, Gender.class);

    public static final StringConstraint FIRST_NAME_CONSTRAINT =
            new StringConstraint("firstName", false, 20);

    public static final StringConstraint LAST_NAME_CONSTTAINT =
            new StringConstraint("lastName", false, 40);

    public static final DateConstraint BIRTH_DATE_CONSTRAINT =
            new DateConstraint("birthDate", false, "01/01/1900", "12/31/3000", Locale.US);

    public static final StringConstraint TAX_ID_CONSTRAINT =
            new StringConstraint("taxId", false, 40);

    private Date birthDate = Calendar.getInstance().getTime();

    private Gender gender = Gender.MALE;
    private String firstName = "<<NEW PERSON>>";
    private String lastName = "<<NEW PERSON>>";
    private String taxID = new String();
}
