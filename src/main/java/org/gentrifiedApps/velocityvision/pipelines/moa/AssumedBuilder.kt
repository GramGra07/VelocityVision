package org.gentrifiedApps.velocityvision.pipelines.moa

import org.gentrifiedApps.velocityvision.pipelines.moa.builderInterfaces.AssumedDetectionBuilder

class AssumedBuilder(
    override val name: String,
    private val function: Runnable?,
) : AssumedDetectionBuilder {
    constructor(function: Runnable) : this("Assumed", function)
    constructor(name: String) : this(name, null)
    constructor() : this("Assumed", null)
    override fun execute() {
        function?.run()
    }
}