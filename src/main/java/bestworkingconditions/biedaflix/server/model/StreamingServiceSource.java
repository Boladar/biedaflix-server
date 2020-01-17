package bestworkingconditions.biedaflix.server.model;

import org.springframework.content.commons.annotations.ContentId;
import org.springframework.content.commons.annotations.MimeType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.net.URI;

@Document(collection = "streamingServices")
public class StreamingServiceSource extends FileResource{

    @Id
    private String id;
    private String name;

    public StreamingServiceSource() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public URI getResourceURI() {
        return null;
    }

    @Override
    public String getFilePath() {
        return  "/" + getClass().getSimpleName() + "/" + name ;
    }
}
