package academy.persist.change

enum ChangeSource {

    LMS, CLIENT, AUTH, TG

    static Set<ChangeSource> all() {
        values() as Set
    }

}
