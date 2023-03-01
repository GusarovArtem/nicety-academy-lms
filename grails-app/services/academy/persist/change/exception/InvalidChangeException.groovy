package academy.persist.change.exception

import academy.persist.event.EntityChangedEvent

class InvalidChangeException extends RuntimeException {

    final EntityChangedEvent changeEvent

    InvalidChangeException(String message, EntityChangedEvent changeEvent) {
        super(message)
        this.changeEvent = changeEvent
    }

}
