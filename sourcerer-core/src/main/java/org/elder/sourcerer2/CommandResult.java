package org.elder.sourcerer2;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * The result of a successfully application of a command against the current state of an aggregate.
 */
public class CommandResult<TEvent> {
    private final StreamId aggregateId;
    private final StreamVersion newVersion;
    private final ImmutableList<? extends TEvent> events;

    public CommandResult(
            final StreamId aggregateId,
            final StreamVersion newVersion,
            final ImmutableList<? extends TEvent> events) {
        Preconditions.checkNotNull(aggregateId);
        this.newVersion = newVersion;
        this.aggregateId = aggregateId;
        this.events = events;
    }

    public CommandResult(
            final StreamId aggregateId,
            final StreamVersion newVersion,
            final List<? extends TEvent> events) {
        this(aggregateId, newVersion, ImmutableList.copyOf(events));
    }

    /**
     * Gets the id of the aggregate that was operated on.
     */
    public StreamId getAggregateId() {
        return aggregateId;
    }

    /**
     * Gets the new version of the aggregate, after the events from the command were applied, e.g.
     * the position marking the point in the event stream where all of the events have been applied.
     * This may be null in the cases where the current version is unknown, e.g. a no-op operation.
     */
    public StreamVersion getNewVersion() {
        return newVersion;
    }

    /**
     * Gets the new commands applied by this event.
     */
    public ImmutableList<? extends TEvent> getEvents() {
        return events;
    }
}
