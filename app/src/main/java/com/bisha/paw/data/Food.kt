package com.bisha.paw.data

data class Food(
    val foodName: String,
    val foodBrand: String,
    val foodPrice: Int
) {
    companion object {
        fun getFoods(): ArrayList<Food> {
            return arrayListOf(
                Food("Whiskas® Dry Adult 1+ Indoor", "Whiskas", 48000),
                Food("WHISKAS® Wet Food Pouch Junior 80gr", "Whiskas", 28000),
                Food("Royal Canin Kitten Dry 400gr", "Royal Canin", 158620),
                Food("Royal Canin Indoor Long Hair (2kg)", "Royal Canin", 314500),
                Food("Korean Collagen 150gr Biotin Zinc Vitamin ", "PetGlow", 128325)
            )
        }
    }
}