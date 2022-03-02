package io.sentry;

import io.sentry.protocol.SentryTransaction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * An Event Processor that may mutate or drop an event. Runs for SentryEvent or SentryTransaction
 */
public interface EventProcessor {

  /**
   * May mutate or drop a SentryEvent
   *
   * @param event the SentryEvent
   * @param hint the Hint
   * @return the event itself, a mutated SentryEvent or null
   */
  @Nullable
  default SentryEvent process(@NotNull SentryEvent event, @Nullable Object hint) {
    return event;
  }

  /**
   * May mutate or drop a SentryTransaction
   *
   * @param transaction the SentryTransaction
   * @param hint the Hint
   * @return the event itself, a mutated SentryTransaction or null
   */
  @Nullable
  default SentryTransaction process(@NotNull SentryTransaction transaction, @Nullable Object hint) {
    return transaction;
  }
}