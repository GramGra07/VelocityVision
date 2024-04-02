package org.gentrifiedApps.velocityvision.moa

import org.gentrifiedApps.velocityvision.moa.builderInterfaces.AssumedDetectionBuilder

class AssumedBuilder(
    override val name: String,
    private val function: Runnable,
) : AssumedDetectionBuilder {
    override fun execute() {
        function.run()
    }
}