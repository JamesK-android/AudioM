package gr.codehub.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class AllFiles {
    

    private ArrayList<MediaFile> mediafiles = new ArrayList<>();

    public void displayFiles(){
        mediafiles.forEach(System.out::println);
    }

    public void addFile(MediaFile md){
        mediafiles.add(md);
    }

    public int displaynumoffiles(){ return mediafiles.size();
    }



    public void savetolist(String filename)   {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/YYYY");
        try {
            PrintWriter printWriter = new PrintWriter(new File(filename));
            for (MediaFile mfile : mediafiles) {
                printWriter.println(mfile.getId() +"," + mfile.getFilename() + "," + mfile.getDuration() + ","
                + dateformat.format(mfile.getDateofrecord()) + "," + mfile.getDescription() + "," +mfile.getFiletype());
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file cannot be saved");
        }

    }

    public void loadfromlist(String filename){
        mediafiles.clear();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try{
            Scanner scanner = new Scanner(new File(filename));
            String line = scanner.nextLine();
            String[] words = line.split(",");
            if(words[5].equals("avi") || words[5].equals("wmv") || words[5].equals("mp4")){
                MediaFile mdfile = new VideoFile(
                        Integer.parseInt(words[0]),
                        words[1],
                        Long.parseLong(words[2]),
                        new SimpleDateFormat("dd/MM/yyyy").parse(words[3]),
                        words[4],
                        words[5]);
                mediafiles.add(mdfile);
            }
            if(words[5].equals("mp3") || words[5].equals("wma") || words[5].equals("wav")){
                MediaFile mdfile = new AudioFile(
                        Integer.parseInt(words[0]),
                        words[1],
                        Long.parseLong(words[2]),
                        new SimpleDateFormat("dd/MM/YYYY").parse(words[3]),
                        words[4],
                        words[5]);
                mediafiles.add(mdfile);
            }
        }catch (Exception e){
        }
    }



    public void SearchFile() {
        System.out.println("You are searching for: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/YYYY");
        Date ndate = null;
        String ndstr = "";
        try {
            ndate = dateformat.parse(name);
            ndstr = dateformat.format(ndate);
        } catch (Exception e) {
        }
        String simpledate;
        for (MediaFile all : mediafiles) {
            simpledate = dateformat.format(all.getDateofrecord());
            if (all.getFilename().contains(name) || all.getDescription().contains(name)
                    || String.valueOf(all.getDuration()).contains(name)
                    || simpledate.contains(ndstr)
                    || all.getFiletype().contains(name)) {
                System.out.println("The macthing file is :");
                System.out.println(all);
                ;
            } else {
                System.out.println("File does not exist");
            }
        }
    }

    public void removeMedia(){
        System.out.println("Give index: ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        if (index>=0 && index < mediafiles.size()){
            mediafiles.remove(index);
        }
    }

    public long totalDuration(){
        long sum ;
        sum  = mediafiles.stream()
                .map(p -> p.getDuration())
                .reduce(0l, (a,b) -> a+b);
     return  sum  ;
    }

}
