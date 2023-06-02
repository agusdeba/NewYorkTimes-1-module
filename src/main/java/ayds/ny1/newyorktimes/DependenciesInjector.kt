package ayds.ny1.newyorktimes

import ayds.ny1.newyorktimes.info.JsonToArtistInfoResolver
import ayds.ny1.newyorktimes.info.NYTArtistInfoServiceImpl
import ayds.ny1.newyorktimes.info.NYTimesAPI
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