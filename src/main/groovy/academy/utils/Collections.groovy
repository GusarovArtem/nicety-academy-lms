package academy.utils

class Collections {

    static boolean isCollectionOrArray(object) {
        [java.util.Collection, Object[]].any {
            it.isAssignableFrom(object.getClass())
        }
    }
}
