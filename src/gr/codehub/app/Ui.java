package gr.codehub.app;

import java.util.Scanner;

public class Ui {


    public Choice menu() {

        int choice;
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    return Choice.AUDIOFILE;
                case 2:
                    return Choice.VIDEOFILE;
                case 3:
                    return Choice.DISPLAY;
                case 4:
                    return Choice.SAVE;
                case 5:
                    return Choice.LOAD1;
                case 6:
                    return Choice.LOAD2;
                case 0:
                    return Choice.EXIT;
                default:
                    return Choice.ERROR;
            }
        } catch (Exception e) {
            return Choice.ERROR;
        }
    }

    public AudioFile createAudioFile() {
        int id;
        String filename;
        String duration;
        String dateofrecord;
        String description;
        String filetype;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the customer id");
        id = scanner.nextInt();
        System.out.println("Give the file name");
        filename = scanner.next();
        System.out.println("Give the duration");
        duration = scanner.next();
        System.out.println("Give the date of record");
        dateofrecord = scanner.next();
        System.out.println("Give description");
        description = scanner.next();
        System.out.println("Give the file type");
        filetype = scanner.next();


        AudioFile a1 = new AudioFile(1, filename, duration, dateofrecord, description, filetype);

        return a1;
    }

    public VideoFile createVideoFile() {
        int id;
        String filename;
        String duration;
        String dateofrecord;
        String description;
        String filetype;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the customer id");
        id = scanner.nextInt();
        System.out.println("Give the file name");
        filename = scanner.next();
        System.out.println("Give the duration");
        duration = scanner.next();
        System.out.println("Give the date of record");
        dateofrecord = scanner.next();
        System.out.println("Give description");
        description = scanner.next();
        System.out.println("Give the file type");
        filetype = scanner.next();


        VideoFile v1 = new VideoFile(1, filename, duration, dateofrecord, description, filetype);

        return v1;
    }


    public void manageAllFiles(AllFiles listoffiles) {
        Choice choice;
        do {
            System.out.println("1. Add Audio File   2. Add Video File" + "  3.Display " + " 4.Save to file"
                    + " 5.Load video file" + "  6.Load audio file" +"  0. Exit");
            choice = menu();

            switch (choice) {
                case AUDIOFILE:
                AudioFile ad = createAudioFile();
                listoffiles.addFile(ad);
                    break;
                case VIDEOFILE:
                    VideoFile av = createVideoFile();
                    listoffiles.addFile(av);
                    break;
                case DISPLAY:
                    listoffiles.displayFiles();
                    break;
                case SAVE:
                    listoffiles.savetolist("media.txt");
                    break;
                case LOAD1:
                    listoffiles.loadaudiofromlist("media.txt");
                    break;
                case LOAD2:
                    listoffiles.loadvideofromlist("media.txt");
                    break;
                case ERROR:
                    System.out.println("You gave erroneous input");
                    break;
            }
        }while (choice != Choice.EXIT);

    }




}
