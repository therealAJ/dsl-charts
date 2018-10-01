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
            case 5:
                retString ="                    ";
                break;
            default:
                retString ="";
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

    public static final String DIV_OPEN_TAG =
            "<div style=' \n" +
                tabs(1) + "max-width: 600px;\n" +
                tabs(1) + "max-height: 600px;\n" +
                tabs(1) + "position:relative;\n" +
                tabs(1) + "margin:100px auto;'>\n";

    public static final String DIV_CLOSE_TAG = "</div>\n";

}
