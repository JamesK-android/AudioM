package gr.codehub.app;

public abstract class MediaFile {
    private int id;
    private String filename;
    private String duration;
    private String dateofrecord;
    private String description;

    public MediaFile(int id, String filename, String duration, String dateofrecord, String description) {
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

    public String getDuration() {
        return duration;
    }

    public String getDateofrecord() {
        return dateofrecord;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "AudioFile{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", duration='" + duration + '\'' +
                ", dateofrecord=" + dateofrecord +
                ", description='" + description + '\'' +
                '}';
    }

}
