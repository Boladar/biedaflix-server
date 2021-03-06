package bestworkingconditions.biedaflix.server.identity.role;

import bestworkingconditions.biedaflix.server.file.FileResource;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Document(collection = "roles")
@Data
@NoArgsConstructor
public class Role implements GrantedAuthority {

    private static final  String prefix = "ROLE_";

    @Id
    private String id;

    private FileResource image;

    @NotBlank
    private String name;
    private List<Operation> allowedOperations = new ArrayList<>();

    public Role(String id) {
        this.id = id;
    }

    public Role(@NotBlank String name, List<Operation> allowedOperations) {
        this.name = name;
        this.allowedOperations = allowedOperations;
    }

    @Override
    public String getAuthority() {
        return prefix + name;
    }

    public Collection<? extends GrantedAuthority> getAllowedOperations(){
        return allowedOperations;
    }
}
