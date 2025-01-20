package searchengine.searching.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import searchengine.dto.entity.ModelSite;
import searchengine.dto.entity.ModelWord;
import searchengine.dto.model.TotalSearchResult;
import searchengine.dto.model.ModelSearch;
import searchengine.dto.statistics.StatisticsResponse;
import searchengine.searching.processing.AppManagementImpl;

import java.util.List;

@Service
@Slf4j
public final class ProjectService implements AppServiceImpl {

    private final AppManagementImpl management;

    @Autowired
    public ProjectService(AppManagementImpl management) {
        this.management = management;
    }

    @Override
    public void startIndexing() {
        log.info("Init method startIndexing in data base. {}", this.getClass().getName());
        management.startIndexing();
    }

    @Override
    public void stopIndexing() {
        log.info("Init method stopIndexing in data base. {}", this.getClass().getName());
        management.stopIndexing();
    }

    @Override
    public void addSite(String url, String name) {
        log.info("Init method addSite in data base. {}", this.getClass().getName());
        management.addSite(url, name);
    }

    @Override
    public TotalSearchResult findByWord(ModelSearch modelSearch) {
        log.info("Init method findByWord in data base. {}", this.getClass().getName());
        return management.findByWord(modelSearch);
    }

    @Override
    public StatisticsResponse getStatistics() {
        log.info("Init method getStatistics in data base. {}", this.getClass().getName());
        return management.getStatistics();
    }

    @Override
    public List<ModelSite> showAllSites() {
        log.info("Init method showAllSites in data base. {}", this.getClass().getName());
        return management.showAllSites();
    }

    @Override
    public List<ModelWord> showAllWords() {
        log.info("Init method showAllWords in data base. {}", this.getClass().getName());
        return management.showAllWords();
    }
}
