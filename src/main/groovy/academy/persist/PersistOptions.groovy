package academy.persist


import groovy.transform.Immutable

@Immutable
class PersistOptions {

    academy.util.change.ChangeSource changeSource = academy.util.change.ChangeSource.LMS

    boolean logAndIgnoreInvalidChanges = false

    boolean noSaveCall = false

    static PersistOptions standard() {
        new PersistOptions()
    }

}
