package academy.util.change

enum ChangeType {

    CREATED, UPDATED, DELETED

    static Set<ChangeType> all() {
        values() as Set
    }

}