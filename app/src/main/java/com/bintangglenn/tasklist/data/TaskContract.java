package com.bintangglenn.tasklist.data;

import android.provider.BaseColumns;

public class TaskContract {
    public static abstract class TaskEntry implements BaseColumns {
        public static final String TABLE_NAME = "ABSENT";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_ABSENT_TASK = "TASK";
        public static final String COLUMN_ABSENT_DAY = "DAY";

        public static final int DAY_MONDAY = 1;
        public static final int DAY_TUESDAY = 2;
        public static final int DAY_WEDNESDAY = 3;
        public static final int DAY_THURSDAY = 4;
        public static final int DAY_FRIDAY = 5;
        public static final int DAY_SATURDAY = 6;
    }
}
