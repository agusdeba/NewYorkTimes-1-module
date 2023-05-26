# NewYorkTimes-module
Para importar el submódulo, se debe ejecutar el siguiente comando en la línea de comandos (CMD) mientras se encuentra ubicado en la carpeta del proyecto en la ruta ".../libs".

git submodule add https://https://github.com/agusdeba/NewYorkTimes-1-module NYTExternal

Utilización del submodulo
Para obtener una instancia del servicio externo, es necesario realizar una llamada al inyector utilizando la función "init()", como se muestra en el siguiente ejemplo:

val nytService = NYTInjector.init()
Una vez obtenida la instancia del servicio, es posible acceder a la obtención de información relacionada con artistas. Para obtener un objeto asociado a un artista en particular, se debe llamar a la función "getArtistInfo()" de la clase "NYTArtistInfoService" como se ejemplifica a continuación:

val nytArtistInfo = nytService.getArtistInfo(artistName)
La función getArtistInfo() recibe como parámetro un string con el nombre del artista. En caso de que se encuentre el artista correspondiente, se devuelve un objeto de tipo "ArtistInformationDataExternal" que contiene la información del mismo. De lo contrario, se retorna "ArtistInformationEmptyExternal".

"nytArtistInfo" contiene lo siguiente:

artistName (string): Representa el nombre del artista.
abstarct (string): Contiene información sobre el artista.
url (string): Almacena la URL de la página de New York Times asociada al artista.
isLocaledStored (boolean): Es un indicador que especifica si el artista se encuentra en la base de datos.