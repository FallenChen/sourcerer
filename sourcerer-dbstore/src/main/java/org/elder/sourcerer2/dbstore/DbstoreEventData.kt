package org.elder.sourcerer2.dbstore

import org.elder.sourcerer2.EventId
import org.elder.sourcerer2.StreamId

/**
 * Generic representation of data to store for a particular event.
 */
data class DbstoreEventData(
        /**
         * The id of the stream that this event relates to. This id is unique only within a
         * particular repository, e.g. only across events describing the same type of aggregate.
         */
        val streamId: StreamId,

        /**
         * The category of events that this event is representing (e.g. the type of aggregates that it represents).
         */
        val category: String,

        /**
         * Gets a globally unique id for this event. This will be unique across all events and all
         * repositories.
         */
        val eventId: EventId,

        /**
         * The application provided type of this particular event.
         */
        val eventType: String,

        /**
         * The event data itself, stored as a JSON string.
         */
        val data: String,

        /**
         * Other information about the event as provided when the event was persisted.
         */
        val metadata: String
) {
        fun getShard(maxShards: Int): String? {

                
        }
}
