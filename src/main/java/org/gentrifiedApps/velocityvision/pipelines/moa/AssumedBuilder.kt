package org.gentrifiedApps.velocityvision.pipelines.moa

import org.gentrifiedApps.velocityvision.pipelines.moa.builderInterfaces.AssumedDetectionBuilder

class AssumedBuilder(
    override val name: String,
    private val function: Runnable,
) : AssumedDetectionBuilder {
    override fun execute() {
        function.run()
    }
}