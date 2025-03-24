package com.anand.virtualroots
import com.google.firebase.firestore.FirebaseFirestore

class FirestoreHelper {
    private val db = FirebaseFirestore.getInstance()

    fun addPlants() {
        val plants = listOf(
            mapOf("name" to "Tulsi", "scientific_name" to "Ocimum tenuiflorum", "uses" to "Boosts immunity, relieves stress"),
            mapOf("name" to "Aloe Vera", "scientific_name" to "Aloe barbadensis miller", "uses" to "Skin care, digestion aid"),
            mapOf("name" to "Neem", "scientific_name" to "Azadirachta indica", "uses" to "Antibacterial, skin diseases, hair care"),
            mapOf("name" to "Ashwagandha", "scientific_name" to "Withania somnifera", "uses" to "Boosts energy, reduces stress, improves brain function"),
            mapOf("name" to "Brahmi", "scientific_name" to "Bacopa monnieri", "uses" to "Enhances memory, reduces anxiety, improves cognitive function"),
            mapOf("name" to "Giloy", "scientific_name" to "Tinospora cordifolia", "uses" to "Boosts immunity, treats fever, diabetes"),
            mapOf("name" to "Lemongrass", "scientific_name" to "Cymbopogon citratus", "uses" to "Relieves pain, improves digestion, mosquito repellent"),
            mapOf("name" to "Peppermint", "scientific_name" to "Mentha piperita", "uses" to "Aids digestion, relieves headaches, freshens breath"),
            mapOf("name" to "Turmeric", "scientific_name" to "Curcuma longa", "uses" to "Anti-inflammatory, antiseptic, boosts skin health"),
            mapOf("name" to "Stevia", "scientific_name" to "Stevia rebaudiana", "uses" to "Natural sweetener, good for diabetes, weight loss"),
            mapOf("name" to "Sarpagandha", "scientific_name" to "Rauvolfia serpentina", "uses" to "Treats high blood pressure, insomnia, anxiety"),
            mapOf("name" to "Shatavari", "scientific_name" to "Asparagus racemosus", "uses" to "Boosts reproductive health, improves digestion, relieves stress"),
            mapOf("name" to "Hibiscus", "scientific_name" to "Hibiscus rosa-sinensis", "uses" to "Improves hair health, lowers blood pressure, rich in antioxidants"),
            mapOf("name" to "Ginseng", "scientific_name" to "Panax ginseng", "uses" to "Enhances energy, improves brain function, fights fatigue"),
            mapOf("name" to "Moringa", "scientific_name" to "Moringa oleifera", "uses" to "Nutrient-rich, boosts energy, fights inflammation"),
            mapOf("name" to "Curry Leaves", "scientific_name" to "Murraya koenigii", "uses" to "Improves digestion, good for hair and skin")
        )

        for (plant in plants) {
            val documentId = plant["name"]?.lowercase()?.replace(" ", "_") ?: "unknown"
            db.collection("plants").document(documentId).set(plant)
                .addOnSuccessListener { println("Added: ${plant["name"]}") }
                .addOnFailureListener { e -> println("Error adding ${plant["name"]}: $e") }
        }
    }
}






