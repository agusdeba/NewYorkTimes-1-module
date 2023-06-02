package ayds.ny1.newyorktimes

import ayds.ny1.newyorktimes.entity.ArtistInformationExternal

interface NYTArtistInfoService {

    fun getArtistInfo(name: String): ArtistInformationExternal?
}