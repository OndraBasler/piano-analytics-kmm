package cz.adastra.piano

expect object Piano {
    fun init(context: PianoContext, configuration: Configuration)

    fun sendEvent(event: Event)
}
