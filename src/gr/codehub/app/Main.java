package gr.codehub.app;

public class Main {

    public static void main(String[] args) {


        Ui ui = new Ui();
        //VideoFile v1 = new VideoFile(1,"james","12 min","12/1/12","new file","mp3");
        //System.out.println(v1.toString());
        AllFiles listoffiles = new AllFiles();
        ui.manageAllFiles(listoffiles);

    }
}
