package academy.utils

import com.google.common.base.Splitter
import org.grails.datastore.gorm.GormEntity

import static academy.utils.Collections.nonNulls

class Entities {

    static <T extends GormEntity> Set<T> unique(Collection<T> entities) {
        nonNulls(entities).unique { it.id } as Set
    }

    static <T extends GormEntity> Object oldValue(T entity, String prop) {
        def propsChain = Splitter.on('.').splitToList(prop)
        def current
        def value = entity
        propsChain.each {
            current = it
            value = value?.getPersistentValue(current)
        }
        value
    }

}
