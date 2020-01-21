package bestworkingconditions.biedaflix.server.repository;

import bestworkingconditions.biedaflix.server.model.Episode;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EpisodeRepository extends MongoRepository<Episode,String> {
    List<Episode> findAllBySeriesId(String seriesId);
}
