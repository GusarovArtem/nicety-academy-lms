package academy.util.change

enum ChangeSource {

    LMS, CLIENT, AUTH, TG

    static Set<ChangeSource> all() {
        values() as Set
    }

}
