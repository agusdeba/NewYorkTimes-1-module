package ayds.ny1.newyorktimes.entity

const val LOGO_URL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVioI832nuYIXqzySD8cOXRZEcdlAj3KfxA62UEC4FhrHVe0f7oZXp3_mSFG7nIcUKhg&usqp=CAU"
sealed class ArtistInformationExternal {
    data class ArtistInformationDataExternal (
        val artistName: String,
        var abstract: String?,
        val url: String?,
        var isLocallyStored: Boolean = false
    ) : ArtistInformationExternal()

    object ArtistInformationEmptyExternal : ArtistInformationExternal()
}