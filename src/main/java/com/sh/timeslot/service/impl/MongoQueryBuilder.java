package com.sh.timeslot.service.impl;

import com.sh.timeslot.model.MongoQueryField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Slf4j
public class MongoQueryBuilder<T> {

    private Query query;
    private T searchParam;

    private static final BiFunction<String, Set, Criteria> getWhere = (col, values) -> {
        if (values.size() == 1) return where(col).is(values.iterator().next());
        return where(col).in(values);
    };


    /**
     * Constructor
     *
     * @param searchParams
     */
    public MongoQueryBuilder(T searchParams) {
        this.searchParam = searchParams;
        this.query =  new Query() ;

    }



    /**
     * MongoDb Query Builder
     *
     * @return {@link Query}
     */
    public Query build() {
        for (Method f : searchParam.getClass().getMethods()) {
            try {

                if ( f.getAnnotation(MongoQueryField.class) !=   null){

                    setCriteria(f.getName(), f.invoke(searchParam )).ifPresent(query::addCriteria);
                }

            }  catch (InvocationTargetException | IllegalAccessException e) {
                log.error(e.getMessage());
            }
        }
        log.debug(query.toString());
        return query;

    }



    /**
     * Generate {@link Criteria} if values not empty , otherwise return empty optional
     *
     * @param columnName Trip entity column name
     * @param value      search value
     * @return Optional of {@link Criteria}
     */
    private Optional<Criteria> setCriteria(String columnName, Object value) {
        if (value == null) return Optional.empty();
        if (columnName.matches("^(get).*$")) columnName = columnName.substring(3);
        return Optional.of(where(columnName).is(value));
    }

    /**
     * Generate {@link Criteria} if values not empty , otherwise return empty optional
     *
     * @param columnName Trip entity column name
     * @param values     set of  search value
     * @return Optional of {@link Criteria}
     */
    private Optional<Criteria> setCriteria(String columnName, Set values) {
        if (values.isEmpty()) return Optional.empty();
        return Optional.of(getWhere.apply(columnName, values));
    }
}
