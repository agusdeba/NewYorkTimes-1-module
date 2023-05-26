package ayds.NY1.NewYorkTimes.external

import ayds.NY1.NewYorkTimes.external.entity.ArtistInformationExternal

interface NYTArtistInfoService {

    fun getArtistInfo(name: String): ArtistInformationExternal?
}