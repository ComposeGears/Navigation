package content.examples.koin

import org.koin.core.context.startKoin

object KoinLib {
    fun start() {
        startKoin {
            modules(koinIntegrationModule)
        }
    }
}