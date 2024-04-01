package com.codercampy.networkingclass

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.codercampy.networkingclass.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader
import java.io.StringWriter
import java.io.Writer

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

//    private val json1 = "{  " +
//            "    \"employee\": {  " +
//            "        \"name\":       \"sonoo\",   " +
//            "        \"salary\":      56000,   " +
//            "        \"married\":    true  " +
//            "    }  " +
//            "}  "

//    private val json2 = "[\n" +
//            "  {\n" +
//            "    \"name\": \"Adeel Solangi\",\n" +
//            "    \"language\": \"Sindhi\",\n" +
//            "    \"id\": \"V59OF92YF627HFY0\",\n" +
//            "    \"bio\": \"Donec lobortis eleifend condimentum. Cras dictum dolor lacinia lectus vehicula rutrum. Maecenas quis nisi nunc. Nam tristique feugiat est vitae mollis. Maecenas quis nisi nunc.\",\n" +
//            "    \"version\": 6.1\n" +
//            "  },\n" +
//            "  {\n" +
//            "    \"name\": \"Afzal Ghaffar\",\n" +
//            "    \"language\": \"Sindhi\",\n" +
//            "    \"id\": \"ENTOCR13RSCLZ6KU\",\n" +
//            "    \"bio\": \"Aliquam sollicitudin ante ligula, eget malesuada nibh efficitur et. Pellentesque massa sem, scelerisque sit amet odio id, cursus tempor urna. Etiam congue dignissim volutpat. Vestibulum pharetra libero et velit gravida euismod.\",\n" +
//            "    \"version\": 1.88\n" +
//            "  },\n" +
//            "  {\n" +
//            "    \"name\": \"Aamir Solangi\",\n" +
//            "    \"language\": \"Sindhi\",\n" +
//            "    \"id\": \"IAKPO3R4761JDRVG\",\n" +
//            "    \"bio\": \"Vestibulum pharetra libero et velit gravida euismod. Quisque mauris ligula, efficitur porttitor sodales ac, lacinia non ex. Fusce eu ultrices elit, vel posuere neque.\",\n" +
//            "    \"version\": 7.27\n" +
//            "  },\n" +
//            "  {\n" +
//            "    \"name\": \"Abla Dilmurat\",\n" +
//            "    \"language\": \"Uyghur\",\n" +
//            "    \"id\": \"5ZVOEPMJUI4MB4EN\",\n" +
//            "    \"bio\": \"Donec lobortis eleifend condimentum. Morbi ac tellus erat.\",\n" +
//            "    \"version\": 2.53\n" +
//            "  },\n" +
//            "  {\n" +
//            "    \"name\": \"Adil Eli\",\n" +
//            "    \"language\": \"Uyghur\",\n" +
//            "    \"id\": \"6VTI8X6LL0MMPJCC\",\n" +
//            "    \"bio\": \"Vivamus id faucibus velit, id posuere leo. Morbi vitae nisi lacinia, laoreet lorem nec, egestas orci. Suspendisse potenti.\",\n" +
//            "    \"version\": 6.49\n" +
//            "  }]"

//    fun getJsonAsString(): String {
//        val raw = resources.openRawResource(R.raw.person_data)
//        val writer: Writer = StringWriter()
//        val buffer = CharArray(1024)
//        raw.use { rawData ->
//            val reader: Reader = BufferedReader(InputStreamReader(rawData, "UTF-8"))
//            var n: Int
//            while (reader.read(buffer).also { n = it } != -1) {
//                writer.write(buffer, 0, n)
//            }
//        }
//        return writer.toString()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://jsonplaceholder.typicode.com/todos"

// Request a string response from the provided URL.
        val stringRequest = JsonArrayRequest(
            Request.Method.GET,
            url,
            null,
            { response ->

            },
            {
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            })

// Add the request to the RequestQueue.
        queue.add(stringRequest)

//        val gson = Gson()

//        val dataStr = getJsonAsString()

//        val listType = object : TypeToken<List<Person>>() {}.type
//        val list = gson.fromJson<List<Person>>(dataStr, listType)

//        val arr = JSONArray(dataStr)
//        for (i in 0 until arr.length()) {
//            val person = gson.fromJson(arr.getJSONObject(i).toString(), Person::class.java)
//
//
////            val t = arr.getJSONObject(i)
////            val name = t.getString("name")
////            val language = t.getString("language")
////            val id = t.getString("id")
////            val bio = t.getString("bio")
////            val version = t.getDouble("version")
////
////            val person = Person(name, language, id, bio, version)
//
//            list.add(person)
//        }


//        val obj = JSONObject(json1)
//        val employee = obj.getJSONObject("employee")
//        val name = employee.getString("name")
//        val salary = employee.getInt("salary")
//        val married = employee.getBoolean("married")

//        val arr = JSONArray(json2)
//
//        var text = ""
//
//        for (i in 0 until arr.length()) {
//            val t = arr.getJSONObject(i)
//            val name = if (t.has("name")) {
//                t.getString("name")
//            } else ""
//            val language = try {
//                t.getString("language")
//            } catch (e: Exception) {
//                ""
//            }
//            val id = t.getString("id")
//            val bio = t.getString("bio")
//            val version = t.getDouble("version")
//
//            text += "\n" +
//                    """
//                name - $name,
//                language - $language,
//                id - $id,
//                bio - $bio,
//                version - $version
//            """.trimIndent()
//        }

//        val parent = JSONObject(SampleData.JSON1)
//        val glossary = parent.getJSONObject("glossary")
//        val title = glossary.getString("title")
//        val glossDiv = glossary.getJSONObject("GlossDiv")
//        val title2 = glossDiv.getString("title")
//        val glossList = glossDiv.getJSONObject("GlossList")
//        val glossEntry = glossList.getJSONObject("GlossEntry")
//        val ID = glossEntry.getString("ID")
//        val SortAs = glossEntry.getString("SortAs")
//        val GlossTerm = glossEntry.getString("GlossTerm")
//        val Acronym = glossEntry.getString("Acronym")
//        val Abbrev = glossEntry.getString("Abbrev")
//        val GlossDef = glossEntry.getJSONObject("GlossDef")
//        val para = GlossDef.getString("para")
//        val GlossSeeAlso = GlossDef.getJSONArray("GlossSeeAlso")
//        val GlossSee = glossEntry.getString("GlossSee")
//
//        var arrayItems = ""
//        for (i in 0 until GlossSeeAlso.length()) {
//            arrayItems += GlossSeeAlso.getString(i)
//        }
//
//        binding.tv.text = """
//            title - $title,
//            title2 - $title2,
//            ID - $ID,
//            SortAs - $SortAs,
//            GlossTerm - $GlossTerm,
//            Acronym - $Acronym,
//            Abbrev - $Abbrev,
//            para - $para,
//            GlossSeeAlso - $arrayItems,
//            GlossSee - $GlossSee,
//
//        """.trimIndent()
    }

}