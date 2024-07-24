package cz.adastra.piano

class Configuration internal constructor(val collectDomain: String, val site: Int) {
    // Add other properties when needed
    @Suppress("unused")
    class Builder(private var collectDomain: String = "", private var site: Int = 0) {
        fun withCollectDomain(collectDomain: String): Builder = apply {
            this.collectDomain = collectDomain
        }

        fun withSite(site: Int): Builder = apply {
            this.site = site
        }

        fun build(): Configuration = Configuration(
            collectDomain = collectDomain,
            site = site
        )
    }
}
