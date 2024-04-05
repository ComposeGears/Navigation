package com.composegears.tiamat

import androidx.compose.runtime.Composable

/**
 * Global in-memory data storage
 */
private val globalDataStorage = NavControllersStorage()

@Composable
internal actual fun rootNavControllersStore(): NavControllersStorage = globalDataStorage

/**
 * Wrap platform content and provides additional info/providable-s
 */
@Composable
internal actual fun <Args> NavDestinationScope<Args>.PlatformContentWrapper(
    content: @Composable NavDestinationScope<Args>.() -> Unit
) {
    content()
}

/**
 * No back button
 */
@Composable
actual fun NavBackHandler(enabled: Boolean, onBackEvent: () -> Unit) = Unit

/**
 * We can not call T::class in @Composable functions,
 *
 * workaround is to call it outside of @Composable via regular inline fun
 */
actual inline fun <reified T : Any> className(): String = T::class.simpleName!!