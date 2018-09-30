package util;

import java.util.ArrayList;

public class SnippetHelpers {

    public static String tabs(int numTabs) {
        String retString = "";
        switch (numTabs) {
            case 1:
                retString ="    ";
                break;
            case 2:
                retString ="        ";
                break;
            case 3:
                retString ="            ";
                break;
            case 4:
                retString ="                ";
                break;
        }
        return retString;
    }

    public static String appendArrayItems(ArrayList lst) {
        String returnString ="";
        Boolean first = true;
        for (Object label: lst) {
            String str;
            if (first) {
                str = "'" + label + "'";
                first = false;
            } else str = ",'" + label + "'";
            returnString += str;
        }
        returnString += "],\n";
        return returnString;
    }

}
