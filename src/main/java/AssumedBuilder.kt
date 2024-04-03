import builderInterfaces.AssumedDetectionBuilder

class AssumedBuilder(
    override val name: String,
    private val function: Runnable,
) : AssumedDetectionBuilder {
    override fun execute() {
        function.run()
    }
}