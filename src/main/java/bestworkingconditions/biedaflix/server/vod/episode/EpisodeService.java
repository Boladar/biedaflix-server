package bestworkingconditions.biedaflix.server.vod.episode;

import bestworkingconditions.biedaflix.server.file.service.FileService;
import bestworkingconditions.biedaflix.server.file.service.GenericFileHandlingServiceImpl;
import bestworkingconditions.biedaflix.server.vod.episode.model.Episode;
import bestworkingconditions.biedaflix.server.vod.episode.model.VideoQuality;
import bestworkingconditions.biedaflix.server.vod.episode.model.request.EpisodeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Locale;


@Service
public class EpisodeService extends GenericFileHandlingServiceImpl<Episode,EpisodeRepository> {

    private final EpisodeMapper mapper;

    @Autowired
    public EpisodeService(EpisodeRepository repository, FileService fileService, EpisodeMapper mapper) {
        super(repository, fileService);
        this.mapper = mapper;
    }

    public Episode setSubtitles(String id, Locale locale, MultipartFile file){
        return setFileReference(id,file,(episode, resource) -> episode.getSubtitles().put(locale.getLanguage(),resource));
    }

    public Episode setVideo(String id, VideoQuality quality, MultipartFile file){
        return setFileReference(id,file,(episode, resource) -> episode.getVideos().put(quality,resource));
    }

    public Episode fetchAndUpdate(String id, EpisodeRequest request){
        Episode e = findById(id);
        return repository.save(mapper.updateEpisodeFromEpisodeRequest(request,e));
    }

    public void delete(Episode episode){
        fileService.deleteFiles(episode.getVideos().values());
        fileService.deleteFiles(episode.getSubtitles().values());
        fileService.deleteFiles(episode.getThumbs());
    }

    @Override
    public Episode fetchAndUpdate(String id, Episode resource) {
        return repository.save(mapper.updateEpisodeFromEpisode(resource,findById(id)));
    }

    @Override
    public void deleteById(String id) {
        delete(findById(id));
    }
}
