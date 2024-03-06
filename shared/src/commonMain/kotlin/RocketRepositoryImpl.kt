class RocketRepositoryImpl : RocketRepository {
    private val rocketComponent = RocketComponent()
    override suspend fun getDateOfLastSuccessfulLaunchPhrase(): String {
        return rocketComponent.launchPhrase()
    }
}