package searchengine.searching.storage;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import searchengine.dto.entity.ParentSiteEntity;

@Repository
@Qualifier
public interface ParentSiteRepository extends MongoRepository<ParentSiteEntity, Integer> {
}
