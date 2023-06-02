package ayds.ny1.newyorktimes.info

import ayds.ny1.newyorktimes.NYTArtistInfoService
import ayds.ny1.newyorktimes.entity.ArtistInformationExternal
import retrofit2.Response

class NYTArtistInfoServiceImpl(
    private val NYTtoArtistInfo: NYTtoArtistInfoResolver,
    private val newYorkTimesAPI : NYTimesAPI
) : NYTArtistInfoService {

    override fun getArtistInfo(name: String): ArtistInformationExternal? {
        val callResponse = getArtistInfoFromService(name)
        return NYTtoArtistInfo.getArtistInfoFromExternalData(name, callResponse.body())
    }

    private fun getArtistInfoFromService(artistName: String): Response<String> {
        return newYorkTimesAPI.getArtistInfo(artistName)
    }
}
