package gr.codehub.app;

public class VideoFile extends MediaFile {

    private String filetype;


    public VideoFile(int id, String filename,String duration, String dateofrecord, String description, String filetype) {
        super(id,filename,duration,dateofrecord,description);
        this.filetype = filetype;
    }

    public String getFiletype() {
        return filetype;
    }

    @Override
    public String toString() {
        return super.toString()+"VideoFile{" +
                "filetype='" + filetype + '\'' +
                '}';
    }
}
