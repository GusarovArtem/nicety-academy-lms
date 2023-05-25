package academy.util.change.exception

import academy.util.entity.EntityChangedEvent

class InvalidChangeException extends RuntimeException {

    final EntityChangedEvent changeEvent

    InvalidChangeException(String message, EntityChangedEvent changeEvent) {
        super(message)
        this.changeEvent = changeEvent
    }

}
