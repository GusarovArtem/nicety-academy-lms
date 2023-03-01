package academy.utils

import academy.utils.constructs.Looper

class Collections {

    static Looper loop(long maxRuns = 10_000, Closure code) {
        new Looper(maxRuns: maxRuns, code: code)
    }

    static boolean notEmpty(Collection collection) {
        collection && !collection.isEmpty()
    }

    static <T> Collection<T> nonNulls(Collection<T> collection) {
        collection.findAll { it != null }
    }

    static boolean isCollectionOrArray(object) {
        [java.util.Collection, Object[]].any {
            it.isAssignableFrom(object.getClass())
        }
    }

    static boolean isClassIterable(Class clazz) {
        [Iterable, Object[]].any { it.isAssignableFrom(clazz) }
    }
}
