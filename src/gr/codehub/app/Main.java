package gr.codehub.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {


        Ui ui = new Ui();
        AllFiles listoffiles = new AllFiles();
        ui.manageAllFiles(listoffiles);

    }
}
