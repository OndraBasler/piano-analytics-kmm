package cz.adastra.piano

import io.piano.android.analytics.PianoAnalytics
import io.piano.android.analytics.model.Property
import io.piano.android.analytics.model.PropertyName
import io.piano.android.analytics.Configuration as PConfiguration
import io.piano.android.analytics.model.Event as PEvent

@Suppress("unused")
actual object Piano {
    actual fun init(context: PianoContext, configuration: Configuration) {
        val config = PConfiguration.Builder(
            collectDomain = configuration.collectDomain,
            site = configuration.site
        ).build()

        PianoAnalytics.init(context.applicationContext, config)
    }

    actual fun sendEvent(event: Event) {
        val properties = event.properties.mapNotNull { (key, value) ->
            val propertyName = PropertyName(key)
            when (value) {
                null -> null
                is Int -> Property(propertyName, value)
                is Long -> Property(propertyName, value)
                is String -> Property(propertyName, value)
                is Double -> Property(propertyName, value)
                is Boolean -> Property(propertyName, value)
                else -> error("property type is not supported yet")
            }
        }
        PianoAnalytics.getInstance().sendEvents(
            PEvent.Builder(event.name)
                .properties(properties)
                .build()
        )
    }
}
