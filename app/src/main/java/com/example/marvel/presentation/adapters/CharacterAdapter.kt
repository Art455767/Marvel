package com.example.marvel.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvel.R
import com.example.marvel.data.models.Character

class CharacterAdapter(private val characters: MutableList<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.character_name)
        val description: TextView = view.findViewById(R.id.character_description)
        val image: ImageView = view.findViewById(R.id.character_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.name.text = character.name
        holder.description.text = character.description.ifEmpty { "No description available" }
        val imageUrl = character.thumbnail.getImageUrl() + "/portrait_xlarge." + character.thumbnail.getExtension()

        Glide.with(holder.itemView.context)
            .load(imageUrl)
            .into(holder.image)
    }

    override fun getItemCount() = characters.size
}