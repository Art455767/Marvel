package com.example.marvel.presentation.adapters

import com.domain.models.Character
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvel.R

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private var characterList = listOf<Character>()

    fun setCharacters(newCharacters: List<Character>) {
        val diffResult = DiffUtil.calculateDiff(CharacterDiffCallback(characterList, newCharacters))
        characterList = newCharacters
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characterList[position]
        holder.bind(character)
    }

    override fun getItemCount(): Int = characterList.size

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.text_name)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.text_description)
        private val imageView: ImageView = itemView.findViewById(R.id.image_character)

        fun bind(character: Character) {
            nameTextView.text = character.name
            descriptionTextView.text = character.description.ifEmpty { "No description available" }
            val imageUrl = "${character.thumbnail.getImageUrl()}.${character.thumbnail.getExtensionValue()}"

            Glide.with(itemView.context)
                .load(imageUrl)
                .into(imageView)
        }
    }

    class CharacterDiffCallback(
        private val oldList: List<Character>,
        private val newList: List<Character>,
        ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size
        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].name == newList[newItemPosition].name &&
                    oldList[oldItemPosition].description == newList[newItemPosition].description
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}