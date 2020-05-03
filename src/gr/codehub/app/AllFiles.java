package gr.codehub.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AllFiles {

    private ArrayList<MediaFile> mediafiles = new ArrayList<>();

    public void displayFiles(){
        mediafiles.forEach(System.out::println);
    }

    public void addFile(MediaFile md){
        mediafiles.add(md);
    }



    public void savetolist(String filename)   {

        try {
            PrintWriter printWriter = new PrintWriter(new File(filename));
            for (MediaFile mfile : mediafiles) {
                printWriter.println(mfile.getId() +"," + mfile.getFilename() + "," + mfile.getDuration() + ","
                + mfile.getDateofrecord() + "," + mfile.getDescription() + ",");
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file cannot be saved");
        }

    }


    //MediaFile(int id, String filename, String duration, String dateofrecord, String description)
    public void loadvideofromlist(String filename){
        mediafiles.clear();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] words = line.split(",");
                VideoFile mdfile = new VideoFile(
                        Integer.parseInt(words[0]),
                        words[1],
                        words[2],
                        words[3],
                        words[4],
                        words[5]);
                mediafiles.add(mdfile);
            }
        } catch (Exception e) {
        }
    }

    public void loadaudiofromlist(String filename){
        mediafiles.clear();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] words = line.split(",");
                AudioFile mdfile = new AudioFile(
                        Integer.parseInt(words[0]),
                        words[1],
                        words[2],
                        words[3],
                        words[4],
                        words[5]);
                mediafiles.add(mdfile);
            }
        } catch (Exception e) {
        }
    }


    public void SearchFile(){
        System.out.println("Give the name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for(MediaFile all: mediafiles){
            if(name == all.getFilename()){
                System.out.println("The file exists");
                all.toString();
            }
        }
    }

}
