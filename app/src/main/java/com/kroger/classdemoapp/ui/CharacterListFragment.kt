package com.kroger.classdemoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kroger.classdemoapp.Character
import com.kroger.classdemoapp.CharacterAdapter
import com.kroger.classdemoapp.R
import kotlin.random.Random

class CharacterListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_character_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.character_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val characters = mutableListOf<Character>()

        val price = mutableListOf("Price: 5 coins",
            "Price: 10 coins",
            "Price: 20 coins",
            "Price: 25 coins",
            "Price: 30 coins",
            )
        val rareness = mutableListOf(
            "Rareness: common",
            "Rareness: uncommon",
            "Rareness: rare",
            "Rareness: epic",
            "Rareness: legendary",
        )
        val nameMods = mutableListOf("Broken", "Normal", "Legendary", "Super")
        val characterNames = mutableListOf("Weapon")
        val image = mutableListOf(R.mipmap.revolver_1,R.mipmap.knife,R.mipmap.sword,R.mipmap.bow,R.mipmap.bazooka,R.mipmap.grenade)

        for (i in 0..30) {
            characters.add(
                createCharacter(

                    "${nameMods.random()} ${characterNames.random()}".trimStart(),
                    price.random(),
                    rareness.random(),
                    image.random(),

                    i
                )
            )
        }

        val adapter = CharacterAdapter(characters)
        recyclerView.adapter = adapter

        return view
    }

    private fun createCharacter(
        name: String,
        power: String,
        detail: String,
        image: Int,
        id: Int
    ) = Character(
        name = name,
        power = power,
        image = image,
        detail = detail
    )
}
