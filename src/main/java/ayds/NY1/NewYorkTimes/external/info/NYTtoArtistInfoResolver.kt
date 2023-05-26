package ayds.NY1.NewYorkTimes.external.info

import ayds.NY1.NewYorkTimes.external.entity.ArtistInformationExternal
import com.google.gson.Gson
import com.google.gson.JsonObject

interface NYTtoArtistInfoResolver {
    fun getArtistInfoFromExternalData(name: String, serviceData: String?): ArtistInformationExternal?
}

internal class JsonToArtistInfoResolver : NYTtoArtistInfoResolver {

    override fun getArtistInfoFromExternalData(
        name: String,
        serviceData: String?
    ): ArtistInformationExternal? {
        return serviceData.getFirstItem()?.let { item ->
            ArtistInformationExternal.ArtistInformationDataExternal(
                name,
                item.getAbstract(),
                item.getURL()
            )
        } ?: ArtistInformationExternal.ArtistInformationEmptyExternal
    }

    private fun String?.getFirstItem(): JsonObject? {
        val jobj = Gson().fromJson(this, JsonObject::class.java)
        val docs = jobj[DOCS].asJsonArray
        val items = docs[0].asJsonArray
        return items[0].asJsonObject
    }

    private fun JsonObject.getAbstract() = this[ABSTRACT].asString
    private fun JsonObject.getURL() = this[URL].asString


}