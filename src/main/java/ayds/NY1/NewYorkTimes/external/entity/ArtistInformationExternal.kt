package ayds.NY1.NewYorkTimes.external.entity

sealed class ArtistInformationExternal {
    data class ArtistInformationDataExternal (
        val artistName: String,
        var abstract: String?,
        val url: String?,
        var isLocallyStored: Boolean = false
    ) : ArtistInformationExternal()

    object ArtistInformationEmptyExternal : ArtistInformationExternal()
}