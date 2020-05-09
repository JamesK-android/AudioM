package gr.codehub.app;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class MediaFile {
    private int id;
    private String filename;
    private long duration;
    private Date dateofrecord;
    private String description;
    private String filetype;

    public String getFiletype() {
        return filetype;
    }

    public MediaFile(int id, String filename, long duration, Date dateofrecord, String description) {
        this.id = id;
        this.filename = filename;
        this.duration = duration;
        this.dateofrecord = dateofrecord;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public long getDuration() {
        return duration;
    }

    public Date getDateofrecord() {
        return dateofrecord;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/YYYY");
        return "{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", duration='" + duration + '\'' +
                ", dateofrecord=" + dateformat.format(dateofrecord) +
                ", description='" + description + '\'' +
                '}';
    }

}
