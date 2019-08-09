package com.sh.timeslot.service.impl;

import com.sh.timeslot.common.ServiceConfig;
import com.sh.timeslot.db.entity.Base;
import com.sh.timeslot.db.entity.SequenceId;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;
import java.util.Objects;


public class BaseService<T extends com.sh.timeslot.db.entity.Base > {
    ServiceConfig serverConfig;
    MongoTemplate template;


    public BaseService(ServiceConfig serverConfig , MongoTemplate template) {
        this.serverConfig = serverConfig;
        this.template= template;
    }


    protected T insert(T t){
        return template.insert(t);
    }


    protected List<? extends Base> find(T t){
        MongoQueryBuilder<T> requestMongoService = new MongoQueryBuilder<T>(t);
        Query query = requestMongoService.build();
        return template.find(query, t.getClass());
    }

    /**
     * Increase sequence id and return result.
     *
     * @param key sequence key
     * @return increased result
     */
    public synchronized long getIncreasedSequenceId(String key) {
        SequenceId seg =template.findAndModify(new Query(Criteria.where("_id").is(key)),
                        new Update().inc("seq", 1),
                        new FindAndModifyOptions().returnNew(true).upsert(true),
                        SequenceId.class);

        return Objects.isNull(seg)? 1 :  seg.getSeq();

    }


}
