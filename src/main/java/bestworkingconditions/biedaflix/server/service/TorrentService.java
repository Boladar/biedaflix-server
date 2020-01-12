package bestworkingconditions.biedaflix.server.service;

import bestworkingconditions.biedaflix.server.model.TorrentInfo;
import bestworkingconditions.biedaflix.server.model.request.EpisodeRequest;

public interface TorrentService {
    void addTorrent(EpisodeRequest request);
    TorrentInfo getTorrentInfo(String name);
    void deleteTorrent(String name, boolean deleteFiles);

}
