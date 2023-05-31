package ayds.NY1.NewYorkTimes.external

import ayds.NY1.NewYorkTimes.external.info.JsonToArtistInfoResolver
import ayds.NY1.NewYorkTimes.external.info.NYTArtistInfoServiceImpl
import ayds.NY1.NewYorkTimes.external.info.NYTimesAPI
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object DependenciesInjector {
    private const val NYTIMES_URL = "https://api.nytimes.com/svc/search/v2/"

    fun init(): NYTArtistInfoService {
        val nyToArtisInfoResolver = JsonToArtistInfoResolver()
        val newYorkTimesRetrofit = Retrofit.Builder()
            .baseUrl(NYTIMES_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        val newYorkTimesAPI: NYTimesAPI = newYorkTimesRetrofit.create(NYTimesAPI::class.java)
        return NYTArtistInfoServiceImpl(nyToArtisInfoResolver, newYorkTimesAPI)
    }
}