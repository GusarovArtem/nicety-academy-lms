package academy.persist.change

enum ChangeType {

    CREATED, UPDATED, DELETED

    static Set<ChangeType> all() {
        values() as Set
    }

}