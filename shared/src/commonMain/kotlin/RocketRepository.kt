interface RocketRepository {
    suspend fun getDateOfLastSuccessfulLaunchPhrase(): String
}