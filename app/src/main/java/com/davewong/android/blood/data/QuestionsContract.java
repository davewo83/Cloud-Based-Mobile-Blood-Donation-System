package com.davewong.android.blood.data;

import android.provider.BaseColumns;

/**
 * Created by dcwou_000 on 28/10/2014.
 */
public class QuestionsContract {

        public static final class QuestionsEntry implements BaseColumns {

            public static final String TABLE_NAME = "questions";

            // Column with the foreign key into the location table.
            public static final String COLUMN_DON_KEY = "donor_id";
            // Date, stored as Text with format yyyy-MM-dd
            public static final String COLUMN_DATETEXT = "date";
            // Weather id as returned by API, to identify the icon to be used
            public static final String COLUMN_Q1 = "q1";
            public static final String COLUMN_Q2 = "q2";
            public static final String COLUMN_Q3 = "q3";
            public static final String COLUMN_Q4 = "q4";
            public static final String COLUMN_Q5 = "q5";
        }

    public static final class DetailsEntry implements BaseColumns {

        public static final String TABLE_NAME = "details";

        // Column with the foreign key into the location table.
        public static final String COLUMN_DON_KEY = "donor_id";
        // Date, stored as Text with format yyyy-MM-dd
        public static final String COLUMN_DATETEXT = "date";
        // Weather id as returned by API, to identify the icon to be used
        public static final String COLUMN_FN = "dave";
        public static final String COLUMN_SN = "wong";
        public static final String COLUMN_HN = "dave";
        public static final String COLUMN_PC = "dave";
        public static final String COLUMN_EM = "dave";
        public static final String COLUMN_PN = "dave";
        public static final String COLUMN_DB = "dave";
        public static final String COLUMN_SX = "dave";
    }

}
