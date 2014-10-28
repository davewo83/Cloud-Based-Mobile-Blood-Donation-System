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
            public static final Boolean COLUMN_Q1 = false;
            public static final Boolean COLUMN_Q2 = false;
            public static final Boolean COLUMN_Q3 = false;
            public static final Boolean COLUMN_Q4 = false;
            public static final Boolean COLUMN_Q5 = false;
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
        public static final Boolean COLUMN_Q3 = false;
    }

}
