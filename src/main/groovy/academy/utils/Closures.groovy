package academy.utils

import academy.utils.props.collector.PropsCollector
import groovy.lang.DelegatesTo.Target
import groovy.transform.stc.ClosureParams
import groovy.transform.stc.FromString
import groovy.util.logging.Slf4j

@Slf4j
class Closures {

    static <T> List<String> collectProps(@Target Class<T> type,
                                         @DelegatesTo(genericTypeIndex = 0) Closure closure) {
        delegate(new PropsCollector(), closure, Closure.DELEGATE_ONLY).collectedProps()
    }

    static <T> T delegate(@Target T delegate,
                          @DelegatesTo
                          @ClosureParams(value = FromString, options = "T") Closure closure,
                          int resolveStrategy = Closure.DELEGATE_FIRST) {
        closure.resolveStrategy = resolveStrategy
        closure.delegate = delegate
        closure(delegate)
        delegate
    }

}
