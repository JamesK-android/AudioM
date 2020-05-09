package gr.codehub.app;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ui {


    public Choice menu() {

        int choice;
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    return Choice.CREATE;
                case 2:
                    return Choice.DISPLAY;
                case 3:
                    return Choice.SAVE;
                case 4:
                    return Choice.LOAD;
                case 5:
                    return Choice.SEARCH;
                case 6:
                    return Choice.REMOVE;
                case 7:
                    return Choice.TOTALDURATION;
                case 0:
                    return Choice.EXIT;
                default:
                    return Choice.ERROR;
            }
        } catch (Exception e) {
            return Choice.ERROR;
        }
    }

    public MediaFile createFile() {
        int id;
        String filename;
        long duration;
        Date dateofrecord = null;
        String description;
        String filetype;
        MediaFile newrecord;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        System.out.println("Give the file id");
        id = scanner.nextInt();
        System.out.println("Give the file name");
        filename = scanner.next();
        System.out.println("Give the duration");
        duration = scanner.nextLong();
        System.out.println("Give the date of record in the form of dd/mm/yyyy");
        String givendate = scanner.next();

        try {
            dateofrecord = dateFormat.parse(givendate);
        } catch (Exception e) {
        }
        System.out.println(dateofrecord);

        System.out.println("Give description");
        description = sc.nextLine();
        System.out.println("Give the file type");
        int i;
        do {
            System.out.println("1.avi" + "  2.wmv" + " 3.mp4" + "   4.mp3" + "  5.wav" + "  6.wma");
            i = scanner.nextInt();
        }while (i <= 0 || i > 6);
        if(i == 1){
            filetype = "avi";
            newrecord = new VideoFile(id, filename, duration,dateofrecord, description, filetype);
        }else if(i ==2){
            filetype = "wmv";
            newrecord = new VideoFile(id, filename, duration, dateofrecord, description, filetype);
        }else if(i == 3){
            filetype = "mp4";
            newrecord = new VideoFile(id, filename, duration, dateofrecord, description, filetype);
        }else if(i == 4) {
            filetype = "mp3";
            newrecord = new AudioFile(id, filename, duration, dateofrecord, description, filetype);
        }else if(i == 5){
            filetype = "wav";
            newrecord = new AudioFile(id, filename, duration, dateofrecord, description, filetype);
        }else{
            filetype = "wma";
            newrecord = new AudioFile(id, filename, duration, dateofrecord, description, filetype);
        }

        return newrecord;
    }


    public void manageAllFiles(AllFiles listoffiles) {
        Choice choice;
        do {
            System.out.println("1. Add a file" + "\t2.Display " + "\t3.Save to file"
                    + "\t4.Load from file" + "\t5.Search for file" + "\t6.Remove Media file " + "\t7.Print total duration" +"\t0. Exit");
            choice = menu();

            switch (choice) {
                case CREATE:
                MediaFile ad = createFile();
                listoffiles.addFile(ad);
                    break;
                case DISPLAY:
                    listoffiles.displayFiles();
                    System.out.println("Number of files: "+listoffiles.displaynumoffiles());
                    break;
                case SAVE:
                    listoffiles.savetolist("media.txt");
                    break;
                case LOAD:
                    listoffiles.loadfromlist("media.txt");
                    System.out.println("Number of files loaded: "+listoffiles.displaynumoffiles());
                    break;
                case SEARCH:
                    listoffiles.SearchFile();
                    break;
                case ERROR:
                    System.out.println("You gave erroneous input");
                    break;
                case REMOVE:
                    listoffiles.removeMedia();
                    break;
                case TOTALDURATION:
                    System.out.println("Total durations is: " + listoffiles.totalDuration() + " milisecont" );
                    listoffiles.totalDuration();
                    break;
            }
        }while (choice != Choice.EXIT);

    }




}
