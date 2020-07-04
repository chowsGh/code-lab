package top.clydezhou.lab.demo.springdata.mongodb;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import com.mongodb.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.util.StopWatch;
import top.clydezhou.lab.demo.springdata.mongodb.entity.Acl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clyde
 * @date 2020-06-22 23:20
 */
public class MongoApp {

    private static final Logger LOG = LoggerFactory.getLogger(MongoApp.class);

    public static void main(String[] args) {
        check();
    }

    private static void check() {
        // 配置线程池大小可以在url中使用 You can configure connection pool size via MongoDb uri parameters. Details - https://stackoverflow.com/a/50407284/6629515
        // com.mongodb.MongoClientSettings.Builder.applyConnectionString
        //  MONGODB_URI (mongo):   mongodb://user:password@localhost:27017/users_db?ssl=true&maxPoolSize=10&readPreference=primaryPreferred&replicaSet=Dev-shard-0&authSource=admin

        MongoOperations mongoOps = new MongoTemplate(MongoClients.create("mongodb://172.16.1.100:27017"), "mongotest");
        for (int i = 0; i < 10; i ++) {
            long start = System.currentTimeMillis();
                    List<Acl> one = mongoOps.find(new Query(where("groupId").is("group-" + 1)), Acl.class);
//            FolderAcl one = mongoOps.findOne(new Query(where("groupId").is("group-" + i).and("userId").is("user-" + i)), FolderAcl.class);
            long end = System.currentTimeMillis();
            System.out.println(end - start);
            System.out.println(one.size());
        }
    }

    private static void insertData() {
        StopWatch sw = new StopWatch();
        sw.start();
        MongoOperations mongoOps = new MongoTemplate(MongoClients.create("mongodb://172.16.1.100:27017"), "mongotest");
        IndexOperations indexOperations = mongoOps.indexOps(Acl.class);
        indexOperations.ensureIndex(new Index("userId", Sort.Direction.ASC));
        indexOperations.ensureIndex(new Index("groupId", Sort.Direction.ASC));
        for (int i = 0; i < 1000; i++) {
            for (int k = 0; k < 100; k++) {
                List<Acl> l = new ArrayList<>();
                for (int j = 0; j < 100; j++) {
                    Acl folderAcl = new Acl();
                    folderAcl.setGroupId("group-" + k);
                    folderAcl.setUserId("user-" + j);
                    folderAcl.setRoleId("role-" + i);
                    l.add(folderAcl);
                }
                mongoOps.insertAll(l);
                System.out.println(i + "-finish " + k);
            }
        }
        sw.stop();
        System.out.println(sw.shortSummary());
    }

    static void dropCollection() {
        MongoOperations mongoOps = new MongoTemplate(MongoClients.create("mongodb://172.16.1.100:27017"), "mongotest");
        mongoOps.dropCollection(Acl.class);
    }
}
