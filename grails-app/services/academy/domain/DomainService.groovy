package academy.domain

import grails.gorm.transactions.Transactional
import org.grails.datastore.gorm.GormEntity
import org.grails.datastore.mapping.model.PersistentEntity
import org.grails.datastore.mapping.model.types.Association

import java.util.function.Supplier
import static academy.util.construct.Collections.isClassIterable

class DomainService {

    def grailsDomainClassMappingContext

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

    Set<String> allPersistentProperties(Class<? extends GormEntity> entityClass) {
        persistentEntity(entityClass).persistentProperties.collect { it.name }
    }

    PersistentEntity persistentEntity(Class<? extends GormEntity> entityClass) {
        grailsDomainClassMappingContext.getPersistentEntity(entityClass.name)
    }


    def <T extends GormEntity> List<Association> associations(Class<T> entityClass) {
        persistentEntity(entityClass).associations
    }

    def <T extends GormEntity> List<Association> ownersAssociations(Class<T> entityClass) {
        associations(entityClass).collect { it.inverseSide }.findAll { it?.owningSide }
    }

    def addToOwnerAssociationIfNecessary(entity, Association association) {
        changeOwnerAssociationIfNecessary(entity, association, "addTo${association.capitilizedName}")
    }

    def removeFromOwnerAssociationIfNecessary(entity, Association association) {
        changeOwnerAssociationIfNecessary(entity, association, "removeFrom${association.capitilizedName}")
    }

    private static changeOwnerAssociationIfNecessary(entity, Association association, String methodName) {
        if (isClassIterable(association.type)) {
            def owningEntity = entity."${association.referencedPropertyName}"
            owningEntity."${methodName}"(entity)
        }
    }

}
