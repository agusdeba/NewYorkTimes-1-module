package ayds.NY1.NewYorkTimes.external.info

import ayds.NY1.NewYorkTimes.external.info.NYTArtistInfoService
import ayds.NY1.NewYorkTimes.external.entity.ArtistInformationExternal
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
