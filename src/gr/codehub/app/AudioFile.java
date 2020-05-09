package gr.codehub.app;

import java.util.Date;

public class AudioFile extends MediaFile {
    private String filetype;


    public AudioFile(int id, String filename, long duration, Date dateofrecord, String description, String filetype) {
        super(id,filename,duration,dateofrecord,description);
        this.filetype = filetype;
    }

    public String getFiletype() {
        return filetype;
    }

    @Override
    public String toString() {
        return super.toString()+ "AudioFile{" +
                "filetype='" + filetype + '\'' +
                '}';
    }
}
