package academy.persist

import academy.persist.change.ChangeSource
import groovy.transform.Immutable

@Immutable
class PersistOptions {

    ChangeSource changeSource = ChangeSource.LMS

    boolean logAndIgnoreInvalidChanges = false

    boolean noSaveCall = false

    static PersistOptions standard() {
        new PersistOptions()
    }

}
