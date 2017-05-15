package com.auvenir.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huy.huynh on 12/05/2017.
 * Contain all popular utility methods
 */
public class GeneralUtilities {

    public static String getTimeStampForNameSuffix(){
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy_HHmmss");
        Date date = new Date();
        return sdf.format(date);
    }
}
