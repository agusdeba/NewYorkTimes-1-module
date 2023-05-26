package ayds.NY1.NewYorkTimes.external

import ayds.NY1.NewYorkTimes.external.info.NYTArtistInfoServiceImpl
import ayds.NY1.NewYorkTimes.external.entity.ArtistInformationExternal

interface ArtistInfoExternalStorage {
    fun getArtistInfo(name: String): ArtistInformationExternal?
}

class ArtistInfoExternalStorageImpl(private val nytArtistInfoService: NYTArtistInfoServiceImpl) :
    ArtistInfoExternalStorage {

    override fun getArtistInfo(name: String): ArtistInformationExternal? {
        return nytArtistInfoService.getArtistInfo(name)
    }
}