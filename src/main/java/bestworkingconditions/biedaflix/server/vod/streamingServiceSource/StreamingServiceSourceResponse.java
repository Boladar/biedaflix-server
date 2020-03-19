package bestworkingconditions.biedaflix.server.vod.streamingServiceSource;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.net.URL;

@Data
public class StreamingServiceSourceResponse implements  Serializable{
    private String id;
    private String name;
    private URL path;

    public StreamingServiceSourceResponse(String id, String name,URL path) {
        this.id = id;
        this.name = name;
        this.path = path;
    }
}