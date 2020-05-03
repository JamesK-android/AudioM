package gr.codehub.app;

public class AudioFile extends MediaFile {
    private String filetype;


    public AudioFile(int id, String filename,String duration, String dateofrecord, String description,String filetype) {
        super(id,filename,duration,dateofrecord,description);
        this.filetype = filetype;
    }

    public String getFiletype() {
        return filetype;
    }
}
