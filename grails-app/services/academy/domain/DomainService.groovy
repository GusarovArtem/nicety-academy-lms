package academy.domain

import grails.gorm.transactions.Transactional
import org.grails.datastore.gorm.GormEntity

import java.util.function.Supplier

class DomainService {

    @Transactional
    <T extends GormEntity> T createIfNotExists(Supplier<T> existingFinder, Supplier<T> newInstance) {
        T model = existingFinder.get()
        if (!model) {
            model = newInstance.get()
            model.save()
        }
        model
    }

    @Transactional
    List createAllIfNotExist(Supplier existingFinder, List newInstances) {
        newInstances.findResults {
            newInstance -> createIfNotExists(existingFinder, newInstance)
        }
    }

}
